package com.example.assignment.Tamir.controller

import com.example.assignment.Tamir.service.NoteService
import java.time.LocalDate
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:4200"], maxAge = 3600)
@RequestMapping("/notes")
@RestController
class NoteController(
    private val noteService: NoteService
) {

    @GetMapping("/all")
    fun getAllNotes() = noteService.getAll()

    @GetMapping("/{id}")
    fun getNoteById(@PathVariable id: Long) = noteService.getById(id = id)

    @GetMapping("/create-note")
    fun createNote(
        @RequestParam("taskDescription") taskDescription: String,
        @RequestParam("date")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) date: LocalDate
    ) = noteService.createNote(
        createNote = CreateNote(
            taskDescription = taskDescription,
            date = date
        )
    )

    @DeleteMapping("/delete-note")
    fun deleteNote(@RequestParam("id") id: Long) {
        noteService.deleteById(id = id)
    }
}

data class CreateNote(
    val taskDescription: String,
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    val date: LocalDate
)
