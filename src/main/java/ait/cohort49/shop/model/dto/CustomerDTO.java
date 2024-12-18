package ait.cohort49.shop.model.dto;

import ait.cohort49.shop.model.entity.Cart;
import jakarta.persistence.*;

import java.util.Objects;


public class CustomerDTO {

    private Long id;

    private String customer_name;

    private Cart cart;

    @Override
    public String toString() {
        return String.format("Customer: id - %d, name - %s", id, customer_name);
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof CustomerDTO that)) return false;

        return Objects.equals(id, that.id) && Objects.equals(customer_name, that.customer_name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(customer_name);
        return result;
    }
}
