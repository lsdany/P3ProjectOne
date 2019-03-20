package com.ld.projectone.edd;


import com.ld.projectone.domain.CardPair;

public class PlayerStack<E> {

    private Node head = null;
    private Node tail = null;




    public void push(E element){

        Node node = new Node(element);

        //empty list
        if(head == null && tail == null){
            head = tail = node;
        }else{
            node.right = tail;
            tail.left = node;
            tail = node;
        }



    }


    public String imprimir() {

        Node aux = head;
        StringBuilder info = new StringBuilder();
        while (aux != null) {

            //mostrar el stack
            System.out.println(aux.data);

            aux = aux.left;
        }
        return info.toString();
    }

    public void pop(){

    }



    public static void main(String[] args) {
        PlayerStack<CardPair> player = new PlayerStack<>();
        CardPair card = new CardPair("black", 1);
        player.push(card);
        CardPair card2 = new CardPair("blue", 3);
        player.push(card2);
        player.imprimir();
    }

}
