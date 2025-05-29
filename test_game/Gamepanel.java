package test_game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class Gamepanel extends JPanel implements Runnable{
    
    final int ogtilesize =16;
    final int scale =3;

   public final int tilesize= ogtilesize*scale; //16*3

    public final int screencols =16;
    public final int screenrows= 12;

   public final int Width= tilesize *screencols;
   public final int Height= tilesize *screenrows;

    int FPS= 60;

    TileManager TileM= new TileManager(this);
    KeyInputs keyp= new KeyInputs();
    Thread gamethread;

    //don't need because declared in player class 
   // int playerX=Width/2;
   // int playerY= Height/2;
   // int playerSpeed= 2;

    Player playboi= new Player(this, keyp);

    public Gamepanel(){

        this.setPreferredSize(new Dimension(Width, Height));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyp);
        this.setFocusable(true);
    }

    public void startthread(){
        gamethread= new Thread(this);
        gamethread.start();
    }

    @Override
    public void run() {

        double drawInterval =1000000000/FPS;
        //draw 0.016667 times per sec 
        double nextdrawTime= System.nanoTime()+ drawInterval;

        while(gamethread != null){

        //long currenttime= System.nanoTime();
        //long currenttime2= System.currentTimeMillis();

        //call update- change info
        //repaint, calls paintcomponent, draws the scene w updated info  

        update();
        repaint();

        try {
            double remainingTime= nextdrawTime - System.nanoTime();
            remainingTime= remainingTime/1000000;

            if(remainingTime<0){
                remainingTime=0;
            }

            Thread.sleep((long)remainingTime);
            nextdrawTime += drawInterval;
        } 
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        }
    }

    public void update(){
        playboi.update();
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        
        Graphics2D g2= (Graphics2D)g;
        //2d has more functions than graphics

        //tiles first, then player, otherwise player gets hidden below tiles
        TileM.draw(g2);
        playboi.draw(g2);

        g2.dispose();

    }
}
