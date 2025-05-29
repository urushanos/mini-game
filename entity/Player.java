//git commit trial
package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import test_game.Gamepanel;
import test_game.KeyInputs;

public class Player extends Entity{
    
    Gamepanel gp;
    KeyInputs keyp;

    public Player(Gamepanel GP, KeyInputs keyp){
        this.gp=GP;
        this.keyp= keyp;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        //declared in Entity class
        x=100;
        y=100;
        speed= 3;
        direction= "left";
    }

    public void getPlayerImage(){

        try{

            up1= ImageIO.read(getClass().getResourceAsStream("/res/player/back_left.png"));
            up2= ImageIO.read(getClass().getResourceAsStream("/res/player/back2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/right1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/right2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/right2.png"));

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void update(){

    //if(keyp.downpress==true||keyp.uppress==true||keyp.leftpress==true||keyp.rightpress==true){

        if(keyp.uppress== true){
            direction="up";
            y -=speed;
        }

        else if(keyp.downpress== true){
            direction= "down";
            y +=speed;
        }

        else if(keyp.leftpress== true){
            direction= "left";
            x -=speed;
        }

        else if(keyp.rightpress== true){
            direction= "right";
            x +=speed;
        }

        //60fps no, so image changes every 10 frames
        spriteCounter++;
        if(spriteCounter>15){
            if(spritenum ==1){
                spritenum =2;
            }
            else if(spritenum ==2){
                spritenum =1;
            }
            spriteCounter=0;
        }
        
   // }
    }

    public void draw(Graphics2D g2){

       // g2.setColor(Color.white);
       // g2.fillRect(x, y, gp.tilesize, gp.tilesize);

       BufferedImage image= null;

       switch (direction) {
        case "up":
            if(spritenum==1){
                image= up1;
            }
            if (spritenum ==2){
                image=up2;
            }
            break;

        case "down":
        if(spritenum==1){
            image= down1;
        }
        if (spritenum ==2){
            image=down2;
        }
            break;

        case "left":
        if(spritenum==1){
            image= left1;
        }
        if (spritenum ==2){
            image=left2;
        }
            break; 
            
        case "right":
        if(spritenum==1){
            image= right1;
        }
        if (spritenum ==2){
            image=right2;
        }
            break;
       }

       g2.drawImage(image, x, y, gp.tilesize, gp.tilesize, null);

    }
}
