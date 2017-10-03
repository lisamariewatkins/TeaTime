package com.example.android.teatime;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by lisa.watkins on 10/3/2017.
 */

@RunWith(AndroidJUnit4.class)
public class MenuActivityScreenTest {
    public static final String TEA_NAME = "Green Tea";

    @Rule public ActivityTestRule<MenuActivity> mActivityTestRule =
            new ActivityTestRule<MenuActivity>(MenuActivity.class);

    @Test
    public void clickGridItem_StartsOrderActivity(){
        onData(anything()).inAdapterView(withId(R.id.tea_name_text_view))
                .atPosition(1).perform(click());

        onView(withId(R.id.tea_name_text_view)).check(matches(withText(TEA_NAME)));
    }
}
