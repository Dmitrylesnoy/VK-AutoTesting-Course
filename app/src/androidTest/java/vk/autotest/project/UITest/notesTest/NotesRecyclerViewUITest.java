package vk.autotest.project.UITest.notesTest;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import java.util.logging.Logger;

import vk.autotest.project.MainActivity;
import vk.autotest.project.R;

public class NotesRecyclerViewUITest {
    @Rule   // Rule to start application activity for Test
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test   // adding some notes to app and checking that they exist on screen
    public void testAddMultipleNotes() {
        String[] titles = {"Note 1", "Note 2", "Note 3"};
        String content = "Sample content";

        for (String title : titles) {
            addNote(title, content);
        }
        Logger.getGlobal().info("Some notes added");
        for (String title : titles) {
            onView(withText(title)).check(matches(isDisplayed()));
        }
    }

    @Test   // add sth one note and try to delete. Screen should be empty
    public void testAddAndDelete() {
        String title = "End-to-End Test Note";
        String content = "This is a test note for end-to-end";

        addNote(title, content);
        Logger.getGlobal().info("Test note added");
        onView(withText(title)).check(matches(isDisplayed()));  // check that note added
        Logger.getGlobal().info("Note displayed");
        onView(withText(title)).perform(longClick());   // deleting note
        Logger.getGlobal().info("Note delete pressed");
        onView(withText(title)).check(doesNotExist());  // chtck that notes deleted

    }

    // utility method to add sth note in App
    private void addNote(String title, String content) {
        onView(withId(R.id.addNoteFab)).perform(click());
        onView(withId(R.id.editTextTitle)).perform(typeText(title));
        onView(withId(R.id.editTextContent)).perform(typeText(content));
        onView(withId(R.id.saveButton)).perform(click());
        Logger.getGlobal().info("Note with title: "+title+" added");
    }
}