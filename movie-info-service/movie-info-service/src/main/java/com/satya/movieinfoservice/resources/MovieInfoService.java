package com.satya.movieinfoservice.resources;

import java.util.Collections;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satya.movieinfoservice.model.Movie;
@RestController
@RequestMapping("/movies")
public class MovieInfoService {
    @RequestMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId) {
		return new Movie(movieId, "test");
		
	}
}
