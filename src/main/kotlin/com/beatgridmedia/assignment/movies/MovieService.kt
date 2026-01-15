package com.beatgridmedia.assignment.movies

import com.beatgridmedia.assignment.movies.Movie
import com.beatgridmedia.assignment.movies.MovieRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class MovieService(
    private val movieRepository: MovieRepository
) {
    fun searchByMovieName(searchText: String): List<Movie> {
        if (searchText.isBlank()) return emptyList()
        return movieRepository.searchMovies(searchText)
    }
    fun searchMoviesPaginated(searchText: String, page: Int): Page<Movie> {
        val zeroBasedPage = if (page > 0) page - 1 else 0
        val pageable: Pageable = PageRequest.of(zeroBasedPage, 20)
        return movieRepository.searchMoviesByPages(searchText, pageable)
    }
    fun getMovieById(id: Long): Movie {
        return movieRepository.findById(id)
            .orElseThrow { RuntimeException("Movie not found") }
    }
}
