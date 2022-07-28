package UI.Game;

import Common.Common;
import Common.Pair;
import Game.EscapeGame;
import Game.Vertex;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {

    private final int DEFAULT_PANEL_WIDTH = 800;
    private final int DEFAULT_PANEL_HEIGHT = 800;

    private final double BOARD_IMG_WIDTH_FACTOR = 3.0 / 4.0;
    private final double BOARD_IMG_HEIGHT_FACTOR = 3.0 / 4.0;

    private final int HEX_TILE_RADIUS_PX = 60;
    private final int AXIS_OFFSET_DEG = 60;

    private final EscapeGame game;
    private BufferedImage boardImage;
    private BufferedImage boardColorImage;
    private BufferedImage boardPiecesImage;

    private int currentPanelWidth;
    private int currentPanelHeight;

    private int currentBoardImageWidth;
    private int currentBoardImageHeight;

    public GamePanel(EscapeGame game) {

        this.game = game;

        resizePanel(DEFAULT_PANEL_WIDTH, DEFAULT_PANEL_HEIGHT);

        setBorder(new BevelBorder(1));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("Arial", Font.PLAIN, 10));

        int centerX = boardImage.getWidth() / 2;
        int centerY = boardImage.getHeight() / 2;

        System.out.println("Center: (" + centerX + "," + centerY + ")");

        Vertex[][][] vertices = game.getBoard().getBoardArr();

        int centerIndex = vertices.length / 2;

        Graphics2D biGraphics = boardImage.createGraphics();

        for (int x = 0; x < vertices.length; x++) {
            for (int y = 0; y < vertices[x].length; y++) {
                for(int z = 0; z < vertices[x][y].length; z++) {

                    try {
                        Vertex currVertex  = vertices[x][y][z];

                        double startX = centerX + ((x - centerIndex) * HEX_TILE_RADIUS_PX);
                        startX += ((y - centerIndex) * HEX_TILE_RADIUS_PX) * Math.cos(Math.toRadians(AXIS_OFFSET_DEG));
                        startX += ((z - centerIndex) * HEX_TILE_RADIUS_PX) * Math.cos(Math.toRadians(2 * AXIS_OFFSET_DEG));

                        double startY = centerY + (((y - centerIndex) * HEX_TILE_RADIUS_PX) * Math.sin(Math.toRadians(AXIS_OFFSET_DEG)));
                        startY += ((z - centerIndex) * HEX_TILE_RADIUS_PX) * Math.sin(Math.toRadians(2 * AXIS_OFFSET_DEG));

                        // Create hexagon edges and background color hexagons
                        Pair<Double, Double>[] endCords = new Pair[6];
                        int[] backCordsX = new int[6];
                        int[] backCordsY = new int[6];
                        for (int i = 0; i < endCords.length; i++) {

                            double cosVal = Math.cos(Math.toRadians(i * AXIS_OFFSET_DEG));
                            double sinVal = Math.sin(Math.toRadians(i * AXIS_OFFSET_DEG));

                            endCords[i] = new Pair<>(startX + (HEX_TILE_RADIUS_PX * cosVal), startY + (HEX_TILE_RADIUS_PX * sinVal));
                            backCordsX[i] = (int) (startX + (HEX_TILE_RADIUS_PX / 2) * cosVal);
                            backCordsY[i] = (int) (startY + (HEX_TILE_RADIUS_PX / 2) * sinVal);

                        }

                        g2.drawString(currVertex.getX() + "," + currVertex.getY() + "," + currVertex.getZ(), (int) (startX + 20), (int) (startY + 10));

                        g2.setColor(vertexTypeToColor(currVertex.getType()));
                        //g2.fillPolygon(backCordsX, backCordsY, 6);

                        g2.setColor(Color.BLACK);
                        g2.setStroke(new BasicStroke(1));
                        for(int i = 0; i < endCords.length; i++) {

                            // skip drawing certain points on edge
                            if (x == 0 && (i == 2 || i == 3 || i == 4)) continue;
                            if (x == vertices.length - 1 && (i == 0 || i == 1 || i == 5)) continue;

                            if ((y == 0 && z == 0) && (i == 1 || i == 2)) continue;
                            if ((y == vertices.length - 1  && z == vertices.length - 1) && (i == 0 || i == 1 || i == 2)) continue;

                            g.drawLine((int) startX, (int) startY, endCords[i].getItem1().intValue(), endCords[i].getItem2().intValue());
                        }

                    } catch (NullPointerException ex) {
                        System.out.println("(" + x + "," + y + "," + z +")\n" + ex.getMessage());
                    }

                }

            }

        }

        g2.setColor(Color.GREEN);
        g2.fillOval(centerX, centerY, 10, 10);

        //g.drawImage(boardImage, 0, 0, boardImage.getWidth(), boardImage.getHeight(), null);
    }

    public Color vertexTypeToColor(Common.VERTEX_TYPE type) {

        switch (type) {

            case PLAIN:
                return Color.BLUE;
            case FORT:
                return Color.GREEN;
            case KING_ESCAPE:
            case KING_START:
                return Color.YELLOW;
        }

        return Color.BLACK;

    }

    public void resizePanel(int frameWidth, int frameHeight) {

        currentPanelWidth = frameWidth;
        currentPanelHeight = frameHeight;

        setPreferredSize(new Dimension(currentPanelWidth, currentPanelHeight));

        currentBoardImageWidth = (int) (currentPanelWidth * BOARD_IMG_WIDTH_FACTOR);
        currentBoardImageHeight = (int) (currentPanelHeight * BOARD_IMG_HEIGHT_FACTOR);

        boardImage = new BufferedImage(currentBoardImageWidth, currentBoardImageHeight, BufferedImage.TYPE_4BYTE_ABGR);
        boardColorImage = new BufferedImage(currentBoardImageWidth, currentBoardImageWidth, BufferedImage.TYPE_4BYTE_ABGR);
        boardPiecesImage = new BufferedImage(currentBoardImageWidth, currentBoardImageWidth, BufferedImage.TYPE_4BYTE_ABGR);

    }

}
