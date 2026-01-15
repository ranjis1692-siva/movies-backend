package com.beatgridmedia.assignment.movies


import com.beatgridmedia.assignment.movies.Movie
import com.beatgridmedia.assignment.movies.MovieService
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["http://localhost:5173"])
@RequestMapping("/api/movies")
class MovieController(
    private val movieService: MovieService
) {
    @GetMapping("/searchByText")
    fun search(@RequestParam query: String): List<Movie> {
        return movieService.searchByMovieName(query)
    }
    @GetMapping("/{id}")
    fun getMovie(@PathVariable id: Long): Movie {
        return movieService.getMovieById(id)
    }
}
