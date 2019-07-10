package uk.co.foulkes.supermarket.kata.model.items;

import uk.co.foulkes.supermarket.kata.model.offers.OfferCode;

import java.util.Optional;

public class ItemD extends Item {

    public ItemD(int price) {
        super(price);
    }

    @Override
    public ItemType getSku() {
        return ItemType.D;
    }

    @Override
    public Integer getItemCost() {
        return price;
    }

    @Override
    public Item getInstance() {
        return new ItemD(price);
    }

    @Override
    public Optional<OfferCode> getOfferCode() {
        return Optional.empty();
    }
}
