import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationinWebTableJavaStreams 
{

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<WebElement> itemList;
		boolean flag=true;
		driver.findElement(By.xpath("//tr/th[1]")).click();	
		do
		{
			itemList = driver.findElements(By.xpath("//tr/td[1]"));
			if(itemList.stream().map(e->e.getText()).anyMatch(s->s.equalsIgnoreCase("Rice")))
			{
				flag=false;
				itemList.stream().filter(e->e.getText().contains("Rice")).map(i->getItemPrice(i))
				.forEach(s->System.out.println(s));							
			}
			else
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}while(flag);
		
	}
	
	public static String getItemPrice(WebElement item)
	{
		return item.findElement(By.xpath("following-sibling::td[1]")).getText();
	}

}
