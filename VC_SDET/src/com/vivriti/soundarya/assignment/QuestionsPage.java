package com.vivriti.soundarya.assignment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.vivriti.soundarya.assignment.ObjectRepository;

public class QuestionsPage {
	
	WebDriver driver;
	static ObjectRepository OR;
    static
    {    
    	OR = new ObjectRepository();
    }
    
    public QuestionsPage(WebDriver driver)
    {
       this.driver = driver;
    }
    
    public void SelectOptions(String sAns)
    {
    	
	   	String[] sAnsArr = sAns.split(",");	  
	   	boolean blnFlag = false;
	   	while (!blnFlag)  {  	
	   		for (int i=0;i<sAnsArr.length;i++){
		    	boolean blnFind = this.FindOption(sAnsArr[i]);
		    	if (blnFind)
		    		this.ClickNext();
		    	String QuesValue = this.GetQuestion();
		    	if(QuesValue.contains("anything else")||QuesValue.contains("what date")){
		    		blnFlag = true;
		    		break;
		    	}	
	   		}	
	    }		    	
    			
    }
    
    public boolean VerifyEmailorNum()
    {
    	String EmailorPNQues = this.GetQuestion();
    	if (EmailorPNQues.contains("notify"))
    		System.out.println("Email or Number field Q is present");
    	return (driver.findElement(OR.txtEmailorNum)).isDisplayed();
    }
    
    public String GetQuestion()
    {
    	return driver.findElement(OR.eleQuestion).getText();
    }
    
    public void EnterText(String Value)
    {
       	WebElement eleText = driver.findElement(OR.txtAnsType);
    	eleText.click();
    	eleText.sendKeys(Value); 
    	this.ClickNext();
    }
    
    public void selectDateNTime(String Time)
    {
    	 Date selDate= this.addDays(new Date(),2); 
    	 String Dateval = new SimpleDateFormat("MMMM d, yyyy").format(selDate);
    	 System.out.println(Dateval+" is selected");
    	 driver.findElement(By.xpath("//button[contains(@aria-label,'"+Dateval+"')]")).click();
    	 this.ClickNext();
    	 Select oSelect = new Select(driver.findElement(OR.selTime));
    	 oSelect.selectByVisibleText(Time);
    	 this.ClickNext();
    }
    
    public boolean FindOption(String optionValue)
    {
    	boolean blnFound = false;	
    	List<WebElement> lstoptions= driver.findElements(OR.lstOptions);
    	for (int op=1; op<=lstoptions.size();op++){
    		String optionXpath = "//label[contains(@data-test,'"+op+"')]//div[contains(@class,'iconContainer')]/following-sibling::div";
			String option= driver.findElement(By.xpath(optionXpath)).getText();
			if(option.equalsIgnoreCase(optionValue)){
				blnFound = true;
				driver.findElement(By.xpath("//div[text()='"+optionValue+"']")).click();
				System.out.println(option+" is selected");
				break;
			}
    	}	
    	return blnFound;
	}
    
    public void ClickNext()
    {
       driver.findElement(OR.btnNext).click();
    }
      
    
    public Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); 
        return cal.getTime();
    }
}
