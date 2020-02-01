package guru.springframework.sfgmsscbrewery.web.mappers;

import guru.springframework.sfgmsscbrewery.domain.Customer;
import guru.springframework.sfgmsscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDto CustomerToCustomerDto(Customer customer);
    Customer CustomerDtoToCustomer(CustomerDto customerDto);
}
