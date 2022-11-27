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

import com.example.vinilosgrupo15.R;
import com.example.vinilosgrupo15.view.LoginActivity;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

public class TestAlbums {
    private static final int ITEM_BELOW_THE_FOLD = 0;
    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule =
            new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void testNavegarListaAlbums() throws InterruptedException {
        onView(withText("Vynils Group 15")).check(matches(isDisplayed()));

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
        onView(withId(R.id.homeBtn)).perform(forceClick());
        Thread.sleep(1000);

    }

    @Test
    public void testNavegarAlbumsInformacion() throws InterruptedException {
        onView(withText("Vynils Group 15")).check(matches(isDisplayed()));

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

        /* Ingresar al primer elemento del recyclerview */
        Thread.sleep(1000);

        onView(ViewMatchers.withId(R.id.recyclerview))
                .perform(
                        RecyclerViewActions.actionOnItemAtPosition(
                                ITEM_BELOW_THE_FOLD,
                                click()
                        )
                );

        /* Ingresar a tracks */
        Thread.sleep(1000);
        onView(withId(R.id.btnTracks)).check(matches(isDisplayed()));
        onView(withId(R.id.btnTracks)).perform(forceClick());

        Thread.sleep(1000);
        //pressBack();

        /* Ingresar a Comments */
        Thread.sleep(1000);
        onView(withId(R.id.btnComments)).check(matches(isDisplayed()));
        onView(withId(R.id.btnComments)).perform(forceClick());

        Thread.sleep(1000);
        //pressBack();

        /* Ingresar a Comments */
        Thread.sleep(1000);
        onView(withId(R.id.btnPerformers)).check(matches(isDisplayed()));
        onView(withId(R.id.btnPerformers)).perform(forceClick());

        Thread.sleep(1000);
        //pressBack();
        Thread.sleep(1000);

        /* Regresar  */
        pressBack();


        /* Volver al home */
        onView(withId(R.id.homeBtn)).check(matches(isDisplayed()));
        onView(withId(R.id.homeBtn)).perform(click());
        Thread.sleep(1000);

    }

    @Test
    public void testAlbumsCreacion () throws InterruptedException {
        onView(withText("Vynils Group 15")).check(matches(isDisplayed()));

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

        /* Clic boton crear album  */
        Thread.sleep(1000);

        onView(withId(R.id.btnCreate)).check(matches(isDisplayed()));
        onView(withId(R.id.btnCreate)).perform(forceClick());


        /* Ingresar al formulario de creacion */
        Thread.sleep(5000);


        /* LLenar campos formulario */
        onView(withId(R.id.editTextAlbumName)).perform(clearText(), typeText("Test creacion album nuevo"), closeSoftKeyboard());
        onView(withId(R.id.editTextAlbumCover)).perform(clearText(), typeText("https://upload.wikimedia.org/wikipedia/en/6/6a/Amoonshapedpool.png"), closeSoftKeyboard());
        onView(withId(R.id.editTextAlbumReleaseDate)).perform(clearText(), typeText("2022-11-26"), closeSoftKeyboard());

        onView(withId(R.id.genreList)).perform(click());
        onData(hasToString(startsWith("Rock"))).perform(click());
        onView(withId(R.id.genreList)).check(matches(withSpinnerText(containsString("Rock"))));

        onView(withId(R.id.recordList)).perform(click());
        onData(hasToString(startsWith("EMI"))).perform(click());
        onView(withId(R.id.recordList)).check(matches(withSpinnerText(containsString("EMI"))));

        onView(withId(R.id.editTextAlbumDescription)).perform(clearText(), typeText("Test descripcion del album nuevo a crear"), closeSoftKeyboard());

        Thread.sleep(1000);

        onView(withId(R.id.saveAlbum)).check(matches(isDisplayed()));
        onView(withId(R.id.saveAlbum)).perform(forceClick());

        Thread.sleep(2000);
        //pressBack();

        /* Volver al home */
        onView(withId(R.id.homeBtn)).check(matches(isDisplayed()));
        onView(withId(R.id.homeBtn)).perform(click());
        Thread.sleep(1000);

    }

    @Test
    public void testAlbumsComentarioCreacion () throws InterruptedException {
        onView(withText("Vynils Group 15")).check(matches(isDisplayed()));

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

        /* Ingresar al primer elemento del recyclerview */
        Thread.sleep(1000);

        onView(ViewMatchers.withId(R.id.recyclerview))
                .perform(
                        RecyclerViewActions.actionOnItemAtPosition(
                                ITEM_BELOW_THE_FOLD,
                                click()
                        )
                );

        /* Ingresar al formulario de creacion */
        Thread.sleep(1000);

        onView(withId(R.id.etComment)).perform(clearText(), typeText("Texto comentario"), closeSoftKeyboard());

        Thread.sleep(5000);

        onView(withId(R.id.btnAddComments)).check(matches(isDisplayed()));
        onView(withId(R.id.btnAddComments)).perform(forceClick());

        Thread.sleep(1000);
        //pressBack();

        /* Volver al home */
        onView(withId(R.id.homeBtn)).check(matches(isDisplayed()));
        onView(withId(R.id.homeBtn)).perform(click());
        Thread.sleep(1000);

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
