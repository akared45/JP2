package E2.Controller;

import E2.Entity.Customer;
import E2.Service.CustomerService;

public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void addCustomer(Customer customer) {
        customerService.add(customer);
    }

    public Customer getCustomer(int id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return null;
        }
        return customer;
    }
}
