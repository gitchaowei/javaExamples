package com.codes.practice;

import java.util.BitSet;

public class BitSetExamples {
    public static void main(String[] args)
    {
        // Constructors of BitSet class
        BitSet bs1 = new BitSet();
        BitSet bs2 = new BitSet(6);

        // no bit set to true, so length is 0 for both BitSets
        System.out.println("bs1  : " + bs1.length());
        System.out.println("bs2  : " + bs2.length());

        /* set is BitSet class method */
        bs1.set(0);
        bs1.set(1);
        bs1.set(2);
        bs1.set(4);
        bs1.set(100);
        // assign values to bs2
        bs2.set(4);
        bs2.set(6);
        bs2.set(5);
        bs2.set(1);
        bs2.set(2);
        bs2.set(3);

        // Printing the 2 Bitsets
        System.out.println("bs1 cardinality: " + bs1.cardinality());
        System.out.println("bs2 cardinality: " + bs2.cardinality());

        // highest bit true
        System.out.println("bs1  : " + bs1.length());
        System.out.println("bs2  : " + bs2.length());
    }
}
