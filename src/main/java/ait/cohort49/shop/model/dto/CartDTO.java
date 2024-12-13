package ait.cohort49.shop.model.dto;

import ait.cohort49.shop.model.entity.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;


public class CartDTO {

    private Long id;

    private Customer customer;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;

    }

    @Override
    public String toString() {
        return String.format("Cart: id - %d", this.id);
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof CartDTO cart)) return false;

        return Objects.equals(id, cart.id) && Objects.equals(customer, cart.customer);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(customer);
        return result;
    }
}
