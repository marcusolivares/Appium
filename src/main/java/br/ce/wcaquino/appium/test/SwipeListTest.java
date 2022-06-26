package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.SwipeListPage;

public class SwipeListTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SwipeListPage page = new SwipeListPage();
	
	@Test
	public void deveRealizarSwipeList() {
		//acessar menu
		menu.acessarSwipeList();
		
		//op1 para a direita
		page.swipeElementRight("Op��o 1");
						
		//op1 +
		page.clicarBotaoMais();
		
		//verificar op1+
		Assert.assertTrue(page.existeElementoPorTexto("Op��o 1 (+)"));
		
		//op4 para direita
		page.swipeElementRight("Op��o 4");
		
		//op4 -
		menu.clicarPorTexto("(-)");
		
		//verificar op4-
		Assert.assertTrue(menu.existeElementoPorTexto("Op��o 4 (-)"));
		
		//op5 para a esquerda
		page.swipeElementLeft("Op��o 5 (-)");
		
		//verificar op5
		Assert.assertTrue(menu.existeElementoPorTexto("Op��o 5"));
	}
}
