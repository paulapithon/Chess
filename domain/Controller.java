public class Controller {

    /**
     * Board containing all the pieces of the game
     */
    private static Board board;

    /**
     * Player with white pieces and player with the black pieces, 
     * as well as whos is currently playing
     */
    private static Player currentPlayer;
    private static Player playerOne;
    private static Player playerTwo;

    /**
     * Initialize game variables
     */
    public static void initGame(String firstName, String secondName) {
        //Initialize both players
        playerOne = new Player(Color.WHITE, firstName);
        playerTwo = new Player(Color.BLACK, secondName);
        //Initialize board
        board = new Board();
        board.initBoard();
        //Set initial player as white
        currentPlayer = playerOne;
    }

    /**
     * Switch current player
     */
    public static void switchPlayers() {
        player = player == playerOne ? playerTwo : playerOne;
    }

    /**
     * Check if movement is valid and move piece on the board
     */
    public static Play movePiece(Movement movement) {
        Play result = board.movePiece(movement, currentPlayer.getColor());
        switch(result) {
            case SUCCESS:
                Controller.switchPlayers();
                break;
            case CAPTURED:
                Controller.switchPlayers();
            case CHECK:
                Controller.switchPlayers();
                break;
            default: break;
        }
        return result;
    }

    /**
     * @return the board
     */
    public static Board getBoard() {
        return board;
    }

    /**
     * @return the player
     */
    public static Player getCurrentPlayer() {
        return currentPlayer;
    }
}