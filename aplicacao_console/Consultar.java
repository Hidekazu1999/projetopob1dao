package aplicacao_console;

import fachada.Fachada;
import modelo.Usuario;
import modelo.Video;

import java.util.List;

public class Consultar {
    public Consultar(){
        try {
            Fachada.inicializar();

            System.out.println("1.Video por Assunto 'java'\n"+Fachada.consultarVideosPorAssunto("java"));
            System.out.println("2.Video pelo Usuario 'pablo@ifpb.com'\n"+Fachada.consultarVideoPorUsuario("pablo@ifpb.com"));
            System.out.println("3.Usuario por video 'https://www.youtube.com/resenha'\n"+Fachada.consultarUsuariosPorVideo("https://www.youtube.com/resenha"));
            System.out.println("consultando...");           

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            Fachada.finalizar();
            System.out.println("\nfim do programa");
        }


    }
    //=================================================
    public static void main(String[] args) {
        new Consultar();
    }
}
