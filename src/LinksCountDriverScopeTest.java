import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksCountDriverScopeTest {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerDriver = driver.findElement(By.cssSelector("#gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		//Click on each link and make sure pages are opening
		int count= columnDriver.findElements(By.tagName("a")).size();		
		for(int i=0;i<count;i++)
		{
			String clicksToOpenLinks = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clicksToOpenLinks);
			
		}
		//Print all windows titles
		Set<String> windows = driver.getWindowHandles();
		java.util.Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
			String windowID = it.next();
			driver.switchTo().window(windowID);
			System.out.println(driver.getTitle());
		}
	}

}
