package com.Emprix.testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.Emprix.driver.TestBase;
import com.Emprix.pages.LoginPage;
import com.Emprix.pages.ProfilePage;
import com.Emprix.util.CommonFunction;


public class ProfilePageTest extends TestBase {
	
	
    ProfilePage profilePage;
    LoginPage loginPage;
	
    @Test(priority = 0)
	public void loginTSecondTest()
	{
    	profilePage=new ProfilePage();
    	loginPage=new LoginPage();
    	loginPage.login(CommonFunction.readPropertyFile("username"), CommonFunction.readPropertyFile("password"));

		
	}
	@Test(priority = 1)
	public void switchToJapaneseLangyage()
	{
		
		profilePage.clickOnProfiledropdown();
		profilePage.japaneseLink();
		CommonFunction.alertAccept();

	}

	@Test(priority = 2)
	public void verifyJapanseDashboardPage()
	{
		Reporter.log("Test Case verifyJapanseDashboardPage For Profile Page started!!");
		profilePage.waitForDashboardPage();
		String actual="ダッシュボード";
		String expected=profilePage.getDashboadTabText();
		boolean result=actual.equals(expected);
		Assert.assertTrue(result);
		Reporter.log("Test Case verifyJapanseDashboardPage For Profile Page started!!");
		
	}
	
	@Test(priority = 3)
	public void verifyJapanseAccesstab()
	{
		profilePage.accessTabusingLanguageVerification();
		List<String> japaneseactualTabText=profilePage.verifyTabTextForLanguageCheck();
		List<String> japaneseexpTabText=new ArrayList<String>();
		japaneseexpTabText.add("ダッシュボード");
		japaneseexpTabText.add("アラート");
		japaneseexpTabText.add("テスト");
		japaneseexpTabText.add("変数");
		japaneseexpTabText.add("通知");
		boolean textTabactual=japaneseactualTabText.equals(japaneseexpTabText);
	    Assert.assertEquals(textTabactual, true);
		List<Boolean> japaneseactualTabdisplay=profilePage.verifyTabdisplayForLanguage();
		List<Boolean> japanesexpectedTabdisplay=new ArrayList<Boolean>();
		japanesexpectedTabdisplay.add(true);
		japanesexpectedTabdisplay.add(true);
		japanesexpectedTabdisplay.add(true);
		japanesexpectedTabdisplay.add(true);
		japanesexpectedTabdisplay.add(true);
        boolean displayTabactual=japaneseactualTabdisplay.equals(japanesexpectedTabdisplay);
        Assert.assertEquals(displayTabactual, true);

	}
	
	
	@Test(priority = 4)
	public void switchToEnglishLangyage()
	{
		profilePage.clickOnProfiledropdown();
		profilePage.englishLink();
		CommonFunction.alertAccept();
	}

	@Test(priority = 5)
	public void verifyEnglishDashboardPage()
	{
		profilePage.waitForDashboardPage();
		String actual="Dashboard";
		String expected=profilePage.getDashboadTabText();
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority = 6)
	public void verifyEnglishAccesstab()
	{
		profilePage.accessTabusingLanguageVerification();
		List<String> englishactualTabText=profilePage.verifyTabTextForLanguageCheck();
		List<String> englishexpTabText=new ArrayList<String>();
		englishexpTabText.add("Dashboard");
		englishexpTabText.add("Alerts");
		englishexpTabText.add("Tests");
		englishexpTabText.add("Variables");
		englishexpTabText.add("Notifications");
		
		boolean textTabactual=englishactualTabText.equals(englishexpTabText);
	    Assert.assertEquals(textTabactual, true);
		List<Boolean> englishactualTabdisplay=profilePage.verifyTabdisplayForLanguage();
		List<Boolean> englishexpTabdisplay=new ArrayList<Boolean>();
		englishexpTabdisplay.add(true);
		englishexpTabdisplay.add(true);
		englishexpTabdisplay.add(true);
		englishexpTabdisplay.add(true);
		englishexpTabdisplay.add(true);
		
        boolean displayTabactual=englishactualTabdisplay.equals(englishexpTabdisplay);
        Assert.assertEquals(displayTabactual, true);

	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
}
