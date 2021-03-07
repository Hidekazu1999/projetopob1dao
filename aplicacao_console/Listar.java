package aplicacao_console;

import fachada.Fachada;

public class Listar {
    public Listar(){
        Fachada.inicializar();
        try {
            System.out.println("Listando");
            System.out.println(Fachada.listarVideos());
            System.out.println(Fachada.listarVisualizacao());
            System.out.println(Fachada.listarUsuario());


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Fachada.finalizar();
    }

    public static void main(String[] args) {
        new Listar();
    }
}
