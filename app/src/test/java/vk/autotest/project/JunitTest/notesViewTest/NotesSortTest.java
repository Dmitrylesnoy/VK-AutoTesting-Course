package vk.autotest.project.JunitTest.notesViewTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import vk.autotest.project.noteData.Note;
import vk.autotest.project.noteView.NotesViewModel;
import static org.junit.Assert.assertEquals;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import vk.autotest.project.MainActivity;

public class NotesSortTest {
    private NotesViewModel viewModel;
    private List<Note> testNotes;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() {
        viewModel = new NotesViewModel();
        testNotes = Arrays.asList(
                new Note("1", "Banana", "Content 1"),
                new Note("2", "Apple", "Content 2"),
                new Note("3", "Cherry", "Content 3")
        );
        for (Note note : testNotes) {
            viewModel.addNote(note.getTitle(), note.getContent());
        }
    }

    @Test
    public void testSortByTitleAscending() {
        viewModel.setSortType(NotesViewModel.SortType.BY_TITLE);
        List<Note> sortedNotes = getNotesFromLiveData(viewModel.getNotes());

        assertEquals("Apple", sortedNotes.get(0).getTitle());
        assertEquals("Banana", sortedNotes.get(1).getTitle());
        assertEquals("Cherry", sortedNotes.get(2).getTitle());
    }

    @Test
    public void testSortByTitleDescending() {
        viewModel.setSortType(NotesViewModel.SortType.BY_TITLE_DESC);
        List<Note> sortedNotes = getNotesFromLiveData(viewModel.getNotes());

        assertEquals("Cherry", sortedNotes.get(0).getTitle());
        assertEquals("Banana", sortedNotes.get(1).getTitle());
        assertEquals("Apple", sortedNotes.get(2).getTitle());
    }

    private List<Note> getNotesFromLiveData(LiveData<List<Note>> liveData) {
        final List<Note>[] notes = new List[1];
        liveData.observeForever(new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> noteList) {
                notes[0] = noteList;
            }
        });
        return notes[0];
    }
}
