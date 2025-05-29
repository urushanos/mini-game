package test_game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputs implements KeyListener{

    public boolean uppress, downpress, leftpress, rightpress;

    @Override
    public void keyTyped(KeyEvent e) {  
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode();

        if(code== KeyEvent.VK_W || code==KeyEvent.VK_UP)
        {
            uppress =true;
        }

        if(code== KeyEvent.VK_S || code== KeyEvent.VK_DOWN)
        {
            downpress =true;
        }
        if(code== KeyEvent.VK_A || code== KeyEvent.VK_LEFT)
        {
            leftpress =true;
        }
        if(code== KeyEvent.VK_D || code== KeyEvent.VK_RIGHT)
        {
            rightpress =true;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode();

        if(code== KeyEvent.VK_W || code==KeyEvent.VK_UP)
        {
            uppress =false;
        }

        if(code== KeyEvent.VK_S|| code== KeyEvent.VK_DOWN)
        {
            downpress =false;
        }
        if(code== KeyEvent.VK_A || code== KeyEvent.VK_LEFT)
        {
            leftpress =false;
        }
        if(code== KeyEvent.VK_D || code== KeyEvent.VK_RIGHT)
        {
            rightpress =false;
        }
    }
    
}
