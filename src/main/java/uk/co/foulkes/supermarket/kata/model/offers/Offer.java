package uk.co.foulkes.supermarket.kata.model.offers;

import uk.co.foulkes.supermarket.kata.model.Basket;
import uk.co.foulkes.supermarket.kata.model.items.ItemType;

public abstract class Offer {

    protected final OfferCode offerCode;

    public Offer(OfferCode offerCode){
      this.offerCode = offerCode;
    }

    public OfferCode getOfferCode() {
        return offerCode;
    }

    public abstract  int calculate(Basket basket, ItemType itemType);
}
