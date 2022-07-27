package UI.Game;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private final int SCREEN_WIDTH;
    private final int SCREEN_HEIGHT;

    private int frameWidth;
    private int frameHeight;
    private GamePanel panel;

    public GameFrame(GamePanel panel) {

        SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
        SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.panel = panel;

        frameWidth = (int) (SCREEN_WIDTH * (3.0 / 4.0));
        frameHeight = (int) (SCREEN_HEIGHT * (3.0 / 4.0));

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(this.panel, gbc);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(frameWidth, frameHeight);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
