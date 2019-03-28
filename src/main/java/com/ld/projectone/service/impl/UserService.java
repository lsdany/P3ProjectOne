package com.ld.projectone.service.impl;

import com.ld.projectone.domain.User;
import com.ld.projectone.edd.PlayerStack;
import com.ld.projectone.game.Game;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    @Autowired
    private Game game;

    public void createUser(String userName){
        assignUser(userName);
    }

    private void assignUser(String userName){

        if(users.size() < 4){

            PlayerStack deck = game.getUserDeck();
            User user =  User.builder().userName(userName).userDeck(deck).build();
            users.add(user);
            users.forEach(System.out::println);
        }

    }

}
