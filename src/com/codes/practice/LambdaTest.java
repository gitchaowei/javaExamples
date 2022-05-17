package com.codes.practice;

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}
@FunctionalInterface
interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
class Lambda4 {
    // test variable scope in Lamda function
    static int outerStaticNum =5;
    int outerNum =10;  // no problem here outside testScope() method

    void testScopes() {
        // int[] outerNum = {11,2}; // no problem with an array
        //int outerNum = 23; // problem using here inside testScope() method:
                            // Variable used in lambda expression should be final or effectively final

        // Lambda expressions can use variables defined in an outer scope.
        // We refer to these lambdas as capturing lambdas.
        // hey can capture static variables, instance variables, and
        // local variables, but only local variables must be final or effectively final.
        //
        // when an anonymous inner class captured a variable local to the method that surrounded it –
        // we needed to add the final keyword before the local variable for the compiler to be happy.
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 32;
            outerStaticNum = 72;
            return String.valueOf(from + outerNum );
        };
        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 27;
            outerNum = 23;
            int x=90;
            return String.valueOf(from + outerStaticNum+x);
        };
        System.out.println( stringConverter1.convert(45));
        System.out.println(stringConverter2.convert(45));
    }
}
//abstract class converter implements Converter <String, Integer> {
//    Integer convert(String s) {
//        return Integer.valueOf(s);
//    }
//}

public class LambdaTest {

    public static void main(String[] args) {

        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123

        Lambda4 lamda4 = new Lambda4();
        lamda4.testScopes();
    }
}
