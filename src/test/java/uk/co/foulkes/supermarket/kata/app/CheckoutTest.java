package uk.co.foulkes.supermarket.kata.app;

import org.junit.Test;
import uk.co.foulkes.supermarket.kata.model.Basket;
import uk.co.foulkes.supermarket.kata.model.items.ItemFactory;
import uk.co.foulkes.supermarket.kata.model.items.ItemType;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class CheckoutTest {

    private ItemFactory itemFactory = new ItemFactory();

    @Test
    public void shouldGenerateSumOfAllItemsInTheBasketWhenNoOffersAreAvailable(){
        Checkout checkout = new Checkout();
        Basket basket = getNoOffersBasket();
        Integer total = checkout.total(basket);
        assertThat("expected the basket to equal 90 pence",total, is(90));
    }

    @Test
    public void shouldGenerateSumOfAllItemsWhenSpecialOffer3For130IsAssignedToItemA(){
        Checkout checkout = new Checkout();
        Basket basket = getAllAItems();
        Integer total = checkout.total(basket);
        assertThat("expected the basket to equal 130 pence",130, is(total));
    }

    private Basket getAllAItems(){
        return  new Basket.Builder()
                .withItem(itemFactory.get(ItemType.A))
                .withItem(itemFactory.get(ItemType.A))
                .withItem(itemFactory.get(ItemType.A))
                .build();
    }

    private Basket getNoOffersBasket() {
      return  new Basket.Builder()
              .withItem(itemFactory.get(ItemType.C))
              .withItem(itemFactory.get(ItemType.C))
              .withItem(itemFactory.get(ItemType.D))
              .withItem(itemFactory.get(ItemType.C))
              .withItem(itemFactory.get(ItemType.D))
              .build();
    }

}