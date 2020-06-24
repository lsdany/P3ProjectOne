package com.ld.projectone.controller;

import com.ld.projectone.domain.MessageNew;
import com.ld.projectone.domain.OutputMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Controller
@AllArgsConstructor
public class GameController {


    @MessageMapping("/chat")
    @SendTo("/topic/public")
    public OutputMessage send(MessageNew message) throws Exception {
        log.info("Message received {} ", message.toString());
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }

}
