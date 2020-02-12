/*
 * Copyright (C) 2020 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.classto.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fan Chen
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Event {

	public String facilityId;
	public String lotId;
	public String eventCode;
	public Payment payment;
	public String items;
	public String flowId;
	public Party party;
	
	
	// ignore below
	public String sourceId;
	public String towType;
	public String destinationId;
	public String serviceClassificationCode;
	public String toCompanyName;
	public String lotDescription;
	public String heavyTow;
	public String zoneId;
	public String vatTaxRate;
	public String amount;
	public String fromCompanyName;
	public String entityType;
	public String tripToDate;
	public String tripConfirmationDate;
	public String lotNumber;
	public String pickupType;
	public String tripKey;
	public String driverType;
	public String dispatchedAt;
	public String tripFromDate;
	public String tripDate;
	public String towProviderShortName;
	
	
	public String toDateCC;
	public String toDateYY;
	public String toDateMM;
	public String toDateDD;
	
	
	public String fromDateCC;
	public String fromDateYY;
	public String fromDateMM;
	public String fromDateDD;
	
}
