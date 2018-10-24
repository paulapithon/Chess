public class Knight extends Piece {

    public Knight(Color color) {
        super(color);
    }

    public String toString() {
        return color == Color.WHITE ? "H" : "h";
    }

    public boolean validateMovement(Movement movement) {
        int xMove = Math.abs(movement.getFromX() - movement.getToX());
        int yMove = Math.abs(movement.getFromY() - movement.getToY());
        if ((xMove == 2 && yMove == 1) || (xMove == 1 && yMove == 2)) {
            return true;
        } else {
            return false;
        }
    }
    
}