package UI.Game;

import Common.Pair;
import Game.EscapeGame;
import Game.Vertex;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {

    private final int DEFAULT_PANEL_WIDTH = 800;
    private final int DEFAULT_PANEL_HEIGHT = 800;

    private final int HEX_TILE_RADIUS_PX = 75;
    private final int AXIS_OFFSET_DEG = 60;

    private final EscapeGame game;

    private BufferedImage boardImage;

    public GamePanel(EscapeGame game) {

        this.game = game;
        this.boardImage = new BufferedImage(DEFAULT_PANEL_WIDTH, DEFAULT_PANEL_HEIGHT, BufferedImage.TYPE_INT_RGB);

        setPreferredSize(new Dimension(DEFAULT_PANEL_WIDTH, DEFAULT_PANEL_HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int centerX = boardImage.getWidth() / 2;
        int centerY = boardImage.getHeight() / 2;

        System.out.println("Center: (" + centerX + "," + centerY + ")");

        Vertex[][][] vertices = game.getBoard().getBoardArr();

        int centerIndex = vertices.length / 2;

        Graphics2D biGraphics = boardImage.createGraphics();

        biGraphics.setColor(Color.BLACK);

        for (int x = 0; x < vertices.length; x++) {
            for (int y = 0; y < vertices[x].length; y++) {
                for(int z = 0; z < vertices[x][y].length; z++) {

                    double startX = centerX + ((x - centerIndex) * HEX_TILE_RADIUS_PX);
                    startX += ((y - centerIndex) * HEX_TILE_RADIUS_PX) * Math.cos(Math.toRadians(AXIS_OFFSET_DEG));
                    startX += ((z - centerIndex) * HEX_TILE_RADIUS_PX) * Math.cos(Math.toRadians(2 * AXIS_OFFSET_DEG));

                    double startY = centerY + (((y - centerIndex) * HEX_TILE_RADIUS_PX) * Math.sin(Math.toRadians(AXIS_OFFSET_DEG)));
                    startY += ((z - centerIndex) * HEX_TILE_RADIUS_PX) * Math.sin(Math.toRadians(2 * AXIS_OFFSET_DEG));


                    Pair<Double, Double>[] endCords = new Pair[6];
                    for (int i = 0; i < endCords.length; i++) {
                        endCords[i] = new Pair<>(startX + (HEX_TILE_RADIUS_PX * Math.cos(Math.toRadians(i * AXIS_OFFSET_DEG))), startY + (HEX_TILE_RADIUS_PX * Math.sin(Math.toRadians(i * AXIS_OFFSET_DEG))));
                    }

                    g.fillOval((int) startX, (int) startX, 1, 1);

                    for(int i = 0; i < endCords.length; i++) {
                        g.drawLine((int) startX, (int) startY, endCords[i].getItem1().intValue(), endCords[i].getItem2().intValue());
                    }

                }

            }

        }

        //g.drawImage(boardImage, 0, 0, boardImage.getWidth(), boardImage.getHeight(), null);

    }
}
