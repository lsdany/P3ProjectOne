package com.ld.projectone.controller;

import com.ld.projectone.domain.Message;
import com.ld.projectone.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class MessageController {

    @Autowired
    private UserService userService;

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public Message send(@Payload Message message){
        log.info("send");
        return message;
    }

    @MessageMapping("/chat.add")
    @SendTo("/topic/public")
    public Message add(@Payload Message message, SimpMessageHeaderAccessor simpMessageHeaderAccessor){
        simpMessageHeaderAccessor.getSessionAttributes().put("username",message.getSender());
        log.info("add");
        userService.createUser(message.getSender());
        return  message;
    }

}
