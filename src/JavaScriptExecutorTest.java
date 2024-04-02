import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorTest {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//window level scrolling
		js.executeScript("window.scrollBy(0,500)");
		//Table level scrolling
		js.executeScript("document.querySelector('.tableFixHead\').scrollTop=5000");
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int num, sum=0;
		for(WebElement value:values)
		{			
			num = Integer.parseInt(value.getText());
			sum = sum+num;
		}
		String totalString = driver.findElement(By.cssSelector(".totalAmount")).getText();
		int total = Integer.parseInt(totalString.split(":")[1].trim());
		Assert.assertEquals(sum, total);
	
	}

}
