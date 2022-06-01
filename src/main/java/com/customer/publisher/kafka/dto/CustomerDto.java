package com.customer.publisher.kafka.dto;

import java.io.Serializable;
import com.customer.publisher.domain.AddressRequest;

public class CustomerDto implements Serializable {

  private static final long serialVersionUID = 2L;

  private Long id = null;

  private String customerNumber = null;

  private String firstName = null;

  private String lastName = null;

  private String birthdate = null;

  private String country = null;

  private String countryCode = null;

  private String mobileNumber = null;

  private String email = null;

  private String customerStatus = null;

  private AddressRequest address = null;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(String birthdate) {
    this.birthdate = birthdate;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCustomerStatus() {
    return customerStatus;
  }

  public void setCustomerStatus(String customerStatus) {
    this.customerStatus = customerStatus;
  }

  public AddressRequest getAddress() {
    return address;
  }

  public void setAddress(AddressRequest address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "CustomerDto [id=" + id + ", customerNumber=" + customerNumber + ", firstName="
        + firstName + ", lastName=" + lastName + ", birthdate=" + birthdate + ", country=" + country
        + ", countryCode=" + countryCode + ", mobileNumber=" + mobileNumber + ", email=" + email
        + ", customerStatus=" + customerStatus + ", address=" + address + "]";
  }


}
