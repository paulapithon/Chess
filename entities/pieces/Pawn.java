public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
    }

    public String toString() {
        return color == Color.WHITE ? "P" : "p";
    }

    public boolean validateMovement(Movement movement) {
        int xMove = Math.abs(movement.getFromX() - movement.getToX());
        int yMove = Math.abs(movement.getFromY() - movement.getToY());
        if (xMove == 0 && yMove == 1) {
            return true;
        } else {
            return false;
        }
    }
    
}