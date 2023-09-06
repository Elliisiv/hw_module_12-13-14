package com.goit.hw.controller;

import com.goit.hw.entity.Note;
import com.goit.hw.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {
    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public String listNotes(Model model) {
        List<Note> notes = noteService.listAll();
        model.addAttribute("notes", notes);
        return "list";
    }

    @GetMapping("/edit")
    public String editNoteForm(@RequestParam long id, Model model) {
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return "note_edit";
    }

    @PostMapping("/edit")
    public String editNoteSubmit(@ModelAttribute Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
    @GetMapping("/add")
    public String addNote() {
        return "add_note";
    }
    @PostMapping("/add")
    public String addNoteToList(@ModelAttribute("note") Note newNote){
        noteService.add(newNote);
        return "redirect:/note/list";
    }

}