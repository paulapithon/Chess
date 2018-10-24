public class Parser {

    /**
     * Parse user input from a string
     * @param movementString text inputed by player
     * @return movement object with origin and destination positions
     */
    public static Movement parseInput(String movementString) {
        //Check if string first mathes pattern
        if (!movementString.matches("[a-hA-H][1-8]\\s[a-hA-H][1-8]")) { 
            return null; 
        }
        //Convert chars to matrix positions
        String[] moves = movementString.split(" ");
        //Convert letters
        int fromX = getInt(moves[0].charAt(0));
        int fromY = getInt(moves[1].charAt(0));
        //Convert numbers
        int toX = Character.getNumericValue(moves[0].charAt(1)) - 1;
        int toY = Character.getNumericValue(moves[1].charAt(1)) - 1;
        //Create movement object with positions
        return new Movement(fromX, toX, fromY, toY);
    }

    /**
     * Get integer value for letter characters
     * @param char that represents a position on the board
     */
    private static int getInt(char position) {
        position = Character.toLowerCase(position);
        System.out.println(position);
        switch(position) {
            case 'a': return 0;
            case 'b': return 1;
            case 'c': return 2;
            case 'd': return 3;
            case 'e': return 4;
            case 'f': return 5;
            case 'g': return 6;
            case 'h': return 7;
            default: return 0;
        }
    }
}