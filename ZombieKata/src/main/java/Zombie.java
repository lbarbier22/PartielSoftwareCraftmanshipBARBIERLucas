import java.util.Random;

public class Zombie {

    Integer xPosition;
    Integer yPosition;

    Random randomizer = new Random();

    public Zombie(Integer xPosition, Integer yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public void moveZombie(GameMap map){
        int direction = randomizer.nextInt(4);

        switch (direction) {
            case 0:
                if (!map.checkIfOutOfMap(xPosition, yPosition - 1)){
                    yPosition--; // North
                }
                break;
            case 1:
                if (!map.checkIfOutOfMap(xPosition, yPosition + 1)){
                    yPosition++; // South
                }
                break;
            case 2:
                if (!map.checkIfOutOfMap(xPosition + 1, yPosition)){
                    xPosition++; // East
                }
                break;
            case 3:
                if (!map.checkIfOutOfMap(xPosition - 1, yPosition)){
                    xPosition--; // West
                }
                break;
        }
    }

}
