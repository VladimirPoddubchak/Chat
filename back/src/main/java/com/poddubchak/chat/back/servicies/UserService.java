package com.poddubchak.chat.back.servicies;

import com.poddubchak.chat.back.model.ChatUser;
import com.poddubchak.chat.back.model.FormUser;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    ChatUser createUser(FormUser formUser);
    boolean loginUser(FormUser formUser);
    boolean logoutUser(Long userId);

    List<ChatUser> getAllUsers();

    List<ChatUser> getOnlineUsers();
}
