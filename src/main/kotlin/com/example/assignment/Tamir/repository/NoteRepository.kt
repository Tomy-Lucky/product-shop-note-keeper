package com.example.assignment.Tamir.repository

import com.example.assignment.Tamir.model.NoteModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NoteRepository : JpaRepository<NoteModel, Long>
