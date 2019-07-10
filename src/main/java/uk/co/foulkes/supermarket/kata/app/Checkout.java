package uk.co.foulkes.supermarket.kata.app;

import uk.co.foulkes.supermarket.kata.model.Basket;
import uk.co.foulkes.supermarket.kata.model.items.Item;
import uk.co.foulkes.supermarket.kata.model.items.ItemFactory;
import uk.co.foulkes.supermarket.kata.model.items.ItemType;
import uk.co.foulkes.supermarket.kata.model.offers.Offer;
import uk.co.foulkes.supermarket.kata.model.offers.OfferFactory;

import java.util.Optional;

public final class Checkout {

    ItemFactory itemFactory = new ItemFactory();
    OfferFactory offerFactory = new OfferFactory();
    public Integer total(Basket basket) {
        int total = 0;
        for(ItemType it : basket.getItems().keySet()){
            Item item = itemFactory.get(it);
            if(item.getOfferCode().isPresent()){
                Optional<Offer> processCost = offerFactory.getOffer(item.getOfferCode().get());
                if(processCost.isPresent()){

                    total += processCost.get().calculate(basket, item.getSku());
                }
                else { //cannot find handler for this offer code, just going to bill full price
                    total += item.getItemCost() * basket.getItems().get(item.getSku());
                }
            } else {
                total += item.getItemCost() * basket.getItems().get(item.getSku());
            }
        }
        return total;
    }
}
