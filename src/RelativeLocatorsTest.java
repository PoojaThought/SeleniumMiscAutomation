import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocatorsTest {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement editBox = driver.findElement(By.cssSelector("[name=\"name\"]"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(editBox)).getText());
		WebElement dobLabel = driver.findElement(By.cssSelector("[for=\"dateofBirth\"]"));
		driver.findElement(with(By.tagName("input")).below(dobLabel)).click();
		WebElement icecreamLabel = driver.findElement(By.cssSelector("[for=\"exampleCheck1\"]"));
		driver.findElement(with(By.tagName("input")).toLeftOf(icecreamLabel)).click();
		WebElement studentRbtn = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(studentRbtn)).getText());
	}

}
