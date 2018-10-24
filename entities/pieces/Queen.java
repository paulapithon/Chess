public class Queen extends Piece {

    public Queen(Color color) {
        super(color);
    }

    public String toString() {
        return color == Color.WHITE ? "Q" : "q";
    }

    public boolean validateMovement(Movement movement) {
        int xMove = Math.abs(movement.getFromX() - movement.getToX());
        int yMove = Math.abs(movement.getFromY() - movement.getToY());
        if ((xMove > 0 && yMove > 0 && xMove == yMove) || (xMove == 0 && yMove > 0) || (xMove > 0 && yMove == 0)) {
            return true;
        } else {
            return false;
        }
    }
    
}