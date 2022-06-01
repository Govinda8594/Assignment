package com.customer.publisher.domain;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;

/**
 * Address
 */
public class AddressRequest {

	private Long id = null;

	@NotEmpty(message = "Address line 1 is mandatory")
	private String addressLine1 = null;

	private String addressLine2 = null;

	private String street = null;

	@NotEmpty(message = "postal code is mandatory")
	private String postalCode = null;

	public AddressRequest id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AddressRequest addressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
		return this;
	}

	/**
	 * Get addressLine1
	 * 
	 * @return addressLine1
	 **/

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public AddressRequest addressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
		return this;
	}

	/**
	 * Get addressLine2
	 * 
	 * @return addressLine2
	 **/

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public AddressRequest street(String street) {
		this.street = street;
		return this;
	}

	/**
	 * Get street
	 * 
	 * @return street
	 **/

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public AddressRequest postalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	/**
	 * Get postalCode
	 * 
	 * @return postalCode
	 **/

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AddressRequest address = (AddressRequest) o;
		return Objects.equals(this.id, address.id)
				&& Objects.equals(this.addressLine1, address.addressLine1)
				&& Objects.equals(this.addressLine2, address.addressLine2)
				&& Objects.equals(this.street, address.street)
				&& Objects.equals(this.postalCode, address.postalCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, addressLine1, addressLine2, street, postalCode);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Address {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    addressLine1: ").append(toIndentedString(addressLine1))
				.append("\n");
		sb.append("    addressLine2: ").append(toIndentedString(addressLine2))
				.append("\n");
		sb.append("    street: ").append(toIndentedString(street)).append("\n");
		sb.append("    postalCode: ").append(toIndentedString(postalCode))
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
