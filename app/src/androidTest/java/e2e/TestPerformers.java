package e2e;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import com.example.vinilosgrupo15.R;
import com.example.vinilosgrupo15.view.MainActivity;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(AndroidJUnit4.class)
@LargeTest

public class TestPerformers {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void testNavegarListaPerformers(){
        onView(withText("Vinilos Grupo 15")).check(matches(isDisplayed()));
        onView(withId(R.id.buttonPerformers)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonPerformers)).perform(click());
        onView(withId(R.id.btnBand)).check(matches(isDisplayed()));
        onView(withId(R.id.btnBand)).check(matches(withText("Bands")));
        onView(withId(R.id.btnBand)).perform(click());

        onView(withId(R.id.btnMusician)).check(matches(isDisplayed()));
        onView(withId(R.id.btnMusician)).check(matches(isDisplayed()));
        onView(withId(R.id.btnMusician)).check(matches(withText("Musicians")));



    }
}
