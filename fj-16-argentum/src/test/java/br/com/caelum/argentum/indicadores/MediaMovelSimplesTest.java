package br.com.caelum.argentum.indicadores;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.Candle;
import br.com.caelum.argentum.SerieTemporal;

public class MediaMovelSimplesTest {
	
	private SerieTemporal criaSerie(double... valores) {
		
		List<Candle> candles = new ArrayList<Candle>();
		for(double d : valores) {
			//cria candle com todos valores iguais, mil de quantidade e uma data qualquer
			candles.add(new Candle(d, d, d, d, 1000.0, Calendar.getInstance()));
		}
		return new SerieTemporal(candles);
		
	}

	@Test
	public void testExemploSimplesParaMedia() {
		SerieTemporal serie = criaSerie(1.0, 2.0, 3.0, 4.0, 3.0, 4.0, 5.0, 4.0, 3.0);
		Indicador mms = new MediaMovelSimples();
		
		assertEquals(2.0, mms.calcula(2, serie), 0.00001);
		assertEquals(3.0, mms.calcula(3, serie), 0.00001);
		assertEquals(10.0 / 3, mms.calcula(4, serie), 0.00001);
		assertEquals(11.0 / 3, mms.calcula(5, serie), 0.00001);
		assertEquals(4.0, mms.calcula(6, serie), 0.00001);
		assertEquals(13.0 / 3, mms.calcula(7, serie), 0.00001);
		assertEquals(4.0, mms.calcula(8, serie), 0.00001);
	}

}
