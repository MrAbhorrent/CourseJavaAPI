package Seminar04;

import Seminar01.Calculator;
import Utils.Utils;

import java.util.*;

public class Main {
//    Задание
//    1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
//    2 *. Реализуйте очередь с помощью LinkedList со следующими методами:
//         enqueue() - помещает элемент в конец очереди,
//         dequeue() - возвращает первый элемент из очереди и удаляет его,
//         first() - возвращает первый элемент из очереди, не удаляя.
//    Это задание повышенной сложности, для решения задачи потребуется создать класс-обертку над LinkedList, например:
//
//      class MyQueue {
//          private LinkedList elements = new LinkedList();
//
//          public MyQueue() { }
//          public MyQueue(LinkedList linkedList) {
//              this.elements = linkedList;
//          }
//          .........
//      }
//    3. В калькулятор (урок 1 и 2) добавьте возможность отменить последнюю операцию.


    public static void main(String[] args) {
        System.out.println("1. Дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.");
        task1();
        Utils.Divider('▬', 80);
        System.out.println("2. Реализуйте очередь с помощью LinkedList со следующими методами:\n" +
                "\t\tenqueue() - помещает элемент в конец очереди,\n" +
                "\t\tdequeue() - возвращает первый элемент из очереди и удаляет его,");
        task2();
        Utils.Divider('▬', 80);
        System.out.println("3. В калькулятор (урок 1 и 2) добавьте возможность отменить последнюю операцию.");
        task3();
    }

    private static void task3() {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("Калькулятор");
            System.out.println("Введите арифметическое выражение (без скобок) и нажмите <Enter>\n" +
                    "\tДля вывода списка операций введите <M>\n" +
                    "\tДля выхода введите <Q>\n");
            String arithmeticEquation = scanner.nextLine();
            arithmeticEquation = arithmeticEquation.toLowerCase(Locale.ROOT);
            Stack<String> stack = new Stack<>();
            switch (arithmeticEquation) {
                case "q":
                    flag = false;
                    break;
                case "m":
                    System.out.println(stack);
                    Utils.Divider('-', 40);
                    System.out.print("Повторить послднюю операцию? ");
                    String answer = scanner.nextLine();
                    if (answer.toLowerCase(Locale.ROOT).equals("y")) {
                        String str = stack.pop();
                        System.out.printf("Результат вычисления - %.2f \n", Calculator.evaluate(str));
                    }
                    break;
                default:
                    stack.add(arithmeticEquation);
                    System.out.printf("Результат вычисления - %.2f \n", Calculator.evaluate(arithmeticEquation));
            }
        }
    }

    private static void task2() {
        MyQueue myQueue = new MyQueue();
        System.out.println("Создаем очередь:");
        System.out.println(myQueue);
        System.out.println("Заполняем очередь");
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        myQueue.enqueue(6);
        System.out.println("Вывод очереди");
        System.out.println(myQueue);
        System.out.printf("Убираем  %s\n", myQueue.dequeue());
        System.out.println("Состояние: ");
        System.out.println(myQueue);
        System.out.printf("Первый элемент - %s\n", myQueue.first());
        System.out.printf("Убираем %s\n", myQueue.dequeue());
        System.out.println("Состояние: ");
        System.out.println(myQueue);
    }

    private static void task1() {
        final int N = 10;
        LinkedList<Integer> linkedList = createLinkedList(N);
        System.out.println("Создан LinkedList: " + linkedList);
        System.out.println("Перевернутый список: " + reverseLinkedList(linkedList));
    }

    private static LinkedList<Integer> createLinkedList(int n) {
        final int MAX_VALUE = 20;
        Random random = new Random();
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            result.add(random.nextInt(MAX_VALUE));
        }
        return result;
    }

    private static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(list.get(list.size() - 1 - i));
        }
        return result;
    }
}
