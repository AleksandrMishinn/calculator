package com.aleksandrmishin;

import com.aleksandrmishin.service.CalcConsole;
import com.aleksandrmishin.service.Calculator;

public class Main {
    public static void main(String[] args) {
        CalcConsole calcConsole = new CalcConsole();
        calcConsole.greet();
        Calculator calculator = new Calculator();
        calculator.calculate();
    }
}
