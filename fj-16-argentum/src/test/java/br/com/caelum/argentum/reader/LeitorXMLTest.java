package br.com.caelum.argentum.reader;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.Negocio;

public class LeitorXMLTest {

	@Test
	public void testLeitorDeXmlCarregaListaDeNegocio() {
		String xmlDeTeste = "<list>" +
				"    <negocio>" +
				"        <preco>43.5</preco>" +
				"        <quantidade>1000</quantidade>" +
				"        <data>" +
				"            <time>1322233344455</time>" +
				"        </data>" +
				"    </negocio>" +
				"</list>";
								
					
		LeitorXML leitor = new LeitorXML();
		List<Negocio> negocios = leitor.carrega(new StringReader(xmlDeTeste));
		
	}

}
