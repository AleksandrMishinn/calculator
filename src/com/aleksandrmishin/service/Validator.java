package com.aleksandrmishin.service;

import com.aleksandrmishin.exception.IncorrectInputStringException;

public class Validator {

    public void validate(String inputString) throws IncorrectInputStringException {

        if (inputString.matches(".*\\s*/0.*")) {
            throw new IncorrectInputStringException("\nНекорректное выражение. Деление на ноль в выражении.");
        }

//        (!inputString.matches("\\(*\\-*[0-9][.,]*[0-9]*\\)*([/\\*\\+\\-]\\(*\\-*[0-9][.,]*[0-9]*\\)*)*")) for the advanced version
        if (!inputString.matches("\\(*[0-9][.,]*[0-9]*\\)*([/*+\\-]\\(*[0-9][.,]*[0-9]*\\)*)*")) {
            throw new IncorrectInputStringException("\nНекорректное выражение. Убедитесь, что в выражении присутствуют только цифры и знаки математических операций.\n" +
                    "Проверьте правильность последовательности.");
        }
    }
}


