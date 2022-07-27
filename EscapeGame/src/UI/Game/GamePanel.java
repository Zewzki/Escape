package UI.Game;

import Game.EscapeGame;
import Game.Vertex;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {

    private final int HEX_TILE_RADIUS_PX = 75;

    private final EscapeGame game;

    private BufferedImage boardImage;

    public GamePanel(EscapeGame game) {

        this.game = game;
        this.boardImage = new BufferedImage(1920, 1080, BufferedImage.TYPE_3BYTE_BGR);

    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);

        int centerX = boardImage.getWidth() / 2;
        int centerY = boardImage.getHeight() / 2;

        Vertex[][][] vertices = game.getBoard().getBoardArr();

        int centerIndex = vertices.length / 2;

        for (int x = 0; x < vertices.length; x++) {
            for (int y = 0; y < vertices[x].length; y++) {
                for(int z = 0; z < vertices[x][y].length; z++) {

                    int startX = centerX + ((x - centerIndex) * HEX_TILE_RADIUS_PX);
                    startX += ((y - centerIndex) * HEX_TILE_RADIUS_PX);

                    // TODO: finish this part

                }

            }

        }


    }
}
