package com.beatgridmedia.assignment.movies


import com.beatgridmedia.assignment.movies.Movie
import com.beatgridmedia.assignment.movies.MovieService
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["http://localhost:5173"])
@RequestMapping("/api/movies")
class MovieController(
    private val movieService: MovieService
) {
    @GetMapping("/searchByText")
    fun search(@RequestParam searchText: String): List<Movie> {
        return movieService.searchByMovieName(searchText)
    }
    @GetMapping("/searchPaginated")
    fun searchPaginated(
        @RequestParam searchText: String,
        @RequestParam(defaultValue = "0") page: Int
    ): Page<Movie> {
        return movieService.searchMoviesPaginated(searchText, page)
    }
    @GetMapping("/{id}")
    fun getMovie(@PathVariable id: Long): Movie {
        return movieService.getMovieById(id)
    }
}
