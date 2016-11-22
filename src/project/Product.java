package project;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by user on 22/11/2016.
 */
public class Product {


    private String name;
    private BigDecimal price;
    private Boolean hasBogof;

    public Product(String name, BigDecimal price, Boolean bogof){
        this.name = name;
        this.price = price;
        this.hasBogof = bogof;
    }

    public Product(Product product){
        this.name = product.name;
        this.price = new BigDecimal(0);
        this.hasBogof = product.getHasBogof();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getHasBogof() {
        return hasBogof;
    }

    public void setHasBogof(Boolean hasBogof) {
        this.hasBogof = hasBogof;
    }




}
