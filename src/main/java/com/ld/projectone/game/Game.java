package com.ld.projectone.game;

import com.ld.projectone.domain.CardPair;
import com.ld.projectone.edd.PlayerStack;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//@Component
public class Game {

    private String[] colours = {"red", "blue", "yellow", "black"};
    private int[] numbers = {0,1,2,3,4,5,6,7,8,9};
    private CardPair[][] deck;
    private List<CardPair> deckList;

    private List<CardPair> deckRandom;

    private void scrambleRandomDeck(){

        Random random = new Random();
        //CardPair[][] deckRandom = new CardPair[numbers.length][colours.length];

        deckRandom = new ArrayList<>();

        for(int i = 0; i < numbers.length ; i ++)
            for(int j = 0; j < colours.length; j ++){
                int number = random.nextInt(deckList.size());

                System.out.println(number);

                CardPair card = deckList.get(number);

                if(card!=null){
                    deckRandom.add(card);
                    deckList.remove(card);
                }

        }

        System.out.println(deckRandom);

    }

    private void createDeck(){
        deck = new CardPair[numbers.length][colours.length];
        deckList = new ArrayList<>();
        for(int i = 0; i < numbers.length ; i ++)
            for(int j = 0; j < colours.length; j ++){
                deck[i][j] = new CardPair( numbers[i], colours[j]);
                deckList.add(new CardPair( numbers[i], colours[j]));
            }

        System.out.println(Arrays.deepToString(deck));
        System.out.println(deckList);
        System.out.println(deckList.size());
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.createDeck();

        game.scrambleRandomDeck();
    }

    public PlayerStack getUserDeck(){

        PlayerStack playerDeck = new PlayerStack();

        for(CardPair c : deckRandom){

        }

        return null;
    }

}
