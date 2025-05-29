package vk.autotest.project.noteData;

import java.util.*;

public class NotesRepository {
    private final List<Note> notes = new ArrayList<>();

    public void addNote(Note note) {
        notes.add(note);
    }

    public void deleteNote(String id) {
        Iterator<Note> iterator = notes.iterator();
        while (iterator.hasNext()) {
            Note note = iterator.next();
            if (note.getId().equals(id)) {
                iterator.remove();
            }
        }
    }

    public List<Note> getAllNotes() {
        return new ArrayList<>(notes);
    }
}
