package vk.autotest.project.JunitTest;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import vk.autotest.project.noteData.Note;
import vk.autotest.project.noteData.NotesRepository;

public class NotesRepositoryTest {

    @Test
    public void addNoteShouldIncreaseListSize() {
        NotesRepository repo = new NotesRepository();
        repo.addNote(new Note("1", "Test", "Content"));
        assertEquals(1, repo.getAllNotes().size());
        Logger.getGlobal().info("Repository size is changing - passed");
    }

    @Test
    public void deleteNoteShouldRemoveFromList() {
        NotesRepository repo = new NotesRepository();
        Note note = new Note("1", "Test", "Content");
        repo.addNote(note);
        repo.deleteNote("1");
        assertEquals(0, repo.getAllNotes().size());
        Logger.getGlobal().info("Notes deleted from repo list - passed");
    }

    @Test
    public void deleteNoteInvalidIdShouldNotAffectList() {
        NotesRepository repo = new NotesRepository();
        repo.addNote(new Note("1", "Note1", "Content1"));
        repo.deleteNote("invalid_id");
        assertEquals(1, repo.getAllNotes().size());
        Logger.getGlobal().info("Invalid notes delete not allow to repo - passed");
    }

    @Test
    public void getAllNotesShouldReturnCopy() {
        NotesRepository repo = new NotesRepository();
        Note note = new Note("1", "Note", "Test");
        repo.addNote(note);
        List<Note> notes = repo.getAllNotes();
        notes.clear();
        assertEquals(1, repo.getAllNotes().size());
        Logger.getGlobal().info("Repo copy is returning from class - passed");
    }
}