package E6.Service;

import E6.Entity.Customer;
import E6.Entity.Order;
import E6.Entity.OrderDetails;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderService {
    private List<Customer> customers;
    private List<Order> orders;
    private List<OrderDetails> orderDetails;

    public OrderService(List<Customer> customers, List<Order> orders, List<OrderDetails> orderDetails) {
        this.customers = customers;
        this.orders = orders;
        this.orderDetails = orderDetails;
    }

    public Optional<Customer> getCustomerByCode(String customerCode) {
        return customers.stream()
                .filter(customer -> customer.getCodeCus().equalsIgnoreCase(customerCode))
                .findFirst();
    }

    public Map<Order, Double> calculateOrderTotals(Customer customer) {
        return orderDetails.stream()
                .filter(od -> od.getOrder().getCustomer().equals(customer))
                .collect(Collectors.groupingBy(
                        OrderDetails::getOrder,
                        Collectors.summingDouble(od -> od.getQuantity() * od.getPrice())
                ));
    }

    public List<OrderDetails> getOrderDetailsByOrder(Order order) {
        return orderDetails.stream()
                .filter(od -> od.getOrder().equals(order))
                .collect(Collectors.toList());
    }
}
