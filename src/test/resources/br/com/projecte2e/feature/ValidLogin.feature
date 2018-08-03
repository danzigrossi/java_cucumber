Feature: Tela de login

@login
Scenario: Logar na aplicação
    Given Estar na tela inicial da aplicação
    When logar na aplicação com um login valido
	    | zigrossi | password |
    Then o usuario deve ser redirecionado para a tela autenticada de url "http://localhost:8095/home"
