package com.ld.projectone.domain;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Message implements Serializable {

    private String content;
    private String sender;
    private Type type;
    private CardPair cardPair;
    private int turno;

    public enum Type{
        IN_CHAT, JOINING, LEAVING
    }

}
