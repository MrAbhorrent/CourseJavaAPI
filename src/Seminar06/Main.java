package Seminar06;

import Utils.Utils;

import java.util.HashSet;

public class Main {

//    Задание
//    Создайте множество, в котором будут храниться экземпляры класса Cat - HashSet<Cat>. Поместите в него некоторое количество объектов.
//    Создайте 2 или более котов с одинаковыми параметрами в полях. Поместите их во множество. Убедитесь, что все они сохранились во множество.
//    Создайте метод
//        public boolean equals(Object o)
//    Пропишите в нём логику сравнения котов по параметрам, хранимым в полях. То есть, метод должен возвращать true, только если значения во всех полях сравниваемых объектов равны.
//    Создайте метод
//        public int hashCode()
//    который будет возвращать hash, вычисленный на основе полей класса Cat. (Можно использовать Objects.hash(...))
//    Выведите снова содержимое множества из пункта 2, убедитесь, что дубликаты удалились.

    public static void main(String[] args) {

        System.out.println("Класс без переопределенных методов equals() и hashCode()");
        HashSet<Cat> cats = new HashSet<>();
        cats.add(new Cat("Barsik", "white", 3, Sex.MALE));
        cats.add(new Cat("Murka", "black-brown", 2, Sex.FEMALE));
        cats.add(new Cat("Shveller", "white", 3, Sex.MALE));
        cats.add(new Cat("Barsik", "white", 3, Sex.MALE));

        System.out.println(cats);
        Utils.Divider('-', 50);
        System.out.println("Класс c переопределенными методами equals() и hashCode()");
        HashSet<CatAdvanced> cats2 = new HashSet<>();
        cats2.add(new CatAdvanced("Barsik", "white", 3, Sex.MALE));
        cats2.add(new CatAdvanced("Murka", "black-brown", 2, Sex.FEMALE));
        cats2.add(new CatAdvanced("Shveller", "white", 3, Sex.MALE));
        cats2.add(new CatAdvanced("Barsik", "white", 3, Sex.MALE));
        System.out.println(cats2);

    }
}
