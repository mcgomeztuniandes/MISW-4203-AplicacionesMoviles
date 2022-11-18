package e2e

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.vinilosgrupo15.R
import com.example.vinilosgrupo15.view.LoginActivity
import org.hamcrest.CoreMatchers
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class TestCollectors {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun testNavegarListaColeccionistas() {

        /* Autenticar usuario guest */
        Espresso.onView(withId(R.id.editTextTextPersonName)).perform(
            clearText(), typeText("Invitado"), closeSoftKeyboard()
        )
        Espresso.onView(withId(R.id.editTextTextPassword))
            .perform(clearText(), typeText("Invitado"), closeSoftKeyboard())
        Espresso.onView(withId(R.id.rolList)).perform(click())
        Espresso.onData(Matchers.hasToString(CoreMatchers.startsWith("Guest"))).perform(
            click()
        )
        Espresso.onView(withId(R.id.rolList))
            .check(matches(withSpinnerText(CoreMatchers.containsString("Guest"))))
        Espresso.onView(withId(R.id.login)).perform(click())
        Thread.sleep(1000)

        /* Ir a la lista de Coleccionistas */
        Espresso.onView(withId(R.id.buttonCollectors)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.buttonCollectors)).perform(click())
        Thread.sleep(1000)


        /* Valida que exista RecyleView collector */
        Espresso.onView(withId(R.id.recyclerview))
            .check(
                matches(isDisplayed())
            )

        /* Volver al home */
        Espresso.onView(withId(R.id.homeBtn)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.homeBtn)).perform(click())
        Thread.sleep(1000)

    }
}
