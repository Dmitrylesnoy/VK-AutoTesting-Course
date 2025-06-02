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

import vk.autotest.project.MainActivity;
import vk.autotest.project.R;

public class NotesRecyclerViewUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testAddMultipleNotes() {
        String[] titles = {"Note 1", "Note 2", "Note 3"};
        String content = "Sample content";

        for (String title : titles) {
            addNote(title, content);
        }

        for (String title : titles) {
            onView(withText(title)).check(matches(isDisplayed()));
        }
    }

    @Test
    public void testAddAndDelete() {
        String title = "End-to-End Test Note";
        String content = "This is a test note for end-to-end";

        addNote(title, content);
        onView(withText(title)).check(matches(isDisplayed()));
        onView(withText(title)).perform(longClick());
        onView(withText(title)).check(doesNotExist());

    }

    private void addNote(String title, String content) {
        onView(withId(R.id.addNoteFab)).perform(click());
        onView(withId(R.id.editTextTitle)).perform(typeText(title));
        onView(withId(R.id.editTextContent)).perform(typeText(content));
        onView(withId(R.id.saveButton)).perform(click());
    }
}