package guru.springframework.sfgmsscbrewery.web.controller;

import guru.springframework.sfgmsscbrewery.services.CustomerService;
import guru.springframework.sfgmsscbrewery.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Controller class for Spring MVC
 *
 * @author Martin Wunderlich
 */
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getBeer(@PathVariable("customerId") UUID customerId) {
        CustomerDto customerDto = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@Valid @RequestBody CustomerDto customerDto) {
        CustomerDto savedCustomerDto = customerService.saveNewCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();
        // TODO: Add server name here to URL
        headers.add("Location", "api/v1/customer/" + savedCustomerDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto) {

        customerService.updateCustomer(customerId, customerDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId) {
        customerService.deleteCustomerById(customerId);
    }
}
