package test_game;

import javax.swing.JFrame;

public class game {
    public static void main(String[] args) {
        
        JFrame game= new JFrame();
        Gamepanel p = new Gamepanel();

        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setResizable(false);
        game.setTitle("Kitty Game");

        game.add(p);
        game.pack();

        game.setLocationRelativeTo(null);
        game.setVisible(true);

        p.startthread();
    }
    
}
