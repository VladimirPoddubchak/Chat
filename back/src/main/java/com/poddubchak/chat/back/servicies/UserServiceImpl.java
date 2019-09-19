package com.poddubchak.chat.back.servicies;

import com.poddubchak.chat.back.model.ChatUser;
import com.poddubchak.chat.back.model.FormUser;
import com.poddubchak.chat.back.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ChatUser createUser(FormUser formUser) {
        ChatUser newUser = ChatUser.builder()
                .name(formUser.getName())
                .login(formUser.getLogin())
                .hashPassword(formUser.getHashPassword())
                .isOnline(true)
                .isBanned(false)
                .isDeleted(false)
                .build();
        return userRepository.save(newUser);
    }

    @Override
    public boolean loginUser(FormUser formUser) {
        ChatUser chatUser = userRepository.findByLogin(formUser.getLogin()).orElseThrow(IllegalArgumentException::new);
        if( chatUser.getHashPassword().equals(formUser.getHashPassword())){
            chatUser.setIsOnline(true);
            userRepository.save(chatUser);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean logoutUser(Long userId) {
        ChatUser chatUser = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        chatUser.setIsOnline(false);
        userRepository.save(chatUser);
        return true;
    }

    @Override
    public List<ChatUser> getAllUsers() {
        return (List<ChatUser>) userRepository.findAll();
    }

    @Override
    public List<ChatUser> getOnlineUsers() {
        return (List<ChatUser>) userRepository.isOnlineIsTrue();
    }
}
