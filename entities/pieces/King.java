public class King extends Piece {

    public King(Color color) {
        super(color);
    }

    public String toString() {
        return color == Color.WHITE ? "K" : "k";
    }

    public boolean validateMovement(Movement movement) {
        int xMove = Math.abs(movement.getFromX() - movement.getToX());
        int yMove = Math.abs(movement.getFromY() - movement.getToY());
        if ((xMove <= 1 && yMove == 1) && (xMove == 1 && yMove <= 1)) {
            return true;
        } else {
            return false;
        }
    }
    
}