package E6.Controller;

import E6.Entity.Customer;
import E6.Entity.Order;
import E6.Entity.OrderDetails;
import E6.Service.OrderService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void findOrdersByCustomerCode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the customer code to search: ");
        String customerCode = sc.nextLine();
        sc.close();
        Customer targetCustomer = orderService.getCustomerByCode(customerCode).orElse(null);
        if (targetCustomer == null) { System.out.println("Customer not found with entered code.");
            return;
        }
        Map<Order, Double> orderTotals = orderService.calculateOrderTotals(targetCustomer);
        writeBillToFile(targetCustomer, orderTotals);
    }
    private void writeBillToFile(Customer customer, Map<Order, Double> orderTotals) {
        String sysPath = System.getProperty("user.dir");
        String fileOutPath = sysPath + "/src/E6/Data/order.out.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutPath))) {
            writer.write("Customer Invoice: " + customer.getNameCus());
            writer.newLine();
            writer.write("Customer Code: " + customer.getCodeCus());
            writer.newLine();
            writer.write("===================================================");
            writer.newLine();
            for (Map.Entry<Order, Double> entry : orderTotals.entrySet()) {
                Order order = entry.getKey();
                Double totalAmount = entry.getValue();
                writer.write("Order ID: " + order.getId());
                writer.write(", DateTime: " + order.getOrderDate());
                writer.newLine();
                writer.write("---------------------------------------------------");
                writer.newLine();
                writer.write("Product ID | Product Name | Quantity | Unit Price | Total Price");
                writer.newLine();
                List<OrderDetails> details = orderService.getOrderDetailsByOrder(order);
                for (OrderDetails detail : details) {
                    writer.write(String.format("%10s | %12s | %8d | %10.2f | %11.2f",
                            detail.getProduct().getId(),
                            detail.getProduct().getNameProduct(),
                            detail.getQuantity(),
                            detail.getPrice(),
                            detail.getQuantity() * detail.getPrice()));
                    writer.newLine();
                }
                writer.write("---------------------------------------------------");
                writer.newLine();
                writer.write(String.format("Total for Order ID %d: %.2f", order.getId(), totalAmount));
                writer.newLine();
                writer.write("===================================================");
                writer.newLine();
            }

            writer.write("End of Bill");
            System.out.println("Invoice has been written to file " + fileOutPath);
        } catch (IOException e) {
            System.out.println("Error writing invoice to file: " + e.getMessage());
        }
    }

}
