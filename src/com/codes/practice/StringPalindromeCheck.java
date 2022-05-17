package com.codes.practice;

// A palindrome is a word or phrase that can be read the same way backward or forward,
// as with the words redivider, kayak, and civic.
public class StringPalindromeCheck {

    public static void main(String[] args) {
        String str = "redivider";
        if (bFindPalindromeString1(str) == true) {
            System.out.println("String :" + str + " is a Palindrome string");
        } else {
            System.out.println("String :" + str + " is not Palindrome string");
        }

        String str1 = "redivider2";
        if (bFindPalindromeString2(str1) == true) {
            System.out.println("String :" + str1 + " is a Palindrome string");
        } else {
            System.out.println("String :" + str1 + " is not Palindrome string");
        }
    }

    // method 1
    private static boolean bFindPalindromeString1(String origStr) {
        String revertStr;
        boolean isPalindromeStr = true;

        int i = 0;
        int j = origStr.length() - 1;

        while (i < j) {
            if (origStr.charAt(i) != origStr.charAt(j)) {
                isPalindromeStr = false;
                break;
            }
            i++;
            j--;
        }
        return isPalindromeStr;
    }

    // method 2
    private static boolean bFindPalindromeString2(String origStr) {
        String revertStr;
        boolean isPalindromeStr = true;

        revertStr = reverseStringChars(origStr);
        if (!revertStr.equals(origStr)) {
            isPalindromeStr = false;
        }
        return isPalindromeStr;

    }
    // recursive method
    public static String reverseStringChars(String s)
    {
        //checks the string if empty
        if (s.isEmpty())
            return s;
        //recursively called function
        return reverseStringChars(s.substring(1)) + s.charAt(0);
    }
}