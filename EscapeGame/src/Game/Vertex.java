package Game;

import Common.Common;

public class Vertex {

    private final Common.VERTEX_TYPE type;
    private final int x, y, z;

    public Vertex(int x, int y, int z, Common.VERTEX_TYPE type) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.type = type;
    }

    //region Getters
    public Common.VERTEX_TYPE getType() { return type; }
    public int getX() { return x; }
    public int getY() { return y; }
    public int getZ() { return z; }
    //endregion

}
