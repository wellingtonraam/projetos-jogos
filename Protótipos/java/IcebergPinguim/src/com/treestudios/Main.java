package com.treestudios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame {
    private JPanel tela;
    private final int FPS = 50;
    private boolean controleTecla[] = new boolean[5]; //5 teclas para configurar
    boolean jogando = true;

    public Main() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                setarTecla(keyEvent.getKeyCode(), true);
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                setarTecla(keyEvent.getKeyCode(), false);
            }
        });

        tela = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                //Desenhar
                g.setColor(Color.white);
                g.fillRect(0, 0, tela.getWidth(), tela.getHeight());

            }
        };

        getContentPane().add(tela);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);

    }

    public void setarTecla(int tecla, boolean pressionada) {switch (tecla) {

        case KeyEvent.VK_ESCAPE:

            jogando = false;
            dispose();
            break;

        case KeyEvent.VK_UP:

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

        case KeyEvent.VK_SPACE:
            controleTecla[4] = pressionada;
    }

    }

    public void atualizarJogo() {
        //controle

        if (controleTecla[0]) {

        }

        else
            if (controleTecla[1]) {
        }


        if (controleTecla[2]) {

        } else
            if (controleTecla[3]) {
        }
        if(controleTecla[4]) {
        } else {

        }
    }

    public void iniciar() {

        long prxAtualizacao = 3;

        while (jogando) {
            if (System.currentTimeMillis() >= prxAtualizacao) {
                atualizarJogo();
                tela.repaint();
                prxAtualizacao = System.currentTimeMillis() + FPS;
            }
        }
    }


        public static void main (String[]args){

            Main jogo = new Main();
            jogo.iniciar();

        }
    }
