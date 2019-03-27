package com.ld.projectone.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * Par de datos que conforman una carta, su numero y su color
 *
 * @author Luisdany Pernillo
 */

@AllArgsConstructor
@Getter
@ToString
public class CardPair {

    private String color;
    private int number;

}
