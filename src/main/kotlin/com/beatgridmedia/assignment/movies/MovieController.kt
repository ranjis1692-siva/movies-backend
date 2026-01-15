package com.beatgridmedia.assignment.movies


import com.beatgridmedia.assignment.movies.Movie
import com.beatgridmedia.assignment.movies.MovieService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/movies")
class MovieController(
    private val movieService: MovieService
) {
    @GetMapping("/searchByText")
    fun search(@RequestParam query: String): List<Movie> {
        return movieService.autocomplete(query)
    }
    @GetMapping("/{id}")
    fun getMovie(@PathVariable id: Long): Movie {
        return movieService.getMovieById(id)
    }
}
