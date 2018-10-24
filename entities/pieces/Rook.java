public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
    }

    public String toString() {
        return color == Color.WHITE ? "R" : "r";
    }

    public boolean validateMovement(Movement movement) {
        int xMove = Math.abs(movement.getFromX() - movement.getToX());
        int yMove = Math.abs(movement.getFromY() - movement.getToY());

        System.out.println(xMove + " " + yMove);
        if ((xMove > 0 && yMove == 0) || (xMove == 0 && yMove > 0)) {
            return true;
        } else {
            return false;
        }
    }
    
}