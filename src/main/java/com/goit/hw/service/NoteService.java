package com.goit.hw.service;

import com.goit.hw.entity.Note;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class NoteService implements NoteServiceInterface {
    private Map<Long, Note> noteMap = new HashMap<>();

    //повертає список всіх нотаток
    @Override
    public List<Note> listAll() {
        return List.copyOf(noteMap.values());
    }

// додає нову нотатку, генеруючи для цієї нотатки унікальний (випадковий)
// числовий ідентифікатор, повертає цю ж нотатку з
// згенерованим ідентифікатором.
    @Override
    public Note add(Note note) {
        long id = new Random().nextLong();
        note.setId(id);
        noteMap.put(id,note);
        return note;
    }

    //видаляє нотатку з вказаним ідентифікатором.
    // Якщо нотатки з ідентифікатором немає - викидає виключення.
    @Override
    public Note getById(long id) {
        if (noteMap.containsKey(id)){
        Note note = noteMap.get(id);
        return note;
    }else {
            throw new NullPointerException("This note was not found.");
        }
    }

// шукає нотатку по note.id. Якщо нотатка є - оновлює для неї title та content.
// Якщо нотатки немає - викидає виключення.
    @Override
    public void deleteById(long id) {
        if (noteMap.containsKey(id)){
            noteMap.remove(id);
        }else {
            throw new NullPointerException("This note was not found.");
        }
    }

//повертає нотатку по її ідентифікатору.
// Якщо нотатки немає - викидає виключення.
    @Override
    public void update(Note note) {
        if (noteMap.containsKey(note.getId())) {
            noteMap.put(note.getId(),note);
        } else {
            throw new NullPointerException("This note was not found.");
        }
    }
    
}
