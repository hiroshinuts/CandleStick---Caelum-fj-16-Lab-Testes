package br.com.caelum.argentum.test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.Candle;
import br.com.caelum.argentum.Negocio;
import br.com.caelum.argentum.reader.CandleStickFactory;

public class TestaClandleStickFactorySemNegocios {

	public static void main(String[] args) {
		
		Calendar hoje = Calendar.getInstance();
		
		List<Negocio> negocios = Arrays.asList();
		
		CandleStickFactory fabrica = new CandleStickFactory();
		Candle candle = fabrica.constroiCandleParaData(hoje, negocios);
		
		System.out.println(candle.getAbertura());
		System.out.println(candle.getFechamento());
		System.out.println(candle.getMinimo());
		System.out.println(candle.getMaximo());
		System.out.println(candle.getVolume());
		
	}
	
}
