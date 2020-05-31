package com.aleksandrmishin.service;

import java.util.Stack;

public class ReversePolishParser {

    public String parse(String inputString) {

        StringBuilder outputString = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int currentPriority;

        for (char currentChar : inputString.toCharArray()) {
            switch (currentPriority = getPriority(currentChar)) {
                case 1:
                    stack.push(currentChar);
                    break;
                case 2:
                case 3:
                    outputString.append(' '); //splitter
                    while (!stack.empty()) {
                        if (getPriority(stack.peek()) >= currentPriority) {
                            outputString.append(' '); //splitter
                            outputString.append(stack.pop());
                        } else {
                            break;
                        }
                    }
                    stack.push(currentChar);
                    break;
                case -1:
                    while (getPriority(stack.peek()) != 1) {
                        outputString.append(' '); //splitter
                        outputString.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    outputString.append(currentChar);
            }
        }

        while (!stack.empty()) {
            outputString.append(' '); //splitter
            outputString.append(stack.pop());
        }
        return outputString.toString();
    }

    private int getPriority(char token) {
        switch (token) {
            case ('*'):
            case ('/'):
                return 3;
            case ('+'):
            case ('-'):
                return 2;
            case ('('):
                return 1;
            case (')'):
                return -1;
            default:
                return 0;
        }
    }

}


