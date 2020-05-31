package com.aleksandrmishin.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class CalcConsole {

    public void greet(){
        String greet = "Добро пожаловать в приложение Калькулятор!\n" +
                "Данное приложение поддерживает операции сложения/вычитания/деления/умножения.\n" +
                "Возможна работа как с целыми так и с дробными числами.\n" +
                "Приложение не поддерживает использование скобок и  отрицательных чисел.\n" +
                "Для выхода из приложения введите слово \"exit\".";
        System.out.println(greet);
    }

    public String getInputString() {
        System.out.println("\nДля того, чтобы вычислить выражение, введите его в строку ниже. (для завершения программы введите \"exit\")");

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            return scanner.nextLine().replaceAll("\\s", "").replaceAll(",",".");
        } else {
            getInputString();
        }
        return "";
    }

    public void ReportResponse(double response){
        NumberFormat numberFormat = new DecimalFormat("#.##");
        System.out.println("Ответ: " + numberFormat.format(response));
    }

}
