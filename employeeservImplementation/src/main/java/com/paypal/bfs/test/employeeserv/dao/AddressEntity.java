package com.paypal.bfs.test.employeeserv.dao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Data;

/**
 * Address Model Object
 */
@Entity
@Data
@Builder
public class AddressEntity {
    @Id
    @GeneratedValue
    private int id;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private EmployeeEntity employee;
}
