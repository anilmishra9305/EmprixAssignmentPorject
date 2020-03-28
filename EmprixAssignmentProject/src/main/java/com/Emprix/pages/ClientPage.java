package com.Emprix.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Emprix.driver.TestBase;

public class ClientPage extends TestBase {
	
	
	
	@FindBy(xpath="//span[contains(text(),'Client')]")
	WebElement clientLink;
	
	
	@FindBy(xpath="//h3[contains(text(),'Client Details')]")
	WebElement clientDetails_hdr;
	
	@FindBy(xpath="//label[contains(text(),'Client Name')]/following-sibling::label[contains(text(),'Empirix_QA_Training')]")
	WebElement clientName;
	
	@FindBy(xpath="//label[contains(text(),'Description')]/following-sibling::label[contains(text(),'This client is for QA Test purposes')]")
	WebElement description;
	
	@FindBy(xpath="//label[contains(text(),'Subscription Start Date')]/following-sibling::label[contains(text(),'Jan 14, 2020')]")
	WebElement subscription_startDate;
	
	@FindBy(xpath="//label[contains(text(),'Subscription End Date')]/following-sibling::label[contains(text(),'Aug 11, 2022')]")
	WebElement subscription_endDate;
	
	@FindBy(xpath="//label[contains(text(),'Maximum Load Tests')]/following-sibling::label[contains(text(),'0')]")
	WebElement maximum_LoadTests;
	
	@FindBy(xpath="//label[contains(text(),'Maximum VoiceWatch Tests')]/following-sibling::label[contains(text(),'0')]")
	WebElement maximum_VoiceWatchTests;
	
	@FindBy(xpath="//label[contains(text(),'Maximum Scenarios')]/following-sibling::label[contains(text(),'0')]")
	WebElement maximum_Scenarios;
	
	@FindBy(xpath="//label[contains(text(),'Schedule Period')]/following-sibling::label[contains(text(),'15')]")
	WebElement minimumTest_SchedulePeriod ;
	
	
	ProfilePage profilePage;
	
	public ClientPage() {
		PageFactory.initElements(driver, this);
		profilePage=new ProfilePage();
		
	}
	
	
	public void clickOnclientLink()
	{
		clientLink.click();
		
	}
	
	
	public List<Object> verifyClientDetails()
	{
		
		List<Object> list=new ArrayList<Object>();
		list.add(clientDetails_hdr.getText());
		list.add(clientName.getText());
		list.add(description.getText());
		list.add(subscription_startDate.getText());
		list.add(subscription_endDate.getText());
		list.add(maximum_LoadTests.getText());
		list.add(maximum_VoiceWatchTests.getText());
		list.add(maximum_Scenarios.getText());
		list.add(minimumTest_SchedulePeriod.getText());
		return list;
		
		
	}
	
	

}
