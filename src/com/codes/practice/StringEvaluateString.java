package com.codes.practice;

import java.util.Stack;

public class StringEvaluateString {

    public static int evaluate(String expression) {
        char[] tokens = expression.toCharArray();
        String operators = "+-*/";

        // Stack for numbers: 'values'
        Stack<Integer> values = new Stack<Integer>();

        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {
            // Current token is a whitespace, skip it
            if (tokens[i] == ' ')
                continue;

            // Current token is a number,
            // push it to stack for numbers
            if (Character.isDigit(tokens[i])) {
                StringBuffer valueBuffer = new StringBuffer();

                // There  may be more than one digits in number
                while (i < tokens.length && Character.isDigit(tokens[i]))
                    valueBuffer.append(tokens[i++]);
                values.push(Integer.parseInt(valueBuffer.toString()));
                // As we have move pointer ahead  we need to move it back once
                i--;
            }

            // Current token is an opening brace, push it to 'ops'
            else if (tokens[i] == '(')
                ops.push(tokens[i]);

                // Closing brace encountered, let's solve entire brace by poping out elements from ops and values till we get opening bracket
            else if (tokens[i] == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            // Current token is an operator.
            else if (operators.indexOf(tokens[i]) != -1) {
                // While top of 'ops' has same or greater precedence to current token, which is an operator.
                // Apply operator on top of 'ops' to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }

        // Entire expression has been parsed at this point, apply remaining ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        // Top of 'values' contains result, return it
        return values.pop();
    }

    // Returns true if 'op2' has higher
    // or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(
            char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') &&
                (op2 == '+' || op2 == '-'))
            return false;
        return true;
    }

    // A utility method to apply an operator to operand a and b
    public static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException(
                            "Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    // Driver method to test above methods
    public static void main(String[] args) {
        System.out.println(StringEvaluateString.
                evaluate("10 + 2*6"));
        System.out.println(StringEvaluateString.
                evaluate("100 * 2+ 12"));
        System.out.println(StringEvaluateString.
                evaluate("100 * ( 2 + 12 )"));
        System.out.println(StringEvaluateString.
                evaluate("0 * ( 2 + 12 ) / 1"));
    }
}
