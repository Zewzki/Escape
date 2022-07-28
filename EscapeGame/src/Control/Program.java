package Control;

import Common.Common;
import Game.EscapeGame;
import UI.Game.GameFrame;
import UI.Game.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Program {

    public static void main(String[] args) {

        EscapeGame game = new EscapeGame();

        GamePanel panel = new GamePanel(game);
        GameFrame frame = new GameFrame(panel, Common.SCREEN_WIDTH, Common.SCREEN_HEIGHT);

        panel.resizePanel(frame.getWidth(), frame.getHeight());

    }

}
