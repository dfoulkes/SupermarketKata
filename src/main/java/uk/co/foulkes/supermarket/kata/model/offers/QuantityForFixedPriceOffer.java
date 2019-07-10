package uk.co.foulkes.supermarket.kata.model.offers;

import uk.co.foulkes.supermarket.kata.model.Basket;
import uk.co.foulkes.supermarket.kata.model.items.Item;
import uk.co.foulkes.supermarket.kata.model.items.ItemType;

public class QuantityForFixedPriceOffer extends Offer {

    private final Item item;
    private final Integer quantity;
    private final Integer price;

    public QuantityForFixedPriceOffer(OfferCode offerCode, Item item, Integer quantity, Integer price) {
        super(offerCode);
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public int calculate(Basket basket, ItemType itemType) {
        int numberOfItems = basket.getItems().get(itemType);
        int modOfItemsToQuantity = numberOfItems % quantity;
        if(modOfItemsToQuantity == 0 && quantity <= numberOfItems){
            return (numberOfItems / quantity) * price;
        }
        else if (numberOfItems > quantity) {
            int total = ((numberOfItems - modOfItemsToQuantity) / quantity) * price;
            total += modOfItemsToQuantity * item.getItemCost();
            return total;
        }
        else {
            return quantity * item.getItemCost();
        }
    }
}
