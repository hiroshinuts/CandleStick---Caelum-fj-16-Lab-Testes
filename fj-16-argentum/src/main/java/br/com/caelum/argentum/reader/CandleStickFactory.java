package br.com.caelum.argentum.reader;

import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.CandleStick;
import br.com.caelum.argentum.Negocio;

public class CandleStickFactory {
	
	public CandleStick constroiCandleParaData(Calendar data, List<Negocio> negocios){
		
		Double maximo = negocios.get(0).getPreco();
		Double minimo = negocios.get(0).getPreco();
		Double volume = 0.0;
		
		//ForEach
		for(Negocio negocio : negocios){
			volume += negocio.getVolume();
			
			if(negocio.getPreco() > maximo){
				maximo = negocio.getPreco();
			}else if(negocio.getPreco() < minimo) {
				minimo = negocio.getPreco();
			}
		}
		
		Double abertura = negocios.get(0).getPreco();
		Double fechamento = negocios.get(negocios.size() - 1).getPreco();
		
		return new CandleStick(abertura, fechamento, minimo, maximo, volume, data);
	}

}