package vk.autotest.project.JunitTest;

import vk.autotest.project.noteData.Note;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.logging.Logger;

public class NoteTest {

    @Test
    public void constructorShouldSetFieldsCorrectly() {
        Note note = new Note("1", "Title", "Content");
        assertEquals("1", note.getId());
        assertEquals("Title", note.getTitle());
        assertEquals("Content", note.getContent());
        Logger.getGlobal().info("Message equals test - passed");
    }

    @Test
    public void settersShouldUpdateFields() {
        Note note = new Note("1", "Old", "Text");
        note.setTitle("New");
        note.setContent("Updated");
        assertEquals("New", note.getTitle());
        assertEquals("Updated", note.getContent());
        Logger.getGlobal().info("Setter updated fields - passed");
    }
}
