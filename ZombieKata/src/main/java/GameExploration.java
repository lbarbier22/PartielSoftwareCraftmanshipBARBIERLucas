public class GameExploration {

    public GameExploration() {
    }

    public void explore(Survivor survivor, GameMap gameMap, String command, Zombie zombie, Loot loot) {
        switch (command) {
            case "forward":
                survivor.moveForward();
                if (gameMap.checkIfOutOfMap(survivor.xPosition, survivor.yPosition)) {
                    survivor.health = 0;
                    System.out.println("You're out of the map, you died.");
                } else if (meetAZombie(survivor, zombie)){
                    getBitByAZombie(survivor);
                } else if (meetSomeLoot(survivor, loot)){
                    takeLootToInventory(survivor, loot);
                }
                break;
            case "turn to the left":
                survivor.turnLeft();
                break;
            case "turn to the right":
                survivor.turnRight();
                break;
            default:
                System.out.println("Unkonwn Command");
        }
    }

    public boolean meetAZombie(Survivor survivor, Zombie zombie) {
        return survivor.xPosition == zombie.xPosition && survivor.yPosition == zombie.yPosition;
    }

    public boolean meetSomeLoot(Survivor survivor, Loot loot) {
        return survivor.xPosition == loot.xPosition && loot.yPosition == loot.yPosition;
    }

    private static void getBitByAZombie(Survivor survivor) {
        survivor.health = survivor.health - 1;
        System.out.println("You fell on a zombie ! He bit you. Health : " + survivor.health);
    }

    private static void takeLootToInventory(Survivor survivor, Loot loot) {
        survivor.inventory.add(loot);
        System.out.println("You fell on a loot ! This is : " + loot);
    }
}
