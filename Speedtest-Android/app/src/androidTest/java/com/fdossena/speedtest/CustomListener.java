package com.fdossena.speedtest;

import android.util.Log;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CustomListener extends RunListener {
    String TAG = "CustomListenerLogs";
    @Override
    public void testFailure(Failure failure) throws Exception {
        super.testFailure(failure);
        Log.d(TAG, "["  + System.currentTimeMillis() + "] Execution of test failed : "+ failure.getMessage());
        Log.d(TAG, "date +%c: " + getBashTime("date +%c") + " date -u: " + getBashTime("date -u") + "  date +%s: " + getBashTime("date +%s"));
    }
    @Override
    public void testAssumptionFailure(Failure failure) {
        super.testAssumptionFailure(failure);
        Log.d(TAG, "["  + System.currentTimeMillis() + "] Execution of test failed due to assumption : "+ failure.getMessage());
        Log.d(TAG, "date +%c: " + getBashTime("date +%c") + " date -u: " + getBashTime("date -u") + "  date +%s: " + getBashTime("date +%s"));
    }
    @Override
    public void testFinished(Description description) throws Exception {
        super.testFinished(description);
        Log.d(TAG, "["  + System.currentTimeMillis() + "] Execution of test finished : "+ description.toString());
        Log.d(TAG, "date +%c: " + getBashTime("date +%c") + " date -u: " + getBashTime("date -u") + "  date +%s: " + getBashTime("date +%s"));
    }
    @Override
    public void testIgnored(Description description) throws Exception {
        super.testIgnored(description);
        Log.d(TAG, "["  + System.currentTimeMillis() + "] Execution of test ignored : "+ description.toString());
        Log.d(TAG, "date +%c: " + getBashTime("date +%c") + " date -u: " + getBashTime("date -u") + "  date +%s: " + getBashTime("date +%s"));
    }
    @Override
    public void testRunFinished(Result result) throws Exception {
        super.testRunFinished(result);
        Log.d(TAG, "["  + System.currentTimeMillis() + "] Execution of test run finished : "+ result.toString());
        Log.d(TAG, "date +%c: " + getBashTime("date +%c") + " date -u: " + getBashTime("date -u") + "  date +%s: " + getBashTime("date +%s"));
    }
    @Override
    public void testRunStarted(Description description) throws Exception {
        super.testRunStarted(description);
        Log.d(TAG, "["  + System.currentTimeMillis() + "] Execution of test run started : "+ description.toString());
        Log.d(TAG, "date +%c: " + getBashTime("date +%c") + " date -u: " + getBashTime("date -u") + "  date +%s: " + getBashTime("date +%s"));
    }
    @Override
    public void testStarted(Description description) throws Exception {
        super.testStarted(description);
        Log.d(TAG, "["  + System.currentTimeMillis() + "] Execution of test started : "+ description.toString());
        Log.d(TAG, "date +%c: " + getBashTime("date +%c") + " date -u: " + getBashTime("date -u") + "  date +%s: " + getBashTime("date +%s"));
    }
    @Override
    public void testSuiteFinished(Description description) throws Exception {
        super.testSuiteFinished(description);
        Log.d(TAG, "["  + System.currentTimeMillis() + "] Execution of test suite finished : "+ description.toString());
        Log.d(TAG, "date +%c: " + getBashTime("date +%c") + " date -u: " + getBashTime("date -u") + "  date +%s: " + getBashTime("date +%s"));
    }
    @Override
    public void testSuiteStarted(Description description) throws Exception {
        super.testSuiteStarted(description);
        Log.d(TAG, "["  + System.currentTimeMillis() + "]Execution of test suite started : "+ description.toString());
        Log.d(TAG, "date +%c: " + getBashTime("date +%c") + " date -u: " + getBashTime("date -u") + "  date +%s: " + getBashTime("date +%s"));
    }

    public String getBashTime(String command) {
        String line = "";
        try {

            // Create a new process for the bash command
            Process process = Runtime.getRuntime().exec(command);

            // Get the input stream of the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();

            // Print the exit code
            System.out.println("Exit Code: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return line;
    }
}
