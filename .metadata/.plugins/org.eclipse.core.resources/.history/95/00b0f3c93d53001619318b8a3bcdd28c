package br.com.caelum.argentum;

import java.util.Calendar;

public final class CandleStick {
	
	private final Double abertura;
	private final Double fechamento;
	private final Double minimo;
	private final Double maximo;
	private final Double volume;
	private final Calendar data;

	
	public CandleStick(Double abertura, Double fechamento, Double minimo, Double maximo, Double volume, Calendar data) {
		
		
		
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}
	public Double getAbertura() {
		return abertura;
	}
	public Double getFechamento() {
		return fechamento;
	}
	public Double getMinimo() {
		return minimo;
	}
	public Double getMaximo() {
		return maximo;
	}
	public Double getVolume() {
		return volume;
	}
	public Calendar getData() {
		return data;
	}
	
	public boolean isAlta() {
		return this.abertura < this.fechamento;
	}
	
	public boolean isBaixa(){
		return this.abertura > this.fechamento;
	}
	
	

}
