package com.satya.ratingdataservice.model;

import java.util.List;

public class UserRatings {

	private List<Rating> userRating;

	public List<Rating> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}

	public UserRatings(List<Rating> userRating) {
		super();
		this.userRating = userRating;
	}

	public UserRatings() {
		super();
	}
	
}
