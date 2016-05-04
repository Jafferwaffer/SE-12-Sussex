package antgame;

/**
 *
 * @author ht226 - Software Engineering Group 12
 */
/**
 * This class is used to represent the Ant.
 * Each Ant object has an Id, state, direction, position.
 * Each Ant also is one of two colors: Black/Red
 */
public class Ant {
    int id;
    Color color;
    int state;
    int resting;
    int direction;
    boolean hasFood;
    boolean alive;
    Position position;
/**
 * Constructor for Ant object. Initial state, resting and direction set to 0.
 * Initially the ant has no food and is alive.
 * @param id Id of the ant
 * @param color Color of the ant
 * @param position Position of the ant
 */
    public Ant(int id, Color color, Position position) {
        this.id = id;
        this.color = color;
        this.state = 0;
        this.resting = 0;
        this.direction = 0;
        this.hasFood = false;
        this.alive = true;
        this.position = position;
    }
    
    /************************************************
    Biology
    ************************************************/
    
    /**
     * Gets the ID of ant object
     * @return id of ant
     */
    public int getId() {
        return id;
    }

    /**
     * Set Id of ant object
     * @param id Id as int
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Gets color of ant
     * @return color of the ant, either black/red
     */
    public Color color() {
        return color;
    }
    /**
     * Gets state of ant
     * @return ant state as int
     */
    public int state() {
        return state;
    }
    /**
     * Sets the state of the ant, which is passed
     * as parameter in form of an int
     * @param state between 0-9999
     */
    public void set_state(int state) {
        this.state = state;
    }
    /**
     * Get the resting state of the ant
     * @return resting state as int
     * @return 
     */
    public int resting() {
        return resting;
    }
    /**
     * Set the resting state of the ant
     * @param resting An int representing how long the ant
     * has to rest before performing another action.
     */
    public void set_resting(int resting) {
        this.resting = resting;
    }
    /**
     * Gets the direction of the ant.
     * The int represent directions as follows:
     * 0 - East
     * 1 - South East
     * 2 - South West
     * 3 - West
     * 4 - North West
     * 5 - North East
     * @return direction as an int
     */
    public int direction() {
        return this.direction;
    }
    /**
     * Set the direction of the ant
     * The int represent directions as follows:
     * 0 - East
     * 1 - South East
     * 2 - South West
     * 3 - West
     * 4 - North West
     * 5 - North East
     * @param direction in integer form
     */
    public void set_direction(int direction) {
        this.direction = direction;
    }
    /**
     * Check if ant has food
     * @return true if has food, false otherwise
     */
    public boolean has_food() {
        return hasFood;
    }
    /**
     * Set if the ant has food or not
     * @param hasFood True if has food, false otherwise
     */
    public void set_has_food(boolean hasFood) {
        this.hasFood = hasFood;
    }
    /**
     * Check if ant is alive.
     * @return true if is alive, false otherwise
     */
    public boolean isAlive() {
        return alive;
    }
    /**
     * Set if the ant is alive or not
     * @param alive True if is alive, false otherwise
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    /**
     * Gets the position object associated with the ant object
     * --See class position for more details
     * @return position object
     */
    public Position getPosition() {
        return position;
    }
    /**
     * Set the position associated with ant
     * --See class position for more details
     * @param position Position object
     */
    public void setPosition(Position position) {
        this.position = position;
    }

}
