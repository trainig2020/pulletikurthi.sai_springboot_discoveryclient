package com.satya.ratingdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satya.ratingdataservice.model.Rating;
import com.satya.ratingdataservice.model.UserRatings;
@RestController
@RequestMapping("/rating")
public class RatingDataService {
    @RequestMapping("{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new  Rating(movieId,4);
		
	}
    @RequestMapping("/user/{userId}")
	public UserRatings getUserRating(@PathVariable("userId") String userId) {
    	List<Rating> ratings=Arrays.asList(
    		new Rating("1234", 4),
    		new Rating("4321", 3)
    			
    			);
		UserRatings userRatings=new UserRatings();
		userRatings.setUserRating(ratings);
		return userRatings;
		
	}
}
