public class GameMap {

    private Integer height;
    private Integer width;

    public GameMap() {
        this.height = 10;
        this.width = 10;
    }

    public boolean checkIfOutOfMap(int xPosition, int yPosition) {
        return xPosition <= 0 || xPosition >= width || yPosition <= 0 || yPosition >= height;
    }
}
