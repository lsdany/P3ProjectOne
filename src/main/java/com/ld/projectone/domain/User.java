package com.ld.projectone.domain;

import com.ld.projectone.edd.PlayerStack;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Clase con la informacion del usuario, su nick(userName) con el cual se identificara en el juego
 * y su mazo o deck
 *
 * @author luisdany pernillo
 */

@Builder
@Getter
@ToString
public class User {

    private String userName;
    private PlayerStack userDeck;
    private int order;

}
