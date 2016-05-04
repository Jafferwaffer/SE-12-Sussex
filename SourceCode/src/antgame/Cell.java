package antgame;

/**
 * Class to represent a cell. Many cell classes used to represent world.
 * @author Software Engineering Group 12
 */
public class Cell {
    boolean rocky;
    int food;
    boolean[] black;
    boolean[] red;
    Ant ant;
    boolean antHill;
    Color antHillColor;
    
    /**
     * Default constructor for a new cell object.
     * Sets the cell to not be rocky, have no food,
     * no ant hill and not ant: a clear cell.
     * Boolean arrays are created to signal one of 6 markers for each color
     * ant
     */
    public Cell() {
        this.rocky = false;
        this.food = 0;
        this.black = new boolean[6];
        this.red = new boolean[6];
        this.ant = null;
        this.antHill = false;
        this.antHillColor = null;
    }
    /**
     * Constructor for cell allowing the setting of the value rocky.
     * Same as default constructor in all other cases.
     * 
     * @param rocky True if is rocky, false otherwise
     */
    public Cell(boolean rocky) {
        this.rocky = rocky;
        this.food = 0;
        this.black = new boolean[6];
        this.red = new boolean[6];
        this.ant = null;
        this.antHill = false;
        this.antHillColor = null;
    }
    /**
     * Constructor for cell allowing setting of whether there is any food, anthill
     * and color of anthill
     * 
     * @param food Number of food particles in cell
     * @param antHill True if anthill, false otherwise
     * @param antHillColor Color of anthill, red/black
     */
    public Cell(int food, boolean antHill, Color antHillColor) {
        this.food = food;
        this.black = new boolean[6];
        this.red = new boolean[6];
        this.ant = null;
        this.antHill = antHill;
        this.antHillColor = antHillColor;
    }
   /**
    * Check is cell is rocky, if is rocky return true, otherwise false.
    * @return True for rocky, false for not.
    */
    public boolean rocky() {
        return rocky;
    }
   /**
    * Get number of food on cell
    * @return int representing number of food particles
    */
    public int getFood() {
        return food;
    }
    /**
     * Set number of food on cell
     * @param food int number of food
     */
    public void setFood(int food) {
        this.food = food;
    }
    /**
     * Get array of black markers for cell
     * @return array of booleans, 6 markers.
     * If a value is true indicates presence of that marker
     */
    public boolean[] getBlack() {
        return black;
    }
    /**
     * Given a marker, as int, and a boolean set marker for cell
     * If set to true, marker is present
     * @param marker as int between 0-5
     * @param set True, false
     */
    public void setBlack(int marker, boolean set) {
        this.black[marker] = set;
    }
    /**
     * Get array of red markers for cell
     * @return array of booleans, 6 markers.
     * If a value is true indicates presence of that marker
     */
    public boolean[] getRed() {
        return red;
    }
    /**
     * Given a marker, as int, and a boolean set marker for cell
     * If set to true, marker is present
     * @param marker as int between 0-5
     * @param set True, false
     */
    public void setRed(int marker, boolean set) {
        this.red[marker] = set;
    }
    /**
     * Get ant on cell
     * @return Ant object
     */
    public Ant getAnt() {
        return ant;
    }
    /**
     * Set ant on cell
     * @param ant to associate with cell
     */
    public void setAnt(Ant ant) {
        this.ant = ant;
    }
    /**
     * Check whether cell is part of anthill
     * @return True if is part of anthill/false otherwise
     */
    public boolean antHill() {
        return antHill;
    }
    /**
     * Get the color of anthill on cell
     * 
     * @return Color enum
     */
    public Color getAntHillColor() {
        return antHillColor;
    }
    /**
     * Set color of anthill
     * 
     * @param antHillColor Enum
     */
    public void setAntHillColor(Color antHillColor) {
        this.antHillColor = antHillColor;
    }
}
