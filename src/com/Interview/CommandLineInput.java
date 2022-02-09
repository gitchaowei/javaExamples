package com.Interview;

public class CommandLineInput {


    public static void main(String[] args) {
        int sum = 0;

        for (int i = 0; i < args.length; i++) {
            System.out.println("input number: " + args[i]);
            try {
                int num = Integer.parseInt(args[i]);
                sum += num;
            } catch (NumberFormatException e) {
                System.out.println("Non number string error: " + e);
//                return;
            }
//            finally {
//                continue;
//            }
        }
        System.out.println("Sum is " + sum);
    }
}
