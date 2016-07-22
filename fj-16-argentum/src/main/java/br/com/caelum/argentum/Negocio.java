package br.com.caelum.argentum;

import java.util.Calendar;

public final class Negocio {

	private final Double preco;
	private final Integer quantidade;
	private final Calendar data;
	
	public Negocio(Double preco, Integer quantidade, Calendar data) {

		if(data == null) {
			throw new IllegalArgumentException("Data n�o pode ser nula");
		}
		
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public Double getPreco() {
		return preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return (Calendar) this.data.clone();
	}
	
	public double getVolume(){
		return preco * quantidade;
	}
	
	
}

