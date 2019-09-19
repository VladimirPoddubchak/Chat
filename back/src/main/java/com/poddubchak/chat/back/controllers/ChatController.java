package com.poddubchak.chat.back.controllers;

import com.poddubchak.chat.back.model.ChatMsg;
import com.poddubchak.chat.back.model.ChatUser;
import com.poddubchak.chat.back.model.FormMsg;
import com.poddubchak.chat.back.servicies.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    MsgService msgService;

    @PostMapping("/say")
    public ChatMsg say (@RequestBody FormMsg formMsg){
        return msgService.say(formMsg);
    }

    @GetMapping("/all")
    public List<ChatMsg> allMsg () {
        return msgService.getAllMsg();
    }

    @GetMapping("/system")
    public List<ChatMsg> allSystemMsg () {
        return msgService.getAllSystemMsg();
    }

    @GetMapping("/{userId}/allMyMsg")
    public List<ChatMsg> allMyMsg (@PathVariable Long userId) {
        return msgService.getAllMyMsg(userId);
    }

    @GetMapping("/{userId}/allMsgToMe")
    public List<ChatMsg> allMsgToMe (@PathVariable Long userId) {
        return msgService.getAllMsgToMe(userId);
    }
}
