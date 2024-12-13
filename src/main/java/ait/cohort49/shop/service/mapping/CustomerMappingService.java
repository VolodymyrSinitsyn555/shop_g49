package ait.cohort49.shop.service.mapping;

import ait.cohort49.shop.model.dto.CustomerDTO;
import ait.cohort49.shop.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMappingService {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    @Mapping(source = "customer_name", target = "name")
    Customer mapDtoToEntity(CustomerDTO dto);

    @Mapping(source = "name", target = "customer_name")
    CustomerDTO mapEntityToDto(Customer entity);
}
