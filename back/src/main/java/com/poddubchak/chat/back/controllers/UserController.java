package com.poddubchak.chat.back.controllers;


import com.poddubchak.chat.back.model.ChatUser;
import com.poddubchak.chat.back.model.FormUser;
import com.poddubchak.chat.back.servicies.MsgService;
import com.poddubchak.chat.back.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MsgService msgService;

    @PostMapping()
    public ResponseEntity<Object> addUser(@RequestBody FormUser userForm) {
        userService.createUser(userForm);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser (@RequestBody FormUser user) {
        if (userService.loginUser(user)){
            msgService.systemMsgLogin(user.getName());
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.badRequest().body("Wrong id or user is already login");
        }
    }

    @GetMapping("/{userId}/logout")
    public ResponseEntity<String> logoutUser (@PathVariable Long userId) {
        if (userService.logoutUser(userId)) {
            msgService.systemMsgLogout(userId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Wrong id or user is already logout");
        }
    }

    @GetMapping("/all")
    public List<ChatUser> allUsers () {
        return userService.getAllUsers();
    }

    @GetMapping("/online")
    public List<ChatUser> onlineUsers () {
        return userService.getOnlineUsers();
    }
}
