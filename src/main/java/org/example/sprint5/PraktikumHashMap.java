package org.example.sprint5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PraktikumHashMap {
    public static void main(String[] args) {

        // создай хеш-таблицу
        HashMap<String, List<String>> kittenToys = new HashMap<>();

        // создай список любимых игрушек Пушка
        List<String> pushokToys = Arrays.asList("Мяч");
        // добавь игрушки Пушка в хеш-таблицу
        kittenToys.put("Пушок", pushokToys);

        // создай список любимых игрушек Снежка
        List<String> snezhokToys = Arrays.asList("Бантик");
        // добавь игрушки Снежка в хеш-таблицу
        kittenToys.put("Снежок", snezhokToys);

        // создай список любимых игрушек Черныша
        List<String> chernyshToys = Arrays.asList("Мышка", "Носок");
        // добавь игрушки Черныша в хеш-таблицу
        kittenToys.put("Черныш", chernyshToys);

        // создай список любимых игрушек Ушастика
        List<String> ushastikToys = Arrays.asList("Бантик", "Клубок");
        // добавь игрушки Ушастика в хеш-таблицу
        kittenToys.put("Ушастик", ushastikToys);

        // создай список любимых игрушек Рыжика
        List<String> ryzhikToys = Arrays.asList("Мяч", "Рыбка-пищалка");
        // добавь игрушки Рыжика в хеш-таблицу
        kittenToys.put("Рыжик", ryzhikToys);

        // проверь, что игрушки Снежка внесены в хеш-таблицу
        System.out.println("Игрушки Снежка есть в таблице: " + kittenToys.containsValue(chernyshToys));

        // проверь количество списков в хеш-таблице
        System.out.println("В таблице есть игрушки " + kittenToys.size() + " котят");

        // проверь, игрушки каких котят есть в таблице
        System.out.println("В таблице есть игрушки котят: " + kittenToys.keySet());

        // выведи на экран любимые игрушки Снежка
        System.out.println("Любимые игрушки Снежка: " + kittenToys.get("Снежок"));

        // выведи на экран список всех игрушек
        System.out.println("В таблице есть игрушки: " + kittenToys.values());

        // очисть хеш-таблицу
        kittenToys.clear();

        // проверь, очистилась ли таблица
        System.out.println("Хеш-таблица пуста: " + kittenToys.isEmpty());

    }
}
