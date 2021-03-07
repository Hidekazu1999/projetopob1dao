package fachada;

import dao.*;
import modelo.Assunto;
import modelo.Usuario;
import modelo.Video;
import modelo.Visualizacao;

import java.util.List;

public class Fachada {
	private static DAOVideo daovideo = new DAOVideo();
	private static DAOAssunto daoassunto = new DAOAssunto();
	private static DAOVisualizacao daovisualizacao = new DAOVisualizacao();
	private static DAOUsuario daousuario = new DAOUsuario();

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
	public static Visualizacao registrarVisualizacao(String link, String email, int nota)throws Exception{
		DAO.begin();
		Usuario usuario = daousuario.read(email);
		Video video = daovideo.read(link);
		if (video == null){
			DAO.rollback();
			throw new Exception("Video não encontrado!");
		}
		int idatual = maiorId(email);
		idatual++;
		Visualizacao v = new Visualizacao(idatual, nota, usuario, video);

		daovisualizacao.create(v);
		DAO.commit();
		return v;
	}
	public static void apagarVisualizacao(int id)throws Exception{
		DAO.begin();
		Visualizacao vis = daovisualizacao.read(id);
		if(vis==null){
			DAO.rollback();
			throw new Exception("Id não existente");
		}
		daovisualizacao.delete(vis);
		DAO.commit();
	}
	public Visualizacao localizarVisualizacao(int id)throws Exception{
		Visualizacao v = daovisualizacao.read(id);
		if(v == null){
			throw new Exception("Visualização não encontrada!");
		}
		return v;
	}
	public static List<Video> consultarVideosPorAssunto(String palavra){
		List<Video> videos = daovideo.consultarVideosPorAssunto(palavra);
		return videos;
	}
	public static List<Video> consultarVideoPorUsuario(String email){
		List<Video> videos = daovideo.consultarVideosPorUsuario(email);
		return videos;
	}
	public static List<Usuario> consultarUsuariosPorVideo(String link){
		List<Usuario> users = daousuario.consultarUsuarioVideo(link);
		return users;
	}
	public static List<Visualizacao> listarVisualizacao(){
		return daovisualizacao.readAll();
	}
	public static List<Video> listarVideos(){return daovideo.readAll();}
	public static List<Usuario> listarUsuario(){return daousuario.readAll();}
	public static int maiorId(String usuario){
		List<Visualizacao> visualizacoes = daovisualizacao.readAll();
		int maior = 0;
		if(visualizacoes.isEmpty()){
			return maior;
		}
		for(Visualizacao v : visualizacoes){
			if(v.getId()>maior);
				maior = v.getId();
		}
		return maior;
	}
	public static void alterarTituloVideo(String titulo, String novotitulo) throws Exception{
		DAO.begin();
		Video v = daovideo.read(titulo);
		if (v==null) {
			throw new Exception("Alterar titulo do Video - filme inexistente:" + titulo);
		}
		v.setNome(novotitulo);
		v = daovideo.update(v);
		DAO.commit();
	}

	public static void alterarAssunto(String assunto, String novoassunto) throws Exception{
		DAO.begin();
		Assunto a = daoassunto.read(assunto);
		if (a==null) {
			throw new Exception("Alterar Assunto do Video - Assunto inexistente:" + assunto);
		}
		a.setPalavra(novoassunto);
		a = daoassunto.update(a);
		DAO.commit();
	}

}
