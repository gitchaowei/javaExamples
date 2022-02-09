package com.Interview;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Runnable runnerable = new Runnable() {
            @Override
            public void run() {
                System.out.println("I am in anonymous runnable ");
            }
        };
        runnerable.run();
    }

}
