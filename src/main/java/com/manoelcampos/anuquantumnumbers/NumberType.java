package com.manoelcampos.anuquantumnumbers;

/**
 * The types of number to generate,
 * which indicates the {@link #maxValue()} to return.
 * @author Manoel Campos da Silva Filho
 */
public enum NumberType {
    uint8 {
        public int maxValue() {
            return Math.abs(Byte.MIN_VALUE) + Byte.MAX_VALUE;
        }
    },
    uint16 {
        public int maxValue() {
            return Math.abs(Short.MIN_VALUE) + Short.MAX_VALUE;
        }
    };

    /**
     * {@return the maximum number that can be generated for this number type}
     */

    public abstract int maxValue();
}
