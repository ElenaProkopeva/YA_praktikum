package org.example.sprint5;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskHashMap {
    public static void main(String[] args) {
        // создай хеш-таблицу
        HashMap<String, ArrayList<Double>> kittenWeightFood = new HashMap<>();

        // создай список для информации о Пушке
        ArrayList<Double> pushok = new ArrayList<>();
        // добавь в список вес Пушка
        pushok.add(1.62);
        // добавь в список количество корма, которое съел Пушок
        pushok.add(0.095);
        // добавь информацию о Пушке в хеш-таблицу
        kittenWeightFood.put("Пушок", pushok);

        // создай список для информации о Снежке
        ArrayList<Double> snezhok = new ArrayList<>();
        // добавь в список вес Снежка
        snezhok.add(1.91);
        // добавь в список количество корма, которое съел Снежок
        snezhok.add(0.092);
        // добавь информацию о Снежке в хеш-таблицу
        kittenWeightFood.put("Снежок", snezhok);

        // создай список для информации о Черныше
        ArrayList<Double> chernysh = new ArrayList<>();
        // добавь в список вес Черныша
        chernysh.add(1.96);
        // добавь в список количество корма, которое съел Черныш
        chernysh.add(0.098);
        // добавь информацию о Черныше в хеш-таблицу
        kittenWeightFood.put("Черныш", chernysh);

        // создай список для информации об Ушастике
        ArrayList<Double> ushastik = new ArrayList<>();
        // добавь в список вес Ушастика
        ushastik.add(2.02);
        // добавь в список количество корма, которое съел Ушастик
        ushastik.add(0.105);
        // добавь информацию об Ушастике в хеш-таблицу
        kittenWeightFood.put("Ушастик", ushastik);

        // создай список для информации о Рыжике
        ArrayList<Double> ryzhik = new ArrayList<>();
        // добавь в список вес Рыжика
        ryzhik.add(1.88);
        // добавь в список количество корма, которое съел Рыжик
        ryzhik.add(0.098);
        // добавь информацию о Рыжике в хеш-таблицу
        kittenWeightFood.put("Рыжик", ryzhik);

        // выведи хеш-таблицу на экран
        System.out.println(kittenWeightFood);

        ////////////////////////////////////
        HashMap<String, String> dinner = new HashMap<>();

        dinner.put("Салат", "Оливье");
        dinner.put("Первое", "Борщ");
        dinner.put("Второе", "Котлеты");
        dinner.put("Гарнир", "Пюре");
        dinner.put("Напиток", "Кисель");

//        // выведи хеш-таблицу на экран, чтобы проверить список блюд
//        System.out.println(dinner);
//
//        // удали из хеш-таблицы салат
//        dinner.remove("Салат");
//        // выведи хеш-таблицу на экран, чтобы проверить, что салата нет
//        System.out.println(dinner);
//        // удали из хеш-таблицы первое блюдо
//        dinner.remove("Первое");
//        // выведи хеш-таблицу на экран, чтобы проверить, что первого нет
//        System.out.println(dinner);
//        // очисти хеш-таблицу
//        dinner.clear();
//        // выведи хеш-таблицу на экран, чтобы проверить, что ничего не осталось
//        System.out.println(dinner);


        // выведи хеш-таблицу на экран, чтобы проверить список блюд
        System.out.println(dinner);
        // проверь по ключу, что в обед входит напиток
        System.out.println(dinner.containsKey("Напиток"));
        // удали из хеш-таблицы салат
        dinner.remove("Салат");
        // проверь по ключу, что салата нет
        System.out.println(dinner.containsKey("Салат"));
        // удали из хеш-таблицы первое блюдо
        dinner.remove("Первое");
        // проверь по значению, что борща нет
        System.out.println(dinner.containsValue("Борщ"));
        // очисти хеш-таблицу
        dinner.clear();
        // проверь по ключу, что второго блюда нет
        System.out.println(dinner.containsKey("Котлеты"));
        // проверь по ключу, что гарнира нет
        System.out.println(dinner.containsKey("Пюре"));
        // проверь по значению, что киселя нет
        System.out.println(dinner.containsValue("Кисель"));
    }
}
