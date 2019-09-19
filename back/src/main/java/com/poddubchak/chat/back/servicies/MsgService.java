package com.poddubchak.chat.back.servicies;

import com.poddubchak.chat.back.model.ChatMsg;
import com.poddubchak.chat.back.model.FormMsg;

import java.util.List;

public interface MsgService {
    void systemMsgLogin(String name);
    void systemMsgLogout(Long userId);

    ChatMsg say(FormMsg formMsg);

    List<ChatMsg> getAllMsg();

    List<ChatMsg> getAllSystemMsg();

    List<ChatMsg> getAllMyMsg(Long userId);

    List<ChatMsg> getAllMsgToMe(Long userId);
}
