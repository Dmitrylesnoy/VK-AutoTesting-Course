package vk.autotest.project.noteView;

import androidx.lifecycle.*;
import java.util.*;

import vk.autotest.project.noteData.Note;
import vk.autotest.project.noteData.NotesRepository;

public class NotesViewModel extends ViewModel {
    private final NotesRepository repository = new NotesRepository();
    private final MutableLiveData<List<Note>> notesLiveData = new MutableLiveData<>(new ArrayList<>());
    private SortType currentSortType = SortType.BY_TITLE;
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
        List<Note> notes = repository.getAllNotes();
        switch (currentSortType) {
            case BY_TITLE:
                notes.sort(Comparator.comparing(Note::getTitle));
                break;
            case BY_TITLE_DESC:
                notes.sort(Comparator.comparing(Note::getTitle).reversed());
                break;
        }
        notesLiveData.setValue(notes);
    }
    public LiveData<List<Note>> getNotes() {
        return notesLiveData;
    }

    public void setSortType(SortType sortType) {
        this.currentSortType = sortType;
        updateNotesList();
    }
    public enum SortType {
        BY_TITLE,
        BY_TITLE_DESC
    }
}
