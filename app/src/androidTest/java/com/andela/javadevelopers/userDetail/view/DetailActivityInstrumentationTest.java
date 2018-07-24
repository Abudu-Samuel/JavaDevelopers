package com.andela.javadevelopers.userDetail.view;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.andela.javadevelopers.R;
import com.andela.javadevelopers.home.model.GithubUsers;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.*;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasType;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.core.AllOf.allOf;

/**
 * The type Detail activity instrumentation test.
 */
@RunWith(AndroidJUnit4.class)
public class DetailActivityInstrumentationTest {
    /**
     * Links.
     */
    private static final String GITHUB_URL = "https://github.com/moyheen",
            IMAGE_URL = "https://bit.ly/2LLs86w",
            USERNAME = "moyheen";


    /**
     * The Rule.
     */
    @Rule
    public IntentsTestRule<DetailActivity> rule =
            new IntentsTestRule<>(DetailActivity.class, true, false);

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        Intent intent = new Intent(getTargetContext(), DetailActivity.class);
        GithubUsers githubUsers = new GithubUsers(IMAGE_URL, GITHUB_URL, USERNAME);
        intent.putExtra("githuber", githubUsers);

        rule.launchActivity(intent);
    }

    /**
     * Ensure intent is launched.
     */
    @Test
    public void ensureIntentIsLaunched() {
        SystemClock.sleep(4000);
        onView(withId(R.id.userName))
                .check(matches(isDisplayed()));

        onView(withId(R.id.imageView))
                .check(matches(isDisplayed()));

        onView(withId(R.id.githubLink))
                .check(matches(isDisplayed()));
    }

    /**
     * Ensure github link works correctly.
     *
     * @throws Exception the exception
     */
    @Test
    public void ensureGithubLinkWorksCorrectly() throws Exception {
        Matcher<Intent> expectedIntent = allOf(hasAction(Intent.ACTION_VIEW), hasData(GITHUB_URL));
        intending(expectedIntent).respondWith(new Instrumentation.ActivityResult(0, null));
        onView(withId(R.id.githubLink)).perform(click());

        intended(expectedIntent);
    }

    /**
     * Ensure share link works correctly.
     *
     * @throws Exception the exception
     */
    @Test
    public void ensureShareLinkWorksCorrectly() throws Exception {
        try {
            openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        } catch (Exception e) {
            Log.e("TAG", e.getMessage());
        }

        onView(anyOf(withText(R.string.share_message), withId(R.id.share))).perform(click());

        intended(allOf(
                hasAction(Intent.ACTION_SEND),
                hasType("text/plain")));
    }
}
