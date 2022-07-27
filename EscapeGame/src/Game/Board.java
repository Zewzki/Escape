package Game;

import Common.Enums;

public class Board {

    private final int diameter;
    private final int radius;

    private Vertex[][][] boardArr;

    public Board(int diameter) {

        this.diameter = diameter;
        this.radius = diameter / 2;
        boardArr = new Vertex[this.diameter][this.diameter][this.diameter];

        for(int i = 0; i < this.diameter; i++) {
            for(int j = 0; j < this.diameter; j++) {
                for(int k = 0; k < this.diameter; k++) {

                    Enums.VERTEX_TYPE vType = Enums.VERTEX_TYPE.PLAIN;

                    if (i == this.radius + 1 && j == this.radius + 1 && k == this.radius + 1) {
                        vType = Enums.VERTEX_TYPE.KING_START;
                    }
                    else if (i == this.radius + 1 || j == this.radius + 1 || k == this.radius + 1) {

                        if (i == 0 || i == this.diameter - 1) vType = Enums.VERTEX_TYPE.KING_ESCAPE;
                        else if (j == 0 || j == this.diameter - 1) vType = Enums.VERTEX_TYPE.KING_ESCAPE;
                        else if (k == 0 || k == this.diameter - 1) vType = Enums.VERTEX_TYPE.KING_ESCAPE;
                        else if (i == 3 || i == this.diameter - 4) vType = Enums.VERTEX_TYPE.FORT;
                        else if (j == 3 || j == this.diameter - 4) vType = Enums.VERTEX_TYPE.FORT;
                        else if (k == 3 || k == this.diameter - 4) vType = Enums.VERTEX_TYPE.FORT;

                    }

                    boardArr[i][j][k] = new Vertex(i - radius, j - radius, k - radius, vType);

                }
            }
        }

    }

}
