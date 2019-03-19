package com.ld.projectone.edd;

public class PlayerStack<E> {

    private Node head = null;
    private Node tail = null;




    public void addElement(E element){

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

            aux = aux.left;
        }
        return info.toString();
    }


    public void explore(){



    }

}
