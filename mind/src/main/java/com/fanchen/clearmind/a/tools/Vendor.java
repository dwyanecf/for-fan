package com.fanchen.clearmind.a.tools;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is the class for enriching vendor data in the bank file.
 * 
 * @author Fan Chen
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vendor {
	
	private Long vendorId;
	
	private String vendorName;
	
	private String vendorShortName;
	
	private String email;
	
	private String businessOwnerFirstName;
	
	private String businessOwnerLastName;
	
	private String primaryAddress;
	
	private String primaryPhone;
	
	private String vendorPaymentDetails;
	
	private String vatDetails;
	
}
