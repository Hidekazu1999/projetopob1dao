package aplicacao_console;

import fachada.Fachada;

public class Cadastrar {
	public Cadastrar() {
		try {

			System.out.println("Cadastrando");

			/*	Video	*/

			Fachada.cadastrarVideo("youtube.com/resenha","videos engraçados","engraçado");
			Fachada.cadastrarVideo("youtube.com/lol","Campeonato Cblol","lol");
			Fachada.cadastrarVideo("youtube.com/fausto","Aprendendo Java","java");

			/*	Usuarios	*/

			Fachada.cadastrarUsuario("Hidekazu", "hidekazuo@ifpb.com","12345");
			Fachada.cadastrarUsuario("Pablo", "pablo@ifpb.com", "123456");

			/*	Visualizações 	*/

			Fachada.cadastrarVisualizacao("youtube.com/resenha","pablo@ifpb.com", 12);
			Fachada.cadastrarVisualizacao("youtube.com/lol","pablo@ifpb.com",22);
			Fachada.cadastrarVisualizacao("youtube.com/fausto","hidekazuo@ifpb.com",102);


		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		} finally {
			Fachada.finalizar();
		}
		System.out.println("fim do programa");
	}

	public static void main(String[] args) {
		new Cadastrar();
	}
}
