package com.Emprix.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.Emprix.driver.TestBase;
import com.Emprix.pages.LoginPage;
import com.Emprix.util.CommonFunction;


public class LoginPageTest extends TestBase {
	
	
	LoginPage loginPage;
	
	@Test(priority = 0)
	public void loginPageLogo()
	{
		loginPage=new LoginPage();
		boolean actual=loginPage.verifyLogo();
		Assert.assertTrue(actual);

	}

	@Test(priority = 1)
	public void loginTest()
	{
		loginPage.login(CommonFunction.readPropertyFile("username"), CommonFunction.readPropertyFile("password"));
		
	}
	
	@Test(priority = 2)
	public void verifyHomePageTitle()
	{
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "VoiceWatch");
	}
	
	
	@Test(priority = 3)
	public void dashboardPageTest()
	{
		boolean actual=loginPage.validateDashboarTab();
		Assert.assertTrue(actual);

		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
}
