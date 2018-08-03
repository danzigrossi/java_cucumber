package br.com.projecte2e.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

public class ApplicationProperties {
	private static final String CONFIG_PROPERTIES = "config.properties";
	private static final String DEFAULT_BROWSER = "application.default.browser";
	private static final String DEFAULT_ENVIRONMENT = "junit";
	private static final String SEPARATOR = "/";
	private static final String BROWSER_DRIVER_CLASS = "browser.driver.class";
	private static final String BROWSER_DRIVER_PATH = "browser.driver.path";
	private static final String BROWSER_SYSTEM_PROPERTY = "browser.systemroperty";
	private static final String BROWSER = "browser";
	private static final String EXECUTION_ENVIRONMENT = "environment";
	private static final String SYSTEM_PROPERTIES = "/system_properties.properties";
	private static final String CONFIG_FOLDER = "./config/";
	private static ApplicationProperties instance = null;
	private Properties properties;
	private Properties browserProperties;
	private WebDriver driver;

	protected ApplicationProperties() throws IOException {
		
		String environment = System.getProperty(EXECUTION_ENVIRONMENT);
		String browser = System.getProperty(BROWSER);

		if (StringUtils.isEmpty(environment)) {
			environment = DEFAULT_ENVIRONMENT;
			System.out.println("Usando default ENV");
		}
		properties = new Properties();
		properties.load(new FileInputStream(CONFIG_FOLDER + environment + SYSTEM_PROPERTIES));
		
		if (browser == null) {
			browser = getValue(DEFAULT_BROWSER);
			System.out.println("Usando default Browswer");
		}
		System.out.println(browser);
		browserProperties = new Properties();
		browserProperties.load(new FileInputStream(CONFIG_FOLDER
				+ environment 
				+ SEPARATOR 
				+ browser 
				+ SEPARATOR
				+ CONFIG_PROPERTIES));
	}

	public static ApplicationProperties getInstance() {
		if (instance == null) {
			try {
				instance = new ApplicationProperties();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return instance;
	}

	public String getValue(String key) {
		return properties.getProperty(key);
	}
	
	public String getBrowserValue(String key) {
		return browserProperties.getProperty(key);
	}

	public WebDriver getDriver() {
		if (null == driver) {
			System.setProperty(getBrowserValue(BROWSER_SYSTEM_PROPERTY), getBrowserValue(BROWSER_DRIVER_PATH));
			Class<?> cls;
			try {
				cls = (Class.forName(getBrowserValue(BROWSER_DRIVER_CLASS)));
				driver = (WebDriver) cls.newInstance();
				driver.manage().timeouts().implicitlyWait(10,
														  TimeUnit.SECONDS);
			} catch (Exception e) {
				System.out.println("NÃO FOI POSSÍVEL INSTANCIAR O DRIVER DO NAVEGADOR");
				e.printStackTrace();
			}
		}
		return driver;
		
	}

}
