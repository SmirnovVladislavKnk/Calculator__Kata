package Calculator;

import java.util.Scanner;

public class Main {
    public static String calc(String input) throws Exception {
        char sign;
        String rome;
        boolean arabian;
        int a, b, result;

        String[] array = input.trim().split(" ");

        if (array.length - 1 != 2 | input.isEmpty()) {
            throw new Exception("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *))");
        }

        try {
            a = Integer.parseInt(array[0]);
            b = Integer.parseInt(array[2]);
            arabian = true;
        } catch (Exception e) {
            arabian = false;
            try {
                a = RomeNumbers.valueOf(array[0]).ordinal();
                b = RomeNumbers.valueOf(array[2]).ordinal();
            } catch (Exception e1) {
                throw new Exception("//т.к. используются одновременно разные системы счисления");
            }
        }

        if (a < 0 | a > 10 | b < 0 | b > 10) {
            throw new Exception("//т.к числа должны быть от 1 (I) до 10 (X)");
        }

        sign = array[1].charAt(0);

        switch (sign) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '*' -> result = a * b;
            case '/' -> result = a / b;
            default -> throw new Exception("//т.к такой арифмитической операции нет");
        }

        if (arabian) {
            return String.valueOf(result);
        } else {
            if (result < 1) {
                throw new Exception("//т.к. в римской системе нет отрицательных чисел");
            }
            rome = String.valueOf(RomeNumbers.values()[result]);
            return rome;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение: ");
        Scanner scanner = new Scanner(System.in);
        String result = calc(scanner.nextLine());
        System.out.println("Выражение равно: " + result);
    }
}
