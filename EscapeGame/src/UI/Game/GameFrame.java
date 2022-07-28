package UI.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GameFrame extends JFrame {

    private final int screenWidth;
    private final int screenHeight;

    private int frameWidth;
    private int frameHeight;
    private GamePanel panel;

    public GameFrame(GamePanel panel, int sWidth, int sHeight) {

        screenWidth = sWidth;
        screenHeight = sHeight;
        this.panel = panel;

        frameWidth = (int) (screenWidth * (5.0 / 6.0));
        frameHeight = (int) (screenHeight * (5.0 / 6.0));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(frameWidth, frameHeight);
        setResizable(true);
        setLocationRelativeTo(null);

        add(this.panel);

        addComponentListener(new ComponentAdapter()
        {
            public void componentResized(ComponentEvent evt) {
                frameWidth = getWidth();
                frameHeight = getHeight();
                panel.resizePanel(frameWidth, frameHeight);
            }
        });

        setVisible(true);

    }

}
