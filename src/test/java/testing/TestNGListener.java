package testing;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener
{
	@Override
	public void onStart(ITestContext result)
	{
		System.out.println("The test is started"+result.getName());
	}
	
	@Override
	public void onFinish(ITestContext result)
	{
		System.out.println("The test is finished"+result.getName());
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		System.out.println("The test has been failed"+result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("The test has been passed"+result.getName());
	}

}
