package com.cjc.dws.test;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ISuite_ITestListeners implements ISuiteListener, ITestListener {

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("On Start Suite");
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("On Finish Suite");
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("On Test Start");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("On Test Success");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("On Test Failure");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("On Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	System.out.println("On Start");	
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("On Finish");
	}

	
}
