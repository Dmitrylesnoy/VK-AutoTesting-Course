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

import vk.autotest.project.MainActivity;
import vk.autotest.project.R;

public class MainActivityUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testComponentsDisplayed() {
        onView(withId(R.id.notesRecyclerView)).check(matches(isDisplayed()));
        onView(withId(R.id.addNoteFab)).check(matches(isDisplayed()));
    }

    @Test
    public void testFabOpensDialog() {
        onView(withId(R.id.addNoteFab)).perform(click());
        onView(withId(R.id.editTextTitle)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextContent)).check(matches(isDisplayed()));
        onView(withId(R.id.saveButton)).check(matches(isDisplayed()));
    }

    @Test
    public void testRecyclerViewEmptyInitially() {
        onView(withId(R.id.notesRecyclerView)).check((view, noViewFoundException) -> {
            if (noViewFoundException != null) throw noViewFoundException;
            assert ((RecyclerView) view).getAdapter().getItemCount() == 0;
        });
    }

    @Test
    public void testOrientationChange() {
        String title = "Orientation Note";
        String content = "Orientation Note content";

        onView(withId(R.id.addNoteFab)).perform(click());
        onView(withId(R.id.editTextTitle)).perform(typeText(title));
        onView(withId(R.id.editTextContent)).perform(typeText(content));
        onView(withId(R.id.saveButton)).perform(click());
        activityRule.getScenario().onActivity(activity ->
                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE));
        onView(withText(title)).check(matches(isDisplayed()));
    }
}
