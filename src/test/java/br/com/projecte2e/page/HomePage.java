package br.com.projecte2e.page;

import org.openqa.selenium.By;

public class HomePage extends AbstractPage{
	
	static final String INPUT_LOGIN ="username";
	static final String INPUT_PASSWORD ="password";
	static final String BTN_LOGIN ="idBtnLogin";
	
	public HomePage() {
		super();
	}
	
	public HomePage navigate() {
		navigateTo(urlHomePage);
		return new HomePage();
	}
	
	public HomePage setLoginField( String value ) {
		findElement(By.name(INPUT_LOGIN)).sendKeys(value);;
		return new HomePage();
	}
	
	public HomePage setPasswordsField( String value ) {
		findElement(By.name(INPUT_PASSWORD)).sendKeys(value);
		return new HomePage();
	}
	
	public IndexPage loginAction() {
		findElement(By.id(BTN_LOGIN)).click();
		return new IndexPage();
	}
	
	public void btnLoginExist() {
		findElement(By.id(BTN_LOGIN)).isEnabled();
	}
	
	
}
