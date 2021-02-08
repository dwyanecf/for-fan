package com.fanchen.clearmind.indeed.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fanchen.clearmind.indeed.vo.AdSystem.Location;

public class CompanyReview {
	
	// load balancer
	// cache
	// kafka
	// log events
	// error handling
	// manual fixes methods available
	

	public double rating;
	public int numOfRating;
	public double sumScoreOfRating;

	public String companyName;

	public List<Reviews> reviews;

	class Reviews {

		public String companyName;
		public String language;
		public double rating;
		public double usefullness;
		public String header;
		public String comments;
		public String pros;
		public String cons;
		public Date fromDate;
		public Date toDate;
		public String jobTitle;
		public Location loc;
		public Date reviewDate;
		public String status;

		public Reviews(String companyName, String language, double rating, double usefullness, String header,
				String comments, String pros, String cons, Date fromDate, Date toDate, String jobTitle, Location loc,
				Date reviewDate, String status) {
			super();
			this.companyName = companyName;
			this.language = language;
			this.rating = rating;
			this.usefullness = usefullness;
			this.header = header;
			this.comments = comments;
			this.pros = pros;
			this.cons = cons;
			this.fromDate = fromDate;
			this.toDate = toDate;
			this.jobTitle = jobTitle;
			this.loc = loc;
			this.reviewDate = reviewDate;
			this.status = status;
		}

	}

	public CompanyReview() {
		reviews = new ArrayList<>();
	}

	public double getRating() {
		return (double) sumScoreOfRating / numOfRating;
	}

	public void addReview(Reviews review) {
		this.reviews.add(review);
		numOfRating++;
		sumScoreOfRating += review.rating;
		this.rating = getRating();
	}

}













































