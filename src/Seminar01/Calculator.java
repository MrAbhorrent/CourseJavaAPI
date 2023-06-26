package Seminar01;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    static List<String> operatorList = Arrays.asList("+","-","/","*");

    public static float evaluate(String equation){
        float result = 0;
        List<String> listNumbers = Arrays.asList(equation.replace(" ","").split(operatorList.toString()));
        System.out.println(listNumbers);
        return result;
    }

    private static void parseString(String str) {

    }
}
