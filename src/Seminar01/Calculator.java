package Seminar01;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    static List<String> operatorList = Arrays.asList("+", "-", "/", "*");

    public static float evaluate(String equation) {
        float result = 0;
        calculateOpetations(equation);
        return result;
    }

    private static String[] parseString(String str, String regex) {
        String[] result = str
                .replace(" ", "")
                .split(regex);
        return result;
    }

    private static float calculateOpetations(String str) {
        float result = 0f;
        // Ищем все операции в строке
        String[] numberOperation = parseString(str, "\\*|\\/|\\+|\\-");
        //List<String> numberOperationList = new ArrayList(Arrays.asList(numberOperation));
        // Ищем все числа в строке
        String[] mathOperation = parseString(str, "[^\\*|^\\/|^\\+|^\\-]+");
        //List<Character> mathOperationList = new ArrayList(Arrays.asList(mathOperation));
//        System.out.println(numberOperationList);
//        System.out.println(mathOperationList);

        if (mathOperation.length > 1) {
            // Получили массив из чисел
            // Теперь надо пробежаться по оригинальной строке и операции деления или умножения
            float[] resultOperation = new float[numberOperation.length];
            String[] tempMathOperation = new String[mathOperation.length];
            for (int i = 1; i < mathOperation.length; i++) {
                if (mathOperation[i].equals("*") | mathOperation[i].equals("/")) {
                    // необходимо произвести операцию "*" или "/"
                    switch (mathOperation[i]) {
                        case "*":
                            resultOperation[i - 1] = Float.parseFloat(numberOperation[i - 1]) * Float.parseFloat(numberOperation[i]);
                            break;
                        case "/":
                            resultOperation[i - 1] = Float.parseFloat(numberOperation[i - 1]) / Float.parseFloat(numberOperation[i]);
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + mathOperation[i]);
                    }
                } else {
                    resultOperation[i - 1] = Float.parseFloat(numberOperation[i - 1]);
                    tempMathOperation[i] = mathOperation[i];
                }
            }
            resultOperation[mathOperation.length - 1] = Float.parseFloat(numberOperation[numberOperation.length - 1]);
            // Пробежали математически операции высшего порядка
            // Теперь необходимо выполнить сложения и вычитания
            result = resultOperation[0];
            for (int i = 1; i < tempMathOperation.length; i++) {
                if (tempMathOperation != null && tempMathOperation[i].equals("+")) {
                    result += resultOperation[i];
                } else if (tempMathOperation != null && tempMathOperation[i].equals("-")) {
                    result -= resultOperation[i];
                }
            }
        }
        return result;
    }
}
