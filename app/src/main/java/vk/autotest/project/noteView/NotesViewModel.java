package vk.autotest.project.noteView;

import androidx.lifecycle.*;
import java.util.*;

import vk.autotest.project.noteData.Note;
import vk.autotest.project.noteData.NotesRepository;

public class NotesViewModel extends ViewModel {
    private final NotesRepository repository = new NotesRepository();
    private final MutableLiveData<List<Note>> notesLiveData = new MutableLiveData<>(new ArrayList<>());

    public void addNote(String title, String content) {
        Note note = new Note(UUID.randomUUID().toString(), title, content);
        repository.addNote(note);
        updateNotesList();
    }

    public void deleteNote(String id) {
        repository.deleteNote(id);
        updateNotesList();
    }

    private void updateNotesList() {
        notesLiveData.setValue(repository.getAllNotes());
    }

    public LiveData<List<Note>> getNotes() {
        return notesLiveData;
    }
}
