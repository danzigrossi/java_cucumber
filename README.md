# java_cucumber
## Drivers
### Gecko Driver
Download:
<br>https://github.com/mozilla/geckodriver/releases
<br>Alterar variável "browser.driver.path" das pastas __mozilla__

### Chrome Driver
Download:
<br>http://chromedriver.chromium.org/downloads
<br>Alterar variável "browser.driver.path" das pastas __chrome__
<br>
## Project Structure
![Project Structure](https://github.com/danzigrossi/java_cucumber/blob/master/imgs/project_view.png)

1 - ObjectPages<br>
2 - StepDefinitions<br>
3 - Classes de apoio<br>
4 - Features/Behaviors<br>


## Configurações


### Parametros:
O projeto possui um sistema de leitura de variáveis de start que orientam sua execução.<br>
As variáveis são mapeados no ".pom" do projeto com o auxilio do plugin surefire <br>

![pom - surefire](https://github.com/danzigrossi/java_cucumber/blob/master/imgs/surefire_variables.png)

environment: define qual o ambiente de execução(local, junit, dev e QA)<br>
browser: define qual o navegador que será utilizado para a validação dos testes<br>

Dado a leitura de variáveis de inicialização, o sistema sabe quais propriedades/configurações que o mesmo deve ler. Estes arquivos de configuração estão na pasta __\<projetc>/config__ sob a seguinte estrutura

__config__/\<environment>/\<browser>

![estrutura config](https://github.com/danzigrossi/java_cucumber/blob/master/imgs/config_estructure.png)

Dentro da pasta config temos os ambientes separados por pastas(local, junit, dev e QA) que representam os ambientes. Em cada ambiente tem um arquivo denominado system_properties.properties que guarda as configurações do sistema. Segue exemplo

--- System.properties example
![System.properties](https://github.com/danzigrossi/java_cucumber/blob/master/imgs/system_properties.png)

Dentro das pastas de ambiente, temos as pastas dos browser, atualmente documentamos as pastas do mozila e chrome
cada pasta de navegador tem um arquivo de configuração para o mesmo. o arquivo é o config.properties. Segue um exemplo;

![config.properties](https://github.com/danzigrossi/java_cucumber/blob/master/imgs/config_properties.png)

