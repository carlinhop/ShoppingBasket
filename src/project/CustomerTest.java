package project;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 23/11/2016.
 */
public class CustomerTest {

    Customer customer1;

    @Before
    public void before(){
        customer1 = new Customer("Carlos");
    }

    @Test
    public void getName() {
        assertEquals("Carlos", customer1.getName());
    }

    @Test
    public void setName() {
        customer1.setName("Maria");
        assertEquals("Maria", customer1.getName());
    }

    @Test
    public void customerHasLoyaltyCard(){
        customer1.setHasLoyalty(true);
        assertEquals(true, customer1.getHasLoyalty());
    }

}