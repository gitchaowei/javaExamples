package com.codes.practice;

// StringBuffer is synchronized i.e. thread safe.
// It means two threads can't call the methods of StringBuffer simultaneously.
// so, StringBuffer is slower than StringBuilder
//
// StringBuilder is non-synchronized i.e. not thread safe.
// It means two threads can call the methods of StringBuilder simultaneously.
public class StringBufferStringBuilder {


    public static void main(String[] args) {
        StringDemo();
    }

    private static void StringDemo() {
        long startTime = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer("Java");
        for (int i=0; i<100000; i++){
            sb.append("Tpoint");
        }
        long timeSpent1 = System.currentTimeMillis() - startTime;
        System.out.println("Time taken by StringBuffer: " + timeSpent1 + "ms");
        startTime = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder("Java");
        for (int i=0; i<100000; i++){
            sb2.append("Tpoint");
        }
        long timeSpent2 = System.currentTimeMillis() - startTime;

        System.out.println("Time taken by StringBuilder: " + timeSpent2 + "ms");
        if (timeSpent1 > timeSpent2)
            System.out.println("StringBuilder is faster than StringBuffer!");
        else
            System.out.println("StringBuffer is faster than StringBuilder!");
    }
}
