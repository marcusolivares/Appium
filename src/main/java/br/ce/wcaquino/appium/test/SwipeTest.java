package br.ce.wcaquino.appium.test;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;

public class SwipeTest extends BaseTest {
	
	MenuPage menu = new MenuPage();

	@Test
	public void deveRealizarSwipe() {
		//acessar menu
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		menu.scrollDown();
		menu.acessarSwipe();
		
		//verificar texto 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
		
		//swipe para direita
		menu.swipeRight();
		
		//verificar o texto 'E veja se'
		Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));
		
		//clicar botao direita
		menu.clicarPorTexto("›");
		
		//verificar o texto 'Chegar até o fim!'
		Assert.assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));
		
		//swipe esquerda
		menu.swipeLeft();
		
		//clicar botao esquerda
		menu.clicarPorTexto("‹");
		
		//verificar texto 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));	
	}
}
