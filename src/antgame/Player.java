package antgame;

/**
 *
 * @author Software Engineering Group 12
 * 
 * Class to represent a player. Keeps track of the player's wins,losses,draws
 * and overall score. Each player has an associated name.
 */
public class Player {
    String playerName;
    int wins;
    int losses;
    int draws;
    int score;
    
    /**
     * Constructor for the player class. Takes a name as string.
     * 
     * @param playerName Name of player
     */
    public Player(String playerName) {
        this.playerName = playerName;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        this.score = 0;
    }
    /**
     * Get the player's name
     * @return Players name as string
     */
    public String getPlayerName() {
        return playerName;
    }
    /**
     * Set the player name
     * @param playerName as string
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    /**
     * Get number of wins for player
     * @return number of wins for player
     */
    public int getWins() {
        return wins;
    }
    /**
     * Update how many wins a player has
     * @param wins number of wins to add.
     */
    public void updateWins(int wins) {
        this.wins += wins;
    }
    /**
     * Get number of losses for player
     * @return number of losses
     */
    public int getLosses() {
        return losses;
    }
    /**
     * Update how many losses a player has
     * @param losses number of losses to add
     */
    public void updateLosses(int losses) {
        this.losses += losses;
    }
    /**
     * Get number of draws for a player
     * @return number of draws for a player
     */
    public int getDraws() {
        return draws;
    }
    /**
     * Update number of draws for player.
     * @param draws number of draws to add.
     */
    public void updateDraws(int draws) {
        this.draws += draws;
    }
    /**
     * Get players score
     * @return score of player
     */
    public int getScore() {
        return score;
    }
    /**
     * Updates score, also update any wins, losses or draws.
     * @param score to add
     * @throws Exception if not a valid score.
     */
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
