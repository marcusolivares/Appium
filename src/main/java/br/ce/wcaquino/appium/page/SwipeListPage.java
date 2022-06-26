package br.ce.wcaquino.appium.page;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class SwipeListPage extends BasePage {

	//nos xpath abaixo, utilizamos o "/.." para subir um elemento depois do encontrado (para usar a barrona e não o texto)
	
	public void swipeElementLeft(String opcao) {
		swipeElement(getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.1, 0.9);
	}
	
	public void swipeElementRight(String opcao) {
		swipeElement(getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.9, 0.1);
	}
	
	//esse método foi necessário ser criado pq ao usar o comando normal, ao clicar no elemento do "(+)" é muito grande
	//e ele acaba clicando no "(-)" erroneamente
	//teoricamente a coordenada deveria ser (-50, 0), pois clicar em 0, 0 não dá certo mas com tap sim 
	public void clicarBotaoMais() {
		MobileElement botao = getDriver().findElement(By.xpath("//*[@text='(+)']/.."));
		new TouchAction<>(getDriver())
			.tap(TapOptions.tapOptions().withElement(ElementOption.element(botao, 0, 0)))
			.perform();
		
	}
}
