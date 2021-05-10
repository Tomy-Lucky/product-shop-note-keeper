package com.example.assignment.Tamir.dto

import java.io.Serializable
import java.time.LocalDateTime

data class Note(
    val id: Long,
    val taskDescription: String,
    val date: LocalDateTime
) : Serializable
