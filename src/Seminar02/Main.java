package Seminar02;


import Utils.Utils;
import jdk.internal.util.xml.impl.Pair;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

    /*Задание
    1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
            Если значение null, то параметр не должен попадать в запрос.
    Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
    2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

    Дополнительные задания
    3) Дана json-строка (можно сохранить в файл и читать из файла)
            [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
    Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
    Пример вывода:
        Студент Иванов получил 5 по предмету Математика.
        Студент Петрова получил 4 по предмету Информатика.
        Студент Краснов получил 5 по предмету Физика.

    4) К калькулятору из предыдущего ДЗ добавить логирование.
    */
    public static void main(String[] args) {

        Task1();
        Utils.Divider('=', 80);
        Task2();
        Utils.Divider('=', 80);
        Task3();
    }

    private static void Task1() {
        System.out.println("Задача 1.");

        ArrayList keys = new ArrayList<>(4);
        keys.add("name");
        keys.add("county");
        keys.add("city");
        keys.add("age");
        System.out.println(keys);

        ArrayList value = new ArrayList<>(3);
        value.add("Ivanov");
        value.add("Russia");
        value.add("Moscow");
        System.out.println(value);

        System.out.println("Выводим запрос: \n" + createSQLQuery(keys, value));
    }

    private static String createSQLQuery(ArrayList _keys, ArrayList _value) {

        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM Students WHERE ");
        int max = (_keys.size() > _value.size()) ? _value.size() : _keys.size();
        for (int i = 0; i < max; i++) {
            if (_keys.get(i) != null || _value.get(i) != null) {
                stringBuilder
                        .append(_keys.get(i))
                        .append("=")
                        .append(_value.get(i));
            }
            if (i < max - 1 ) {
                stringBuilder.append(" AND ");
            }
        }
        return stringBuilder.toString();
    }

    private static void Task2() {
        System.out.println("Задача 2.");
        int n = 10;
        int[] beforeArray = GenerateArray(n);

            System.out.println("Original array => " + Arrays.toString(beforeArray));

            int[] afterArray = BubbleSort(beforeArray);
            System.out.println("Sorted array   => " + Arrays.toString(afterArray));

    }

    private static int[] GenerateArray(int n) {
        int upperBorder = 10;
        Random random = new Random();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = random.nextInt(upperBorder);
        }
        return result;
    }

    private static int[] BubbleSort(int[] array) {
        int[] result = array;
        SaveLogFile("Original array => " + Arrays.toString(result));
        for (int i = result.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (result[j] > result[j + 1]) {
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
            SaveLogFile("Итерация - " + (result.length - i) + " => " + Arrays.toString(result));
        }
        return result;
    }

    private static void SaveLogFile(String saveLine) {
        File logfile = new File("BubbleSort.log");
        try (FileWriter fileWriter = new FileWriter(logfile, true)) {
            fileWriter.append(saveLine);
            fileWriter.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void Task3() {
        System.out.println("Задача 3.");

    }
}