package com.ld.projectone.controller;

import com.ld.projectone.domain.Message;
import com.ld.projectone.game.Game;
import com.ld.projectone.service.impl.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@AllArgsConstructor
public class GameController {

    private UserService userService;

    @MessageMapping("/game.send")
    @SendTo("/topic/public")
    public Message send(@Payload Message message){
        log.info("send");
        return message;
    }

    @MessageMapping("/game.add")
    @SendTo("/topic/public")
    public Message add(@Payload Message message, SimpMessageHeaderAccessor simpMessageHeaderAccessor){

        log.info("adding user {} to the game", message.getSender());
        simpMessageHeaderAccessor.getSessionAttributes().put("username",message.getSender());
        userService.createUser(message.getSender());
        return  message;
    }

}
