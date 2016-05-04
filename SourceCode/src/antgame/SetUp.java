package antgame;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Software Engineering Group 12
 * 
 * Handles set- up of the game.
 * A game consists of a world, 2 ant brains, and players
 */
public class SetUp {
    Cell[][] antWorld;
    List<AntBrain> antBrains;
    List<Player> players;
    /**
     * Constructor with the setup class.
     * Initialises variables for world, brains and players
     */
    public SetUp() {
        this.antWorld = null;
        this.antBrains = new ArrayList();
        this.players= new ArrayList();
    }
    /**
     * Generate world. Creates a new world with given parameters.
     * --Currently not fully supported.
     * 
     * @param x
     * @param y
     * @param antHillSize
     * @param numRocks
     * @param rockSize
     * @param numFood
     * @param foodSize 
     */
    public void generateWorld(int x, int y, int antHillSize, int numRocks, int rockSize, int numFood, int foodSize) {
        this.antWorld = new Cell[x][y];
        for (int xPos = 0; xPos < x; x++) {
            for (int yPos = 0; yPos < y; y++) {
                if (xPos == 0 || yPos == 0 || xPos == x-1 || yPos == y-1) {
                    this.antWorld[xPos][yPos] = new Cell(true);
                }
            }
        }
    }
    /**
     * Loads the world from a file path.
     * The file is parsed by a world parser.
     * 
     * @param filePath of world
     * @throws Exception If parsing fails
     */
    public void loadWorld(String filePath) throws Exception {
        WorldParser worldParser = new WorldParser();
        this.antWorld = worldParser.parseWorld(filePath);
    }
    /**
     * Loads the ant brain from file path.
     * The file is parsed by the world parser and added to the ant brain
     * array if parsing passes
     * @param filePath of ant brain
     * @throws Exception If parsing fails
     */
    public void loadAntBrain(String filePath) throws Exception {
        AntBrainParser antBrainParser = new AntBrainParser();
        this.antBrains.add(new AntBrain(antBrainParser.parseAntBrain(filePath)));
    }
    /**
     * Create a new player object with name.
     * @param name of player
     */
    public void addPlayer(String name) {
        this.players.add(new Player(name));
    }
    /**
     * Remove a player.
     * @param index player number to remove. eg: 1 to remove player 1
     */
    public void removePlayer(int index) {
        this.players.remove(index);
        this.antBrains.remove(index);
    }
    /**
     * Updates the scores for players depending on the result of the game.
     * 
     * @param winner Which color won, or a draw
     * @param playerOne 
     * @param playerTwo
     * @throws Exception If a there was no draw or no winner.
     */
    public void updateScores(String winner, Player playerOne, Player playerTwo) throws Exception {
        switch (winner) {
            case "DRAW":
                System.out.println("The game was a draw");
                playerOne.updateScore(1);
                playerTwo.updateScore(1);
                break;
            case "BLACK":
                System.out.println("Supremem overlord won Won");
                playerOne.updateScore(2);
                playerTwo.updateScore(0);
                break;
            case "RED":
                System.out.println(" Won");
                playerOne.updateScore(0);
                playerTwo.updateScore(2);
                break;
            default:
                throw new Exception();
        }
    }
    /**
     * Runs a 2 player game for 300000 rounds.
     * 
     * @throws Exception 
     */
    public void run2PGame() throws Exception{
        GameInstance game = new GameInstance(this.antWorld, this.antBrains.get(0), this.antBrains.get(1));
        for(int i = 0; i<300000;i++){
            game.runRound();
        }
        System.out.println(game.getWinner());
    }
    /**
     * Used for system test. Compares state of world with a provided dump file.
     * The dump file is the state expected.
     * At current system test passes - may take a long time to execute.
     * 
     * @throws Exception 
     */
    public void checkDump() throws Exception {
        addPlayer("Hayden");
        addPlayer("Loser");
        loadAntBrain("Ant3.ant");
        loadAntBrain("Ant3.ant");
        loadWorld("1.world");
        try {
            FileInputStream fstream = new FileInputStream("dump.all");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String fileLine;
            GameInstance game = new GameInstance(this.antWorld, this.antBrains.get(0), this.antBrains.get(1));
            Cell[][] world = game.gameWorld.getWorld();
            for (int round = 0; round < 10001; round++) {
                br.readLine();
                fileLine = br.readLine();
                for (int y = 0; y < world.length; y++) {
                    for (int x = 0; x < world[y].length; x++) {
                        String cellContains = "cell (" + x + ", " + y + "): ";
                        fileLine = br.readLine();
                        if (world[x][y].rocky()) {
                            cellContains += "rock";
                        } else {
                            if (world[x][y].getFood() > 0) {
                                cellContains += world[x][y].getFood() + " food; ";
                            }
                            if (world[x][y].antHill()){
                                cellContains += world[x][y].getAntHillColor().name().toLowerCase() + " hill; ";
                            }
                            if (game.gameWorld.check_any_marker_at(new Position(x, y), Color.RED)) {
                                cellContains += "red marks: ";
                                for (int marker = 0; marker < 6; marker ++) {
                                    if (world[x][y].getRed()[marker]) {
                                        cellContains += marker;
                                    }
                                }
                                cellContains += "; ";
                            }
                            if (game.gameWorld.check_any_marker_at(new Position(x, y), Color.BLACK)) {
                                cellContains += "black marks: ";
                                for (int marker = 0; marker < 6; marker ++) {
                                    if (world[x][y].getBlack()[marker]) {
                                        cellContains += marker;
                                    }
                                }
                                cellContains += "; ";
                            }
                            if (world[x][y].getAnt() != null) {
                                Ant ant = world[x][y].getAnt();
                                cellContains += ant.color().name().toLowerCase()+ " ant of ";
                                cellContains += "id " + ant.getId() + ", ";
                                cellContains += "dir " + ant.direction() + ", ";
                                int food = (ant.has_food()) ? 1 : 0;
                                cellContains += "food " + food + ", ";
                                cellContains += "state " + ant.state() + ", ";
                                cellContains += "resting " + ant.resting();
                            }
                            if (!fileLine.equals(cellContains)) {
                                System.out.print(fileLine + "\n");
                                System.out.print(cellContains + "\n");
                                throw new Exception();
                            }
                        }
                    }
                }
                world = game.runRound();
            }
 
        } catch (Exception e){//Catch exception if any
            throw e;
        }
    }
}
