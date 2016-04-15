/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antgame;

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
    
    public void runTwoPlayer() throws Exception {
        if (this.players.size() == 2 && this.antWorld != null) {
            GameInstance game = new GameInstance(this.antWorld, this.antBrains.get(0), this.antBrains.get(1));
            game.runGame(this.antWorld);
            updateScores(game.getWinner(), this.players.get(0), this.players.get(1));
        } else {
            throw new Exception();
        }
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
}
