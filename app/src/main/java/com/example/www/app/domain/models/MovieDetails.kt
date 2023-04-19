package com.example.www.app.domain.models

data class MovieDetails(
    val id:Int,
    val title:String,
    val posterUrl:String,
    val year:String,
    val plot:String,
    val actors:String,
    val genres:String,
    val runtime:String
)