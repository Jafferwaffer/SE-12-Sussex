/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antgame;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ht226
 */
public class SetUp {
    Cell[][] antWorld;
    List<AntBrain> antBrains;
    List<Player> players;

    public SetUp() {
        this.antWorld = null;
        this.antBrains = new ArrayList();
        this.players= new ArrayList();
    }
    
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
    
    public void loadWorld(String filePath) throws Exception {
        WorldParser worldParser = new WorldParser();
        this.antWorld = worldParser.parseWorld(filePath);
    }
    
    public void loadAntBrain(String filePath) throws Exception {
        AntBrainParser antBrainParser = new AntBrainParser();
        this.antBrains.add(new AntBrain(antBrainParser.parseAntBrain(filePath)));
    }
    
    public void addPlayer(String name) {
        this.players.add(new Player(name));
    }
    
    public void removePlayer(int index) {
        this.players.remove(index);
        this.antBrains.remove(index);
    }
    
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
    
    public void checkDump() throws Exception {
        addPlayer("Hayden");
        addPlayer("Loser");
        loadAntBrain("N:\\Documents\\sample.txt");
        loadAntBrain("N:\\Documents\\sample.txt");
        loadWorld("N:\\Documents\\tiny.txt");
        try {
            FileInputStream fstream = new FileInputStream("N:\\Year_2\\Software Engineering\\dump.all");
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
