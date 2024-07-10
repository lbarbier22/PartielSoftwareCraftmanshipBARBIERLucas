import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameExplorationTest {

    Survivor survivor = new Survivor("NORTH", 1, 1);
    Zombie zombie =  new Zombie(1, 1);
    GameMap gameMap = new GameMap();
    GameExploration gameExploration = new GameExploration();

    @Test
    public void testSurvivorMovesCorrectlyToTheEast(){
        survivor.direction = "EAST";
        gameExploration.explore(survivor, gameMap, "forward", zombie);
        gameExploration.explore(survivor, gameMap, "forward", zombie);
        gameExploration.explore(survivor, gameMap, "forward", zombie);

        assertEquals(survivor.xPosition, 4);
        assertEquals(survivor.yPosition, 1);
    }

    @Test
    public void testSurvivorCanTurnToTheWest(){
        survivor.xPosition = 5;
        survivor.yPosition = 5;

        survivor.direction = "WEST";
        gameExploration.explore(survivor, gameMap, "forward", zombie);

        assertEquals(survivor.xPosition, 4);
        assertEquals(survivor.yPosition, 5);
    }

    @Test
    public void checkHealthWhenSurvivorMeetOnAZombie(){
        gameExploration.explore(survivor, gameMap, "forward", zombie);

        assertTrue(gameExploration.meetAZombie(survivor, zombie));
        assertEquals(survivor.health, 9);
    }

    @Test
    public void testSurvivorGoesOutOfTheMap(){
        survivor.direction = "SOUTH";
        gameExploration.explore(survivor, gameMap, "forward", zombie);

        assertTrue(gameMap.checkIfOutOfMap(survivor.xPosition, survivor.yPosition));
        assertEquals(survivor.health, 0);
    }
}
