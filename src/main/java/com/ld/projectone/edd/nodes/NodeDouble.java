package com.ld.projectone.edd.nodes;

import lombok.Getter;
import lombok.Setter;

/**
 * Implementacion especifica de la clase Node para
 * una lista doblemente enlazada
 * @param <E>
 * @author Luisdany Pernillo
 */

@Getter
@Setter
public class NodeDouble<E>  {

    private NodeDouble left;
    private E data;
    private NodeDouble right;

    public NodeDouble(E data){
        this.data = data;
    }

}
