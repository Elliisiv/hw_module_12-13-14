package com.goit.hw.service;

import com.goit.hw.entity.Note;
import com.goit.hw.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements NoteServiceInterface {
    private final NoteRepository noteRepository ;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    //повертає список всіх нотаток
    @Override
    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    // додає нову нотатку
    @Override
    public Note add(Note note) {
        return noteRepository.save(note);
    }

    //шукає нотатку з вказаним ідентифікатором.
    @Override
    public Note getById(long id) {
        return noteRepository.findById(id).orElse(null);
    }

// видаляє нотатку по note.id.
    @Override
    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public void update(Note note) {
       noteRepository.save(note);
    }
    }
