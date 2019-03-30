package com.ld.projectone.game;

import com.ld.projectone.domain.CardPair;
import com.ld.projectone.edd.PlayerStack;


public interface Game {

    PlayerStack getUserDeck();

    CardPair getCard(PlayerStack stack);

    void createUser(String userName);

    CardPair getUserCard(String userName);

    int getTurn();

    void newTurn();

}
