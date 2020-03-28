package com.Emprix.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Emprix.driver.TestBase;
import com.Emprix.util.CommonFunction;
import com.Emprix.util.TestUtil;

public class ProfilePage extends TestBase {
	
	
	
	@FindBy(xpath="//a[@class='dropdown-toggle ng-binding']")
	WebElement profiledropdownLink;
	
	@FindBy(xpath="//a[contains(text(),'Japanese')]")
	WebElement japaneselanguageLink;
	
	
	@FindBy(xpath="//a[contains(text(),'English')]")
	WebElement englishLink;
	
	@FindBy(xpath="//li/a[contains(@href,'/alerts')]")
	WebElement alertsTab;
	
	@FindBy(xpath="//li/a[contains(@href,'/tests')]")
	WebElement testsTab;
	
	@FindBy(xpath="//li/a[contains(@href,'/variables')]")
	WebElement variablesTab;
	
	@FindBy(xpath="//li/a[contains(@href,'/notifi')]")
	WebElement notificationTab;
	
	
	
	
	LoginPage loginpage;
	
	public ProfilePage() {
		PageFactory.initElements(driver, this);
		loginpage=new LoginPage();
		
	}
	
	public ClientPage clickOnProfiledropdown()
	{
		profiledropdownLink.click();
		
		return new ClientPage();
	}
	
	public void japaneseLink()
	{
		japaneselanguageLink.click();
		
	}
	
	public void englishLink()
	{
		englishLink.click();
		
	}
	
	public void waitForDashboardPage()
	{
		
		WebDriverWait wait=new WebDriverWait(driver, TestUtil.EXPLICIT_WAIT, TestUtil.SLEEP_TIME);
		wait.until(ExpectedConditions.visibilityOf(loginpage.dashboardTab));
		
	}
	
	public String getDashboadTabText()
	{
		
		String text=loginpage.dashboardTab.getText();
		return text;
		
	}
	
	public void accessTabusingLanguageVerification()
	{
		CommonFunction.verifyLinkAccessibilty(loginpage.dashboardTab.getAttribute("href"));
		CommonFunction.verifyLinkAccessibilty(alertsTab.getAttribute("href"));
		CommonFunction.verifyLinkAccessibilty(testsTab.getAttribute("href"));
		CommonFunction.verifyLinkAccessibilty(variablesTab.getAttribute("href"));
		CommonFunction.verifyLinkAccessibilty(notificationTab.getAttribute("href"));

	}
	
	
	public List<String> verifyTabTextForLanguageCheck()
	{
		List<String> tabList=new ArrayList<String>();
		String dashboard=loginpage.dashboardTab.getText();
		String alerts=alertsTab.getText();
		String tests=testsTab.getText();
		String variables=variablesTab.getText();
		String notification=notificationTab.getText();
		tabList.add(dashboard);
		tabList.add(alerts);
		tabList.add(tests);
		tabList.add(variables);
		tabList.add(notification);
		return tabList;
	}
	
	public List<Boolean> verifyTabdisplayForLanguage()
	{
		List<Boolean> tabList=new ArrayList<Boolean>();
		boolean dashboard=loginpage.dashboardTab.isDisplayed();
		boolean alerts=alertsTab.isDisplayed();
		boolean tests=testsTab.isDisplayed();
		boolean variables=variablesTab.isDisplayed();
		boolean notification=notificationTab.isDisplayed();
		tabList.add(dashboard);
		tabList.add(alerts);
		tabList.add(tests);
		tabList.add(variables);
		tabList.add(notification);
		return tabList;
	}

}
