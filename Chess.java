import java.util.Scanner;

public class Chess {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        readPlayerInput(scanner);
        readGameInput(scanner);
        scanner.close();
    }

    /**
     * Read player names and save on game controller
     */
    private static void readPlayerInput(Scanner scanner) {
        //Read player names
        System.out.print("Player one, type your name: ");
        String firstName = scanner.nextLine();
        System.out.print("Player two, type your name: ");
        String secondName = scanner.nextLine();
        //Initialize game with input
        Controller.initGame(firstName, secondName);
    }

    /**
     * Read user input as each movement
     */
    private static void readGameInput(Scanner scanner) {
        Board board = Controller.getBoard();
        //Print board
        printBoard(board);
        //Loop until a player wins
        scanLoop: while (true) {
            System.out.print(Controller.getCurrentPlayer().getName() + ", insert your move (i.e. B2 C4): ");
            //Scan player input
            String movementString = scanner.nextLine();
            //Parse string to movement object
            Movement movement = Parser.parseInput(movementString);
            //Check if movement mathes pattern
            if (movement != null) {
                printBoard(board);
                //Move piece on board base on movement parsed
                switch(Controller.movePiece(movement)) {
                    case CAPTURED:
                        System.out.print("Captured! ");
                    case FAIL:
                        System.out.print("You can't move that piece there. ");
                        break;
                    case CHECK:
                        System.out.print("Check... ");
                        break;
                    case CHECKMATE:
                        System.out.println("Checkmate! " + Controller.getCurrentPlayer().getName() + ", you won!");
                        break scanLoop;
                    default: break;
                }
            } else {
                System.out.print("Invalid movement! ");
            }
        }
    }

    /**
     * Print board on the console format
     */
    private static void printBoard(Board board) {
        Piece[][] pieces = Controller.getBoard().getPieces();
        StringBuilder boardPrint = new StringBuilder();
        //Add letters to each column
        String letters = "    A  B  C  D  E  F  G  H    ";
        boardPrint.append("\n");
        boardPrint.append(letters);
        boardPrint.append("\n\n");
        //Iterate on row
        for (int x = 0; x < pieces.length; x++) {
            //Add numbers to the beggining of line
            boardPrint.append(x + 1);
            boardPrint.append("  ");
            //Iterate on column
            for (int y = 0; y < pieces[x].length; y++) {
                boardPrint.append(" ");
                //If board piece is not null, print it's string value
                if (pieces[x][y] != null) {
                    boardPrint.append(pieces[x][y].toString());
                } else {
                    boardPrint.append("-");
                }
                boardPrint.append(" ");
            }
            boardPrint.append("  ");
            boardPrint.append(x + 1);
            boardPrint.append("\n\n");
        }
        boardPrint.append(letters);
        boardPrint.append("\n");
        //Print board string builder on console
        System.out.println(boardPrint);
    }

}