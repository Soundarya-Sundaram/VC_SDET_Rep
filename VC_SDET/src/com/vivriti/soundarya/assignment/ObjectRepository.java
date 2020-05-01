package com.vivriti.soundarya.assignment;

import org.openqa.selenium.By;

public class ObjectRepository {
	
	//SelectCity Page
	public By ajaPostalCode = By.xpath("//div[contains(@class,'angucomplete-holder')]//input[contains(@id,'postal_code')]");
	
	public By btnGo = By.xpath("//button[contains(text(),'Go')]");
	
	public By btnNext = By.xpath("//button[text()='Next']");
	
	//Questions Page
	public By eleQuestion = By.xpath("//div[contains(@class,'commonFormTitle')]");
	
	public By lstOptions = By.xpath("//div[contains(@class,'iconContainer')]/following-sibling::div");
	
	public By txtAnsType = By.xpath("//div[contains(text(),'anything else')]/following::textarea[contains(@class,'input')]");
	
	public By selTime = By.xpath("//select[contains(@class,'selectBox')]");
	
	public By txtEmailorNum = By.xpath("//input[contains(@placeholder,'Email') or contains(@placeholder,'Number')]");
	
	}
