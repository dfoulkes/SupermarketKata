package uk.co.foulkes.supermarket.kata.model.items;

import uk.co.foulkes.supermarket.kata.model.offers.OfferCode;

import java.util.Optional;

public abstract class Item {
     public abstract  ItemType getSku();
     public abstract  Integer getItemCost();
     public abstract  Item getInstance();
     public abstract Optional<OfferCode> getOfferCode();

     protected final Integer price;

     public Item(int price) {
          this.price = price;
     }
     @Override
     public boolean equals(Object o){
          if (o instanceof Item){
               return ((Item) o).getSku().equals(getSku());
          }
      return false;
     }

     @Override
     public int hashCode() {
      return getSku().hashCode();
     }
}
