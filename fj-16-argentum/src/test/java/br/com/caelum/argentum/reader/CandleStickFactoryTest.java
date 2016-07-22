package br.com.caelum.argentum.reader;


import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.CandleStick;
import br.com.caelum.argentum.Negocio;

public class CandleStickFactoryTest {

	@Test
	public void test() {

		Calendar hoje = Calendar.getInstance();
		
		
		Negocio negocio1 = new Negocio(40.5, 100, hoje);
		Negocio negocio2 = new Negocio(45.0, 100, hoje);
		Negocio negocio3 = new Negocio(39.8, 100, hoje);
		Negocio negocio4 = new Negocio(42.3, 100, hoje);
		
		List<Negocio> negocios = Arrays.asList(negocio1, negocio2, negocio3, negocio4);
		
		CandleStickFactory fabrica = new CandleStickFactory();
		
		CandleStick candle = fabrica.constroiCandleParaData(hoje, negocios);
		
		assertEquals(40.5, candle.getAbertura(), 0.00001);
		assertEquals(42.3, candle.getFechamento()	, 0.00001);
		assertEquals(39.8, candle.getMinimo(), 0.00001);
		assertEquals(45.0, candle.getMaximo(), 0.00001);
		assertEquals(16760.0, candle.getVolume(), 0.00001);
	
	}
	
	@Test
	public void testSemNegocios(){
		
		Calendar hoje = Calendar.getInstance();
		
		List<Negocio> negocios = Arrays.asList();
		
		CandleStickFactory fabrica = new CandleStickFactory();
		CandleStick candle = fabrica.constroiCandleParaData(hoje, negocios);
		
		assertEquals(0.0, candle.getVolume(), 0.00001);
		
	}
	
	@Test
	public void testComApenasUmNegocio() {
		
		Calendar hoje = Calendar.getInstance();
		
		Negocio negocio1 = new Negocio((40.5), 100, hoje);
		
			
		List<Negocio> negocios = Arrays.asList(negocio1);
		
		CandleStickFactory fabrica = new CandleStickFactory();
		CandleStick candle = fabrica.constroiCandleParaData(hoje, negocios);
		
		assertEquals(40.5, candle.getAbertura(), 0.00001);
		assertEquals(40.5, candle.getFechamento(), 0.00001);
		assertEquals(1.7976931348623157E308, candle.getMinimo(), 0.00001);
		assertEquals(40.5, candle.getMaximo(), 0.00001);
		assertEquals(4050.0, candle.getVolume(), 0.00001);
		
		
		
	}

}
