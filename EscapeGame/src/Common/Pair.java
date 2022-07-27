package Common;

public class Pair <T, K> {

    private T item1;
    private K item2;

    public Pair() {
        item1 = null;
        item2 = null;
    }

    public Pair (T item1, K item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    //region Getters

    public T getItem1() { return item1; }
    public K getItem2() { return item2; }

    //endregion

    //region Setters

    public void setItem1(T item1) { this.item1 = item1; }
    public void setItem2(K item2) { this.item2 = item2; }

    //endregion

}
