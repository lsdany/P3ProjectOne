package com.ld.projectone.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {

    private String content;
    private String sender;
    private Type type;

    public enum Type{
        IN_CHAT, JOINING, LEAVING
    }

}
