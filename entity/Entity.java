package entity;

import java.awt.image.BufferedImage;

public class Entity {
    
    public int x, y;
    public int speed;
    
    public BufferedImage up1, left1, right1, down1, up2, left2, right2, down2; 
    public String direction;

    public int spriteCounter= 0;
    public int spritenum= 1;
}
