package com.ld.projectone.service.impl;

import com.ld.projectone.domain.CardPair;
import com.ld.projectone.domain.User;
import com.ld.projectone.edd.PlayerStack;
import com.ld.projectone.game.Game;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserService {

    private Map<String,User> users = new HashMap<>();

    private Game game;

    public UserService (Game game){
        this.game = game;
    }

    public void createUser(String userName){
        assignUser(userName);
    }

    private void assignUser(String userName){

        if(users.size() < 4){
            PlayerStack deck = game.getUserDeck();
            User user =  User.builder().userName(userName).userDeck(deck).order(users.size()+1).build();
            users.put(user.getUserName(),user);
            users.forEach((k,v) -> log.info("key: {} , values: {}",k,v.toString()));
        }
    }

    public int getNumberUsers(){
        return users.size();
    }

    public CardPair getUserCard(String userName){

        if(users.containsKey(userName)){
            User user = users.get(userName);



        }

        return null;
    }

}
