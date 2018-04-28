package com.bookstore.ui;

import java.util.Scanner;
import java.util.function.Function;
public abstract class AbstractСonsoleUi {

    private static Scanner scanner = new Scanner(System.in, "UTF-8");

    abstract int printMainActions();

    abstract void runAction(int action);

    public void run() {
        int action = 0;
        do {
            printDelimiter();
            int maxInput = printMainActions();
            action = readUserActionInput(maxInput);
            System.out.println("");
            if (action > 0) {
                runAction(action);
            }
        } while (action > 0);
    }

    private void printDelimiter() {
        System.out.println("--------------------------------------------");
    }

    String readStringInput(String prefix) {
        System.out.print(prefix);
        String line = scanner.nextLine();
        return line;
    }

    private <R> R readInput(String prefix, Function<String, R> convertFunction) {
        R input = null;
        do {
            String str = readStringInput(prefix);
            try {
                input = convertFunction.apply(str);
            } catch (Exception e) {
                System.err.println("Ошибка конвертации: " + e.getMessage());
                input = null;
            }
        } while (input == null);
        return input;
    }

    int readIntInput(String prefix) {
        if (prefix == null) {
            return 0;
        }
        return readInput(prefix, s -> Integer.parseInt(s.trim()));
    }

    int readIntInput(final String prefix, final int max) {
        return readInput(prefix, s -> {
            int i = Integer.parseInt(s);
            if (i > max) {
                throw new IllegalArgumentException("Вводимое значение не может быть больше " + max);
            }
            return i;
        });
    }

    double readDoubleInput(String prefix) {
        if (prefix == null) {
            return 0;
        }
        return readInput(prefix, s -> Double.parseDouble(s.trim()));
    }

    int readUserActionInput(int maxInput) {
        do {
            int action = readIntInput("Введите необходимое действие: ");
            if (action >= 0 && action <= maxInput) {
                return action;
            }
        } while (true);
    }

}
