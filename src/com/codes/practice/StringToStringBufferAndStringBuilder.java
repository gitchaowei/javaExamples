package com.codes.practice;

//
// 1) Objects of String are immutable, and objects of StringBuffer and StringBuilder are mutable.
// 2) StringBuffer is synchronized and StringBuilder is not synchronized
// 3) StringBuffer is thread-safe. So, multiple threads can’t access at the same time,
//    therefore, it is slow.
// 4) StringBuilder is not thread-safe hence faster than String Buffer
//    If thread safety is needed, then StringBuffer is used
//
public class StringToStringBufferAndStringBuilder {

    public static void main(String[] args) {
        // Custom input string
        String str = "Geeks";

        StringBuffer sbr = new StringBuffer(str);
        sbr.reverse();
        System.out.println(sbr);  //skeeG

        StringBuilder sbl = new StringBuilder(str);
        sbl.append("ForGeeks");
        System.out.println(sbl); //GeeksForGeeks
    }

    static void StringBufferToString(String[] args)
    {
        StringBuffer sbr = new StringBuffer("Geeks");
        StringBuilder sbdr = new StringBuilder("Hello");


        String str1 = sbr.toString();
        String str2 = sbdr.toString();

        System.out.println(str1);
        System.out.println(str2);

        sbr.append("ForGeeks");
        System.out.println(sbr);
        System.out.println(sbdr);
    }
    static void StringBufferToStringBuilder(String[] args) {
        StringBuffer sbr = new StringBuffer("Geeks");
        String str = sbr.toString();
        StringBuilder sbl = new StringBuilder(str);

        System.out.println(sbl);
    }
}
