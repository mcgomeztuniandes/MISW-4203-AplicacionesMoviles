package e2e;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasToString;

import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.vinilosgrupo15.R;
import com.example.vinilosgrupo15.view.LoginActivity;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class TestCollectors {
    private static final int ITEM_BELOW_THE_FOLD = 0;
    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule =
            new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void testNavegarListaColeccionistas() throws InterruptedException {
        onView(withText("Vinilos Grupo 15")).check(matches(isDisplayed()));

        /* Autenticar usuario collector */
        onView(withId(R.id.editTextTextPersonName)).perform(clearText(), typeText("Collector"), closeSoftKeyboard());
        onView(withId(R.id.editTextTextPassword)).perform(clearText(), typeText("Collector"), closeSoftKeyboard());
        onView(withId(R.id.rolList)).perform(click());
        onData(hasToString(startsWith("Guest"))).perform(click());
        onView(withId(R.id.rolList)).check(matches(withSpinnerText(containsString("Guest"))));
        onView(withId(R.id.login)).perform(click());

        /* ir a Collectors */
        onView(withId(R.id.buttonCollectors)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonCollectors)).perform(click());
        Thread.sleep(2000);

        /* Valida que exista RecyleView collector */
        onView(withId(R.id.recyclerview)).check(matches(isDisplayed()));
        Thread.sleep(2000);

        /* Volver al home */
        onView(withId(R.id.homeBtn)).check(matches(isDisplayed()));
        onView(withId(R.id.homeBtn)).perform(click());
        Thread.sleep(2000);

    }

    @Test
    public void testNavegarDetalleColeccionistas() throws InterruptedException {
        onView(withText("Vinilos Grupo 15")).check(matches(isDisplayed()));

        /* Autenticar usuario guest */
        onView(withId(R.id.editTextTextPersonName)).perform(clearText(), typeText("Invitado"), closeSoftKeyboard());
        onView(withId(R.id.editTextTextPassword)).perform(clearText(), typeText("Invitado"), closeSoftKeyboard());
        onView(withId(R.id.rolList)).perform(click());
        onData(hasToString(startsWith("Guest"))).perform(click());
        onView(withId(R.id.rolList)).check(matches(withSpinnerText(containsString("Guest"))));
        onView(withId(R.id.login)).perform(click());

        /* ir a collector */
        onView(withId(R.id.buttonCollectors)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonCollectors)).perform(click());
        Thread.sleep(2000);

        /* Valida que exista RecyleView collector */
        onView(withId(R.id.recyclerview)).check(matches(isDisplayed()));


        Thread.sleep(1000);

        /* Ver informacion collector */
        onView(ViewMatchers.withId(R.id.recyclerview))
                .perform(
                        RecyclerViewActions.actionOnItemAtPosition(
                                ITEM_BELOW_THE_FOLD,
                                click()
                        )
                );

        Thread.sleep(1000);
        pressBack();

        /* Volver al home */
        onView(withId(R.id.homeBtn)).check(matches(isDisplayed()));
        onView(withId(R.id.homeBtn)).perform(click());
        Thread.sleep(2000);

    }




    public static ViewAction forceClick() {
        return new ViewAction() {
            @Override public Matcher<View> getConstraints() {
                return allOf(isClickable(), isEnabled(), isDisplayed());
            }

            @Override public String getDescription() {
                return "force click";
            }

            @Override public void perform(UiController uiController, View view) {
                view.performClick();
                uiController.loopMainThreadUntilIdle();
            }
        };
    }






}