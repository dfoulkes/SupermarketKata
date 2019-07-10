package uk.co.foulkes.supermarket.kata.model.items;

import uk.co.foulkes.supermarket.kata.model.offers.OfferCode;

import java.util.Optional;

public class ItemA extends Item {


    public ItemA(int price) {
       super(price);
    }

    @Override
    public ItemType getSku() {
        return ItemType.A;
    }

    @Override
    public Integer getItemCost() {
        return price;
    }

    @Override
    public Item getInstance() {
        return new ItemA(price);
    }

    @Override
    public Optional<OfferCode> getOfferCode() {
        return Optional.of(OfferCode.ITEM_A_3_FOR_130);
    }

}
