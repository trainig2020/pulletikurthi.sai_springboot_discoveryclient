package com.satya.moviecatlogservice.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.satya.moviecatlogservice.model.CatlogItem;
import com.satya.moviecatlogservice.model.Movie;
import com.satya.moviecatlogservice.model.Rating;
import com.satya.moviecatlogservice.model.UserRatings;
@RestController
@RequestMapping("/catlog")
public class MovieCatlogResources {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private WebClient.Builder webbuilder;
	
	
	@RequestMapping("/{userId}")
	public List<CatlogItem> getCatlog(@PathVariable("userId") String userId) {
		UserRatings ratings=restTemplate.getForObject("http://rating-data-service/rating/user/"+userId, UserRatings.class);
		/*List<Rating> ratings=Arrays.asList(
				new Rating("1234",4),
				new Rating("4321",3)
				
				);*/
		
				
		return ratings.getUserRating().stream().map(rating -> {
	Movie movie=restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
	return new CatlogItem(movie.getName(), "test",rating.getRating());
		})
    // Movie movie=webbuilder.build()
       //  .get()
       //  .uri("http://localhost:8181/movies/"+rating.getMovieId())
      //   .retrieve()
      //   .bodyToMono(Movie.class)
      //   .block();
			
		
		.collect(Collectors.toList());
				
				
	}
}
