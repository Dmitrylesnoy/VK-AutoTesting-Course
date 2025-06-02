package vk.autotest.project.JunitTest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;
import org.mockito.internal.matchers.Not;

import static org.junit.Assert.assertEquals;

import vk.autotest.project.noteData.Note;
import vk.autotest.project.noteData.NotesRepository;

public class NotesRepositoryTest {

    @Test   // adding a note should be increase a NotesRepo size (check than sth added to repo)
    public void addNoteShouldIncreaseListSize() {
        NotesRepository repo = new NotesRepository();
        repo.addNote(new Note("1", "Test", "Content"));
        assertEquals(1, repo.getAllNotes().size());
        Logger.getGlobal().info("Repository size is changing - passed");
    }

    @Test   // deleting sth from repo collection should be removed
    public void deleteNoteShouldRemoveFromList() {
        NotesRepository repo = new NotesRepository();
        Note note = new Note("1", "Test", "Content");
        repo.addNote(note);
        Logger.getGlobal().info("Size: "+repo.getSize());
        repo.deleteNote("1");
        assertEquals(new ArrayList<Not>(), repo.getAllNotes());
        Logger.getGlobal().info("Notes deleted from repo list - passed");
    }

    @Test   // deleting by invalid note id should not work
    public void deleteNoteInvalidIdShouldNotAffectList() {
        NotesRepository repo = new NotesRepository();
        repo.addNote(new Note("1", "Note1", "Content1"));
        repo.deleteNote("invalid_id");
        assertEquals(1, repo.getAllNotes().size());
        Logger.getGlobal().info("Invalid notes delete not allow to repo - passed");
    }

    @Test   // getAll method should make a copy of data and return
    public void getAllNotesShouldReturnCopy() {
        NotesRepository repo = new NotesRepository();
        Note note = new Note("1", "Note", "Test");
        repo.addNote(note);
        List<Note> notes = repo.getAllNotes();
        notes.clear();
        Logger.getGlobal().info("Size: "+notes.size());
        assertEquals(1, repo.getAllNotes().size());
        Logger.getGlobal().info("Repo copy is returning from class - passed");
    }
}