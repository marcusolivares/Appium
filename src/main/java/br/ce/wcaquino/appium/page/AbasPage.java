package br.ce.wcaquino.appium.page;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class AbasPage extends BasePage {

	public void acessarAba(String texto) {
		clicarPorTexto(texto);
	}
	
	public String obterConteudoAba() {
		//exemplo de retorno de valor com contains no text
		return obterTexto(By.xpath("//*[contains(@text, 'conte')]"));
	}
	
	/* outra maneira de resolver usando o seguinte m�todo do basepage:
	 * existeElementoPorTexto("Este � o conte�do da aba 1);
	 */
}
