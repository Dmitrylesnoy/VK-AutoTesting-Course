package vk.autotest.project.JunitTest.notesViewTest;

import org.junit.Rule;
import org.junit.Test;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import static org.junit.Assert.*;

import vk.autotest.project.noteView.NotesViewModel;

public class NotesViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Test
    public void addNoteShouldUpdateLiveData() {
        NotesViewModel vm = new NotesViewModel();
        vm.addNote("Title", "Content");
        assertEquals(1, vm.getNotes().getValue().size());
    }

    @Test
    public void deleteNoteShouldUpdateLiveData() {
        NotesViewModel vm = new NotesViewModel();
        vm.addNote("Title", "Content");
        String id = vm.getNotes().getValue().get(0).getId();
        vm.deleteNote(id);
        assertTrue(vm.getNotes().getValue().isEmpty());
    }

    @Test
    public void addMultipleNotesShouldAllBePresent() {
        NotesViewModel vm = new NotesViewModel();
        vm.addNote("Note 1", "Content 1");
        vm.addNote("Note 2", "Content 2");
        assertEquals(2, vm.getNotes().getValue().size());
    }

    @Test
    public void deleteNonexistentNoteShouldNotCrash() {
        NotesViewModel vm = new NotesViewModel();
        vm.addNote("Note", "Content");
        vm.deleteNote("invalid-id");
        assertEquals(1, vm.getNotes().getValue().size());
    }
}