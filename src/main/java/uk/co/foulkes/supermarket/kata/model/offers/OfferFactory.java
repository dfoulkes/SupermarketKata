package uk.co.foulkes.supermarket.kata.model.offers;

import uk.co.foulkes.supermarket.kata.model.items.ItemFactory;
import uk.co.foulkes.supermarket.kata.model.items.ItemType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OfferFactory {

    private Map<OfferCode, Offer>  offers = new HashMap<>();
    private ItemFactory itemFactory = new ItemFactory();
    public OfferFactory(){
        offers.put(OfferCode.ITEM_A_3_FOR_130, new QuantityForFixedPriceOffer(OfferCode.ITEM_A_3_FOR_130, itemFactory.get(ItemType.A),3,130));
        offers.put(OfferCode.ITEM_B_2_FOR_45, new QuantityForFixedPriceOffer(OfferCode.ITEM_B_2_FOR_45, itemFactory.get(ItemType.B),2,45));
    }

  public Optional<Offer> getOffer(OfferCode code){
    return Optional.ofNullable(offers.get(code));
  }
}
