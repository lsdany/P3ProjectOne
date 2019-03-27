package com.ld.projectone.edd;

import com.ld.projectone.domain.CardPair;
import com.ld.projectone.edd.nodes.Node;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 *
 * Lista simple para guardar la informacion del deck central
 *
 * @author luisdany pernillo
 */

@Slf4j
public class LikedList implements LinkedList<CardPair> {

    private Node<CardPair> head;

    @Override
    public void add(CardPair element) {

        Node<CardPair> node = new Node<>(element) ;

        //lista vacia
        if(head == null){
            head = node;
        }else{
            node.setRight(head);
            head = node;
        }
    }

    @Override
    public void show() {

        if(head!=null){
            Node aux = head;
            while(aux != null){
                System.out.println(aux.getData());
                aux = aux.getRight();
            }
        }

    }

    @Override
    public CardPair remove() {

        if(head == null){
            log.info("La lista esta vacia");
        }else{

        }

        return null;
    }

    public static void main(String[] args) {

        LinkedList<CardPair> list = new LikedList();

        CardPair cardPair1 =  CardPair.builder().colour("red").number(2).build();
        CardPair cardPair2 =  CardPair.builder().colour("blue").number(1).build();
        CardPair cardPair3 =  CardPair.builder().colour("yellow").number(5).build();

        list.add(cardPair1);
        list.add(cardPair2);
        list.add(cardPair3);

        list.show();

    }
}
