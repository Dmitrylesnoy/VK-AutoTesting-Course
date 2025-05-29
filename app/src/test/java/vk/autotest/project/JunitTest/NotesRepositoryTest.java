package vk.autotest.project.JunitTest;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import vk.autotest.project.noteData.Note;
import vk.autotest.project.noteData.NotesRepository;

//@RunWith(AndroidJUnit4.class)
public class NotesRepositoryTest {

    @Test
    public void addNote_ShouldIncreaseListSize() {
        NotesRepository repo = new NotesRepository();
        repo.addNote(new Note("1", "Test", "Content"));
        assertEquals(1, repo.getAllNotes().size());
    }

//    @Test
//    public void deleteNote_ShouldRemoveFromList() {
//        NotesRepository repo = new NotesRepository();
//        Note note = new Note("1", "Test", "Content");
//        repo.addNote(note);
//        repo.deleteNote("1");
//        assertEquals(0, repo.getAllNotes().size());
//    }
//
//    @Test
//    public void deleteNote_InvalidId_ShouldNotAffectList() {
//        NotesRepository repo = new NotesRepository();
//        repo.addNote(new Note("1", "Note1", "Content1"));
//        repo.deleteNote("invalid_id");
//        assertEquals(1, repo.getAllNotes().size());
//    }
//
//    @Test
//    public void getAllNotes_ShouldReturnCopy() {
//        NotesRepository repo = new NotesRepository();
//        Note note = new Note("1", "Note", "Test");
//        repo.addNote(note);
//        List<Note> notes = repo.getAllNotes();
//        notes.clear();
//        assertEquals(1, repo.getAllNotes().size());
//    }
}