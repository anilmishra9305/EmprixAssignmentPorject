package com.Emprix.testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.Emprix.driver.TestBase;
import com.Emprix.pages.ClientPage;
import com.Emprix.pages.LoginPage;
import com.Emprix.pages.ProfilePage;
import com.Emprix.util.CommonFunction;


public class ClientPageTest extends TestBase {
	
	
    ClientPage clientPage;
    ProfilePage profilePage;
    LoginPage loginPage;
	
    @Test(priority = 0)
	public void loginThirdTest()
	{
    	clientPage=new ClientPage();
    	loginPage=new LoginPage();
    	loginPage.login(CommonFunction.readPropertyFile("username"), CommonFunction.readPropertyFile("password"));
		
	}
	@Test(priority = 1)
	public void moveToClientDashboard()
	{
		
		profilePage=new ProfilePage();
		clientPage.clickOnclientLink();
		profilePage.clickOnProfiledropdown();
		
	}

	@Test(priority = 2)
	public void verifyclientDetailsdPage()
	{
		List<Object> listexpected=new ArrayList<Object>();
		listexpected.add("Empirix_QA_Training");
		listexpected.add("This client is for QA Test purposes");
		listexpected.add("Jan 14, 2020");
		listexpected.add("Aug 11, 2022");
		listexpected.add(0);
		listexpected.add(0);
		listexpected.add(0);
		listexpected.add(0);
		listexpected.add(0);
		listexpected.add(15);
		List<Object> listactual=clientPage.verifyClientDetails();
		boolean actual=listactual.equals(listexpected);
		Assert.assertEquals(actual, true);

		
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
}
