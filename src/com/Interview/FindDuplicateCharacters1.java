package com.Interview;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateCharacters1 {
    public static void main(String[] args) {
        String str = "programming";

//        int count = 1;
//        // method 1
//        List<Character> charList = new ArrayList<>();
//        for (int i=0; i< str.length(); i++) {
//            char ch = str.charAt(i);
//            if (!charList.contains(ch)) {
//                for (int j= i+1; j<str.length();j++){
//                    if (ch==str.charAt(j)) {
//                        count++;
//                    }
//                }
//            }
//            if (count >1) {
//                System.out.println(ch+ ":"+ count);
//            }
//
//            charList.add(ch);
//            count = 1;
//        }

        // method 2
        Map<Character, Integer> results = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (results.containsKey(ch)) {
                results.put(ch, results.get(ch) + 1);
            } else {
                results.put(ch, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : results.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }

    }


}
