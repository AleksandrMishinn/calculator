package com.aleksandrmishin.service;

import com.aleksandrmishin.exception.IncorrectInputStringException;

import java.util.Stack;

public class Calculator {

    private static Validator validator = new Validator();
    private static CalcConsole calcConsole = new CalcConsole();
    private static ReversePolishParser reversePolishParser = new ReversePolishParser();

    public void calculate() {
        String inputString = calcConsole.getInputString();

        if (inputString.equalsIgnoreCase("exit")) {
            return;
        }

        try {
            validator.validate(inputString);
        } catch (IncorrectInputStringException e) {
            System.err.println(e);
            calculate();
            return;
        }

        calcConsole.ReportResponse(evaluatedExpression(reversePolishParser.parse(inputString)));

        calculate();
    }


    public double evaluatedExpression(String expression) {
        Stack<Double> stack = new Stack<>();
        StringBuilder operand = new StringBuilder();

        for (char currentChar : expression.toCharArray()) {

            if (currentChar == ' ') {
                if (!(operand.length() == 0)) {
                    stack.push(Double.parseDouble(operand.toString()));
                    operand = new StringBuilder();
                }
                continue;
            }

            if (Character.isDigit(currentChar) || currentChar == '.' || currentChar == ',') {
                operand.append(currentChar);
                continue;
            }

            double a = stack.pop();
            double b = stack.pop();

            switch (currentChar) {
                case ('+'):
                    stack.push(b + a);
                    break;
                case ('-'):
                    stack.push(b - a);
                    break;
                case ('*'):
                    stack.push(b * a);
                    break;
                case ('/'):
                    stack.push(b / a);
                    break;
            }
        }
        return stack.pop();
    }

}

