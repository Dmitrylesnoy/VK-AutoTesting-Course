package vk.autotest.project.UITest;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.pm.ActivityInfo;

import vk.autotest.project.MainActivity;
import vk.autotest.project.R;

public class MainActivityUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    // Test 1: Verify RecyclerView and FAB are displayed
    @Test
    public void testComponentsDisplayed() {
        onView(withId(R.id.notesRecyclerView)).check(matches(isDisplayed()));
        onView(withId(R.id.addNoteFab)).check(matches(isDisplayed()));
    }

    // Test 2: Verify clicking FAB opens AddNoteDialog
//    @Test
//    public void testFabOpensDialog() {
//        onView(withId(R.id.addNoteFab)).perform(click());
//        onView(withId(R.id.editTextTitle)).check(matches(isDisplayed()));
//        onView(withId(R.id.editTextContent)).check(matches(isDisplayed()));
//        onView(withId(R.id.saveButton)).check(matches(isDisplayed()));
//    }
//
//
//    // Test 3: Verify RecyclerView is empty initially
//    @Test
//    public void testRecyclerViewEmptyInitially() {
//        onView(withId(R.id.notesRecyclerView)).check((view, noViewFoundException) -> {
//            if (noViewFoundException != null) throw noViewFoundException;
//            assert ((RecyclerView) view).getAdapter().getItemCount() == 0;
//        });
//    }
//
//    @Test
//    public void testOrientationChange() {
//        String title = "Orientation Note";
//        String content = "Orientation Note content";
//
//        // Add a note
//        onView(withId(R.id.addNoteFab)).perform(click());
//        onView(withId(R.id.editTextTitle)).perform(typeText(title));
//        onView(withId(R.id.editTextContent)).perform(typeText(content));
//        onView(withId(R.id.saveButton)).perform(click());
//        // Rotate screen
//        activityRule.getScenario().onActivity(activity ->
//                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE));
//        // Verify note persists
////        onView(withId(R.id.notesRecyclerView)).perform(RecyclerViewActions.scrollTo(withText(title)));
//        onView(withText(title)).check(matches(isDisplayed()));
//    }
}
