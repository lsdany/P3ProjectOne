package com.ld.projectone.edd;

import com.ld.projectone.domain.CardPair;
import com.ld.projectone.edd.nodes.Node;

import java.util.Arrays;

public class LikedList implements LinkedList<CardPair> {

    private Node<CardPair> head;

    @Override
    public void add(CardPair element) {

        Node<CardPair> node = new Node<>(element) ;

        //lista vacia
        if(head == null){
            head = node;
        }else{

        }
    }

    @Override
    public void show() {

    }

    @Override
    public CardPair remove() {
        return null;
    }

    public static void main(String[] args) {

        String test = "hola.mundo_esto es una cadena";
        String[] t = test.split("\\.|\\_");
        System.out.println(Arrays.deepToString(t));

    }
}
