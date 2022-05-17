package com.codes.practice.DesignPatterns.Structral;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DecoratorPatternCustomer {
	private static int  choice;

	public static void main(String args[]) throws NumberFormatException, IOException
	{
//		String str = "Hello/This is JavaTpoint/My name is Abhishek.";
//		//Create scanner with the specified String Object
//		Scanner scanner = new Scanner(str);
//		System.out.println("Boolean Result: "+scanner.hasNextBoolean());
//		//Change the delimiter of this scanner
//		scanner.useDelimiter("/");
//		//Printing the tokenized Strings
//		System.out.println("---Tokenizes String---");
//		while(scanner.hasNext()){
//			System.out.println(scanner.next());
//		}
//		//Display the new delimiter
//		System.out.println("Delimiter used: " +scanner.delimiter());
//		scanner.close();

		Integer i = 201;
		Integer j = 201;
		if(i == j)
		{
			System.out.println("hello");
		}
		else
		{
			System.out.println("bye");
		}

		do{
			System.out.print("========= Food Menu ============ \n");
			System.out.print("            1. Vegetarian Food.   \n");
			System.out.print("            2. Non-Vegetarian Food.\n");
			System.out.print("            3. Chineese Food.         \n");
			System.out.print("            4. Exit                        \n");
			System.out.print("Enter your choice: ");

			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

			choice=Integer.parseInt(br.readLine());

			switch (choice) {
				case 1:
				{
					VegFood vf=new VegFood();
					System.out.println(vf.prepareFood());
					System.out.println( vf.foodPrice());
				}
				break;

				case 2:
				{
					Food f1=new NonVegFood((Food) new VegFood());
					System.out.println(f1.prepareFood());
					System.out.println( f1.foodPrice());
				}
				break;

				case 3:
				{
					Food f2=new ChineseFood((Food) new VegFood());
					System.out.println(f2.prepareFood());
					System.out.println( f2.foodPrice());
				}
				break;

				default:
				{
					System.out.println("Other than these no food available");
				}
				return;
			}

		}while(choice!=4);
	}
}

interface Food {
	public String prepareFood();
	public double foodPrice();
}

// Abstract class but all methods are implemented
abstract class FoodDecorator implements Food
{
	private Food newFood;
	public FoodDecorator(Food newFood)
	{
		this.newFood=newFood;
	}

	@Override
	public String prepareFood()
	{
		return newFood.prepareFood();
	}
	@Override
	public double foodPrice()
	{
		return newFood.foodPrice();
	}
}

class ChineseFood extends FoodDecorator
{
	public ChineseFood(Food newFood)
	{
		super(newFood);
	}

	@Override
	public String prepareFood()
	{
		return super.prepareFood() +" With Fried Rice and Manchurian  ";
	}

	@Override
	public double foodPrice()
	{
		return super.foodPrice()+65.0;
	}
}

class NonVegFood extends FoodDecorator{
	public NonVegFood(Food newFood)
	{
		super(newFood);
	}

	@Override
	public String prepareFood()
	{
		return super.prepareFood() +" With Roasted Chiken and Chiken Curry  ";
	}

	@Override
	public double foodPrice()
	{
		return super.foodPrice()+150.0;
	}
}

class VegFood implements Food {
	public String prepareFood()
	{
		return "Veg Food";
	}

	public double foodPrice()
	{
		return 50.0;
	}
}
