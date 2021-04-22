package com.cjc.mt.tests;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Isuite_Itest_Listeners implements ISuiteListener, ITestListener
{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("ON-Test start ITestSUITE");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("ON-Test Success ITestSUITE");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("ON-Test Failure ITestSUITE");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("ON-Test skipped ITestSUITE");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("ON-start ITestSUITE");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("ON-Finish ITestSUITE");
	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("ON-START ISUITE");
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("ON-Finish ISUITE");
	}



}
