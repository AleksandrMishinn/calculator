package com.aleksandrmishin.service;

import com.aleksandrmishin.exception.IncorrectInputStringException;

public class Validator {

    public void validate(String inputString) throws IncorrectInputStringException {
        boolean isValid;

        for (char currentChar : inputString.toCharArray()) {
            isValid = ((currentChar >= '0') && (currentChar <= '9')) ||
                    currentChar == '+' || currentChar == '-' ||
                    currentChar == '/' || currentChar == '*' ||
                    currentChar == '.' || currentChar == ',' ||
                    currentChar == '(' || currentChar == ')';

            if (!isValid) {
                throw new IncorrectInputStringException("\nНекорректное выражение. Убедитесь, что в выражении присутствуют только цифры и знаки математических операций.");
            }
        }
    }

}
