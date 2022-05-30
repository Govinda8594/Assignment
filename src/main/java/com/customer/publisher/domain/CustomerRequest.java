package com.customer.publisher.domain;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Customer
 */
public class CustomerRequest {

	private Long id = null;

	@NotEmpty(message = "Customer Number cannot be blank")
	private String customerNumber = null;

	@NotEmpty(message = "First Name cannot be blank")
	private String firstName = null;

	@NotEmpty(message = "Last Name cannot be blank")
	private String lastName = null;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@NotNull(message = "Birth date cannot be null and future date")
	private String birthdate = null;

	@NotEmpty(message = "Country cannot be blank")
	private String country = null;

	@NotEmpty(message = "Country code cannot be blank")
	private String countryCode = null;

	@NotEmpty(message = "Mobile cannot be blank")
	@Size(min = 10, max = 10, message = "mobile no should be of 10 digit")
	private String mobileNumber = null;

	@NotEmpty(message = "email cannot be blank")
	@Email(regexp = ".+[@].+[\\.].+", message = "Please enter valid email id")
	private String email = null;

	/**
	 * Customer Status
	 */
	public enum CustomerStatusEnum {
		RESTORED("Restored"),

		SUSPENDED("Suspended"),

		OPEN("Open"),

		CLOSED("Closed");

		private String value;

		CustomerStatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static CustomerStatusEnum fromValue(String text) {
			for (CustomerStatusEnum b : CustomerStatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}
	@NotNull(message = "Status is required")
	private CustomerStatusEnum customerStatus = null;

	@NotNull(message = "Address is required")
	private AddressRequest address = null;

	public CustomerRequest id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	// @Schema(required = true, description = "")
	// @NotNull

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerRequest customerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
		return this;
	}

	/**
	 * Get customerNumber
	 * 
	 * @return customerNumber
	 **/
	// @Schema(required = true, description = "")
	// @NotNull

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public CustomerRequest firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * Get firstName
	 * 
	 * @return firstName
	 **/
	// @Schema(required = true, description = "")
	// @NotNull

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public CustomerRequest lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * Get lastName
	 * 
	 * @return lastName
	 **/
	// @Schema(required = true, description = "")
	// @NotNull

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public CustomerRequest birthdate(String birthdate) {
		this.birthdate = birthdate;
		return this;
	}

	/**
	 * Get birthdate
	 * 
	 * @return birthdate
	 **/
	// @Schema(required = true, description = "")
	// @NotNull

	@Valid
	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public CustomerRequest country(String country) {
		this.country = country;
		return this;
	}

	/**
	 * Get country
	 * 
	 * @return country
	 **/
	// @Schema(required = true, description = "")
	// @NotNull

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public CustomerRequest countryCode(String countryCode) {
		this.countryCode = countryCode;
		return this;
	}

	/**
	 * Get countryCode
	 * 
	 * @return countryCode
	 **/
	// @Schema(required = true, description = "")
	// @NotNull

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public CustomerRequest mobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
		return this;
	}

	/**
	 * Get mobileNumber
	 * 
	 * @return mobileNumber
	 **/
	// @Schema(required = true, description = "")
	// @NotNull

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public CustomerRequest email(String email) {
		this.email = email;
		return this;
	}

	/**
	 * Get email
	 * 
	 * @return email
	 **/
	// @Schema(required = true, description = "")
	// @NotNull

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CustomerRequest customerStatus(CustomerStatusEnum customerStatus) {
		this.customerStatus = customerStatus;
		return this;
	}

	/**
	 * Customer Status
	 * 
	 * @return customerStatus
	 **/
	// @Schema(required = true, description = "Customer Status")
	// @NotNull

	public CustomerStatusEnum getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(CustomerStatusEnum customerStatus) {
		this.customerStatus = customerStatus;
	}

	public CustomerRequest address(AddressRequest address) {
		this.address = address;
		return this;
	}

	/**
	 * Get address
	 * 
	 * @return address
	 **/
	// @Schema(required = true, description = "")
	// @NotNull

	@Valid
	public AddressRequest getAddress() {
		return address;
	}

	public void setAddress(AddressRequest address) {
		this.address = address;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CustomerRequest customer = (CustomerRequest) o;
		return Objects.equals(this.id, customer.id)
				&& Objects.equals(this.customerNumber, customer.customerNumber)
				&& Objects.equals(this.firstName, customer.firstName)
				&& Objects.equals(this.lastName, customer.lastName)
				&& Objects.equals(this.birthdate, customer.birthdate)
				&& Objects.equals(this.country, customer.country)
				&& Objects.equals(this.countryCode, customer.countryCode)
				&& Objects.equals(this.mobileNumber, customer.mobileNumber)
				&& Objects.equals(this.email, customer.email)
				&& Objects.equals(this.customerStatus, customer.customerStatus)
				&& Objects.equals(this.address, customer.address);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, customerNumber, firstName, lastName, birthdate,
				country, countryCode, mobileNumber, email, customerStatus,
				address);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Customer {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    customerNumber: ")
				.append(toIndentedString(customerNumber)).append("\n");
		sb.append("    firstName: ").append(toIndentedString(firstName))
				.append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName))
				.append("\n");
		sb.append("    birthdate: ").append(toIndentedString(birthdate))
				.append("\n");
		sb.append("    country: ").append(toIndentedString(country))
				.append("\n");
		sb.append("    countryCode: ").append(toIndentedString(countryCode))
				.append("\n");
		sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber))
				.append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("    customerStatus: ")
				.append(toIndentedString(customerStatus)).append("\n");
		sb.append("    address: ").append(toIndentedString(address))
				.append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
