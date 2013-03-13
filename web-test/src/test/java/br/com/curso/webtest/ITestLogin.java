package br.com.curso.webtest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class ITestLogin {
	private static final boolean INTERROMPE = true;

	private static final boolean CONTINUA = true;

	private static WebDriver driver;

	private String baseUrl;

	private StringBuffer erros;

	@BeforeClass
	public static void setUpClass() throws Exception {
		FirefoxBinary binary = new FirefoxBinary(new File(
			"/usr/bin/firefox"));
		FirefoxProfile profile = new FirefoxProfile();
		driver = new FirefoxDriver(binary, profile);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
	}

	@Before
	public void setUp() throws Exception {
		erros = new StringBuffer();
		baseUrl = "http://localhost:8081";
	}

	@Test
	public void testCenarioLogin() throws Exception {
		driver.get(baseUrl + "/web-test/login.jsp");
		verificaPresencaTexto("Login do sistema", INTERROMPE);
		driver.findElement(By.id("emailInput")).clear();
		driver.findElement(By.id("emailInput")).sendKeys("fabio@gmail.com");
		driver.findElement(By.id("senhaInput")).clear();
		driver.findElement(By.id("senhaInput")).sendKeys("teste123");
		driver.findElement(By.id("loginBtn")).click();
		verificaPresencaTexto("WEB-TEST: Pagina Inicial", CONTINUA);
		driver.findElement(By.id("sairLink")).click();
		verificaPresencaTexto("Login do sistema", INTERROMPE);
	}

	@Test
	public void testCenarioLoginConsulta() throws Exception {
		driver.get(baseUrl + "/web-test/login.jsp");
		verificaPresencaTexto("Login do sistema", INTERROMPE);
		driver.findElement(By.id("emailInput")).clear();
		driver.findElement(By.id("emailInput")).sendKeys("fabio@gmail.com");
		driver.findElement(By.id("senhaInput")).clear();
		driver.findElement(By.id("senhaInput")).sendKeys("teste123");
		driver.findElement(By.id("loginBtn")).click();
		verificaPresencaTexto("WEB-TEST: Pagina Inicial", CONTINUA);
		driver.findElement(By.id("usuarioLink")).click();
		verificaPresencaTexto("WEB-TEST: Listagem de Usuarios", CONTINUA);
		verificaPresencaTexto("fabio@gmail.com", INTERROMPE);
		driver.findElement(By.id("voltarLink")).click();
		driver.findElement(By.id("sairLink")).click();
		verificaPresencaTexto("Login do sistema", INTERROMPE);
	}

	@After
	public void tearDown() throws Exception {
		String verificationErrorString = erros.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		driver.quit();
	}

	private void verificaPresencaTexto(String texto, boolean interromperCasoErro) {
		int i = 5;
		boolean textoPresente = driver.getPageSource().contains(texto);
		while (!textoPresente && i > 0) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
			textoPresente = driver.getPageSource().contains(texto);
			i--;
		}
		if (interromperCasoErro) {
			assertTrue("O texto '" + texto + "' nao foi encontrado na pagina!",
					textoPresente);
		} else {
			if (!textoPresente) {
				erros.append("O texto '" + texto
						+ "' nao foi encontrado na pagina!");
			}
		}
	}
}
