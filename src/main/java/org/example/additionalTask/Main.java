package org.example.additionalTask;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        HashMap<String, Item> items = new HashMap<>();
//        items.put("яблоки", new Item(50.5));
//        items.put("груши", new Item(100.5));
//        items.put("бананы", new Item(60.0));
//        OnlineShoppingCart onlineShoppingCart = new OnlineShoppingCart(items);
//        System.out.println("Полная стоимость покупок: " + onlineShoppingCart.getTotalPrice());

///////////////////////////////////////////////////////////////////////////
        //от наставника решение
        List<Item> itemlist = List.of(
                new Item(20_000),
                new Item(1_000)
        );
        OnlineShoppingCart onlineShoppingCart = new OnlineShoppingCart(itemlist, 10);
        System.out.println("Полная стоимость покупок: " + onlineShoppingCart.getTotalPrice());
        System.out.println("Полная стоимость покупок со скидкой: " + onlineShoppingCart.getTotalPriceWithDiscount());
    }
}

//Задача №2: Дизайн классов. Учет скидки при расчете полной стоимости
//
//        Появилось новое требование: корзина должна учитывать скидку
//        Процент скидки можно устанавливать при создании корзины через конструктор вот так:
//
//        ShoppingCart cart = new OnlineShoppingCart(items, 10); // 10% скидка на всю корзину
//        Задание
//        Считать полную стоимость корзины с учетом скидки.
//        Интерфейс взаимодействия с корзиной не должен измениться.
//
//        Присылайте свои варианты в тред к этому сообщению. Будем обсуждать вместе. Помните, неправильных вариантов нет, давайте практиковаться и искать оптимальные