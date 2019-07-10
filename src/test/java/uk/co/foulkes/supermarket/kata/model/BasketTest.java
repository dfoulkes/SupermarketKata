package uk.co.foulkes.supermarket.kata.model;

import org.junit.Test;
import uk.co.foulkes.supermarket.kata.model.items.ItemFactory;
import uk.co.foulkes.supermarket.kata.model.items.ItemType;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BasketTest {

    private ItemFactory itemFactory = new ItemFactory();

    @Test
    public void shouldHaveABasketWithThreeItemsOfItemA(){
        Basket basket =  new Basket.Builder()
                .withItem(itemFactory.get(ItemType.A))
                .withItem(itemFactory.get(ItemType.A))
                .withItem(itemFactory.get(ItemType.A))
                .build();
        assertThat("expected three items of A in the basked", basket.getItems().get(ItemType.A), is(3));
    }

    @Test
    public void shouldAllowMixedBasketsOfGoods(){
        Basket basket =  new Basket.Builder()
                .withItem(itemFactory.get(ItemType.A))
                .withItem(itemFactory.get(ItemType.B))
                .withItem(itemFactory.get(ItemType.B))
                .withItem(itemFactory.get(ItemType.C))
                .build();
        assertThat("expected one items of A in the basked", basket.getItems().get(ItemType.A), is(1));
        assertThat("expected two items of B in the basked", basket.getItems().get(ItemType.B), is(2));
        assertThat("expected one items of C in the basked", basket.getItems().get(ItemType.C), is(1));
    }

}