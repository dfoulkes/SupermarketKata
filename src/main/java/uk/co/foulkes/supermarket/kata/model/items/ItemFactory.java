package uk.co.foulkes.supermarket.kata.model.items;

import java.util.HashMap;
import java.util.Map;

public class ItemFactory {

    private  Map<ItemType,Item> skus = new HashMap<>();

    public ItemFactory(){
        skus.put(ItemType.A, new ItemA(50));
        skus.put(ItemType.B, new ItemB(30));
        skus.put(ItemType.C, new ItemC(20));
        skus.put(ItemType.D, new ItemD(15));
    }

    public  Item get(ItemType itemType){
        return skus.get(itemType).getInstance();
    }

}
