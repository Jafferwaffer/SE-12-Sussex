package WorldClasses;

/**
 * Class to represent position. Acts as a tuple,
 * two integers for X,Y coordinates
 * @author George
 */
public class Position {
    private int x;
    private int y;
    
    /**
     * Create new position
     * @param _x X coordinate
     * @param _y Y coordinate
     */
    public Position(int _x, int _y){
        x = _x;
        y = _y;
    }
    /**
     * Get X coordinate
     * @return X coordinate 
     */
    public int getX() {
        return x;
    }
    
    /**
     * Set X coordinate
     * @param x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * Get Y coordinate
     * @return Y coordinate 
     */
    public int getY() {
        return y;
    }

    /**
     * Set Y coordinate
     * @param y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }   
}
