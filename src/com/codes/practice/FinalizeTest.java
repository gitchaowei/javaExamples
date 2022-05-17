package com.codes.practice;


public class FinalizeTest {
    int j=12;

    // notes:
    //  Runtime.getRuntime().gc() is an instance method
    // System.gc() is a class method. System.gc(), Internally calls Runtime.getRuntime().gc().
    public static void main(String[] args) {
        new FinalizeTest().add();
        new FinalizeTest().add();
        System.gc();
        FinalizeTest s1=new FinalizeTest();
        FinalizeTest s2=new FinalizeTest();
        s1=null;
        s2=null;
        System.gc();

    }


    void add()
    {
        j=j+12;
        System.out.println("J="+j);
    }
    // override
    protected void finalize()
    {
        System.out.println("Object is garbage collected");
    }
}