package com.codes.practice;

public class StringRemoveSpecialChars {
    public static void main(String[] args) {
        RemoveSpecialCharacterExample1();
        RemoveSpecialCharacterExample2();
        RemoveSpecialCharacterExample3();

    }

    private static void RemoveSpecialCharacterExample1()
    {
            String str= "This#string%contains^special*characters&.";
            str = str.replaceAll("[^a-zA-Z0-9]", " ");
            System.out.println(str);
    }
    private static void RemoveSpecialCharacterExample2()
    {
            String str = "Hello+-^Java+ -Programmer^ ^^-- ^^^ +!";
            str = str.replaceAll("[-+^]*", " ");
            //str=str.replaceAll("\\W", " ")    //we can also use this regular expression
            System.out.println(str);
    }

    private static void RemoveSpecialCharacterExample3()
    {
            //declare a string having special characters
            String str="Pr!ogr#am%m*in&g Lan?#guag(e";
            String resultStr="";
            //loop execute till the length of the string
            for (int i=0;i<str.length();i++)
            {
            //comparing alphabets with their corresponding ASCII value
                if (str.charAt(i)>64 && str.charAt(i)<=122) //returns true if both conditions returns true
                {
            //adding characters into empty string
                    resultStr=resultStr+str.charAt(i);
                }
            }
            System.out.println("String after removing special characters: "+resultStr);
    }
}
