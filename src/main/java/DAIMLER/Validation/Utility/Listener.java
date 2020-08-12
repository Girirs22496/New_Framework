package DAIMLER.Validation.Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {

	}

	@Override
	public void onStart(ITestContext arg0) {
		System.err.println(arg0.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	@Override
	public void onTestFailure(ITestResult arg0) {

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.err.println(arg0.getClass().getName());

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {

	}

}
