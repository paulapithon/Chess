public abstract class Piece {

    /**
     * Player color
     */
    Color color;

    public Piece(Color color) {
        this.color = color;
    }

    /**
     * Get piece printable version to show on console
     */
    public abstract String toString();

    /**
     * Check if piece can move towards especific spot
     */
    public abstract boolean validateMovement(Movement movement);

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

}