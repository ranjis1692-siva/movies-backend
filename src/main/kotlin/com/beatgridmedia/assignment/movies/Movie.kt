package com.beatgridmedia.assignment.movies

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "MOVIE")
data class Movie(
    @Id
    val id: Long,
    val name: String,
    @Column(columnDefinition = "TEXT")
    val description: String,
    val year: Int,
    @Column(columnDefinition = "JSON")
    val genres: String,
    @Column(columnDefinition = "JSON")
    val actors: String,
    @Column(columnDefinition = "JSON")
    val directors: String,
    @Column(name = "image_url")
    val imageUrl: String,
    @Column(name = "thumbnail_url")
    val thumbnailUrl: String,
    val rating: Double,
    val duration: String
)