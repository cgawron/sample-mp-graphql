package de.fhswf.fit.graphql;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.GraphQLException;
import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

@GraphQLApi
@ApplicationScoped
public class PizzaService {

    private static final Map<String, Order> orders = new HashMap<>();

    public PizzaService() {
        List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10").forEach(id -> {
            Customer customer = new Customer("John Doe", "", "");
            Order order = new Order(id, customer);
            orders.put(id, order);
        });
    }

    @Query
    public Collection<Order> orders() {
        return orders.values();
    }

    @Query
    public Order order(@Name("id") String id) {
        return orders.get(id);
    }

    @Mutation
    public Order addOrder(@Name("order") Order order) {
        if (order.getId() == null) {
            order.setId(String.valueOf(order.hashCode()));
        }
        orders.put(order.getId(), order);
        return order;
    }
}
