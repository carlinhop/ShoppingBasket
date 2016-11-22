package tests;

import project.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by user on 22/11/2016.
 */
public class ShoppingBasketTest {

    ShoppingBasket basket;
    Product product1;


    @Before
    public void before(){
        BigDecimal price = new BigDecimal(1.99).setScale(2, BigDecimal.ROUND_CEILING);
        product1 = new Product("Radio", price, true);
        basket = new ShoppingBasket();
        basket.setProducts(product1);
    }

    @Test
    public void basketExists(){
        assertTrue(basket!= null);
    }

    @Test
    public void basketHasProducts(){
        assertTrue(basket.getProducts()!=null);
        assertEquals(1, basket.getProducts().size());
    }

    @Test
    public void removeProduct(){
        basket.removeProduct(product1);
        assertEquals(0, basket.getProducts().size());
    }

    @Test
    public void empty(){
        basket.empty();
        assertEquals(0, basket.getProducts().size());
    }

    @Test
    public void value(){
        assertEquals(new BigDecimal(1.99).setScale(2, BigDecimal.ROUND_CEILING), basket.value());
    }

}