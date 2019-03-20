package com.ld.projectone.edd.nodes;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase Nodo para manejar la estructura dinamica
 * @param <E>
 * @author Luisdany Pernillo
 */

@Getter
@Setter
public class Node<E> {

    private E data;
    private Node right;

    public Node(E data){
        this.data = data;
    }
}
