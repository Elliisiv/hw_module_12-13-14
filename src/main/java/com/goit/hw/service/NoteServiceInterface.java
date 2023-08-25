package com.goit.hw.service;

import com.goit.hw.entity.Note;

import java.util.List;
public interface NoteServiceInterface {
    List<Note> listAll();
    Note add(Note note);
    Note getById(long id);
    void deleteById(long id);
    void update(Note note);



}
