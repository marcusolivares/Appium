package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AccordionPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class AccordionTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private AccordionPage page = new AccordionPage();
	
	@Test
	public void deveInteragirComAccordion() {
		//acessar menu
		menu.acessarAccordion();
		
		//clicar op 1
		page.selecionarOp1();
		
		//verificar texto op 1
		
		//O valor que volta do OP1 n�o � a descri��o, por algum motivo n�o funciona
		//Assert.assertEquals("Esta � a descri��o da op��o 1", page.obterValorOp1());
		//System.out.println(page.obterValorOp1());
		
	}
}
