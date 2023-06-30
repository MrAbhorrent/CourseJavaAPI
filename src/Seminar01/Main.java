package Seminar01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

//    Задание
//    1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
//    2) Вывести все простые числа от 1 до 1000
//    3) Реализовать простой калькулятор
//    4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69. Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.

    static boolean flag;

    public static void main(String[] args) {
        flag = true;
        int choose_task;
        while (flag) {
            choose_task = menu();
            Divider('=', 40);
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Выбран вариант - %d ", choose_task);
            System.out.println();
            switch (choose_task) {
                case 1:
                    System.out.print("Введите число N: ");
                    int n = scanner.nextInt();
                    System.out.printf("Треугольное число от %d равно - %d\n", n, TriangleNumber(n));
                    System.out.printf("Факториал числа %d равен %d\n", n, Factorial(n));
                    break;
                case 2:
                    System.out.println("Вывод простых чисел от 1 до 1000");
                    int example_value = 1000;
                    System.out.println(findSimpleNumbers(example_value));
                    break;
                case 3:
                    System.out.println("Калькулятор");
                    System.out.println("Введите арифметическое выражение (без скобок) и нажмите <Enter>");
                    String arithmeticEquation = scanner.nextLine();
                    System.out.printf("Результат вычисления - %.2f \n", Calculator.evaluate(arithmeticEquation));
                    break;
                case 4:
//                    System.out.println("Введите уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.");
//                    String queryArithmetic = scanner.nextLine();
                    System.out.println("Задача не решена");
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Введите число из диапазона от 1 до 4 или 0.");
            }
        }
    }


    public static void Divider(char symbol, int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append(symbol);
        }
        System.out.println(builder);
    }

    private static int menu() {
        int selected_variant = -1;
        System.out.println("Выберете вариант:\n" +
                "\t1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)\n" +
                "\t2) Вывести все простые числа от 1 до 1000\n" +
                "\t3) Реализовать простой калькулятор\n" +
                "\t4) Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.\n\t\tТребуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.\n" +
                "\t0) Выход из программы");
        System.out.print("Введите число [1-4]]: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            selected_variant = scanner.nextInt();
        }
        return selected_variant;
    }

    private static int TriangleNumber(int value) {
        return value > 0 ? ((int) (0.5f * value * (value + 1))) : -1;
    }

    private static int Factorial(int value) {
        int result = 1;
        if (value > 0) {
            result = value * Factorial(value - 1);
        }
        return result;
    }

    private static List<Integer> findSimpleNumbers(int value) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= value; i++) {
            boolean findOneFlag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    findOneFlag = false;
                    break;
                }
            }
            if (findOneFlag) {
                result.add(i);
            }
        }
        return result;
    }
}
