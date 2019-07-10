package uk.co.foulkes.supermarket.kata.model.offers;

import org.junit.Test;
import uk.co.foulkes.supermarket.kata.model.Basket;
import uk.co.foulkes.supermarket.kata.model.items.Item;
import uk.co.foulkes.supermarket.kata.model.items.ItemFactory;
import uk.co.foulkes.supermarket.kata.model.items.ItemType;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static uk.co.foulkes.supermarket.kata.model.offers.OfferCode.ITEM_A_3_FOR_130;
import static uk.co.foulkes.supermarket.kata.model.offers.OfferCode.ITEM_B_2_FOR_45;

public class QuantityForFixedPriceOfferTest {



    @Test
    public void shouldReturn130WhenExactlyThreeItemsOfItemWithThreeFor130(){
        QuantityForFixedPriceOffer threeItemsAt130 = new QuantityForFixedPriceOffer(ITEM_A_3_FOR_130, getItem(ItemType.A),3, 130);
        assertThat("expected to find the offer code ITEM_A_3_FOR_130",threeItemsAt130.getOfferCode(), is(ITEM_A_3_FOR_130));
        assertThat("expected item A to equal 130",threeItemsAt130.calculate(getBasketWithX(3, ItemType.A), ItemType.A), is(130));
    }

    @Test
    public void shouldReturn230WhenTheBasketHas5Items(){
        QuantityForFixedPriceOffer threeItemsAt130 = new QuantityForFixedPriceOffer(ITEM_A_3_FOR_130, getItem(ItemType.A),3, 130);
        assertThat("expected to find the offer code ITEM_A_3_FOR_130",threeItemsAt130.getOfferCode(), is(ITEM_A_3_FOR_130));
        assertThat("expected 5 items of A to equal 230",threeItemsAt130.calculate(getBasketWithX(5, ItemType.A), ItemType.A), is(230));
    }

    @Test
    public void shouldReturn45WhenExactlyTwoItemsOfItemWithTwoFor45(){
        QuantityForFixedPriceOffer twoItemsAt45 = new QuantityForFixedPriceOffer(ITEM_B_2_FOR_45, getItem(ItemType.B),2, 45);
        assertThat("expected to find the offer code ITEM_B_2_FOR_45",twoItemsAt45.getOfferCode(), is(ITEM_B_2_FOR_45));
        assertThat("expected 2 items of B to equal 45",twoItemsAt45.calculate(getBasketWithX(2, ItemType.B), ItemType.B), is(45));
    }

    @Test
    public void shouldReturn75WhenExactlyThreeItemsOfItemWithTwoFor45(){
        QuantityForFixedPriceOffer twoItemsAt45 = new QuantityForFixedPriceOffer(ITEM_B_2_FOR_45, getItem(ItemType.B),2, 45);
        assertThat("expected to find the offer code ITEM_B_2_FOR_45",twoItemsAt45.getOfferCode(), is(ITEM_B_2_FOR_45));
        assertThat("expected 3 items of B to equal 75",twoItemsAt45.calculate(getBasketWithX(3, ItemType.B), ItemType.B), is(75));
    }



    private Basket getBasketWithX(int numberOfItems, ItemType itemType) {
        Basket.Builder builder = new Basket.Builder();
        for(int i=0; i<numberOfItems; i++){
            builder.withItem(getItem(itemType));
        }
        return builder.build();
    }

    private Item getItem(ItemType itemType) {
        return new ItemFactory().get(itemType);
    }

}