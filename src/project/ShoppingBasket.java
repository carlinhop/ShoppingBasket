package project;


import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by user on 22/11/2016.
 */
public class ShoppingBasket {

    ArrayList<Product> products;

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
        BigDecimal result = (new BigDecimal(floatResult));
        return result.setScale(2, BigDecimal.ROUND_FLOOR);
    }


}
