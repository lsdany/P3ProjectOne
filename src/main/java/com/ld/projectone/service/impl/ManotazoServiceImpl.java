package com.ld.projectone.service.impl;

import com.ld.projectone.domain.CardPair;
import com.ld.projectone.service.ManotazoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ManotazoServiceImpl implements ManotazoService {


    private static final int[] cardNumbers = {1,2,3,4,5,6,7,8,9};
    private static final String[] cardColors = {"blue", "red", "black", "yellow"};
    private static CardPair[][] deck = new CardPair[4][9];
    private static CardPair[][] deckUnorder = new CardPair[4][9];
    private static List<CardPair> deckList = new ArrayList<>();

    @Override
    public void dealingCards() {

    }

    private static void generateUnorderDeck(){
        Random random = new Random();

        for(int i = 0 ; i < 36 ; i ++){
            int number = random.nextInt(36)+1;

            System.out.println(number);

            deckList.get(number);


        }

    }

    private static void generateDeck(){
        for(int i = 0; i < cardColors.length; i++){
            for(int j = 0 ; j < cardNumbers.length; j++){
                //deck[i][j] = new CardPair(cardColors[i], cardNumbers[j]);
                deckList.add(new CardPair(cardColors[i], cardNumbers[j]));
            }
        }
    }

    public static void main(String[] args) {
        generateDeck();
        System.out.println(deckList);
        System.out.println(deckList.size());

    }

}
