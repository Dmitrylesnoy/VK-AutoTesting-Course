package vk.autotest.project.JunitTest.notesViewTest;

import org.junit.Rule;
import org.junit.Test;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import vk.autotest.project.noteView.NotesViewModel;

public class NotesViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Test   // adding a note should be increase LiveData element size
    public void addNoteShouldUpdateLiveData() {
        NotesViewModel vm = new NotesViewModel();
        vm.addNote("Title", "Content");
        assertEquals(1, vm.getNotes().getValue().size());
        Logger.getGlobal().info("Live data s updating - passed");
    }

    @Test   // also deleting note from LiveData should reduce size
    public void deleteNoteShouldUpdateLiveData() {
        NotesViewModel vm = new NotesViewModel();
        vm.addNote("Title", "Content");
        String id = vm.getNotes().getValue().get(0).getId();
        vm.deleteNote(id);
        assertTrue(vm.getNotes().getValue().isEmpty());
        Logger.getGlobal().info("deleting is updatin LiveData - passed");
    }

    @Test   // simple check that multiple adding works
    public void addMultipleNotesShouldAllBePresent() {
        NotesViewModel vm = new NotesViewModel();
        vm.addNote("Note 1", "Content 1");
        vm.addNote("Note 2", "Content 2");
        assertEquals(2, vm.getNotes().getValue().size());
        Logger.getGlobal().info("Adding multiple notes work correctly - passed");
    }

    @Test   // non-existal note should not be deleted
    public void deleteNonExistentNoteShouldNotCrash() {
        NotesViewModel vm = new NotesViewModel();
        vm.addNote("Note", "Content");
        vm.deleteNote("invalid-id");
        assertEquals(1, vm.getNotes().getValue().size());
        Logger.getGlobal().info("Not existing notes does not deleting - passed");
    }
}