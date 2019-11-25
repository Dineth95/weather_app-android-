package com.example.day4.Models

data class Request(
    val type: String,
    val query: String,
    val language: String,
    val unit: String
)