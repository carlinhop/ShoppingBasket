package project;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by user on 24/11/2016.
 */
public class ShoppingBasketThread  extends Thread {


    private String threadName;
    public ShoppingBasket basket;
    public BigDecimal result;

    public ShoppingBasketThread(String name, ShoppingBasket basket) {
        this.threadName = name;
        this.basket = basket;
    }

    public void run() {

        try {
            result = basket.value();
            System.out.println(result);


        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}


