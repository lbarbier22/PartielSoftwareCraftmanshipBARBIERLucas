import java.util.Random;

public class Loot {
    private String type;
    Integer xPosition;
    Integer yPosition;

    public Loot(String type, Integer xPosition, Integer yPosition) {
        this.type = type;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public String getType() {
        return type;
    }
}
