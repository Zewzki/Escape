package Common;

import java.awt.*;

public class Common {

    public static int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public enum GAME_STATE {
        PLAYER1TURN,
        PLAYER2TURN
    }

    public enum PIECE_TYPE {
        RED_PAWN,
        BLUE_PAWN,
        KING
    }

    public enum VERTEX_TYPE {
        KING_START,
        KING_ESCAPE,
        FORT,
        PLAIN
    }

}
