package E6;

import E6.Controller.OrderController;
import E6.Entity.Customer;
import E6.Entity.Order;
import E6.Entity.OrderDetails;
import E6.Entity.Product;
import E6.Service.OrderService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "C001", "John Doe", "0123456789"));
        customers.add(new Customer(2, "C002", "Jane Smith", "0987654321"));
        customers.add(new Customer(3, "C003", "Alice Johnson", "0111222333"));

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "P001", "Laptop", 1200.0, 10));
        products.add(new Product(2, "P002", "Smartphone", 800.0, 20));
        products.add(new Product(3, "P003", "Tablet", 500.0, 15));
        products.add(new Product(4, "P004", "Headphones", 150.0, 30));
        products.add(new Product(5, "P005", "Smartwatch", 200.0, 25));

        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, customers.get(0), LocalDateTime.now()));
        orders.add(new Order(2, customers.get(0), LocalDateTime.now().plusHours(3)));
        orders.add(new Order(3, customers.get(1), LocalDateTime.now().plusHours(1)));
        orders.add(new Order(4, customers.get(2), LocalDateTime.now().plusHours(2)));

        List<OrderDetails> orderDetails = new ArrayList<>();
        orderDetails.add(new OrderDetails(1,orders.get(0),products.get(0),10,1500));
        orderDetails.add(new OrderDetails(2,orders.get(0),products.get(1),20,1000));
        orderDetails.add(new OrderDetails(2,orders.get(1),products.get(1),20,1000));
        orderDetails.add(new OrderDetails(3,orders.get(2),products.get(2),10,700));
        orderDetails.add(new OrderDetails(4,orders.get(2),products.get(3),10,700));

        OrderService orderService = new OrderService(customers, orders, orderDetails);
        OrderController orderController = new OrderController(orderService);
        orderController.findOrdersByCustomerCode();
    }
}
