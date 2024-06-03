package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	static WebDriver driver;
	static Logger logger;
	static Properties p;

	public static WebDriver intializeBrowser() throws IOException {

		// for invoking the remote execution
		if (getproperties().getProperty("execution_env").equalsIgnoreCase("remote")) {

			DesiredCapabilities capibilites = new DesiredCapabilities();

			// OS
			if (getproperties().getProperty("os").equalsIgnoreCase("windows")) {
				capibilites.setPlatform(Platform.WINDOWS);
			} else if (getproperties().getProperty("os").equalsIgnoreCase("mac")) {
				capibilites.setPlatform(Platform.MAC);

			} else {
				System.out.println("No OS is matching");
			}

			// browser
			switch (getproperties().getProperty("browser".toLowerCase())) {
			case "chrome":
				capibilites.setBrowserName("chrome");
				break;
			case "edge":
				capibilites.setBrowserName("MicrosoftEdge");
				break;
			case "firefox":
				capibilites.setBrowserName("firefox");
				break;
			default:
				System.out.println("Invalid Browser");

			}

			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capibilites);

		} else if (getproperties().getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (getproperties().getProperty("browser".toLowerCase())) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("Invalid Browser");
				driver = null;

			}

		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

		return driver;

	}

	// Return WebDriver
	public static WebDriver getDriver() {
		return driver;
	}

	// Properties file configuration
	public static Properties getproperties() throws IOException {

		FileReader file = new FileReader(".\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(file);
		return p;

	}

	// Initializing logger for logs generation
	public static Logger getLogger() {
		logger = LogManager.getLogger();

		return logger;
	}

	public static String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public static String randomeNumber() {
		String generatedString = RandomStringUtils.randomNumeric(10);
		return generatedString;
	}

	public static String randomAlphaNumeric() {
		String str = RandomStringUtils.randomAlphabetic(5);
		String num = RandomStringUtils.randomNumeric(10);
		return str + num;
	}

}
