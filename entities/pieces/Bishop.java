
public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color);
    }

    public String toString() {
        return color == Color.WHITE ? "B" : "b";
    }

    public boolean validateMovement(Movement movement) {
        int xMove = Math.abs(movement.getFromX() - movement.getToX());
        int yMove = Math.abs(movement.getFromY() - movement.getToY());
        if (xMove > 0 && yMove > 0 && xMove == yMove) {
            return true;
        } else {
            return false;
        }
    }
    
}