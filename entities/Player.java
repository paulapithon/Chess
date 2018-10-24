public class Player {

    private Color color;
    private String name;

    public Player (Color color, String name) {
        this.color = color;
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }
}