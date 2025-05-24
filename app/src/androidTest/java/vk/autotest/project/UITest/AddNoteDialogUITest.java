package vk.autotest.project.UITest;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.idling.CountingIdlingResource;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.After;
import org.junit.Before;
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
import static org.hamcrest.Matchers.not;

import vk.autotest.project.MainActivity;
import vk.autotest.project.R;

public class AddNoteDialogUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);
    private final CountingIdlingResource idlingResource = new CountingIdlingResource("DialogIdling");

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(idlingResource);
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(idlingResource);


        // Test 1: Verify adding a note with valid input
    @Test
    public void testAddNoteWithValidInput() {
        String title = "Test Note";
        String content = "This is a test note content";

        // Open dialog
        onView(withId(R.id.addNoteFab)).perform(click());
        // Enter title and content
        onView(withId(R.id.editTextTitle)).perform(typeText(title));
        onView(withId(R.id.editTextContent)).perform(typeText(content));
        // Click save
        onView(withId(R.id.saveButton)).perform(click());
        // Verify dialog is dismissed
        onView(withId(R.id.addNoteDialog)).check(doesNotExist());
        // Verify note appears in RecyclerView
        onView(withText(title)).check(matches(isDisplayed()));
    }

    // Test 2: Verify adding a note with empty title does not save
    @Test
    public void testAddNoteWithEmptyTitle() {
        String content = "This is a test note content";

        // Open dialog
        onView(withId(R.id.addNoteFab)).perform(click());
        // Enter content but leave title empty
        onView(withId(R.id.editTextContent)).perform(typeText(content));
        // Click save
        onView(withId(R.id.saveButton)).perform(click());
        // Verify dialog is not dismissed
        onView(withId(R.id.editTextContent)).check(matches(isDisplayed()));
    }
}