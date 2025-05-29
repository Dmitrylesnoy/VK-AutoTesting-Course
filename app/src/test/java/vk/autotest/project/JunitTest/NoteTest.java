package vk.autotest.project.JunitTest;

import vk.autotest.project.noteData.Note;
import static org.junit.Assert.assertEquals;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

public class NoteTest {

    @Test
    public void constructorShouldSetFieldsCorrectly() {
        Note note = new Note("1", "Title", "Content");
        assertEquals("1", note.getId());
        assertEquals("Title", note.getTitle());
        assertEquals("Content", note.getContent());
    }

//    @Test
//    public void settersShouldUpdateFields() {
//        Note note = new Note("1", "Old", "Text");
//        note.setTitle("New");
//        note.setContent("Updated");
//        assertEquals("New", note.getTitle());
//        assertEquals("Updated", note.getContent());
//    }
}
