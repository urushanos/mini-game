//chatgpt version
package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import test_game.Gamepanel;

public class TileManager {
    Gamepanel gp;
    Tile[] tile;
    int[][] MapTileNum;

    public TileManager(Gamepanel gp) {
        this.gp = gp;

       // int tileRows = gp.Height / gp.tilesize;  // Number of tiles vertically
       // int tileCols = gp.Width / gp.tilesize;   // Number of tiles horizontally
       //gp.screencols and gp.screenrows

        tile = new Tile[10]; 
        MapTileNum = new int[gp.screenrows][gp.screencols]; // Properly sized array

        getTileImage();
        loadMap("/res/maps/map1.txt");
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/bg.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/bg2.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/path.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath) {
        try {
            InputStream inputStream = getClass().getResourceAsStream(filePath);
            if (inputStream == null) {
                System.out.println("Map file not found: " + filePath);
                return;
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            int row = 0;
            String line;
            while ((line = br.readLine()) != null && row < MapTileNum.length) {
                String[] numbers = line.split(" ");
                
                for (int col = 0; col < numbers.length && col < MapTileNum[row].length; col++) {
                    MapTileNum[row][col] = Integer.parseInt(numbers[col]);
                }
                row++;
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        //int tileRows = gp.Height / gp.tilesize;
        //int tileCols = gp.Width / gp.tilesize;

        for (int row = 0; row < gp.screenrows; row++) {
            for (int col = 0; col < gp.screencols; col++) {
                int tileNum = MapTileNum[row][col];
                int x = col * gp.tilesize;
                int y = row * gp.tilesize;
                g2.drawImage(tile[tileNum].image, x, y, gp.tilesize, gp.tilesize, null);
            }
        }
    }
}
