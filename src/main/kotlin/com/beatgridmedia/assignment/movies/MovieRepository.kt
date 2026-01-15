package com.beatgridmedia.assignment.movies

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface MovieRepository : JpaRepository<Movie, Long> {
    @Query("""SELECT m FROM Movie m WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :name, '%')) """)
    fun searchMovies(@Param("name") name: String): List<Movie>
}