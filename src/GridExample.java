import java.net.MalformedURLException;
import java.net.URI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridExample {
	
			public DesiredCapabilities caps;
			
			@Parameters("browser")

			@Test
			public void login(String browser) throws MalformedURLException {
				// TODO Auto-generated method stub
			
				if(browser.equals("ch"))
				{
				ChromeOptions option = new ChromeOptions();		
				caps = new DesiredCapabilities();
			    caps.setCapability(CapabilityType.BROWSER_NAME,"chrome");
			    caps.setCapability(ChromeOptions.CAPABILITY, option);
			    System.setProperty("webdriver.chrome.driver", "C:/Selenium_Software/chromedriver.exe");
				}
				else if(browser.equals("ff"))
				{
				
					FirefoxOptions option = new FirefoxOptions();		
					caps = new DesiredCapabilities();
				    caps.setCapability(CapabilityType.BROWSER_NAME,"firefox");
				    caps.setCapability(FirefoxOptions.FIREFOX_OPTIONS, option);
				    System.setProperty("webdriver.gecko.driver", "C:/Selenium_Software/geckodriver.exe");
				}
				
				
				WebDriver driver = new RemoteWebDriver(URI.create("http://192.168.0.107:4444/").toURL(), caps);
				driver.navigate().to("http://localhost:100");
				driver.manage().window().maximize();
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				WebElement elm = driver.findElement(By.name("Login"));
				elm.click();
				driver.quit();

			}

		

	}


