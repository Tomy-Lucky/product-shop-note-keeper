package com.example.assignment.Tamir.model

import com.example.assignment.Tamir.dto.Note
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "note")
class NoteModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,

    @Column
    var taskDescription: String,

    @Column
    var date: LocalDateTime
) : Serializable

fun NoteModel.toDTO() = Note(
    id = id,
    taskDescription = taskDescription,
    date = date
)
