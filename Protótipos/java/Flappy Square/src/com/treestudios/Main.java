package com.treestudios;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class Main extends JFrame {

    private JPanel tela;
    private boolean jogando = true;
    private final int FPS = 1000 / 20; // 50
    private boolean[] controleTecla = new boolean[4];
    int posicaoX = 4;
    int posicaoY, gravidade = 10 ;
    int posicaoYInimigo,posicaoXInimigo = 590;
    int tamanhoRandomico = ((int) (Math.random() * ((400 - 100) - 1) + 100));
    int posicaoYinimigo2 = tamanhoRandomico + 60;
    int pontos;
    float controle, posicaoXnuvem = 0;
    int velocidadeInimigo = 8;

    ImageIcon background = new ImageIcon("res/background.jpg");
    ImageIcon filtro = new ImageIcon("res/filtro.png");
    ImageIcon fundo_camada_um = new ImageIcon("res/fundo_camada_2.png");
    ImageIcon fundo_nuvem = new ImageIcon("res/fundo_nuvem.png");

    //setando as cores do quadrado


    Color amarelo = new Color(68,39,230);
    Color inimigo = new Color(153, 192,230);

    Color fundo = new Color (241, 196, 15);
    Color teste_cor;
    Color cor_principal = amarelo;




    public Main() {

        //adicionando listener para os botões

        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                setaTecla(e.getKeyCode(), false);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                setaTecla(e.getKeyCode(), true);
            }
        });





    tela = new JPanel() {


        @Override
        public void paintComponent(Graphics g) {

                g.setColor(fundo);
                g.fillRect(0, 0, tela.getWidth(), tela.getHeight());

                g.drawImage(background.getImage(), 0,0, null);
                g.drawImage(fundo_nuvem.getImage(), (int) posicaoXnuvem, 0, null);
                g.setColor(inimigo);
                g.fillRect(posicaoXInimigo, posicaoYInimigo, 50, tamanhoRandomico);
                g.fillRect(posicaoXInimigo, posicaoYinimigo2, 50, 500);
                g.drawImage(fundo_camada_um.getImage(), 80, 50, null);
                g.setColor(cor_principal);
                g.fillRect(posicaoX, posicaoY, 20, 20);
                g.drawImage(filtro.getImage(), 0,0, null);
                g.setColor(Color.white);
                g.drawString("Pontos: " + pontos, 550 , 10);




                //som da vitoria
            if (posicaoXInimigo<posicaoX) {

            }


            }





/**
            int x = tela.getWidth() / 2 - 20 + px;
            g.drawImage(fundo.getImage(), ppx, 0, null);
            g.setColor(Color.WHITE);
            g.fillRect(9, (int) posicaoInicialY, 40, 40);
            g.drawString("Agora eu estou em " + x + "x", 5, 10);
 **/

    };

    getContentPane().add(tela);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(640, 480);
    setVisible(true);

}


public void mudarCor()
{

    if(controle <= 255) {
        teste_cor = new Color((int) controle, 41, 240);
        cor_principal = teste_cor;
        controle+= 0.05;


    }
    if (controle > 255)
    {
        controle = 0 ;
    }
}

public boolean colisao () {

    boolean colidiu = false;

    Sprite player = new Sprite();
    player.setY(posicaoY);
    player.setX(posicaoX);
    player.setW(20);
    player.setH(20);

    Sprite canoDeCima = new Sprite();
    canoDeCima.setY(posicaoYInimigo);
    canoDeCima.setX(posicaoXInimigo);
    canoDeCima.setW(50);
    canoDeCima.setH(tamanhoRandomico);

    Sprite canoDeBaixo = new Sprite();
    canoDeBaixo.setY(posicaoXInimigo);
    canoDeBaixo.setX(posicaoYinimigo2);
    canoDeBaixo.setW(50);
    canoDeBaixo.setH(tamanhoRandomico);

    if(player.colideCom(canoDeCima) || player.colideCom(canoDeBaixo) )
    {

        posicaoXInimigo = tela.getWidth();
        pontos = 0;
         colidiu = true;

    }



    return colidiu;
}


    private void setaTecla(int tecla, boolean pressionada) {

        switch (tecla) {

            case KeyEvent.VK_ESCAPE:

                // Tecla ESC
                jogando = false;
                dispose();
                break;

            case KeyEvent.VK_SPACE:

                // Seta para cima
                controleTecla[0] = pressionada;
                break;

            case KeyEvent.VK_DOWN:

                // Seta para baixo
                controleTecla[1] = pressionada;
                break;

            case KeyEvent.VK_LEFT:

                // Seta para esquerda
                controleTecla[2] = pressionada;
                break;

            case KeyEvent.VK_RIGHT:

                // Seta para direita
                controleTecla[3] = pressionada;
                break;
        }
    }

        private void atualizaJogo() {

        //movimento do cano
            if(posicaoY >= tela.getHeight())
            {
                posicaoY = 0;
            }
            else {
                posicaoY += gravidade;
            }
            if( posicaoXInimigo <= 0){
                posicaoXInimigo = tela.getWidth();
               tamanhoRandomico = ((int) (Math.random() * ((400 - 100) - 1) + 100));
                posicaoYinimigo2 = tamanhoRandomico + 100;
                pontos+= 10;

            } else {

                if (pontos < 8)
                    velocidadeInimigo = 8;
                if (pontos == 10)
                    velocidadeInimigo = 10;
                if (pontos >= 30)
                    velocidadeInimigo = 12;
                if (pontos >= 70)
                    velocidadeInimigo = 15;
                if (pontos >= 90)
                    velocidadeInimigo = 17;
                if (pontos>= 110)
                    velocidadeInimigo = 20;
                if (pontos>=  150)
                    velocidadeInimigo = 23;
                if (pontos >= 200)
                    velocidadeInimigo = 29;


                posicaoXInimigo -= velocidadeInimigo ;

            }

            // movimento da nuvem

            if (posicaoXnuvem > -100){

                posicaoXnuvem -= 1;
            }
            else {
                posicaoXnuvem = 640;
            }



            if (controleTecla[0]) {
                posicaoY -= 30;
            }

            else if (controleTecla[1]) {
            }


            if (controleTecla[2]) {
            } else if (controleTecla[3]) {
            }

        }

public void carregaSom() throws Exception {



}


        public void inicia() {

            long prxAtualizacao = 0;



            while (jogando) {

                if (System.currentTimeMillis() >= prxAtualizacao) {
                    atualizaJogo();
                    tela.repaint();
                    prxAtualizacao = System.currentTimeMillis() + FPS;
                }
                if(colisao()) {

                    System.out.println("perdeu");
                }
                mudarCor();

            }
        }


    public static void main(String[] args) {
        Main jogo = new Main();
        jogo.inicia();
    }

    }


