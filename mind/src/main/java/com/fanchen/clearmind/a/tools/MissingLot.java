/*
 * Copyright (C) 2020 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.a.tools;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author fachen
 *
 */
public class MissingLot {

	public static void main(String[] args) {
		List<String> casLot = Arrays.asList("29460970", "29894850", "29906500", "31735580", "31782370", "31906000",
				"32320230", "32320920", "32320980", "28548560", "29012820", "29043380", "30225240", "32169400",
				"28243190", "29624690", "31267470");

		List<String> portalLot = Arrays.asList("28548560", "29012820", "29043380", "29460970", "30225240", "29894850",
				"29906500", "31906000", "31782370", "32320230", "32320920", "32320980", "32169400", "31735580");

		Set<String> portalSet = new HashSet<>(portalLot);

		for (String lot : casLot) {
			if (!portalSet.contains(lot)) {
				System.out.println(lot);
			}
		}
	}

}
