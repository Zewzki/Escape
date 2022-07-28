package Game;

import Common.Common;

public class Board {

    private final int diameter;
    private final int radius;

    private Vertex[][][] boardArr;

    public Board(int diameter) {

        this.diameter = diameter;
        radius = diameter / 2;
        boardArr = new Vertex[this.diameter][this.diameter][this.diameter];

        for(int i = 0; i < this.diameter; i++) {
            for(int j = 0; j < this.diameter; j++) {
                for(int k = 0; k < this.diameter; k++) {

                    Common.VERTEX_TYPE vType = Common.VERTEX_TYPE.PLAIN;

                    int polarX = i - radius;
                    int polarY = j - radius;
                    int polarZ = k - radius;

                    if (polarX == 0 && polarY == 0 && polarZ == 0) {
                        vType = Common.VERTEX_TYPE.KING_START;
                        System.out.println(i + "," + j + "," + k);
                    }

                    boardArr[i][j][k] = new Vertex(i - radius, j - radius, k - radius, vType);

                }
            }
        }

    }

    //region Getters

    public Vertex[][][] getBoardArr() { return boardArr; }

    public Vertex getVertex(int polarX, int polarY, int polarZ) { return boardArr[polarX + radius][polarY + radius][polarZ + radius]; }

    public int getDiameter() { return diameter; }
    public int getRadius() { return radius; }

    //endregion

}
