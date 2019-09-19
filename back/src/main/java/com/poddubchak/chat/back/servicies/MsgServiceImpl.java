package com.poddubchak.chat.back.servicies;

import com.poddubchak.chat.back.model.ChatMsg;
import com.poddubchak.chat.back.model.FormMsg;
import com.poddubchak.chat.back.repositories.MsgRepository;
import com.poddubchak.chat.back.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MsgServiceImpl  implements MsgService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    MsgRepository msgRepository;

    @Override
    public void systemMsgLogin(String name) {
        ChatMsg chatMsg = ChatMsg.builder()
                .msg("User "+ name + " login.")
                .date(new Date())
                .isPrivate(false)
                .build();
        msgRepository.save(chatMsg);
    }

    @Override
    public void systemMsgLogout(Long userId) {
        ChatMsg chatMsg = ChatMsg.builder()
                .msg("User "+ userRepository.findById(userId).orElseThrow(IllegalArgumentException::new).getName() + " logout.")
                .date(new Date())
                .isPrivate(false)
                .build();
        msgRepository.save(chatMsg);
    }

    @Override
    public ChatMsg say(FormMsg formMsg) {
        ChatMsg newMsg = ChatMsg.builder()
                .msg(formMsg.getMsg())
                .fromUser(userRepository.findById(formMsg.getFromUserId()).orElseThrow(IllegalArgumentException::new))
                .toUser(userRepository.findById(formMsg.getToUserId()).orElseThrow(IllegalArgumentException::new))
                .isPrivate(formMsg.getIsPrivate())
                .date(new Date())
                .build();
        return msgRepository.save(newMsg);
    }

    @Override
    public List<ChatMsg> getAllMsg() {
        return (List)msgRepository.findAll();
    }

    @Override
    public List<ChatMsg> getAllSystemMsg() {
        return (List)msgRepository.fromUserIsNull();
    }

    @Override
    public List<ChatMsg> getAllMyMsg(Long userId) {
        return (List)msgRepository.fromUserIs(userRepository.findById(userId).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public List<ChatMsg> getAllMsgToMe(Long userId) {
        return (List)msgRepository.toUserIs(userRepository.findById(userId).orElseThrow(IllegalArgumentException::new));
    }

}
