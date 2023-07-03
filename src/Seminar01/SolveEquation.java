package Seminar01;

import java.util.Arrays;

public class SolveEquation {

    private static final char[] OPERATION = { '+', '-' };
    public static String Solve(String str){
        String result = "";
        String[] allPartsEquiation = str
                .replace(" ", "")
                .split("=");
        if (allPartsEquiation.length == 2) {
            String[] partsOperation = allPartsEquiation[0].split(Arrays.toString(OPERATION));
            String operation = findOperation(allPartsEquiation[0]);
            String rightPartStr = allPartsEquiation[allPartsEquiation.length - 1];
            String firstPartStr = partsOperation[0];
            String secondPartStr = partsOperation[1];
            int rightPartLength = rightPartStr.length();
            int firstPartLength = firstPartStr.length();
            int secondPartLength = secondPartStr.length();
            int maxLength = findMaxNumber(rightPartLength, firstPartLength, secondPartLength);
            for (int i = 0; i < maxLength ; i++) {
                if (checkQuestionMark(rightPartStr.substring(rightPartLength - i))) {
                    System.out.println("Справа знак вопроса.");;
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
