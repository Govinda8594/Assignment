package com.customer.publisher.kafka.dto;

import java.io.Serializable;

public class AddressDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id = null;

  private String addressLine1 = null;

  private String addressLine2 = null;

  private String street = null;

  private String postalCode = null;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAddressLine1() {
    return addressLine1;
  }

  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  public String getAddressLine2() {
    return addressLine2;
  }

  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }


}
