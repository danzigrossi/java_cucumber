package br.com.projecte2e.stepDefinition;

import java.util.List;
import java.util.Optional;

import br.com.projecte2e.page.HomePage;
import br.com.projecte2e.page.IndexPage;
import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

public class LoginCucumber {
	HomePage homePage;
	
	@Given("^Estar na tela inicial da aplicação$")
	public void openChromeBrowser() {
		homePage = new HomePage();
		homePage.navigate();
	}

	@When("^logar na aplicação com um login valido$")
	public void goToFacebook(DataTable usercredentials) {
		
		List<List<String>> data = usercredentials.raw();
		homePage.setLoginField(data.get(0).get(0));
		homePage.setPasswordsField(data.get(0).get(1));
		homePage.loginAction();

	}

    @Then("^o usuario deve ser redirecionado para a tela autenticada de url \"([^\"]*)\"$")
    public void userLogged(String url) throws Exception {
		IndexPage index = new IndexPage();
        index.isCorrectPage(url);
	}

	@After("@login")
    public void beforeLogin() {
        if (Optional.ofNullable(new IndexPage()).isPresent()){
            (new IndexPage()).closeDriver();
        }
        if (Optional.ofNullable(new HomePage()).isPresent()){
            (new HomePage()).closeDriver();
        }
    }

}