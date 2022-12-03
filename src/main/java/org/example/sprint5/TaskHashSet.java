package org.example.sprint5;

import java.util.ArrayList;
import java.util.HashSet;

public class TaskHashSet {
    public static void main(String[] args) {

        ArrayList<String> favoriteToys = new ArrayList<String>(); // создали список всех любимых игрушек

        favoriteToys.add("Мяч"); // добавили любимые игрушки Пушка в список

        favoriteToys.add("Бантик"); // добавили любимые игрушки Снежка в список

        favoriteToys.add("Мышка");
        favoriteToys.add("Носок"); // добавили любимые игрушки Черныша в список

        favoriteToys.add("Бантик");
        favoriteToys.add("Клубок"); // добавили любимые игрушки Ушастика в список

        favoriteToys.add("Мяч");
        favoriteToys.add("Рыбка-пищалка"); // добавили любимые игрушки Рыжика в список

        // создай из списка множество любимых игрушек
        HashSet<String> uniqueFavoriteToys = new HashSet<>(favoriteToys);

        // посчитай количество игрушек в множестве
        System.out.println("Разных игрушек у котят: " + uniqueFavoriteToys.size());

        // добавь в множество пакет и коробку
        uniqueFavoriteToys.add("Пакет");
        uniqueFavoriteToys.add("Коробка");

        // проверь, есть ли в множестве "Бантик"
        System.out.println("Бантик есть в списке любимых игрушек: " + uniqueFavoriteToys.contains("Бантик"));

        // проверь, есть ли в множестве "Ботинок"
        System.out.println("Ботинок есть в списке любимых игрушек: " + uniqueFavoriteToys.contains("Ботинок"));

        // убери "Носок" из множества
        uniqueFavoriteToys.remove("Носок");

        // выведи множество на экран
        System.out.println(uniqueFavoriteToys);

    }
}
