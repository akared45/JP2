package E6.Entity;

import java.time.LocalDateTime;

public class Order {
    private int id;
    private Customer customer;
    private LocalDateTime orderDate;

    public Order() {
    }

    public Order(int id, Customer customer, LocalDateTime orderDate) {
        this.id = id;
        this.customer = customer;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                '}';
    }
}
