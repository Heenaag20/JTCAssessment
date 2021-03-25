package JTCAssessment;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Googlesearch extends driver{
  @Test
  public void BrowserAutomation () throws IOException{
	  driver = InitializeDriver();
	  driver.get("https://www.google.co.in");
	  driver.manage().window().maximize();
	WebElement search= driver.findElement(By.cssSelector("input[type='text']"));
	search.sendKeys("Java");
	WebDriverWait wait=new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@role='listbox']")));
	List <WebElement> all=driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='L3OrEb']"));
	System.out.println(all.size());
	for(int i=0;i<all.size();i++)  {
		String option = all.get(i).getText();
		if (option.contains("java download")) {
			all.get(i).click();
			break;		
		}
	}	
driver.close();
  }	
}
