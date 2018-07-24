package com.andela.javadevelopers.util;

import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.idling.CountingIdlingResource;

/**
 * Created by andeladeveloper on 20/07/2018.
 */
public final class EspressoIdlingResource {
    /**
     * RESOURCE.
     */
    private static final String RESOURCE = "GLOBAL";
    /**
     * CountingIdlingResource.
     */
    private static CountingIdlingResource mCountingIdlingResource =
            new CountingIdlingResource(RESOURCE);

    /**
     * private constructor.
     * prevents instantiation
     */
    private EspressoIdlingResource() {
        // cannot be instantiated
    }

    /**
     * Increment counter.
     */
    public static void increment() {
        mCountingIdlingResource.increment();
    }

    /**
     * Decrement counter.
     */
    public static void decrement() {
        mCountingIdlingResource.decrement();
    }

    /**
     * Get instance of IdlingResource.
     *
     * @return - instance of the IdlingResource
     */
    public static IdlingResource getIdlingResource() {
        return mCountingIdlingResource;
    }
}

