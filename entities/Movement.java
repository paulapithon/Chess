public class Movement {

    private int fromX;
    private int toX;
    private int fromY;
    private int toY;

    public Movement(int fromX, int toX, int fromY, int toY) {
        this.fromX = fromX;
        this.toX = toX;
        this.fromY = fromY;
        this.toY = toY;
    }

    /**
     * @return the fromX
     */
    public int getFromX() {
        return fromX;
    }

    /**
     * @return the fromY
     */
    public int getFromY() {
        return fromY;
    }

    /**
     * @return the toX
     */
    public int getToX() {
        return toX;
    }

    /**
     * @return the toY
     */
    public int getToY() {
        return toY;
    }

}