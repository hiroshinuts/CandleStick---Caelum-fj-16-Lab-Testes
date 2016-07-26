package br.com.caelum.argentum.reader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.Candle;
import br.com.caelum.argentum.Negocio;

public class CandleStickFactory {
	
	public Candle constroiCandleParaData(Calendar data, List<Negocio> negocios){
		
		Double maximo = Double.MIN_VALUE;
		Double minimo = Double.MAX_VALUE;
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
		
		Double abertura = negocios.isEmpty() ? 0 : negocios.get(0).getPreco();
		Double fechamento = negocios.isEmpty() ? 0 : negocios.get(negocios.size() - 1).getPreco();
		
		return new Candle(abertura, fechamento, minimo, maximo, volume, data);
	}

	public boolean isMesmoDia(Calendar data1, Calendar data2) {
		
		return data1.get(Calendar.DAY_OF_MONTH) == data2.get(Calendar.DAY_OF_MONTH)
				&& data1.get(Calendar.MONTH) == data2.get(Calendar.MONTH)
				&& data1.get(Calendar.YEAR) == data2.get(Calendar.YEAR);
	}

	public List<Candle> constroiCandles(List<Negocio> todosNegocios) {
		
		List<Candle> candles = new ArrayList<Candle>();
		
		//lista com negocios que sejam do mesmo dia que dataPrimeiro
		List<Negocio> negociosMesmoDia = new ArrayList<Negocio>();
		Calendar dataPrimeiro = todosNegocios.get(0).getData();
		
		for(Negocio negocio : todosNegocios){
			//se nao for mesmo dia, fecha candle e reinicia variaveis
			if(!isMesmoDia(dataPrimeiro, negocio.getData())){
				fecharCandle(candles, negociosMesmoDia, dataPrimeiro);
				
				negociosMesmoDia = new ArrayList<Negocio>();
				dataPrimeiro = negocio.getData();
			}
			
			negociosMesmoDia.add(negocio);
		}
		
		//adiciona ultimo candle
		
		fecharCandle(candles, negociosMesmoDia, dataPrimeiro);
		
		return candles;
	}

	private void fecharCandle(List<Candle> candles, List<Negocio> negociosMesmoDia, Calendar dataPrimeiro) {
		candles.add(constroiCandleParaData(dataPrimeiro, negociosMesmoDia));
	}

}
