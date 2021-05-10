package com.example.assignment.Tamir.service

import com.example.assignment.Tamir.controller.CreateNote
import com.example.assignment.Tamir.exception.ElementNotFoundException
import com.example.assignment.Tamir.model.NoteModel
import com.example.assignment.Tamir.model.toDTO
import com.example.assignment.Tamir.repository.NoteRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class NoteService(
    private val noteRepository: NoteRepository
) {

    @Transactional
    fun getAll() = noteRepository.findAll().map { it.toDTO() }

    @Transactional
    fun getById(id: Long) =
        noteRepository.findByIdOrNull(id)?.toDTO() ?: throw ElementNotFoundException("note by id $id")

    @Transactional
    fun createNote(createNote: CreateNote) =
        noteRepository.save(
            NoteModel(
                id = 0,
                taskDescription = createNote.taskDescription,
                date = createNote.date.atStartOfDay()
            )
        ).toDTO()

    @Transactional
    fun deleteById(id: Long) {
        noteRepository.deleteById(id)
    }
}
