package com.vivriti.soundarya.assignment;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.vivriti.soundarya.assignment.ObjectRepository;

public class SelectCityPage {

	WebDriver driver;
	static ObjectRepository OR;
    static
    {    
    	OR = new ObjectRepository();
    }
    
    public SelectCityPage(WebDriver driver)
    {
       this.driver = driver;
    }
    
    public void loginToSite(String PostalCode)
    {
       this.SelectPostalCode(PostalCode);
       this.ClickGo();
    }
    
  
    
    public void SelectPostalCode(String PostalCode)
    {
    try {
	     WebElement elePostalCode = driver.findElement(OR.ajaPostalCode);
	     elePostalCode.clear();
	     elePostalCode.sendKeys(PostalCode);	     
	     Thread.sleep(1000);		
	     elePostalCode.sendKeys(Keys.ARROW_DOWN);
	     elePostalCode.sendKeys(Keys.ENTER);
    	}
     catch (InterruptedException e) {
 		e.printStackTrace();
     }
    }
    
    public void ClickGo()
    {
       driver.findElement(OR.btnGo).click();
    }
   
}
