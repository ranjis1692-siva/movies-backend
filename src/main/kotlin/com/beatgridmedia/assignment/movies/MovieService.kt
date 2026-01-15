package com.beatgridmedia.assignment.movies

import com.beatgridmedia.assignment.movies.Movie
import com.beatgridmedia.assignment.movies.MovieRepository
import org.springframework.stereotype.Service

@Service
class MovieService(
    private val movieRepository: MovieRepository
) {
    fun searchByMovieName(query: String): List<Movie> {
        if (query.isBlank()) return emptyList()
        return movieRepository.searchMovies(query).take(10)
    }
    fun getMovieById(id: Long): Movie {
        return movieRepository.findById(id)
            .orElseThrow { RuntimeException("Movie not found") }
    }
}
