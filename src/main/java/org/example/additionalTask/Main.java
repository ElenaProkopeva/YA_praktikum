package org.example.additionalTask;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Item> items = new HashMap<>();
        items.put("яблоки", new Item(50.5));
        items.put("груши", new Item(100.5));
        items.put("бананы", new Item(60.0));
        OnlineShoppingCart onlineShoppingCart = new OnlineShoppingCart(items);
        System.out.println("Полная стоимость покупок: " + onlineShoppingCart.getTotalPrice());
    }
}
