package tests;

import org.junit.Before;
import org.junit.Test;
import project.Product;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by user on 22/11/2016.
 */
public class ProductTest {

    Product product1;


    @Before
    public void before() {

        product1 = new Product("Radio", new BigDecimal(1.99) , true);

    }

    @Test
    public void getName()  {
        assertEquals("Radio",product1.getName());

    }

    @Test
    public void setName()  {
        product1.setName("Turntable");
        assertEquals("Turntable", product1.getName());
    }

    @Test
    public void getPrice()  {
        assertEquals(new BigDecimal(1.99), product1.getPrice());
    }

    @Test
    public void setPrice()  {
        product1.setPrice(new BigDecimal(2.00));
        assertEquals(new BigDecimal(2.00), product1.getPrice());
    }

    @Test
    public void getHasBogof()  {
        assertEquals(true, product1.getHasBogof());
    }

    @Test
    public void setHasBogof() throws Exception {
        product1.setHasBogof(false);
        assertEquals(false, product1.getHasBogof());
    }

}