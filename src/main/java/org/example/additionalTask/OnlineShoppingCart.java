package org.example.additionalTask;

import java.util.HashMap;
import java.util.List;

public class OnlineShoppingCart implements ShoppingCart{
//    хранить в себе список покупок
//    считать полную стоимость покупок
    HashMap<String, Item> itemList;

    public OnlineShoppingCart(HashMap<String, Item> itemList) {
        this.itemList = itemList;
    }

    //   List<Item> itemsList;
    @Override
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Item item: itemList.values()) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}
