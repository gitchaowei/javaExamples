package com.Interview;

import java.util.ArrayList;
import java.util.List;

//
// Amazon interview coding:
// example:
// secret shopping reward code [[apple,apple],[banana, orange, banana]]
// shopping cart1 [apple,banana,banana,orange,banana, apple, apple]: return 1 for reward
// shopping cart1 [apple,orange, banana,banana,apple,apple]: return 0 for no reward
public class AmazonCode4 {
    public static void main(String[] args) {
        List<List<String>> sCode = new ArrayList<>();
        List<String> sCodeItem = new ArrayList<>();
        sCodeItem.add("apple");
        sCodeItem.add("apple");
        sCode.add(sCodeItem);
        System.out.println("Code:" + sCode.get(0));

        sCodeItem = new ArrayList<>();
        sCodeItem.add("banana");
        sCodeItem.add("orange");
        sCodeItem.add("banana");
        sCode.add(sCodeItem);
        System.out.println("Code:" + sCode.get(1));

        List<String> shopItem1 = new ArrayList<>();
        shopItem1.add("banana");
        shopItem1.add("apple");
        shopItem1.add("apple");
        shopItem1.add("banana");
        shopItem1.add("orange");
        shopItem1.add("banana");
        shopItem1.add("banana");
        shopItem1.add("apple");
        System.out.println("Shopping 1:" + shopItem1);

        List<String> shopItem2 = new ArrayList<>();
        shopItem2.add("apple");
        shopItem2.add("banana");
        shopItem2.add("orange");
        shopItem2.add("banana");
        shopItem2.add("banana");
        shopItem2.add("apple");
        shopItem2.add("apple");
        System.out.println("Shopping 2:" + shopItem2);

        //int reward1 = isShoppingRewarded(sCode, shopItem1 );
        int reward1 = isShoppingRewarded2(sCode,shopItem1 );

            System.out.println("1. Reward: " + reward1);

        //int reward2 = isShoppingRewarded(sCode, shopItem2 );
        int reward2 = isShoppingRewarded2(sCode,shopItem2 );
        System.out.println("2. Reward: " + reward2);

    }

    static int isShoppingRewarded(List<List<String>> sCode,List<String> shopItems ) {
        int matchIndex = 0;
        boolean matched=false;

        if (sCode.size() < 1) return 0;

        for (List<String> sCodeItem: sCode) {
            int searchlen = sCodeItem.size();
            if (matchIndex >= shopItems.size()) {
                matched=false;
            }
                // check each fruit in a code
                for (int j=matchIndex; j< shopItems.size(); j++) {
                    // check if fruits in the code match shopping cart
                    if (!shopItems.get(j).equals(sCodeItem.get(0))) {
                        matched = false;
                        continue;
                    }
                    else
                    {
                        matched= true;
                        // check if match all fruit sequence in the code
                        for (int k=1; k<searchlen; k++) {
                            if (!shopItems.get(j+k).equals(sCodeItem.get(k))) {
                                matched = false;
                                break;  // break k loop
                            }
                        }
                        if (matched) {
                            matchIndex = j + searchlen;
                            break; // break j loop
                        }
                    }

                    if (matched) break; // break j loop and continue next code
                } //j loop - ship items
        } // loop of code

        if (matched) {
            return 1;
        } else {
            return 0;
        }

    }

    static int isShoppingRewarded2(List<List<String>> sCode,List<String> shopItems ) {
        int matchIndex = 0;
        boolean matched=false;

        if (sCode.size() < 1) return 0;

        for (List<String> sCodeItem: sCode) {
            int searchlen = sCodeItem.size();
            if (matchIndex >= shopItems.size()) {
                matched=false;
                break;
            }

            // check each fruit in a code
            for (int j=matchIndex; j< shopItems.size(); j++) {
                // check if fruits in the code match shopping cart

                if (!sCodeItem.equals(shopItems.subList(j,j+searchlen))) {
                    matched = false;
                    continue;
                }
                else
                {
                    matched= true;
                    matchIndex = j + searchlen;
                    break; // break j loop
                }
            } //j loop - ship items
        } // loop of code

        if (matched) {
            return 1;
        } else {
            return 0;
        }
    }
}

