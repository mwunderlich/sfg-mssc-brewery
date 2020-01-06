/*
 * Copyright (c) by censhare AG
 */
package guru.springframework.sfgmsscbrewery.web.controller;

import guru.springframework.sfgmsscbrewery.services.CustomerService;
import guru.springframework.sfgmsscbrewery.web.model.BeerDto;
import guru.springframework.sfgmsscbrewery.web.model.Customer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller class for Spring MVC
 *
 * @author Martin Wunderlich
 */
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<Customer> getBeer(@PathVariable("customerId") UUID customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveNewCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        // TODO: Add server name here to URL
        headers.add("Location", "api/v1/customer/" + savedCustomer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody Customer customer) {

        customerService.updateCustomer(customerId, customer);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId) {
        customerService.deleteCustomerById(customerId);
    }
}
