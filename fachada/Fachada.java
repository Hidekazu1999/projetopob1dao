package fachada;

import dao.DAO;
import dao.DAOAssunto;
import dao.DAOVideo;
import dao.DAOVisualizacao;
import modelo.Assunto;
import modelo.Video;
import modelo.Visualizacao;

import java.util.List;

public class Fachada {
	private static DAOVideo daovideo = new DAOVideo();
	private static DAOAssunto daoassunto = new DAOAssunto();
	private static DAOVisualizacao daovisualizacao = new DAOVisualizacao();

	public static void inicializar() {
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}	
	public static Video cadastrarVideo(String link, String nome, String palavra) throws Exception {
		DAO.begin();

		Video v = daovideo.read(link);
		if(v != null) {
			DAO.rollback();
			throw new Exception("Link cadastrado: " + link);
		}
		
		Assunto a = daoassunto.read(palavra);
		if(a == null) {
			adicionarAssunto(v, palavra);
			a = daoassunto.read(a);
		}
		v = new Video(link, nome);
		v.adicionar(a);
		daovideo.create(v);
		DAO.commit();
		return v;
	}
	
	public static void adicionarAssunto(Video link, String palavra) throws Exception{
		DAO.begin();
		Assunto a = daoassunto.read(palavra);
		if(a != null) {
			DAO.rollback();
			throw new Exception("Assunto j� existente");
		}
		a = new Assunto(palavra);
		a.adicionar(link);
		daoassunto.create(a);
		DAO.commit();
	}
	public static Visualizacao registrarVisualizacao(String link, String email, int nota){
		DAO.begin();
		Visualizacao v = daovisualizacao.read();
		

	}
	public static List<Visualizacao> listarVisualizacao(){
		return daovisualizacao.readAll();
	}
}
