package com.vivriti.soundarya.assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.vivriti.soundarya.assignment.SelectCityPage;
import com.vivriti.soundarya.assignment.QuestionsPage;
import java.util.concurrent.TimeUnit;


public class Process {
	
	static SelectCityPage SC;
	static QuestionsPage QP;
	static String BrowserPath = "C:\\Users\\";
	static String URL = "https://www.starofservice.in/dir/telangana/hyderabad/hyderabad/plumbing#/";
    
	public static void main(String[] args) {  
		System.setProperty("webdriver.chrome.driver", BrowserPath+"ChromeDriver.exe");
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		SC = new SelectCityPage(driver);
        QP = new QuestionsPage(driver);
        SC.loginToSite("Chennai");
		QP.ClickNext();
		QP.SelectOptions("Replace,Leak in a pipe,Tap");
		QP.EnterText("Test");
		QP.SelectOptions("On a specific date");
		QP.selectDateNTime("02:00");
		if (QP.VerifyEmailorNum())				  
		 driver.quit();	 
		
	}
	
}

