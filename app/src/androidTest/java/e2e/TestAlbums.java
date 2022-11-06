package e2e;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.ViewAction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.vinilosgrupo15.R;
import com.example.vinilosgrupo15.view.MainActivity;

import org.hamcrest.CustomMatcher;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

public class TestAlbums {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void testNavegarListaAlbums(){
        onView(withText("Vinilos Grupo 15")).check(matches(isDisplayed()));
        onView(withId(R.id.buttonAlbums)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonAlbums)).perform(click());





    }




}
