package e2e;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.hasToString;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.vinilosgrupo15.R;
import com.example.vinilosgrupo15.view.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class TestLoginApp {
    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule =
            new ActivityScenarioRule<LoginActivity>(LoginActivity.class);


    @Test
    public void testLoginAppGuest() throws InterruptedException {
        onView(withText("Vynils App")).check(matches(isDisplayed()));

        onView(withId(R.id.editTextTextPersonName)).perform(clearText(), typeText("Invitado"), closeSoftKeyboard());
        onView(withId(R.id.editTextTextPassword)).perform(clearText(), typeText("Invitado"), closeSoftKeyboard());

        onView(withId(R.id.rolList)).perform(click());
        onData(hasToString(startsWith("Guest"))).perform(click());
        onView(withId(R.id.rolList)).check(matches(withSpinnerText(containsString("Guest"))));

        onView(withId(R.id.login)).perform(click());

        onView(withText(R.string.app_name)).check(matches(isDisplayed()));
        Thread.sleep(2000);

    }

    @Test
    public void testLoginAppCollector() throws InterruptedException {
        onView(withText("Vynils App")).check(matches(isDisplayed()));

        onView(withId(R.id.editTextTextPersonName)).perform(clearText(), typeText("Coleccionista"), closeSoftKeyboard());
        onView(withId(R.id.editTextTextPassword)).perform(clearText(), typeText("Coleccionista"), closeSoftKeyboard());

        onView(withId(R.id.rolList)).perform(click());
        onData(hasToString(startsWith("Collector"))).perform(click());
        onView(withId(R.id.rolList)).check(matches(withSpinnerText(containsString("Collector"))));

        onView(withId(R.id.login)).perform(click());

        onView(withText(R.string.app_name)).check(matches(isDisplayed()));
        Thread.sleep(2000);

    }

    @Test
    public void testLoginAppSinDatosUsuario() throws InterruptedException {
        onView(withText("Vynils App")).check(matches(isDisplayed()));

        onView(withId(R.id.login)).perform(click());
        Thread.sleep(2000);

    }



}
