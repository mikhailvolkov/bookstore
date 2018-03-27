package com.bookstore.ui;

import java.util.Scanner;
import java.util.function.Function;
public abstract class AbstractState {

    private static Scanner scanner = new Scanner(System.in, "UTF-8");

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

    public void printDelimiter() {
        System.out.println("--------------------------------------------");
    }

    protected String readStringInput(String prefix) {
        System.out.print(prefix);
        String line = scanner.nextLine();
        return line;
    }

    protected <R> R readInput(String prefix, Function<String, R> convertFunction) {
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

    protected int readIntInput(String prefix) {
        return readInput(prefix, s -> Integer.parseInt(s.trim()));
    }

    protected int readIntInput(final String prefix, final int max) {
        return readInput(prefix, s -> {
            int i = Integer.parseInt(s);
            if (i > max) {
                throw new IllegalArgumentException("Вводимое значение не может быть больше " + max);
            }
            return i;
        });
    }

    protected double readDoubleInput(String prefix) {
        return readInput(prefix, s -> Double.parseDouble(s.trim()));
    }

    protected abstract int printMainActions();

    protected abstract void runAction(int action);

    private int readUserActionInput(int maxInput) {
        do {
            int action = readIntInput("Введите необходимое действие: ");
            if (action >= 0 && action <= maxInput) {
                return action;
            }
        } while (true);
    }

}
