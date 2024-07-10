import java.util.ArrayList;
import java.util.List;

public class Survivor {

    Integer xPosition;
    Integer yPosition;

    String direction;

    Integer health;

    List<Loot> inventory;

    public Survivor(String direction, Integer xPosition, Integer yPosition) {
        this.direction = direction;
        this.health = 10;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.inventory = new ArrayList<>();
    }

    public void moveForward() {
        switch (direction) {
            case "NORTH":
                yPosition++;
                break;
            case "SOUTH":
                yPosition--;
                break;
            case "EAST":
                xPosition++;
                break;
            case "WEST":
                xPosition--;
                break;
        }
    }

    public void turnLeft() {
        switch (direction) {
            case "NORTH":
                direction = "WEST";
                break;
            case "SOUTH":
                direction = "EAST";
                break;
            case "EAST":
                direction = "NORTH";
                break;
            case "WEST":
                direction = "SOUTH";
                break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case "nord":
                direction = "EAST";
                break;
            case "sud":
                direction = "WEST";
                break;
            case "est":
                direction = "SOUTH";
                break;
            case "ouest":
                direction = "NORTH";
                break;
        }
    }

    public void addLootToInventory(Loot loot){
        inventory.add(loot);
    }
}
