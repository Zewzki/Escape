package Game;

public class EscapeGame {

    private final int ESCAPE_BOARD_DIAM = 15;

    private final Board board;

    public EscapeGame() {

        board = new Board(ESCAPE_BOARD_DIAM);

    }


    //region Getters
    public Board getBoard() { return board; }

    //endregion

}
