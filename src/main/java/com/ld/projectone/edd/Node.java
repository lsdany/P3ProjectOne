package com.ld.projectone.edd;

public class Node<E> {

    E data;
    Node right;
    Node left;

    public Node(E data){
        this.data = data;
    }

    public Node(E data, Node right, Node left){
        this.data = data;
        this.right = right;
        this.left = left;

    }

}
