package models;

import lombok.Data;

@Data
public class Address {
    private String streetNumber;
    private String state;
    private String country;
    private String city;
}
