package com.fanchen.clearmind.a.tools;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Generic POJO for doc generation
 * 
 * @author Fan Chen
 * @since G2-US-Subhauler
 *
 */
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
public class DocGenProcessRequest {

	private PaymentBatch payoutTransactions;

	private FacilityInfo facility;

	private Vendor vendor;
	
	private String standardPrinter;

}
