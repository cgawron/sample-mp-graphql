package de.fhswf.fit.graphql;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.Mutation;

@Description("A pizza order")
public class Order {
    private String id;
    private Customer customer;
    private Choice choice;

    public Order() {
    }   
    
    public Order(String id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.choice = new Choice();
    }

    @Description("The id of the order")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Description("The customer who ordered the pizza")
    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Choice getChoice() {
        return this.choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }

}
