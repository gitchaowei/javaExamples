package com.Interview.BehavioralDesignPatterns;

import javax.naming.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//
// Calculator
public class StrategyDemo2 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the first value: ");
        float value1=Float.parseFloat(br.readLine());
        System.out.print("Enter the second value: ");
        float value2=Float.parseFloat(br.readLine());

        StrategyContext context = new StrategyContext(new Addition());
        System.out.println("Addition = " + context.executeStrategy(value1, value2));

        context = new StrategyContext(new Subtraction());
        System.out.println("Subtraction = " + context.executeStrategy(value1, value2));

        context = new StrategyContext(new Multiplication());
        System.out.println("Multiplication = " + context.executeStrategy(value1, value2));

        context = new StrategyContext(new Division());
        System.out.println("Multiplication = " + context.executeStrategy(value1, value2));
    }
}

interface Strategy {
    public float calculation(float a, float b);
}
class Subtraction  implements Strategy{
    @Override
    public float calculation(float a, float b) {
        return a-b;
    }
}

class Addition implements Strategy{

    @Override
    public float calculation(float a, float b) {
        return a+b;
    }

}
class Multiplication implements Strategy{

    @Override
    public float calculation(float a, float b){
        return a*b;
    }

}
class Division implements Strategy{

    @Override
    public float calculation(float a, float b){
        return a/b;
    }

}
class StrategyContext {

    private Strategy strategy;

    public StrategyContext(Strategy strategy){
        this.strategy = strategy;
    }

    public float executeStrategy(float num1, float num2){
        return strategy.calculation(num1, num2);
    }
}
