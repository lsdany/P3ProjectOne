package com.ld.projectone.domain;

import lombok.*;

/**
 *
 * Par de datos que conforman una carta, su numero y su color
 *
 * @author Luisdany Pernillo
 */

@AllArgsConstructor
@Getter
@ToString
@Builder
@NoArgsConstructor
public class CardPair {

    private int number;
    private String colour;

}
