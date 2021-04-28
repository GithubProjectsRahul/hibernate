package com.projects.github.hibernate.service;

import com.projects.github.hibernate.entity.Actor;
import com.projects.github.hibernate.entity.Movie;
import com.projects.github.hibernate.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void addMovie() {
        Movie movie1 = new Movie("Movie 1");
        Movie movie2 = new Movie("Movie 2");

        Actor actor1 = new Actor("Actor 1");
        Actor actor2 = new Actor("Actor 2");

        movie1.getActors().add(actor1);

        movie2.getActors().add(actor1);
        movie2.getActors().add(actor2);

        movieRepository.save(movie1);
        movieRepository.save(movie2);
    }
}
