import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSortedUsingJavaStreamsTest {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//Click on button
		//Get all web elements into list
		//Get all texts of all web elements into list
		//apply sort onto list produced by step 3
		//original list vs sorted list
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> productNamesList = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> productNames = productNamesList.stream().map(e->e.getText()).collect(Collectors.toList());
		List<String> sortedProductNames = productNames.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(productNames.equals(sortedProductNames));
	}

}
