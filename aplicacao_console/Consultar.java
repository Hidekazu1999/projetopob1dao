package aplicacao_console;

import fachada.Fachada;

public class Consultar {
    public Consultar(){
        Fachada.inicializar();
        try {
            System.out.println(Fachada.consultarVideosPorAssunto(""));
            System.out.println(Fachada. consultarVideoPorUsuario(""));
            System.out.println(Fachada.consultarUsuariosPorVideo(""));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Fachada.finalizar();
        System.out.println("\nfim do programa");
    }



    //=================================================
    public static void main(String[] args) {
        new Consultar();
    }
}