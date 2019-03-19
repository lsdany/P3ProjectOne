package com.ld.projectone.controller;

import com.ld.projectone.domain.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public Message send(@Payload Message message){
        return message;
    }

    @MessageMapping("/chat.add")
    @SendTo("/topic/public")
    public Message add(@Payload Message message, SimpMessageHeaderAccessor simpMessageHeaderAccessor){
        simpMessageHeaderAccessor.getSessionAttributes().put("username",message.getSender());
        return  message;
    }

}
