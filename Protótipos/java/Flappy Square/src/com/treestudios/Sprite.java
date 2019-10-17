package com.treestudios;

import java.awt.*;

public class Sprite {

    private int x;
    private int y;
    private int w;//largura
    private int h;//altura

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    //verifica colisão
    public boolean colideCom(Sprite outro) {
        Rectangle r1 = new Rectangle(x,y,w,h);//esse sprite
        Rectangle r2 = new Rectangle(outro.getX(), outro.getY(), outro.getW(), outro.getH());
        if (r1.intersects(r2)) {
            return true;
        }
        return false;
    }

}




































