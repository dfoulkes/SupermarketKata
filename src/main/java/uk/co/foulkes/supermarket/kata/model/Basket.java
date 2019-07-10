package uk.co.foulkes.supermarket.kata.model;

import uk.co.foulkes.supermarket.kata.model.items.Item;
import uk.co.foulkes.supermarket.kata.model.items.ItemType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Basket {

    private final Map<ItemType, Integer> items;

    private Basket(Map<ItemType, Integer> items ) {
        this.items = items;
    }
    public Map<ItemType, Integer> getItems() {
        return items;
    }

    public static class Builder {
        private static final int INIT_AMOUNT = 1;
        Map<ItemType, Integer> items = new HashMap<>();

        private Function<ItemType, Integer> updateCount() {
            return (itemType -> (items.containsKey(itemType) ? items.get(itemType) + 1 : INIT_AMOUNT));
        }

        public Builder withItem(Item i) {
            items.put(i.getSku(), updateCount().apply(i.getSku()));
            return this;
        }

        public Basket build() {
            return new Basket(items);
        }
    }
}
