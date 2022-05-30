package com.customer.publisher.utils;
public class MaskingUtils {

	private final static char emailIdMaskPattern = '*';
	private final static String customerNumberMaskPattern = "######****";
	private final static String birthdateMaskPattern = "XX-XX-####";

	// public static void main(String[] args) throws Exception {
	//
	// System.out.println(
	// maskEmailId("abcjlkj@gmail.com"));
	// System.out.println(
	// maskCustomerNumber("CJHKHK8889"));
	// System.out.println(maskBirthdate("08-05-1994"));
	//
	// }

	public static String maskEmailId(String emailid) throws Exception {
		return maskEmailAddress(emailid, emailIdMaskPattern);
	}

	public static String maskCustomerNumber(String customerNumber)
			throws Exception {
		return maskCustomerNumer(customerNumber, customerNumberMaskPattern);
	}

	public static String maskBirthdate(String birthdate) throws Exception {
		return maskBirthDate(birthdate, birthdateMaskPattern);
	}

	private static String maskCustomerNumer(String number, String mask) {
 
      int index = 0;
      StringBuilder masked = new StringBuilder();
      for (int i = 0; i < mask.length(); i++) {
         char c = mask.charAt(i);
			if (c == '#') {
            masked.append(number.charAt(index));
            index++;
		} else if (c == 'X') {
            masked.append(c);
            index++;
		} else {
            masked.append(c);
		}
      }
      return masked.toString();
   }

	private static String maskBirthDate(String number, String mask) {
		StringBuilder masked = new StringBuilder();
		for (int i = 0; i < mask.length(); i++) {
			char c = mask.charAt(i);
			if (c == 'X')
				masked.append(c);
			else if (c == '#')
				masked.append(number.charAt(i));
			else
				masked.append(c);
		}
		return masked.toString();
	}

	private static String maskEmailAddress(String strEmail, char maskChar)
			throws Exception {

		String[] parts = strEmail.split("@");

		// mask first part
		String maskString = "";
		maskString = maskString(parts[0], 0, 4, maskChar);

		// now append the domain part to the masked id part
		return maskString + "@" + parts[1];
	}

	private static String maskString(String strText, int start, int end,
			char maskChar) throws Exception {

		if (strText == null || strText.equals(""))
			return "";
		int maskLength = end - start;

		if (maskLength == 0)
			return strText;

		StringBuilder sbMaskString = new StringBuilder(maskLength);

		for (int i = 0; i < maskLength; i++) {
			sbMaskString.append(maskChar);
		}

		return strText.substring(0, start) + sbMaskString.toString()
				+ strText.substring(start + maskLength);
	}
}