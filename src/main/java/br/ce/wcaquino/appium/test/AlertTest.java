package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AlertaPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class AlertTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private AlertaPage page = new AlertaPage();
	
	@Before
	public void setup() {
		menu.acessarAlertas();
	}
	
	@Test
	public void deveConfirmarAlerta() {		
		//clicar alert confirm
		page.clicarAlertaConfirm();
		
		//verificar os textos
		Assert.assertEquals("Info", page.obterTituloAlerta());
		
		
		//exemplos de wait explicito
		//1 usando xpath de texto
		/*
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Confirma a opera��o?']")));
		*/
		//2 usando id como locator
		/*
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/message")));
		*/
		
		esperar(5000); //n�o sei porque esse teste est� assim, ele confirma antes de executar o assert, coloquei esse wait
		Assert.assertEquals("Confirma a opera��o?", page.obterMensagemAlerta());
		
		//confirmar o alert
		page.confirmar();
		
		//verificar nova mensagem
		Assert.assertEquals("Confirmado", page.obterMensagemAlerta());
		
		//sair
		page.sair();
	}
	
	@Test
	public void deveClicarForaAlerta() {
		//clicar alerta simples
		page.clicarAlertaSimples();
		
		//clicar fora da caixa
		esperar(1000);
		page.clicarForaCaixa();
		
		//verificar que a mensagem nao existe mais
		Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
		
	}
}
