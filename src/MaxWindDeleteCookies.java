import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaxWindDeleteCookies {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		//delete cookies
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("sessionKey");
		//click on any link
		//redirects to login page
	}

}
