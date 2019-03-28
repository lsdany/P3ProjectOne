package com.ld.projectone.game;

import com.ld.projectone.domain.CardPair;
import com.ld.projectone.domain.User;
import com.ld.projectone.edd.PlayerStack;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Slf4j
@Component
public class Game {

    private String[] colours = {"red", "blue", "yellow", "black"};
    private int[] numbers = {0,1,2,3,4,5,6,7,8,9};
    private List<CardPair> deckList;

    private List<CardPair> deckRandom;
    private User[] users = new User[3];


    public Game(){
        createDeck();
        scrambleRandomDeck();
    }

    private void scrambleRandomDeck(){

        Random random = new Random();
        deckRandom = new ArrayList<>();

        for(int i = 0; i < numbers.length ; i ++)
            for(int j = 0; j < colours.length; j ++){
                int number = random.nextInt(deckList.size());

                CardPair card = deckList.get(number);
                if(card!=null){
                    deckRandom.add(card);
                    deckList.remove(card);
                }
        }

        System.out.println(deckRandom);

    }

    private void createDeck(){
        deckList = new ArrayList<>();
        for(int i = 0; i < numbers.length ; i ++)
            for(int j = 0; j < colours.length; j ++){
                deckList.add(new CardPair( numbers[i], colours[j]));
            }

        System.out.println(deckList.size());
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.createDeck();
        game.scrambleRandomDeck();
    }

    public PlayerStack getUserDeck(){

        PlayerStack playerDeck = new PlayerStack();
        log.info("quedan: {} cartas",deckRandom.size());

        for(int i = 12 ; i > -1 ; i--){
            if(!deckRandom.isEmpty()){
                playerDeck.add(deckRandom.get(i));
                deckRandom.remove(i);
            }
        }

        return playerDeck;
    }

    private boolean isUserSpace(){

        if(users.length == 3)
            return true;
        return false;
    }

}
