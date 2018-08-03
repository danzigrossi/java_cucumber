package br.com.projecte2e.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.projecte2e.utils.ApplicationProperties;

public class AbstractPage {
	private static final String APPLICATION_URL = "application.url";
	protected static WebDriver driver = null;
	protected static String urlHomePage;
	protected static ApplicationProperties instance;
	
	public AbstractPage () {
		if (instance == null) {
			instance = ApplicationProperties.getInstance();
			driver = instance.getDriver();
			urlHomePage = instance.getValue(APPLICATION_URL);
		}
	}

	public String getUrlPage (){
        return driver.getCurrentUrl();
    }

	public WebElement findElement(By value) {
		return driver.findElement(value);
	}
	
	public void navigateTo(String value) {
		driver.navigate().to(value);
	}
	
	public void closeDriver () {
		driver.quit();
	}

	public void isCorrectPage(String correctPage) throws Exception {
	    if (!correctPage.equals(getUrlPage())) {
	        throw new Exception("WrongPage: "+getUrlPage());
        }
    }
}
