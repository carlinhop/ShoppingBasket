package project;

import javafx.beans.binding.BooleanExpression;

/**
 * Created by user on 23/11/2016.
 */
public class Customer {


    String name;
    Boolean hasLoyalty;

    public Customer(String name){
        this.name = name;
        this.hasLoyalty = false;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getHasLoyalty(){
        return this.hasLoyalty;
    }

    public void setHasLoyalty(Boolean loyalty){
        this.hasLoyalty = loyalty;
    }

}
