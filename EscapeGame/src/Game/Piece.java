package Game;

import Common.Enums;

public class Piece {

    private final Enums.PIECE_TYPE type;

    public Piece(Enums.PIECE_TYPE type) {
        this.type = type;
    }

    public Enums.PIECE_TYPE getType() { return type; }

}
