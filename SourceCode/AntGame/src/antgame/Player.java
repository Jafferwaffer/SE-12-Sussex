/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antgame;

/**
 *
 * @author ht226
 */
public class Player {
    String playerName;
    int wins;
    int losses;
    int draws;
    int score;
    

    public Player(String playerName) {
        this.playerName = playerName;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        this.score = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getWins() {
        return wins;
    }

    public void updateWins(int wins) {
        this.wins += wins;
    }

    public int getLosses() {
        return losses;
    }

    public void updateLosses(int losses) {
        this.losses += losses;
    }
    
    public int getDraws() {
        return draws;
    }

    public void updateDraws(int draws) {
        this.draws += draws;
    }
    
    public int getScore() {
        return score;
    }

    public void updateScore(int score) throws Exception {
        this.score += score;
        switch (score) {
            case 2:
                updateWins(1);
                break;
            case 1:
                updateDraws(1);
                break;
            case 0:
                updateLosses(1);
                break;
            default:
                throw new Exception();
        }
    }
    
    
}
