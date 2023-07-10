package Seminar03;

import Utils.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Main {

//    Задание
//    Пусть дан произвольный список целых чисел.
//          1) Нужно удалить из него чётные числа
//          2) Найти минимальное значение
//          3) Найти максимальное значение
//          4) Найти среднее значение

    public static void main(String[] args) {
        System.out.println("Задача по семинару 3");
        Utils.Divider('*', 80);
        ArrayList<Integer> simpleList = createList();
        System.out.println(simpleList);
        Utils.Divider('▼', 80);
        System.out.println("1) Нужно удалить из него чётные числа");
        ArrayList<Integer> simpleList2 = removeOddNumbers(simpleList);
        System.out.println("Результирующий список => " + simpleList2);
        Utils.Divider('▼', 80);
        System.out.println("2) Найти минимальное значение");
        Collections.sort(simpleList);
        System.out.println("Минимальное значение = " + simpleList.get(0));
        Utils.Divider('▼', 80);
        System.out.println("3) Найти максимальное значение");
        simpleList.sort(Collections.reverseOrder());
        System.out.println("Максимальное значение = " + simpleList.get(0));
        Utils.Divider('▼', 80);
        System.out.println("4) Найти среднее значение");
        Double avgNumber = findAVGNumber(simpleList);
        System.out.println("Среднее значение - " + avgNumber);
    }

    private static Double findAVGNumber(ArrayList<Integer> simpleList) {
        Double result = 0.0;
        for (Integer integer : simpleList) {
            result += integer;
        }
        result /= simpleList.size();
        return result;
    }

    private static ArrayList<Integer> removeOddNumbers(ArrayList<Integer> simpleList) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer integer : simpleList) {
            if (integer % 2 != 0) {
                result.add(integer);
            }
        }
        return result;
    }

    private static ArrayList<Integer> createList() {
        final int MAX_SIZE_LIST = 30;
        final int MIN_VALUE = -5;
        final int MAX_VALUE = 10;
        Random random = new Random();
        int size = random.nextInt(MAX_SIZE_LIST);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(random.nextInt(MAX_VALUE + 1));
        }
        return result;
    }

}
