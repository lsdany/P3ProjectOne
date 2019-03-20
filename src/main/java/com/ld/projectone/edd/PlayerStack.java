package com.ld.projectone.edd;


import com.ld.projectone.domain.CardPair;

public class PlayerStack<E> {

    private Node head = null;
    private Node top = null;




    public void push(E element){

        Node node = new Node(element);

        //empty list
        if(head == null && top == null){
            head = top = node;
        }else{
            node.right = top;
            top = node;
        }



    }


    public void imprimir() {

        Node aux = top;
        while (aux != null) {

            //mostrar el stack
            System.out.println(aux.data);

            aux = aux.right;
        }
    }

    public CardPair pop(){

        if(top != null && head != null){

            Node<CardPair> nodeAux = top;
            top = top.right;
            nodeAux.right = null;
            return nodeAux.data;

        }
        return null;
    }



    public static void main(String[] args) {
        PlayerStack<CardPair> player = new PlayerStack<>();
        CardPair card = new CardPair("black", 1);
        player.push(card);
        CardPair card2 = new CardPair("blue", 3);
        player.push(card2);
        CardPair card3 = new CardPair("yellow", 8);
        player.push(card3);
        player.imprimir();
        System.out.println("------------------------------");
        CardPair card4 = player.pop();
        System.out.println(card4.toString());
        System.out.println("------------------------------");
        player.imprimir();
        System.out.println("------------------------------");
        CardPair card5 = player.pop();
        System.out.println(card5.toString());
        System.out.println("------------------------------");
        player.imprimir();
    }

}
