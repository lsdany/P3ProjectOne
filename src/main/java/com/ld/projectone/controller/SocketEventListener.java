package com.ld.projectone.controller;

import com.ld.projectone.domain.MessageNew;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@AllArgsConstructor
@Slf4j
public class SocketEventListener {

    private SimpMessageSendingOperations simpMessageSendingOperations;

    @EventListener
    public void handleSocketConnectListener(SessionConnectedEvent event){
        log.info("New connection");
    }

    @EventListener
    public void handleSocketDisconnectListener(SessionDisconnectEvent event){
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String userName = (String) headerAccessor.getSessionAttributes().get("username");
        if(userName != null){
            log.info("Disconnected: "+userName);

            MessageNew message = new MessageNew();
            message.setFrom("home");
            message.setText("disconnected");

            simpMessageSendingOperations.convertAndSend("/topic/public", message);
        }
    }





}
