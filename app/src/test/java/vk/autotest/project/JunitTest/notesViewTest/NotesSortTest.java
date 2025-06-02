package vk.autotest.project.JunitTest.notesViewTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import vk.autotest.project.noteData.Note;
import vk.autotest.project.noteView.NotesViewModel;
import static org.junit.Assert.assertEquals;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import vk.autotest.project.MainActivity;

public class NotesSortTest {
    private NotesViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before     // Setting a list of Notes to work in Tests
    public void setUp() {
        viewModel = new NotesViewModel();
        List<Note> testNotes = Arrays.asList(
                new Note("1", "Banana", "Content 1"),
                new Note("2", "Apple", "Content 2"),
                new Note("3", "Cherry", "Content 3")
        );
        for (Note note : testNotes) {
            viewModel.addNote(note.getTitle(), note.getContent());
        }
        Logger.getGlobal().info("Be  fore test notes added - passed");
    }

    @Test   // test to by default type
    public void testSortByTitleAscending() {
        Logger.getGlobal().info("Setted a By TITLE sort type");
        List<Note> sortedNotes = getNotesFromLiveData(viewModel.getNotes());
        Logger.getGlobal().info("Getting sorted notes  list");

        assertEquals("Apple", sortedNotes.get(0).getTitle());
        assertEquals("Banana", sortedNotes.get(1).getTitle());
        assertEquals("Cherry", sortedNotes.get(2).getTitle());
        Logger.getGlobal().info("Defalut sort by TITLE test working - passed");
    }

    @Test   // Sort test with custom sort type
    public void testSortByTitleDescending() {
        viewModel.setSortType(NotesViewModel.SortType.BY_TITLE_DESC);
        List<Note> sortedNotes = getNotesFromLiveData(viewModel.getNotes());
        Logger.getGlobal().info("Setted a BY_TITLE_DESC sort type");
        assertEquals("Cherry", sortedNotes.get(0).getTitle());
        assertEquals("Banana", sortedNotes.get(1).getTitle());
        assertEquals("Apple", sortedNotes.get(2).getTitle());
        Logger.getGlobal().info("Defalut sort by TITLE_DECS test working - passed");
    }

    // utility method for tests to get notes from LiveData
    private List<Note> getNotesFromLiveData(LiveData<List<Note>> liveData) {
        List<Note>[] notes = new List[1];
        liveData.observeForever(new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> noteList) {
                notes[0] = noteList;
            }
        });
        return notes[0];
    }
}
