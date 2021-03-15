package com.fanchen.clearmind.a.tools;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacilityInfo {

	private Long facilityId;

	private String country;
	private String yardName;

	private String yardAddressLine1;
	private String yardAddressLine2;

	private String yardState;

	private String yardCity;

	private String postalCode;

	private String phoneNumber;

}
