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

    public ShoppingBasket basket;
    public Product product1;
    public Product product2;
    public BigDecimal price;


    @Before
    public void before(){
        price = new BigDecimal(1.99).setScale(2, BigDecimal.ROUND_CEILING);
        product1 = new Product("Radio", price, false);
        product2 = new Product("TV", price, false);

        basket = new ShoppingBasket();
        basket.setProducts(product1);
    }

    @Test
    //Should I name my tests as the method I'm testing?
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
        basket.setProducts(product2);
        assertEquals(new BigDecimal(3.98).setScale(2, BigDecimal.ROUND_CEILING), basket.value());

    }

    @Test
    public void basketHasBOGOF(){
        //BOGOF
        basket.empty();
        product1 = new Product("Radio", price, true);
        product2 = new Product("TV", price, false);
        basket.setProducts(product1);
        basket.setProducts(product2);
        assertEquals(3, basket.getProducts().size());
    }

    @Test
    public void basketOfferOver20(){
        price  = new BigDecimal(20.00).setScale(2, BigDecimal.ROUND_CEILING);
        basket.empty();
        product1 = new Product("Radio", price, true);
        product2 = new Product("TV", price, false);
        basket.setProducts(product1);
        basket.setProducts(product2);
        assertEquals(new BigDecimal(36.00).setScale(2, BigDecimal.ROUND_CEILING), basket.value());
    }

}