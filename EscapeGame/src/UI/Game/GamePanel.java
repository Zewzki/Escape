package UI.Game;

import Game.EscapeGame;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {

    private final EscapeGame game;

    private BufferedImage boardImage;

    public GamePanel(EscapeGame game) {

        this.game = game;

    }

}
