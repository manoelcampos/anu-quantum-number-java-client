package com.manoelcampos.anuquantumnumbers;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Manoel Campos da Silva Filho
 */
@Getter @Setter
class Response {
    private boolean success;
    private String type;
    private int length;
    private int[] data;
}
