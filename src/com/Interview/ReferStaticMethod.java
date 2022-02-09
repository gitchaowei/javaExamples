package com.Interview;

import java.util.function.BiFunction;

interface Sayable{
	void say();
}
class Arithmetic{
	public static int add(int a, int b){
		return a+b;
	}
	public static float add(int a, float b){
		return a+b;
	}
	public static float add(float a, float b){
		return a+b;
	}
}
public class ReferStaticMethod {

		public static void saySomething(){
			System.out.println("Hello, this is static method.");
		}

		public static void ThreadStatus(){
			System.out.println("Thread is running...");
		}
		public static void main(String[] args) {
			// Referring static method 1
			Sayable sayable = ReferStaticMethod::saySomething;
			// Calling interface method
			sayable.say();

			// Referring static method 2
			//using predefined functional interface Runnable to refer static method
			Thread t2=new Thread(ReferStaticMethod::ThreadStatus);
			t2.start();

			// Referring static method 3
			//using predefined functional interface to refer methods. In the following example,
			// we are using BiFunction interface and using it's apply() method.
			BiFunction<Integer, Integer, Integer> adder = Arithmetic::add;
			int result = adder.apply(10, 20);
			System.out.println(result);

			// Referring static method 4 :

			BiFunction<Integer, Integer, Integer>adder1 = Arithmetic::add;
			BiFunction<Integer, Float, Float>adder2 = Arithmetic::add;
			BiFunction<Float, Float, Float>adder3 = Arithmetic::add;
			int result1 = adder1.apply(10, 20);
			float result2 = adder2.apply(10, 20.0f);
			float result3 = adder3.apply(10.0f, 20.0f);
			System.out.println(result1);
			System.out.println(result2);
			System.out.println(result3);
		}
}
