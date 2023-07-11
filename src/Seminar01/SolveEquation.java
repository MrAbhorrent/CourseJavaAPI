package Seminar01;

import java.util.Arrays;

public class SolveEquation {

    private static final char[] OPERATION = { '+', '-' };
    public static String Solve(String str){
        String result = "";
        String[] allPartsEquation = str
                .replace(" ", "")
                .split("=");
        if (allPartsEquation.length == 2) {
            String[] partsOperation = allPartsEquation[0].split(Arrays.toString(OPERATION));
            String operation = findOperation(allPartsEquation[0]);
            String rightPartStr = allPartsEquation[allPartsEquation.length - 1];
            String firstPartStr = partsOperation[0];
            String secondPartStr = partsOperation[1];
            int rightPartLength = rightPartStr.length();
            int firstPartLength = firstPartStr.length();
            int secondPartLength = secondPartStr.length();
            int maxLength = findMaxNumber(rightPartLength, firstPartLength, secondPartLength);
            for (int i = 0; i < maxLength ; i++) {
                if (checkQuestionMark(rightPartStr.substring(rightPartLength - i))) {
                    System.out.println("Справа знак вопроса.");
                    if (checkQuestionMark(firstPartStr.substring(firstPartLength - i))) {
                        //TODO: Обработать вариант когда у нас два знака вопроса
                        System.out.println("Слева у первого слагаемого знак вопроса.");
                    } else {
                        if (checkQuestionMark(secondPartStr.substring(secondPartLength - i))) {
                            //TODO: А здесь у нас уже знак вопроса во втором слагаемом
                        } else {

                        }
                    }
                }
            }
        } else {
            result = "Нет решения";
        }
        return result;
    }

    private static boolean checkQuestionMark(String str) {
        return str.equals("?");
    }

    private static int findMaxNumber(int a, int b, int c) {
        int result = -1;
        if (a > b) {
            if (a > c) {
                result = a;
            } else {
                result = c;
            }
        } else if (a > c) {
            result = b;
        }
        return  result;
    }
    private static String findOperation(String s) {
        for (char c : OPERATION) {
            if (s.indexOf(c) != -1)
                return String.valueOf(c);
        }
        return null;
    }
}
