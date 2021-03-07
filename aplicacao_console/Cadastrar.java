package aplicacao_console;

import fachada.Fachada;
import modelo.Video;

public class Cadastrar {
	public Cadastrar() {
		try {
			Fachada.inicializar();
			Video v;
			v=Fachada.cadastrarVideo("www.google.com", "Site", "Pesquisa");
			//v=Fachada.cadastrarVideo("youtube.com/video","","Pesquisa");
		}
		catch(Exception e){
			System.out.println(e.getMessage()); 
		}
		finally {
			Fachada.finalizar();
		}
	}
	public static void main(String[] args) {
		
		new Cadastrar();
	}

}
