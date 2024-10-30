package E2.Service;

import E2.Entity.Booking;
import E2.Entity.Customer;
import E2.General.Generic;

import java.util.HashMap;
import java.util.Map;

public class CustomerService implements Generic<Customer> {
    private Map<Integer, Customer> customers = new HashMap<>();
    @Override
    public void add(Customer item) {
        customers.put(item.getId(), item);
    }

    @Override
    public Customer findById(Integer id) {
        return customers.entrySet().stream()
                .filter(c->c.getKey().equals(id))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }
}
