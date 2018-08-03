package br.com.projecte2e.page;

import org.openqa.selenium.By;

public class IndexPage extends AbstractPage{
	static final String ID_NAVBAR = "navbar-collapse";
	static final String URL_PAGE = "http://localhost:8095/home";
	public IndexPage() {
		super();
	}
	
	public void navBarExists() {
		findElement(By.id(ID_NAVBAR)).isEnabled();
	}

	public void isPageCorrect() throws Exception {
	    super.isCorrectPage(URL_PAGE);
    }
}
