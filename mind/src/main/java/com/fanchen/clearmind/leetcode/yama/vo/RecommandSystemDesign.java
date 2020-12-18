package com.fanchen.clearmind.leetcode.yama.vo;

public class RecommandSystemDesign {

//	https://leetcode.com/discuss/interview-question/144287/Design-Recommendation-System-for-Amazon-Videos
//  https://leetcode.com/discuss/interview-question/124557/Amazon's-%22Customers-who-bought-this-item-also-bought%22-recommendation-system
//  https://wizardforcel.gitbooks.io/gainlo-interview-guide/content/sd12.html
	/**
	 * Recommendation rules: based on history?(related area) Topic, Category, Uploader, Channel....
	 * based on popularity/ review times / liked times/ subscribed
	 * Collaborative filtering  // if A watch tv shows, B also watch. Then recommend A with what other shows B like also
	 * Calculate points
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * FUNCTIONALITY
		Qn: When are the items shown? Assumption: When the page of an item is viewed.
		Qn: How many items are shown? Assumption: Maximum of 5.
		Qn: Did the other customer buy the items at the same time? Assumption: Not necessarily,
		 but if it was many years between purchases of A and B then we would not recommend B with A.
		Qn: What is the scale of the system? Assumption: Start with a small solution and extent to the scale of Amazon.
		
		INITIAL HIGH-LEVEL DESIGN
		Relational database table ALSO_BOUGHT with columns item_A_id, item_B_id, count.
		Primary key is (item_A_id, item_B_id).
		count is the number of times these items have been bought by the same customer (within 1 year of the purchases).
		Enforce ordering so that item_A_id < item_B_id, so we don't duplicate everything.
		Do not store multiple purchases where item_A_id == item_B_id since they are not good recommendations.
		
		WORKFLOW
		When a customer makes a new purchase of A then retrieve all items purchased in the last year (B, C, D, E ...)
		Increment the count for each pair (A, B), (A, C), ...
		When a customer views item X, select all rows in the table where item_A_id == X or item_B_id == X.
		Sort by count and return the top 5.
		
		OPTIMIZATIONS AND SCALING
		Updating ALSO_BOUGHT can be done asynchronously. It is not necessary to include all purchases to the latest millisecond.
		Use a cache to store purchases temporarily, and periodically update the database.
		Or write purchases to a log, which are processed in parallel similar to MapReduce.
		Or write to a queue, which are consumed by workers (a dedicated microservice).
		If data is lost due to hardware failure, we can recreate it by querying the main purchases database.
		
		Finding the recommentaions to show with an item must have low latency.
		The scheme above will be slow, if Amazon has 10^8 products and each product has been bought with 1000 others the table has ~10^11 rows.
		Calculate the top 5 recommendations for each item asynchronously and store in a RECOMMENDATIONS table.
		For the most popular items, store their top 5 recommendations in a cache.
		
		Split ALSO_BOUGHT by department (electronics, clothes, toys). Reduces the size and "long tail" but miss some cross-department sales.
		Improve recommendations from the above count-based method with machine learning accounting for individual characteristics.
	 */

}
