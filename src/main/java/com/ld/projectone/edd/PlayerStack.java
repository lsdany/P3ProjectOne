package com.ld.projectone.edd;


import com.ld.projectone.domain.CardPair;
import com.ld.projectone.edd.nodes.NodeDouble;

/**
 * Clase para guardar la informacion del deck de cada usuario
 *
 * @autor luisdany pernillo
 */


public class PlayerStack implements LinkedList<CardPair>  {

    private NodeDouble<CardPair> head = null;
    private NodeDouble<CardPair> top = null;


    @Override
    public void add(CardPair element) {
        NodeDouble<CardPair> node = new NodeDouble<>(element);

        //empty list
        if(head == null && top == null){
            head = top = node;
        }else{
            node.setRight(top);
            //TODO validar esto no se está asignando ahorita de null pointer exception
            //top.getRight().setLeft(node);
            top = node;
        }
    }

    @Override
    public void show() {
        NodeDouble<CardPair> aux = top;
        while (aux != null) {

            //mostrar el stack
            System.out.println(aux.getData());

            aux = aux.getRight();
        }
    }

    @Override
    public CardPair remove() {
        if(top != null && head != null){

            NodeDouble<CardPair> nodeAux = top;
            top = top.getRight();
            nodeAux.setRight(null);
            return nodeAux.getData();

        }
        return null;
    }


    @Override
    public String toString() {

        NodeDouble<CardPair> aux = top;
        StringBuilder stringNode = new StringBuilder();
        while (aux != null) {
            //mostrar el stack
            stringNode.append(aux.getData());
            aux = aux.getRight();
        }

        return stringNode.toString();
    }

    public static void main(String[] args) {
//        PlayerStack player = new PlayerStack();
//        CardPair card = new CardPair("black", 1);
//        player.add(card);
//        CardPair card2 = new CardPair("blue", 3);
//        player.add(card2);
//        CardPair card3 = new CardPair("yellow", 8);
//        player.add(card3);
//        player.show();
//        System.out.println("------------------------------");
//        CardPair card4 = player.remove();
//        System.out.println(card4.toString());
//        System.out.println("------------------------------");
//        player.show();
//        System.out.println("------------------------------");
//        CardPair card5 = player.remove();
//        System.out.println(card5.toString());
//        System.out.println("------------------------------");
//        player.show();
    }

}
