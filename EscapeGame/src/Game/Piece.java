package Game;

import Common.Common;

public class Piece {

    private final Common.PIECE_TYPE type;

    public Piece(Common.PIECE_TYPE type) {
        this.type = type;
    }

    public Common.PIECE_TYPE getType() { return type; }

}
