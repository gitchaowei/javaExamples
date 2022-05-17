package com.codes.practice;
import java.lang.reflect.Parameter;
import java.lang.reflect.Method;

class Calculate {
    int add(int a, int b){
        return (a+b);
    }
    int mul(int a, int b){
        return (b*a);
    }
}
public class ClassReflectionParameters {

    public static void main(String[] args) {
        // Creating object of a class
        Calculate calculate = new Calculate();
        // instantiating Class
        Class cls = calculate.getClass();
        // Getting declared methods inside the Calculate class
        Method[] methods = cls.getDeclaredMethods(); // It returns array of methods
        // Iterating method array
        for (Method method : methods) {
            System.out.print(method.getName());    // getting name of method
            // Getting parameters of each method
            Parameter[] parameters = method.getParameters(); // It returns array of parameters
            // Iterating parameter array
            for (Parameter parameter : parameters) {
                System.out.print(" "+parameter.getParameterizedType()); // returns type of parameter
                System.out.print(" "+parameter.getName()); // returns parameter name
            }
            System.out.println();
        }
    }
}
