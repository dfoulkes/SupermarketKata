package uk.co.foulkes.supermarket.kata.model.items;

import uk.co.foulkes.supermarket.kata.model.offers.OfferCode;

import java.util.Optional;

public class ItemB extends Item {

    public ItemB(int price) {
        super(price);
    }

    @Override
    public ItemType getSku() {
        return ItemType.B;
    }

    @Override
    public Integer getItemCost() {
        return price;
    }

    @Override
    public Item getInstance() {
        return new ItemB(price);
    }

    @Override
    public Optional<OfferCode> getOfferCode() {
        return Optional.empty();
    }
}
