package com.paypal.bfs.test.employeeserv.mapper;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.dao.AddressEntity;

/**
 * Utility mapper class
 */
public class AddressEntityMapper {
    public static Address toDto(AddressEntity entity) {
        if (entity == null) {
            return null;
        }

        Address address = new Address();
        address.setId(entity.getId());
        address.setLine1(entity.getLine1());
        address.setLine2(entity.getLine2());
        address.setCity(entity.getCity());
        address.setCountry(entity.getCountry());
        address.setZipCode(entity.getZipCode());
        return address;
    }

    public static AddressEntity toDao(Address address) {
        if (address == null) {
            return null;
        }

        return AddressEntity.builder()
                .line1(address.getLine1())
                .line2(address.getLine2())
                .city(address.getCity())
                .country(address.getCountry())
                .state(address.getState())
                .zipCode(address.getZipCode())
                .build();
    }
}
