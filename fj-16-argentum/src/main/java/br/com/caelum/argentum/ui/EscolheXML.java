package br.com.caelum.argentum.ui;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import br.com.caelum.argentum.Negocio;
import br.com.caelum.argentum.reader.LeitorXML;

public class EscolheXML {
	
	public List<Negocio> escolher() {
		
		try {
			
			JFileChooser fileChooser = new JFileChooser(".");
			int retorno = fileChooser.showOpenDialog(null);
			
			if(retorno == JFileChooser.APPROVE_OPTION){
				FileReader reader = new FileReader(fileChooser.getSelectedFile());
				return new LeitorXML().carrega(reader);
						
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return Collections.emptyList();
	}
	
	public static void main(String[] args) {
		new EscolheXML().escolher();
	}

}
