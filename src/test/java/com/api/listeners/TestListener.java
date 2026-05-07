package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    // Define the logger
    private static final Logger logger = LogManager.getLogger(TestListener.class);

    public void onTestStart(ITestResult result) {
        logger.info("TEST STARTED: " + result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("TEST PASSED: " + result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        logger.error("TEST FAILED: " + result.getMethod().getMethodName());
    }

    public void onTestSkipped(ITestResult result) {
        logger.warn("TEST SKIPPED: " + result.getMethod().getMethodName());
    }
}
