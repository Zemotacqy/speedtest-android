package com.fdossena.speedtest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.assertEquals;

import android.util.Log;

import androidx.test.filters.MediumTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.After;
import com.microsoft.appcenter.espresso.Factory;
import com.microsoft.appcenter.espresso.ReportHelper;

import com.fdossena.speedtest.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@MediumTest
@RunWith(AndroidJUnit4.class)
public class bandwidthTest {

    String TAG = "bandwidthTest";
    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Rule
    public ReportHelper reportHelper = Factory.getReportHelper();

    @Before
    public void SetupPhase(){
        reportHelper.label("Starting App " + System.currentTimeMillis());
    }
    @After
    public void TearDown(){
        reportHelper.label("Stopping App " +  System.currentTimeMillis());
    }

    @Test
    public void speedTest1() throws InterruptedException {
        Log.d(TAG, "[" + System.currentTimeMillis() + "] test started");
        NativeScreenshot.capture("home-screen");
        Thread.sleep(20000);
        Log.d(TAG, "[" + System.currentTimeMillis() + "] Clicked on start");
        onView(withId(R.id.start)).perform(click());
        Thread.sleep(50000);
        NativeScreenshot.capture("speed-screen");
        assertEquals("0", "0");
    }

    @EvenMarker
    @PrimeMarker
    @Test
    public void speedTest2() throws InterruptedException {
        Log.d(TAG, "[" + System.currentTimeMillis() + "] test started");
        NativeScreenshot.capture("home-screen");
        Thread.sleep(20000);
        Log.d(TAG, "[" + System.currentTimeMillis() + "] Clicked on start");
        onView(withId(R.id.start)).perform(click());
        Thread.sleep(50000);
        NativeScreenshot.capture("speed-screen");
        assertEquals("0", "0");
    }

    @PrimeMarker
    @Test
    public void speedTest3() throws InterruptedException {
        Log.d(TAG, "[" + System.currentTimeMillis() + "] test started");
        NativeScreenshot.capture("home-screen");
        Thread.sleep(20000);
        Log.d(TAG, "[" + System.currentTimeMillis() + "] Clicked on start");
        onView(withId(R.id.start)).perform(click());
        Thread.sleep(50000);
        NativeScreenshot.capture("speed-screen");
        assertEquals("0", "0");
    }

    @CompositeMarker
    @Test
    public void speedTest9() throws InterruptedException {
        Log.d(TAG, "[" + System.currentTimeMillis() + "] test started");
        NativeScreenshot.capture("home-screen");
        Thread.sleep(20000);
        Log.d(TAG, "[" + System.currentTimeMillis() + "] Clicked on start");
        onView(withId(R.id.start)).perform(click());
        Thread.sleep(50000);
        NativeScreenshot.capture("speed-screen");
        assertEquals("0", "0");
    }
}
