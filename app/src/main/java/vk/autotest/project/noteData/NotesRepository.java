package vk.autotest.project.noteData;

import java.util.*;

public class NotesRepository {
    private final List<Note> notes = new ArrayList<>();

    public void addNote(Note note) {
        notes.add(note);
    }

    public void deleteNote(String id) {
        notes.removeIf(note -> note.getId().equals(id));
    }

    public List<Note> getAllNotes() {
        return new ArrayList<>(notes);
    }
}
