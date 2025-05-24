package vk.autotest.project.UITest;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import vk.autotest.project.MainActivity;
import vk.autotest.project.R;

public class NotesRecyclerViewUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    // Test 1: Verify deleting a note via long press
    @Test
    public void testDeleteNote() {
        String title = "Note to Delete";
        String content = "Content of note to delete";

        // Add a note
        addNote(title, content);
        // Verify note is added
        onView(withText(title)).check(matches(isDisplayed()));
        // Long press to delete
        onView(withText(title)).perform(longClick());
        // Verify note is removed
        onView(withText(title)).check(doesNotExist());
    }

    // Test 2: Verify multiple notes are displayed
    @Test
    public void testAddMultipleNotes() {
        String[] titles = {"Note 1", "Note 2", "Note 3"};
        String content = "Sample content";

        // Add multiple notes
        for (String title : titles) {
            addNote(title, content);
        }

        // Verify all notes are displayed
        for (String title : titles) {
            onView(withText(title)).check(matches(isDisplayed()));
        }
    }

    // Test 3: End-to-end test: Add, verify, delete
    @Test
    public void testAddAndDelete() {
        String title = "End-to-End Test Note";
        String content = "This is a test note for end-to-end";

        // Add a note
        addNote(title, content);
        // Verify note is added
        onView(withText(title)).check(matches(isDisplayed()));
        // Delete the note
        onView(withText(title)).perform(longClick());
        // Verify note is removed
        onView(withText(title)).check(doesNotExist());

    }

    // Helper method to add a note
    private void addNote(String title, String content) {
        onView(withId(R.id.addNoteFab)).perform(click());
        onView(withId(R.id.editTextTitle)).perform(typeText(title));
        onView(withId(R.id.editTextContent)).perform(typeText(content));
        onView(withId(R.id.saveButton)).perform(click());
    }
}