package com.Emprix.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Emprix.driver.TestBase;
import com.Emprix.util.TestUtil;

public class LoginPage extends TestBase {
	
	
	@FindBy(name="callback_0")
	WebElement username_txtbox;
	
	@FindBy(name="callback_1")
	WebElement password_txtbox;
	
	@FindBy(name="callback_2")
	WebElement login_btn;
	
	@FindBy(xpath="//img[@src='images/logo-empirix-nav.png']")
	WebElement logo;
	
	@FindBy(xpath="//li/a[contains(@href,'/dashboard')]")
	WebElement dashboardTab;
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLogo(){
		return logo.isDisplayed();
	}
	
	public void login(String username,String password)
	{
		username_txtbox.sendKeys(username);
		password_txtbox.sendKeys(password);
		login_btn.click();
	}
	
	public String validateLoginPageTitle(){
		WebDriverWait wait=new WebDriverWait(driver, TestUtil.EXPLICIT_WAIT, TestUtil.SLEEP_TIME);
		wait.until(ExpectedConditions.visibilityOf(dashboardTab));
		return driver.getTitle();
	}
	
	public boolean validateDashboarTab(){

		return dashboardTab.isDisplayed();
	}
	
	
	
	
	
	

}
