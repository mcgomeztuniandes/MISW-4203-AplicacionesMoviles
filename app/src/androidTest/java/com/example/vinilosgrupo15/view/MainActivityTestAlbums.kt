package com.example.vinilosgrupo15.view


import androidx.test.espresso.DataInteraction
import androidx.test.espresso.ViewInteraction
import androidx.test.filters.LargeTest
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent

import androidx.test.InstrumentationRegistry.getInstrumentation
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*

import com.example.vinilosgrupo15.R

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.hamcrest.Matchers.`is`

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTestAlbums {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivityTestAlbums() {
        val appCompatEditText = onView(
allOf(withId(R.id.editTextTextPersonName),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()))
        appCompatEditText.perform(click())
        
        val appCompatEditText2 = onView(
allOf(withId(R.id.editTextTextPersonName),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()))
        appCompatEditText2.perform(replaceText("afasdfasdfasdf"), closeSoftKeyboard())
        
        val appCompatEditText3 = onView(
allOf(withId(R.id.editTextTextPassword),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()))
        appCompatEditText3.perform(replaceText("asdfasdf"), closeSoftKeyboard())
        
        val appCompatEditText4 = onView(
allOf(withId(R.id.editTextTextPassword), withText("asdfasdf"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()))
        appCompatEditText4.perform(click())
        
        pressBack()
        
         // Added a sleep statement to match the app's execution delay.
 // The recommended way to handle such scenarios is to use Espresso idling resources:
  // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
Thread.sleep(300)
        
        val appCompatSpinner = onView(
allOf(withId(R.id.rolList),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
4),
isDisplayed()))
        appCompatSpinner.perform(click())
        
         // Added a sleep statement to match the app's execution delay.
 // The recommended way to handle such scenarios is to use Espresso idling resources:
  // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
Thread.sleep(250)
        
        val appCompatCheckedTextView = onData(anything())
.inAdapterView(withClassName(`is`("androidx.appcompat.widget.DropDownListView")))
.atPosition(1)
        appCompatCheckedTextView.perform(click())
        
        val materialButton = onView(
allOf(withId(R.id.login), withText("Continue"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()))
        materialButton.perform(click())
        
         // Added a sleep statement to match the app's execution delay.
 // The recommended way to handle such scenarios is to use Espresso idling resources:
  // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
Thread.sleep(700)
        
        val materialTextView = onView(
allOf(withId(R.id.buttonAlbums), withText("Albums"),
childAtPosition(
childAtPosition(
withId(R.id.container),
0),
3),
isDisplayed()))
        materialTextView.perform(click())
        }
    
    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
    }
