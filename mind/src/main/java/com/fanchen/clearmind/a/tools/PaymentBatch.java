package com.fanchen.clearmind.a.tools;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.NoArgsConstructor;

/**
 * This is Payment Batch domain object thats contains information we require to
 * generate outgoing bank file
 * <p>
 * 
 * @author beiwen
 * @see {@link PaymentRequest}
 * 
 */
@NoArgsConstructor
public class PaymentBatch {

	// Used to keep track of the corresponding entity object
	private Long paymentId;

	// Currency in which the payment account is held
	@NotNull(message = "Missing required field currency")
	private String currency;

	private String paymentDate;
	private List<PaymentTransaction> transactions;

	// refactored
	private String finObjType;

	private Long finObjId;

	
	private BigDecimal totalAmount;
	
	private BigDecimal vatAmount;
	
	private BigDecimal subTotalAmount;
	
	private String paymentReferenceNums;
	
	private String txnReferenceNum;
	
	private String paymentMethod;
}
