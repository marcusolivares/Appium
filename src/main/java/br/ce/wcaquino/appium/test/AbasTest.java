package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.core.DriverFactory;
import br.ce.wcaquino.appium.page.AbasPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class AbasTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private AbasPage page = new AbasPage();
	
	@Test
	public void deveInteragirComAbas() {
		//acessar menu abas
		menu.acessarAbas();
		
		//verificar que esta na aba 1
		Assert.assertEquals("Este é o conteúdo da Aba 1", page.obterConteudoAba());
		
		//acessar aba 2
		page.acessarAba("ABA 2");
		
		//tive que usar explicit wait com locator, caso contrário ele tenta verificar antes de mudar a página
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text, 'da Aba 2')]")));
		//verificar que esta na aba 2
		Assert.assertEquals("Este é o conteúdo da Aba 2", page.obterConteudoAba());
	}
}
