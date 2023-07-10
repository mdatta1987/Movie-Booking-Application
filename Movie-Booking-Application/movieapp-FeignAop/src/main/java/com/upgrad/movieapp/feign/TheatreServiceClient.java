package com.upgrad.movieapp.feign;

import com.upgrad.movieapp.entities.Theatre;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "theatre-service",url = "http://localhost:8082")
public interface TheatreServiceClient {

    @RequestMapping(value = "/theatre_app/v1/theatres/{theatreId}/movie/{movieId}", method = RequestMethod.GET)
    public Theatre getTheatre(@PathVariable("theatreId") int theatreId, @PathVariable("movieId") int movieId);
}
