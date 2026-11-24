package com.example.consolenotes;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    private final List<String> notes = new ArrayList<>();

    public void addNote(String note) {
        notes.add(note);
    }

    public List<String> getAllNotes() {
        return notes;
    }
}
