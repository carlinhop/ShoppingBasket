package project;


import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

/**
 * Created by user on 22/11/2016.
 */
public class ShoppingBasket {

    ArrayList<Product> products;
    Customer customer;



    public ShoppingBasket(){
        this.products = new ArrayList<Product>();
    }

    public ArrayList<Product> getProducts(){
        ArrayList<Product> copy = new ArrayList<Product>();
        for(Product product:this.products) {

            if(product.getHasBogof() && product.getPrice() != new BigDecimal(0)){
                Product newOne = new Product(product);
                copy.add(newOne);
            }
        }

        this.products.addAll(copy);

        return this.products;
    }

    public void setProducts(Product product){
        this.products.add(product);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
    }

    public void empty(){
        this.products.clear();
    }

    public BigDecimal value(){


        Float floatResult = new Float(0);

        for(Product product: getProducts()){

            floatResult += (product.getPrice().floatValue());
        }

        BigDecimal result = ((new BigDecimal(floatResult)).setScale(2, BigDecimal.ROUND_FLOOR));

        BigDecimal mult2 = (new BigDecimal(0.98));
        MathContext mc = new MathContext(4);

        //method to apply discount of 10% when the purchase is more than £20
        if((result.compareTo(new BigDecimal(19.00)) == 1)) {
            result.setScale(2, BigDecimal.ROUND_FLOOR);


            BigDecimal mult = (new BigDecimal(0.90));
            BigDecimal finalResult = (result.setScale(2, BigDecimal.ROUND_FLOOR)).multiply(mult, mc);


            return this.customer.getHasLoyalty() ? (finalResult.setScale(2, BigDecimal.ROUND_FLOOR)).multiply(mult2, mc): finalResult ;
        }

        else{

            return this.customer.getHasLoyalty() ? (result.setScale(2, BigDecimal.ROUND_FLOOR)).multiply(mult2, mc): result;
        }
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



}
