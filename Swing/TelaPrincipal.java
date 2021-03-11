package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal {
    private JFrame frame;
    private JLabel label;

    //BOTÕES
    private JButton btnCadastrarVideo;
    private JButton btnCadastrarVisualizacao;
    private JButton btnListarVideo;
    private JButton btnListarVisualizacao;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaPrincipal window = new TelaPrincipal();
                    window.frame.setLocationRelativeTo(null);
                    window.frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
        public TelaPrincipal(){
            initialize();
        }


        private void initialize() {
            frame = new JFrame();
            frame.setResizable(false);
            frame.setTitle("Link");

            frame.setBounds(0,0,300,400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(null);

            //-----------MENU----------------------
             btnCadastrarVideo = new JButton("Cadastrar vídeo");
             btnCadastrarVideo.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     try{
                        TelaCadastrarVideo cv = new TelaCadastrarVideo();
                        cv.setLocationRelativeTo(null);
                        cv.setVisible(true);
                        System.out.println("Okay 1");
                     }
                     catch (Exception a){
                         System.out.println("Deu ruim"+ a);

                     }

                 }
             });
             btnCadastrarVideo.setBounds(40,60,200,20);
             frame.add(btnCadastrarVideo);
             btnCadastrarVisualizacao = new JButton("Cadastrar Visualizacão");
             btnCadastrarVisualizacao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        System.out.println("Okay 2");
                    }
                    catch (Exception a){
                        System.out.println("Deu ruim"+ a);

                    }

                }
            });
            btnCadastrarVisualizacao.setBounds(40,100,200,20);
            frame.add(btnCadastrarVisualizacao);


            btnListarVideo = new JButton("Listar video");
            btnListarVideo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        System.out.println("Okay 3");
                    }
                    catch (Exception a){
                        System.out.println("Deu ruim"+ a);

                    }

                }
            });
            btnListarVideo.setBounds(40,140,200,20);
            frame.add(btnListarVideo);



            btnListarVisualizacao = new JButton("Listar visualizacao");
            btnListarVisualizacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             try{
                System.out.println("Okay 4");
             }
             catch (Exception a){
                System.out.println("Deu ruim"+ a);

            }

            }
            });
            btnListarVisualizacao.setBounds(40,180,200,20);
            frame.add(btnListarVisualizacao);
}
    }
