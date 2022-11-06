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
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasToString;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.ViewAction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.vinilosgrupo15.R;
import com.example.vinilosgrupo15.view.LoginActivity;
import com.example.vinilosgrupo15.view.MainActivity;

import org.hamcrest.CustomMatcher;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

public class TestAlbums {
    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule =
            new ActivityScenarioRule<LoginActivity>(LoginActivity.class);

    @Test
    public void testNavegarListaAlbums() throws InterruptedException {
        onView(withText("Vinilos Grupo 15")).check(matches(isDisplayed()));

        /* Autenticar usuario guest */
        onView(withId(R.id.editTextTextPersonName)).perform(clearText(), typeText("Invitado"), closeSoftKeyboard());
        onView(withId(R.id.editTextTextPassword)).perform(clearText(), typeText("Invitado"), closeSoftKeyboard());
        onView(withId(R.id.rolList)).perform(click());
        onData(hasToString(startsWith("Guest"))).perform(click());
        onView(withId(R.id.rolList)).check(matches(withSpinnerText(containsString("Guest"))));
        onView(withId(R.id.login)).perform(click());

        /* Ir a Albums */
        onView(withId(R.id.buttonAlbums)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonAlbums)).perform(click());

        Thread.sleep(1000);
        /*  Valida imagenes en Recyclerview */
        onView(allOf(withId(R.id.img_album), isDisplayed()));

        /* Volver al home */
        onView(withId(R.id.homeBtn)).check(matches(isDisplayed()));
        onView(withId(R.id.homeBtn)).perform(click());
        Thread.sleep(1000);





    }




}
