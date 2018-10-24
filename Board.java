public class Board {

    /**
     * Board matrix containing all pieces
     */
    private Piece[][] pieces = new Piece[8][8];

    /**
     * Initialize board with correct pieces
     */
    public void initBoard() {
        //Initialize white colors on up row
        Rook rook = new Rook(Color.WHITE);
        pieces[0][0] = rook;
        Bishop bishop = new Bishop(Color.WHITE);
        pieces[0][1] = bishop;
        Knight horse = new Knight(Color.WHITE);
        pieces[0][2] = horse;
        King king = new King(Color.WHITE);
        pieces[0][3] = king;
        Queen queen = new Queen(Color.WHITE);
        pieces[0][4] = queen;
        //Initialize black colors on down row
        Rook rook2 = new Rook(Color.BLACK);
        pieces[7][0] = rook2;
        Bishop bishop2 = new Bishop(Color.BLACK);
        pieces[7][1] = bishop2;
        Knight horse2 = new Knight(Color.BLACK);
        pieces[7][2] = horse2;
        King king2 = new King(Color.BLACK);
        pieces[7][3] = king2;
        Queen queen2 = new Queen(Color.BLACK);
        pieces[7][4] = queen2;
    }

    /**
     * Validate if movement is possible and perform it
     * @param movement performed by player
     * @param playerColor color of the current player
     * @return if the play succeeded or not, if it was a capture or a checkmate
     */
    public Play movePiece(Movement movement, Color playerColor) {
        Piece piece = pieces[movement.getFromX()][movement.getFromY()];
        //Check if there is a piece on that square
        if(piece == null) { return Play.FAIL; }
        //Check if piece color is the same as players
        if (piece.getColor() != playerColor) { return Play.FAIL; }
        //Check if piece can perform movement
        if (piece.validateMovement(movement)){
            Piece captured = pieces[movement.getToX()][movement.getToY()];
            //Replace initial piece
            pieces[movement.getFromX()][movement.getFromY()] = null;
            pieces[movement.getToX()][movement.getToY()] = piece;
            //Check if there was another piece in square
            if (captured != null) {
                //Check if piece is a different color and user can capture ir
                if (captured.getColor() == playerColor) { return Play.FAIL; }
                //If piece was a king, checkmate!
                if (captured instanceof King) {
                    return Play.CHECKMATE;
                } else {
                    return Play.CAPTURED;
                }
            } else {
                return Play.SUCCESS;
            }
        } else {
            return Play.FAIL;
        }
    }

    /**
     * @return the pieces
     */
    public Piece[][] getPieces() {
        return pieces;
    }
}