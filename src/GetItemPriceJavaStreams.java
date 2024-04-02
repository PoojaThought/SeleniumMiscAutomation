import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetItemPriceJavaStreams {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<WebElement> itemList = driver.findElements(By.xpath("//tr/td[1]"));
		itemList.stream().filter(i->i.getText().contains("Rice")).map(i->getPriceOfItem(i))
			.forEach(s->System.out.println(s));
	}
	
	public static String getPriceOfItem(WebElement item)
	{
		return item.findElement(By.xpath("following-sibling::td[1]")).getText();
	}
	
	

}
