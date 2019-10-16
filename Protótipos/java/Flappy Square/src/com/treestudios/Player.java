package com.treestudios;

import java.awt.*;

public class Player extends Sprite {


    public Color mudarCor(Color cor)
    {
        int controle = 0;
        Color cor_atual;
        if(controle <= 255) {
            cor_atual = new Color(controle, 41, 240);
            cor = cor_atual;
            controle++;
        }
        if (controle > 255)
        {
            controle = 0 ;
        }

        return cor;
        /**
         //trocando de cores
         if(controle<=3){
         switch (controle){
         case 0:
         cor_principal = rosa;
         case 1:
         cor_principal = roxo;
         case 2:
         cor_principal = roxo2;
         case 3:
         cor_principal = azul;
         }
         controle ++;
         if(controle>3){
         cor_principal = amarelo;
         controle= 0;
         }
         }
         **/
    }





}
