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
import androidx.test.filters.LargeTest;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.vinilosgrupo15.R;
import com.example.vinilosgrupo15.view.LoginActivity;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class TestPerformers {
    private static final int ITEM_BELOW_THE_FOLD = 0;
    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule =
            new ActivityScenarioRule<LoginActivity>(LoginActivity.class);

    @Test
    public void testNavegarListaPerformers() throws InterruptedException {
        onView(withText("Vinilos Grupo 15")).check(matches(isDisplayed()));

        /* Autenticar usuario guest */
        onView(withId(R.id.editTextTextPersonName)).perform(clearText(), typeText("Invitado"), closeSoftKeyboard());
        onView(withId(R.id.editTextTextPassword)).perform(clearText(), typeText("Invitado"), closeSoftKeyboard());
        onView(withId(R.id.rolList)).perform(click());
        onData(hasToString(startsWith("Guest"))).perform(click());
        onView(withId(R.id.rolList)).check(matches(withSpinnerText(containsString("Guest"))));
        onView(withId(R.id.login)).perform(click());

        /* ir a interprete */
        onView(withId(R.id.buttonPerformers)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonPerformers)).perform(click());
        Thread.sleep(2000);

        /* Valida que exista RecyleView interprete */
        onView(withId(R.id.recyclerview)).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.img_character), isDisplayed()));

        /* Volver al home */
        onView(withId(R.id.homeBtn)).check(matches(isDisplayed()));
        onView(withId(R.id.homeBtn)).perform(click());
        Thread.sleep(2000);

    }

    @Test
    public void testNavegarPerformersInformacion() throws InterruptedException {
        onView(withText("Vinilos Grupo 15")).check(matches(isDisplayed()));

        /* Autenticar usuario guest */
        onView(withId(R.id.editTextTextPersonName)).perform(clearText(), typeText("Invitado"), closeSoftKeyboard());
        onView(withId(R.id.editTextTextPassword)).perform(clearText(), typeText("Invitado"), closeSoftKeyboard());
        onView(withId(R.id.rolList)).perform(click());
        onData(hasToString(startsWith("Guest"))).perform(click());
        onView(withId(R.id.rolList)).check(matches(withSpinnerText(containsString("Guest"))));
        onView(withId(R.id.login)).perform(click());

        /* ir a interprete */
        onView(withId(R.id.buttonPerformers)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonPerformers)).perform(click());
        Thread.sleep(2000);

        /* Valida que exista RecyleView interprete */
        onView(withId(R.id.recyclerview)).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.img_character), isDisplayed()));

        Thread.sleep(1000);

        /* Ver informacion interprete */
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

    @Test
    public void testNavegarListaBands() throws InterruptedException {
        onView(withText("Vinilos Grupo 15")).check(matches(isDisplayed()));

        /* Autenticar usuario guest */
        onView(withId(R.id.editTextTextPersonName)).perform(clearText(), typeText("Invitado"), closeSoftKeyboard());
        onView(withId(R.id.editTextTextPassword)).perform(clearText(), typeText("Invitado"), closeSoftKeyboard());
        onView(withId(R.id.rolList)).perform(click());
        onData(hasToString(startsWith("Guest"))).perform(click());
        onView(withId(R.id.rolList)).check(matches(withSpinnerText(containsString("Guest"))));
        onView(withId(R.id.login)).perform(click());

        /* ir a interprete */
        onView(withId(R.id.buttonPerformers)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonPerformers)).perform(click());

        /* Pasar a bandas */
        Thread.sleep(1000);
        onView(withId(R.id.btnBand)).check(matches(isDisplayed()));
        onView(withId(R.id.btnBand)).perform(forceClick());


        /* Valida que exista RecyleView interprete */
        Thread.sleep(1000);
        onView(withId(R.id.recyclerview)).check(matches(isDisplayed()));

        Thread.sleep(1000);

        /* Ver informacion banda */
        onView(ViewMatchers.withId(R.id.recyclerview))
                .perform(
                        RecyclerViewActions.actionOnItemAtPosition(
                                ITEM_BELOW_THE_FOLD,
                                click()
                        )
                );

        Thread.sleep(1000);
        pressBack();
        Thread.sleep(1000);

        /* Volver al home */
        onView(withId(R.id.homeBtn)).check(matches(isDisplayed()));
        onView(withId(R.id.homeBtn)).perform(click());
        Thread.sleep(2000);

    }

    @Test
    public void testNavegarBandsInformacion() throws InterruptedException {
        onView(withText("Vinilos Grupo 15")).check(matches(isDisplayed()));

        /* Autenticar usuario guest */
        onView(withId(R.id.editTextTextPersonName)).perform(clearText(), typeText("Invitado"), closeSoftKeyboard());
        onView(withId(R.id.editTextTextPassword)).perform(clearText(), typeText("Invitado"), closeSoftKeyboard());
        onView(withId(R.id.rolList)).perform(click());
        onData(hasToString(startsWith("Guest"))).perform(click());
        onView(withId(R.id.rolList)).check(matches(withSpinnerText(containsString("Guest"))));
        onView(withId(R.id.login)).perform(click());

        /* ir a interprete */
        onView(withId(R.id.buttonPerformers)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonPerformers)).perform(click());

        /* Pasar a bandas */
        Thread.sleep(1000);
        onView(withId(R.id.btnBand)).check(matches(isDisplayed()));
        onView(withId(R.id.btnBand)).perform(forceClick());


        /* Valida que exista RecyleView interprete */
        Thread.sleep(1000);
        onView(withId(R.id.recyclerview)).check(matches(isDisplayed()));



        /* Volver al home */
        onView(withId(R.id.homeBtn)).check(matches(isDisplayed()));
        onView(withId(R.id.homeBtn)).perform(forceClick());
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
