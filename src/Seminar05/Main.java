package Seminar05;

import Utils.Utils;

import java.util.*;

public class Main {
//    Задание
//
//    Написать простой класс Телефонный Справочник (с помощью HashMap), который хранит в себе список фамилий и телефонных номеров.
//    В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
//    Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
//    тогда при запросе такой фамилии должны выводиться все телефоны.
//
//***Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
//    взаимодействие с пользователем через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного справочника.

    static String[] testList = {
            "Иванов;+79123456789",
            "Петров;+79234567890",
            "Сидоров;+79345678901",
            "Смирнов;+79456789012",
            "Кузнецов;+79567890123",
            "Попов;+79678901234",
            "Лебедев;+79789012345",
            "Козлов;+79890123456",
            "Новиков;+79901234567",
            "Сидоров;+79012345678",
            "Петров;+79123456780",
            "Иванов;+79234567801",
            "Смирнов;+79345678902",
            "Кузнецов;+79456789023",
            "Попов;+79567890134",
            "Лебедев;+79678901245",
            "Козлов;+79789012356",
            "Новиков;+79890123467",
            "Петров;+79901234578",
            "Иванов;+79012345689",
            "Сидоров;+79123456790",
            "Смирнов;+79234567801",
            "Кузнецов;+79345678902",
            "Попов;+79456789013",
            "Лебедев;+79567890124",
            "Козлов;+79678901235",
            "Новиков;+79789012346",
            "Сидоров;+79890123457",
            "Петров;+79901234568",
            "Иванов;+79012345679"
    };

    public static void main(String[] args) {
        boolean exitFlag = false;
        int chooseVariant;
        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();
        while (!exitFlag) {
            System.out.println("Телефонный Справочник");
            Utils.Divider('=', 55);
            chooseVariant = menu();
            Scanner scanner = new Scanner(System.in);
            switch (chooseVariant) {
                case 1:

                    System.out.println("Заполняем телефонный справочник тестовыми данными");
                    loadTestList(telephoneDirectory, testList);
                    Utils.Divider('*', 55);
                    break;
                case 2:
                    System.out.println("Добавление записи");
                    System.out.println("Введите фамилию");
                    String family = scanner.nextLine();
                    System.out.println("Введите телефон");
                    String phoneNumber = scanner.nextLine();

                    telephoneDirectory.add(Utils.capitalize(family), phoneNumber);
                    break;
                case 3:
                    System.out.println("Поиск записи");
                    System.out.println("Введите фамилию");
                    String searchFamily = scanner.nextLine();
                    telephoneDirectory.print(searchFamily);
                    break;
                case 4:
                    System.out.println("Печать телефонной книги");
                    telephoneDirectory.printAll();
                    break;
                case 0:
                    exitFlag = true;
                    break;
                default:
                    System.out.println("Введите число из диапазона от 1 до 4 или 0.");
            }
            Utils.Divider('=', 55);
        }



        System.out.println("Вывод содержимого на экран:");
        telephoneDirectory.printAll();

    }


    private static int menu() {
        int selected_variant = -1;
        System.out.println("Выберете вариант:\n" +
                "\t1) Заполнить справочник тестовыми данными\n" +
                "\t2) Добавить запись\n" +
                "\t3) Найти запись\n" +
                "\t4) Распечатать справочник\n" +
                "\t0) Выход из программы");
        System.out.print("Введите число [1-4]]: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            selected_variant = scanner.nextInt();
        }
        return selected_variant;
    }

    private static void loadTestList(TelephoneDirectory telephoneDirectory, String[] array) {
        for (String item: array) {
            String[] parts = item.split(";");
            if (parts.length == 2) {
                telephoneDirectory.add(parts[0], parts[1]);
            }
        }
    }
}
