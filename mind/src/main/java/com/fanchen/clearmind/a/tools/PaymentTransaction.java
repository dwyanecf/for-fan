package com.fanchen.clearmind.a.tools;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.NoArgsConstructor;

/**
 * This is Transaction domain object includes vendorId we use to 
 * fetch vendor data and other information related to one transaction.
 * <p>
 * 
 * @author beiwen
 */
@NoArgsConstructor
public class PaymentTransaction {
	
	private List<String> taxes;

	//Used to identify the current transaction
	@NotNull(message = "Missing required field txnReferenceNum")	
	@Size(min = 1, message = "Empty required field txnReferenceNum")
	private String txnReferenceNum;

	//Used to identify the creditor we need to pay
	//@NotNull(message = "Missing required field vendorId")
	private Long vendorId;

	@NotNull(message = "Missing required field vendorId")
	private String vendorShortName;

	//Amount of money payed to vendor with the above vendorId
	@NotNull(message = "Missing required field amount")
	private BigDecimal amount;

	private List<String> noteToPayee;

	//Lot number for which the payment is being received
	@NotNull(message = "Missing required field lotNunmber")
	private Long lotNumber;

	//Lot description
	@NotNull(message = "Missing required field lotDescription")
	private String lotDescription;

	//The date the vehicle was picked up/delivered according to what was entered at the time of Trip Confirmation
	private String tripConfirmationDate;

	//From source address
	@NotNull(message = "Missing required field fromAddress")
	private String fromAddress;

	//destination address
	@NotNull(message = "Missing required field toAddress")
	private String toAddress;
	
	private String fromCompanyName;
	
	private String toCompanyName;
	//zone number address
	private String zoneId;

	private String pickupType;

	private String towType;

	private Boolean isVatAmount;

	// Financial Entity Type Code
	private String finEntityTypeCode;

	// Cas Entity Type Code == Service level classification code
	private String casEntityTypeCode;
	
	private String vehicleRegistrationNum;
	

}
