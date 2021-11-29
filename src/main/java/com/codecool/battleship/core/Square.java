class Square {

    public enum SquareStatus {
        EMPTY, SHIP, HIT, MISSED;
    }

    private final int x;
    private final int y;
    private SquareStatus status;

    public Square(x, y) {
        this.x = x;
        this.y = y;
        status = SquareStatus.EMPTY;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return status;
    }
}