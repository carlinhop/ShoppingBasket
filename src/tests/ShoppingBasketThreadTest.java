package tests;

import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import project.*;


import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Created by user on 24/11/2016.
 */
public class ShoppingBasketThreadTest {

    public Thread t;
    ShoppingBasket basket;
    ArrayList<Product> list;
    BigDecimal valueResult;
    Customer customer1;

    @Before
    public void before(){
        Product product1 = new Product("radio", new BigDecimal(2.00),false );
        Product product2 = new Product("tv", new BigDecimal(2.00),false );
        Product product3 = new Product("radio", new BigDecimal(2.00),false );
        Product product4 = new Product("tv", new BigDecimal(2.00),false );
        Product product5 = new Product("radio", new BigDecimal(2.00),false );
        Product product6 = new Product("tv", new BigDecimal(2.00),false );
        Product product7 = new Product("radio", new BigDecimal(2.00),false );
        Product product8 = new Product("tv", new BigDecimal(2.00),false );
        list = new ArrayList<>();
        list.add(product1);
        list.add(product2);
        list.add(product3);
        list.add(product4);
        list.add(product5);
        list.add(product6);
        list.add(product7);
        list.add(product8);

        customer1 = new Customer("Julio");

        basket = new ShoppingBasket(list);
        basket.setCustomer(customer1);

        t = new ShoppingBasketThread("turbo", basket);
    }

    @Test
    public void basketHasThread() {

        t.start();

        assertTrue(t != null);
        try {
            t.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
