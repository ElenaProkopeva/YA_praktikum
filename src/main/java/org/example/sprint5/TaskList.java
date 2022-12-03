package org.example.sprint5;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskList {
    public static void main(String[] args) {
        // создай список kittensInTheKitchen
        ArrayList<String> kittensInTheKitchen = new ArrayList<>();
        // проверь, есть ли котята на кухне
        if (kittensInTheKitchen.isEmpty()) {
            System.out.println("На кухне нет котят");
        } else {
            // если на кухне есть котята, посчитай их
            System.out.println("Котят на кухне: " + kittensInTheKitchen.size());
        }
        // добавь в список каждого котёнка
        kittensInTheKitchen.add("Пушок");
        kittensInTheKitchen.add("Снежок");
        kittensInTheKitchen.add("Черныш");
        kittensInTheKitchen.add("Ушастик");
        kittensInTheKitchen.add("Рыжик");
        // проверь, есть ли котята на кухне
        if (kittensInTheKitchen.isEmpty()) {
            System.out.println("На кухне нет котят");
        } else {
            // если на кухне есть котята, посчитай их
            System.out.println("Котят на кухне: " + kittensInTheKitchen.size());
        }
        // удали Пушка из списка по индексу
        kittensInTheKitchen.remove(0);
        // удали Снежка из списка по имени
        kittensInTheKitchen.remove("Снежок");
        // проверь, пропал ли Снежок из списка
        if (kittensInTheKitchen.contains("Снежок")) {
            System.out.println("Снежок ещё на кухне");
        } else {
            System.out.println("Снежок уже ушёл");
        }
        // удали Черныша из списка по имени
        kittensInTheKitchen.remove("Черныш");
        // проверь, пропал ли Черныш из списка
        if (kittensInTheKitchen.contains("Черныш")) {
            System.out.println("Черныш ещё на кухне");
        } else {
            System.out.println("Черныш уже ушёл");
        }
        // удали оставшихся котят из списка
        kittensInTheKitchen.clear();
        // проверь, сколько теперь котят на кухне
        if (kittensInTheKitchen.isEmpty()) {
            System.out.println("На кухне нет котят");
        } else {
            // если на кухне остались котята, посчитай их
            System.out.println("Котят на кухне: " + kittensInTheKitchen.size());
        }

        //////////////////////////////////////////////////////////////////
        HashMap<String, ArrayList<Double>> menu = new HashMap<>(); // создали хеш-таблицу
        ArrayList<Double> mohitoPrice = new ArrayList<>(); // создали список для цен на мохито
        mohitoPrice.add(350.0); // добавили в список цену в рублях
        mohitoPrice.add(15.50); // добавили в список цену в долларах
        mohitoPrice.add(13.20); // добавили в список цену в евро
        menu.put("Мохито", mohitoPrice); // добавили коктейль и список цен в хеш-таблицу

        ArrayList<Double> tiramisuPrice = new ArrayList<>(); // создали список для цен на тирамису
        tiramisuPrice.add(120.0);
        tiramisuPrice.add(4.00);
        tiramisuPrice.add(3.20);
        menu.put("Тирамису", tiramisuPrice); // добавили тирамису и список цен в хеш-таблицу

        ArrayList<Double> ramenPrice = new ArrayList<>(); // создали список для цен на рамен
        ramenPrice.add(230.0);
        ramenPrice.add(8.50);
        ramenPrice.add(7.00);
        menu.put("Рамен", ramenPrice); // добавили рамен и список цен в хеш-таблицу
        System.out.println(menu);
    }
}
