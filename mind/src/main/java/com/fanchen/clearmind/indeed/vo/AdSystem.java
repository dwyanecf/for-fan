package com.fanchen.clearmind.indeed.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AdSystem {

	// Scale, Speed, Auction, Pacing
	PriorityQueue<Ad> pq;
	Map<Location, PriorityQueue<Ad>> locMap;
	int noOfAds;

	public AdSystem(List<Ad> ads) {
		locMap = new HashMap<>();
		for (Ad ad : ads) {
			for (Location loc : ad.availableLocations) {
				if (locMap.containsKey(loc)) {
					locMap.get(loc).offer(ad);
				} else {
					locMap.put(loc, new PriorityQueue<>((a, b) -> b.price - a.price));
				}
			}
		}
		noOfAds = pq.size();
	}

	public Ad getBestAds(Location loc) {
		if (!locMap.get(loc).isEmpty()) {
			return locMap.get(loc).poll();
		} else {
			return null;
		}
	}

	class Ad {

		public int price;
		public String type;
		public Date fromDate;
		public Date toDate;
		public String info;
		public List<Location> availableLocations;

		public Ad(int price, String type, Date fromDate, Date toDate, String info, List<Location> availableLocations) {
			super();
			this.price = price;
			this.type = type;
			this.fromDate = fromDate;
			this.toDate = toDate;
			this.info = info;
			this.availableLocations = availableLocations;
		}
	}

	class Location {
		public String regionCd;
		public String countryCode;

	}

	// 1, webiste.com

	// 2. call ad selector service (load balancer needed)

	// 3. Enrichment service (by request)

	// 3. same time log it through kafka

	// 4. monitoring each advertiser for how many ads. how long we monitored.

	// 5. load testing

}












































