package com.customer.publisher.domain;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ModelApiResponse
 */
@Validated
public class SucessResponse {
	@JsonProperty("status")
	private String status = null;

	@JsonProperty("message")
	private String message = null;

	public SucessResponse status(String status) {
		this.status = status;
		return this;
	}

	/**
	 * Get status
	 * 
	 * @return status
	 **/

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public SucessResponse message(String message) {
		this.message = message;
		return this;
	}

	/**
	 * Get message
	 * 
	 * @return message
	 **/
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SucessResponse _apiResponse = (SucessResponse) o;
		return Objects.equals(this.status, _apiResponse.status)
				&& Objects.equals(this.message, _apiResponse.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(status, message);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ModelApiResponse {\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    message: ").append(toIndentedString(message))
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
