package com.ld.projectone.service.impl;

import com.ld.projectone.domain.User;
import com.ld.projectone.edd.PlayerStack;
import com.ld.projectone.game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private Game game;

    public void createUser(String userName){
        User user =  User.builder().userName(userName).build();
        PlayerStack deck = game.getUserDeck();
    }

}
