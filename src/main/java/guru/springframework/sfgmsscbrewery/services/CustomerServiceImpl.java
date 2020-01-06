/*
 * Copyright (c) by censhare AG
 */
package guru.springframework.sfgmsscbrewery.services;

import guru.springframework.sfgmsscbrewery.web.model.Customer;
import guru.springframework.sfgmsscbrewery.web.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Service impl
 *
 * @author Martin Wunderlich
 */
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer getCustomerById(UUID customerId) {
        return Customer.builder().id(customerId)
                .customerName("Thirsty Me")
                .build();
    }

    @Override
    public Customer saveNewCustomer(Customer customer) {
        return Customer.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateCustomer(UUID customerId, Customer customer) {
        //TODO Impl
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        log.debug("deleting customer with id " + customerId);
    }
}
