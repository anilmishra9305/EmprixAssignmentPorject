package com.Emprix.listener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
 
public class TestNGListener implements ITestListener{
 
	public void onTestStart(ITestResult result) {
		Reporter.log(result.getMethod().getMethodName() + " started");
		Reporter.log(result.getMethod().getDescription());
	}
 
	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getMethod().getMethodName() + " Passed");
	}
 
	public void onTestFailure(ITestResult result) {
		Reporter.log("Failed because of " + result.getThrowable());		
	}
 
	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test Skipped because of "+ result.getThrowable());		
	}
 
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
 
	public void onStart(ITestContext context) {
		Reporter.log("======= onStart :- " +context.getName() + " =======");
	}
 
	public void onFinish(ITestContext context) {
		Reporter.log("======= onFinish :- " + context.getName() + " =======");
	}
}