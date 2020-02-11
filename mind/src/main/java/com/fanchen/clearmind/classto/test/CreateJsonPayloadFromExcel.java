/*
 * Copyright (C) 2020 Copart, Inc. All rights reserved.
 */
package com.fanchen.clearmind.classto.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

/**
 * @author Fan Chen
 *
 */
public class CreateJsonPayloadFromExcel {

	public static List<Event> events;

	public static void main(String[] args) {

		try {
			mapJavaBeanExample();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void mapJavaBeanExample() throws FileNotFoundException {
		ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
		strat.setType(Event.class);
		String[] columns = new String[] { "lotId", "tripKey", "pickupType", "destinationId", "towProviderShortName",
				"driverType", "amount", "toDateCC", "toDateYY", "toDateMM", "toDateDD", "heavyTow", "lotDescription",
				"zoneId", "toCompanyName", "fromCompanyName", "fromDateCC", "fromDateYY", "fromDateMM", "fromDateDD" };
		strat.setColumnMapping(columns);
		CsvToBean csv = new CsvToBean();
		String csvFilename = "/Users/fachen/Desktop/jeff.csv";
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
		List list = csv.parse(strat, csvReader);
		for (Object object : list) {
			Event event = (Event) object;
			Gson gson = new Gson();
			System.out.println(gson.toJson(event));
//			System.out.println("[" + event.getLotId() + "]:[" + event.getFacilityId() + "] Win againest [");
		}
	}

}
