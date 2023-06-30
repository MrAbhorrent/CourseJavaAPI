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
            int rightPart = Integer.parseInt(allPartsEquiation[allPartsEquiation.length - 1]);
            String[] partsOperation = allPartsEquiation[0].split(Arrays.toString(OPERATION));
            String operation = findOperation(allPartsEquiation[0]);
        } else {
            result = "Нет решения";
        }
        return result;
    }

    private static String findOperation(String s) {
        for (char c : OPERATION) {
            if (s.indexOf(c) != -1)
                return String.valueOf(c);
        }
        return null;
    }
}
