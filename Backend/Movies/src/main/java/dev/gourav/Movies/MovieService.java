package dev.gourav.Movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  java.util.*;

@Service
public class MovieService {
//    we will make Database call from here to find all movies
    @Autowired
 private  MovieRepository movieRepository;

    public Movie createMovie(Movie movie) {
        // Additional logic to handle movie creation
        return movieRepository.save(movie);
    }

//    will find all movies :
public List<Movie> allMovies(){
return movieRepository.findAll();
}

    public Optional<Movie> findMovieByImdbId(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }


}

