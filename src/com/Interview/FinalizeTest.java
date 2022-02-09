package com.Interview;

public class FinalizeTest {
    int j=12;
    void add()
    {
        j=j+12;
        System.out.println("J="+j);
    }
    protected void finalize()
    {
        System.out.println("Object is garbage collected");
    }
    public static void main(String[] args) {
        new FinalizeTest().add();
        new FinalizeTest().add();
        System.gc();
//        FinalizeTest s1=new FinalizeTest();
//        FinalizeTest s2=new FinalizeTest();
//        s1=null;
//        s2=null;
//        System.gc();
    }
}