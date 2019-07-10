package uk.co.foulkes.supermarket.kata.model.items;

import uk.co.foulkes.supermarket.kata.model.offers.OfferCode;

import java.util.Optional;

public class ItemC extends Item {

    public ItemC(int price) {
        super(price);
    }

    @Override
    public ItemType getSku() {
        return ItemType.C;
    }

    @Override
    public Integer getItemCost() {
        return price;
    }

    @Override
    public Item getInstance() {
        return new ItemC(price);
    }

    @Override
    public Optional<OfferCode> getOfferCode() {
        return Optional.empty();
    }
}
