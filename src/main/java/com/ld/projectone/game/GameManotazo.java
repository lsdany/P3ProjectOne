package com.ld.projectone.game;

import com.ld.projectone.domain.CardPair;
import com.ld.projectone.edd.LinkedList;
import com.ld.projectone.edd.LinkedListSimple;
import com.ld.projectone.edd.PlayerStack;
import com.ld.projectone.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Slf4j
@Component
public class GameManotazo implements Game {


    private String[] colours = {"red", "blue", "yellow", "black"};
    private int[] numbers = {0,1,2,3,4,5,6,7,8,9};

    private List<CardPair> deckList;
    private List<CardPair> deckRandom;

    private LinkedList<CardPair> centralDeck;
    private static int turno = 0;

    @Autowired
    private UserService userService;


    public GameManotazo(){
        createDeck();
        scrambleRandomDeck();
        centralDeck = new LinkedListSimple();
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

//        int indexTemp = random.nextInt(deckList.size());
//        centralDeck.add(deckRandom.get(indexTemp));
//        deckRandom.remove(indexTemp);

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
//        Game game = new GameManotazo();
//        game.createDeck();
//        game.scrambleRandomDeck();
    }

    @Override
    public PlayerStack getUserDeck(){

        PlayerStack playerDeck = new PlayerStack();


        for(int i = 12 ; i > -1 ; i--){
            if(!deckRandom.isEmpty()){
                playerDeck.add(deckRandom.get(i));
                deckRandom.remove(i);
            }
        }

        log.info("Usuarios registrados {}",getUsersNumber());
        log.info("quedan: {} cartas",deckRandom.size());

        return playerDeck;
    }

    private int getUsersNumber(){
        return userService.getNumberUsers();
    }

    @Override
    public CardPair getCard(PlayerStack stack){
        return stack.get();
    }

    @Override
    public void createUser(String userName) {
        PlayerStack deck = getUserDeck();
        userService.assignUser(userName, deck);
    }

    @Override
    public CardPair getUserCard(String userName) {
        log.info("Obteniendo carta para el usuario {} y el turno {}", userName);
        turno++;
        return userService.getCardFromDeck(userName, turno);
    }

    @Override
    public int getTurn() {
        if(turno == 10){
            turno = 0;
        }
        return turno;
    }

    @Override
    public void newTurn() {

    }
}
