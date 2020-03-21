package com.example.jogodenave;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Impossible extends SurfaceView implements Runnable {
    SurfaceHolder holder;
    Paint paint;
    private int playerX = 300, playerY = 300;
    private int enemyX = 100 , enemyY = 100;
    private float playerRadius = 50, enemyRadius = 1;
    private double distance;
    private boolean gameOver;
    private int score = 0;
    boolean running = false;
    Thread renderThread = null;

    public Impossible(Context context) {
        super(context);
        paint = new Paint();
        holder = getHolder();
    }

    @Override
    public void run() {

        while(running){
            // verifica se a tela já está pronta
            if (!holder.getSurface().isValid())
                continue;
            // bloqueia o canvas
            Canvas canvas = holder.lockCanvas();
            // limpa a tela
            canvas.drawColor(Color.BLACK);
            // background
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sky), 0, 0, null );

            // desenha player
            drawPlayers(canvas);
            // desenha inimigo
            drawEnemy(canvas);
            // detecta colisão
            checkCollision(canvas);
            // checa se o jogo terminou
            if(gameOver){
                stopGame(canvas);
                holder.unlockCanvasAndPost(canvas);
                break;
            }
            // desenha o score
            drawScore(canvas);
            // desenha os botões
            drawButtons(canvas);
            // desbloqueia o canvas
            holder.unlockCanvasAndPost(canvas);


        }

    }

    public void resume(){

        running = true;
        renderThread = new Thread(this);
        renderThread.start();


    }

    public void drawPlayers(Canvas canvas){
    //paint.setColor(Color.GREEN);
    //canvas.drawCircle(playerX, playerY, playerRadius, paint);
    canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.nave), playerX -50, playerY-50, null);

    }

    public void moveDown (int pixels){
        playerY += pixels;
    }

    private void drawEnemy(Canvas canvas){
        paint.setColor(Color.RED);
        enemyRadius++;
        canvas.drawCircle(enemyX, enemyY, enemyRadius, paint);

    }

    private void checkCollision(Canvas canvas){
     // calcula a hipotenusa
        distance = Math.pow(playerY - enemyY, 2) +
                   Math.pow(playerX - enemyX, 2);
        distance = Math.sqrt(distance);
     // verifica distancia entre os raios
        if (distance <= playerRadius + enemyRadius){
            gameOver = true;
        }
    }

    private void stopGame(Canvas canvas){
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.LTGRAY);
        paint.setTextSize(100);
        canvas.drawText("Game Over!", (110), (getHeight()/2), paint);

    }

    public void addScore(int points){
    score += points;
   }

   private void drawScore(Canvas canvas){
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        paint.setTextSize(50);
        canvas.drawText(String.valueOf(score), 50, 200, paint);
   }

   private void drawButtons(Canvas canvas){
        //botão restart
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(30);
        paint.setColor(Color.WHITE);
        canvas.drawText("Restart", 50, 300, paint);
        //botão exit
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(30);
        paint.setColor(Color.WHITE);
        canvas.drawText("Exit", 50, 500, paint);

   }

   public void init(){
        enemyX = enemyY = 0;
        enemyRadius = 0;
        playerX = playerY = 300;
        playerRadius = 50;
        score = 0;
        gameOver = false;
   }

}
