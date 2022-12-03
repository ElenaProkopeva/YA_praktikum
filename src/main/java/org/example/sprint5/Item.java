package org.example.sprint5;
import java.util.ArrayList;
import java.util.Comparator;

public class Item {
    private final String name;
    private final int price;
    private final int popularity;

    public Item(String name, int price, int popularity) {
        this.name = name;
        this.price = price;
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", popularity=" + popularity +
                '}';
    }


    // компаратор по названию товара:
    public static final Comparator<Item> ITEM_NAME_CASE_INSENSITIVE_COMPARATOR = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return String.CASE_INSENSITIVE_ORDER.compare(o1.name, o2.name);
        }
    };

    // компаратор по цене товара по возрастанию:
    public static final Comparator<Item> ITEM_PRICE_COMPARATOR = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return o1.price - o2.price;
        }
    };

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Рубашка", 6, 4));
        items.add(new Item("Носки", 5, 10));
        items.add(new Item("Носки", 7, 9));
        items.add(new Item("Носки", 3, 13));

        System.out.println(items);

        items.sort(ITEM_NAME_CASE_INSENSITIVE_COMPARATOR.thenComparing(ITEM_PRICE_COMPARATOR));

        System.out.println(items);
    }
}