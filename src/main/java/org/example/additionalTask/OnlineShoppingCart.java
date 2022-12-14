package org.example.additionalTask;

import java.util.HashMap;
import java.util.List;

public class OnlineShoppingCart implements ShoppingCart{
//    хранить в себе список покупок
//    считать полную стоимость покупок
//    private final HashMap<String, Item> itemList;
//
//    public OnlineShoppingCart(HashMap<String, Item> itemList) {
//        this.itemList = itemList;
//    }
//
//    //   List<Item> itemsList;
//    @Override
//    public double getTotalPrice() {
//        double totalPrice = 0.0;
//        for (Item item: itemList.values()) {
//            totalPrice += item.getPrice();
//        }
//        return totalPrice;
//    }
///////////////////////////////////////////////////////////////////////////
    //от наставника решение
    private final List<Item> items;
    private final int discount;

    public OnlineShoppingCart(List<Item> items, int discount) {
        this.items = items;
        this.discount = discount;
    }

    @Override
    public double getTotalPrice() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }
    @Override
    public double getTotalPriceWithDiscount() {
        double cartDiscount = (items.stream().mapToDouble(Item::getPrice).sum() * discount)/100;
        return items.stream().mapToDouble(Item::getPrice).sum() - cartDiscount;
    }
}
