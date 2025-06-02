package vk.autotest.project.UITest.notesTest;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import java.util.logging.Logger;

import vk.autotest.project.MainActivity;
import vk.autotest.project.R;

public class AddNoteDialogUITest {
    @Rule   // Rule to start application activity for Test
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test   // simple test to add base note with correct nonempty fields
    public void testAddNoteWithValidInput() {
        String title = "Test Note";
        String content = "This is a test note content";

        onView(withId(R.id.addNoteFab)).perform(click());
        onView(withId(R.id.editTextTitle)).perform(typeText(title));
        onView(withId(R.id.editTextContent)).perform(typeText(content));
        onView(withId(R.id.saveButton)).perform(click());
        Logger.getGlobal().info("Trying to save note");
        onView(withId(R.id.addNoteDialog)).check(doesNotExist());
        Logger.getGlobal().info("AddNote dialog is not displayed");
        onView(withText(title)).check(matches(isDisplayed()));
    }

    @Test   // trying to add note with empty title. Adding should not be complete
    public void testAddNoteWithEmptyTitle() {
        String content = "This is a test note content";

        onView(withId(R.id.addNoteFab)).perform(click());
        onView(withId(R.id.editTextContent)).perform(typeText(content));
        Logger.getGlobal().info("Note content didn't wrote");
        onView(withId(R.id.saveButton)).perform(click());
        Logger.getGlobal().info("Tryed to save");
        onView(withId(R.id.editTextContent)).check(matches(isDisplayed()));
    }
}