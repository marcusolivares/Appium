package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.SplashPage;

public class SplashTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();
	
	@Test
	public void deveAguardarSplashsSumir() {
		//acessar menu splash
		menu.acessarSplash();
		
		//verificar que o splash esta sendo exibido
		page.isTelaSplashVisivel();
		
		//aguardar a saida do splash
		page.aguardarSplashSumir();
		
		//verificar que o formulario esta aparecendo
		Assert.assertTrue(page.existeElementoPorTexto("Formulário"));
		
	}
}
