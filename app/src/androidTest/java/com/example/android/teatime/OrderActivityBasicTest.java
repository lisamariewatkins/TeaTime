package com.example.android.teatime;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by lisa.watkins on 10/3/2017.
 */
@RunWith(AndroidJUnit4.class)
public class OrderActivityBasicTest {
    // this means the activity will be launched before each test
    // allows you to directly access activity during test
    @Rule public ActivityTestRule<OrderActivity> mActivityTestRule =
            new ActivityTestRule<OrderActivity>(OrderActivity.class);

    @Test
    public void clickIncrementButton_ChangesQuantityAndCost(){
        // find view
        // perform action
        onView((withId(R.id.increment_button))).perform(click());

        onView(withId(R.id.quantity_text_view)).check(matches(withText("1")));
        onView(withId(R.id.cost_text_view)).check(matches(withText("$5.00")));
    }

    @Test
    public void clickDecrementButton_ChangesQuantityAndCost(){
        // find view
        // perform action
        onView((withId(R.id.decrement_button))).perform(click());

        onView(withId(R.id.quantity_text_view)).check(matches(withText("0")));
        onView(withId(R.id.cost_text_view)).check(matches(withText("$0.00")));
    }
}
