package vk.autotest.project.UITest.frontTest;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.pm.ActivityInfo;

import java.util.logging.Logger;

import vk.autotest.project.MainActivity;
import vk.autotest.project.R;

public class MainActivityUITest {

    @Rule   // Rule to start application activity for Test
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test   //  checking that main feed UI components are existing and displayed
    public void testComponentsDisplayed() {
        onView(withId(R.id.notesRecyclerView)).check(matches(isDisplayed()));
        Logger.getGlobal().info("RecycleView is displayed");
        onView(withId(R.id.addNoteFab)).check(matches(isDisplayed()));
        Logger.getGlobal().info("AddNote button is displayed");
    }

    @Test   // checking that add note dialog has all displayed elements
    public void testFabOpensDialog() {
        onView(withId(R.id.addNoteFab)).perform(click());
        Logger.getGlobal().info("Add note button is displayed");
        onView(withId(R.id.editTextTitle)).check(matches(isDisplayed()));
        Logger.getGlobal().info("Note title field in adding dialog is displayed");
        onView(withId(R.id.editTextContent)).check(matches(isDisplayed()));
        Logger.getGlobal().info("Note content field in adding dialog is displayed");
        onView(withId(R.id.saveButton)).check(matches(isDisplayed()));
        Logger.getGlobal().info("Saving button in adding dialog is displayed");
    }

    @Test   // checking that element for showing notes is empty from start
    public void testRecyclerViewEmptyInitially() {
        onView(withId(R.id.notesRecyclerView)).check((view, noViewFoundException) -> {
            if (noViewFoundException != null) throw noViewFoundException;
            assert ((RecyclerView) view).getAdapter().getItemCount() == 0;
        });
    }

    @Test   //  Testing that notes displayed shown even when turning
    public void testOrientationChange() {
        String title = "Orientation Note";
        String content = "Orientation Note content";

        onView(withId(R.id.addNoteFab)).perform(click());
        onView(withId(R.id.editTextTitle)).perform(typeText(title));
        onView(withId(R.id.editTextContent)).perform(typeText(content));
        onView(withId(R.id.saveButton)).perform(click());
        Logger.getGlobal().info("Test note added");
        activityRule.getScenario().onActivity(activity ->
                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE));
        Logger.getGlobal().info("Screen orientation changed");
        onView(withText(title)).check(matches(isDisplayed()));
    }
}
