package antgame;
import antgame.instruction.LeftOrRight;
import antgame.instruction.SenseDir;
import antgame.condition.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Software Engineering Group 12
 * 
 * Represents the world, which consists of a 2D array of cells
 * and a list of the ants present in the world.
 */
public class World {
    Cell[][] world;
    List<Ant> ants;
    /**
     * Gets the world
     * @return the world as a 2D array of cells.
     */
    public Cell[][] getWorld() {
        return world;
    }
    /**
     * Constructor for world object.
     * Initialises the 2D cell array.
     * 
     * @param world 2D array of cell objects
     */
    public World(Cell[][] world) {
        this.ants = new ArrayList();
        this.world = world;
    }
    
    /********************************************
    Geometry
    ********************************************/
    /**
     * Given a position (X,Y coordinates) and a direction finds the adjacent cell.
     * 
     * @param pos Position object, which consists of X,Y coordinates
     * @param direction 0-5, 0 being EAST, 5 being NORTH-EAST
     * @return position of an adjacent cell
     * @throws Exception if direction invalid (<0, >5)
     */
    public Position adjacent_cell(Position pos, int direction) throws Exception {
        switch (direction) {
            case 0: return new Position(pos.x + 1, pos.y);
            case 1: return (pos.y % 2 == 0) ? new Position(pos.x, pos.y + 1) : new Position(pos.x + 1, pos.y + 1);
            case 2: return (pos.y % 2 == 0) ? new Position(pos.x - 1, pos.y + 1) : new Position(pos.x, pos.y + 1);
            case 3: return new Position(pos.x - 1, pos.y);
            case 4: return (pos.y % 2 == 0) ? new Position(pos.x - 1, pos.y - 1) : new Position(pos.x, pos.y - 1);
            case 5: return (pos.y % 2 == 0) ? new Position(pos.x, pos.y - 1) : new Position(pos.x + 1, pos.y - 1);
            default: throw new Exception();
        }
    }
    /**
     * Given a left_or_right enum and a direction turn.
     * 
     * @param left_or_right Enum - left or right
     * @param direction 0-5, 0 being EAST, 5 being NORTH-EAST
     * @return new direction as int
     * @throws Exception not left or right
     */
    public int turn(LeftOrRight left_or_right, int direction) throws Exception {
        switch (left_or_right) {
            case LEFT: return (direction + 5) % 6;
            case RIGHT: return (direction + 1) % 6;
            default: throw new Exception();
        }
    }
    /**
     * Given a current position, and a direction and a sense direction instruction
     * return the cell which is sensed.
     * 
     * @param p Current position
     * @param direction 0-5, 0 being EAST, 5 being NORTH-EAST
     * @param sense_dir Direction to sense in
     * @return position (consisting of an X,Y coordinate)
     * @throws Exception If sense_dir instruction is invalid.
     */
    public Position sensed_cell(Position p, int direction, SenseDir sense_dir) throws Exception {
        switch (sense_dir) {
            case HERE: return p;
            case AHEAD: return adjacent_cell(p, direction);
            case LEFTAHEAD: return adjacent_cell(p, turn(LeftOrRight.LEFT, direction));
            case RIGHTAHEAD: return adjacent_cell(p, turn(LeftOrRight.RIGHT, direction));
            default: throw new Exception();
        }
    }
    
    /********************************************
    Biology
    ********************************************/
    /**
     * Given a color get the other color
     * 
     * @param c current color
     * @return other color
     * @throws Exception if invalid color
     */
    public Color other_color(Color c) throws Exception {
        switch (c) {
            case BLACK: return Color.RED;
            case RED: return Color.BLACK;
            default: throw new Exception();
        }
    }
    
    /********************************************
     Geography
    ********************************************/
    /**
     * Check if some ant is at the given position.
     * 
     * @param pos position to check
     * @return true if ant exists, false otherwise
     */
    public boolean some_ant_is_at(Position pos) {
        return world[pos.x][pos.y].getAnt() != null;
    }
    /**
     * Get the ant object at the given position.
     * 
     * @param pos position to check
     * @return Ant at position
     */
    public Ant ant_at(Position pos) {
        return world[pos.x][pos.y].getAnt();
    }
    /**
     * Set the ant at a given position
     * 
     * @param pos position to set ant at
     * @param ant ant to set at position
     */
    public void set_ant_at(Position pos, Ant ant) {
        world[pos.x][pos.y].setAnt(ant);
    }
    /**
     * Removed the ant from the cell object at a given
     * position
     * 
     * @param pos position to remove ant from
     */
    public void clear_ant_at(Position pos) {
        world[pos.x][pos.y].setAnt(null);
    }
    /**
     * Check ant is alive given it's ID
     * 
     * @param id of ant
     * @return True if is alive , false if dead
     */
    public boolean ant_is_alive(int id) {
        return ants.get(id).isAlive();
    }
    /**
     * Find the position of an ant given its ID.
     * 
     * @param id of ant
     * @return Position of ant if it can be found, null otherwise
     */
    public Position find_ant(int id) {
        return (ants.get(id).isAlive()) ? ants.get(id).getPosition() : null;
    }
    /**
     * Kills the ant with given ID. Clears the ant at position
     * 
     * @param id of ant
     * @param pos position of ant to clear.
     */
    public void kill_ant_at(int id, Position pos) {
        set_ant_at(pos, null);
        ants.get(id).setAlive(false);
    }
    /**
     * Get the number of food particles at a given position.
     * 
     * @param pos position to check
     * @return number of food as int
     */
    public int food_at(Position pos) {
        return world[pos.x][pos.y].getFood();
    }
    /**
     * Sets the food at a given position
     * 
     * @param pos position to set food at
     * @param food number of food particles to set
     */
    public void set_food_at(Position pos, int food) {
        world[pos.x][pos.y].setFood(food);
    }
    /**
     * Check if anthill is at current position with a given color
     * 
     * @param p position
     * @param c color
     * @return True if there is an anthill of that color, flase otherwise
     */
    public boolean anthill_at(Position p, Color c) {
        return this.world[p.x][p.y].antHill() && this.world[p.x][p.y].getAntHillColor() == c;
    }
    
    /********************************************
    Chemistry
    ********************************************/
    /**
     * Sets the given marker at a given position for a given color
     * 
     * @param p position
     * @param color colour
     * @param marker marker as an int 0-5
     */
    public void set_marker_at(Position p, Color color, int marker) {
        if (color == Color.RED) {
            this.world[p.x][p.y].setRed(marker, true);
        } else {
            this.world[p.x][p.y].setBlack(marker, true);
        }
        
    }
    /**
     * Clears the given marker at a given position for a given color
     * 
     * @param p position
     * @param color colour
     * @param marker marker as an int 0-5
     */
    public void clear_marker_at(Position p, Color color, int marker) {
        if (color == Color.RED) {
            if (this.world[p.x][p.y].getRed()[marker]) {
                this.world[p.x][p.y].setRed(marker, false);
            }
        } else {
            if (this.world[p.x][p.y].getBlack()[marker]) {
                this.world[p.x][p.y].setBlack(marker, false);
            }
        }
    }
    /**
     * Checks the given marker at a given position and color to see if it exists
     * (is set to true)
     * @param p position
     * @param c color
     * @param marker marker as an int 0-5
     * @return true if exists, flase otherwise
     */
    public boolean check_marker_at(Position p, Color c, int marker) {
        return (c == Color.RED) ? this.world[p.x][p.y].getRed()[marker]: 
                this.world[p.x][p.y].getBlack()[marker];
    }
    /**
     * Checks if there is any marker at a given position for a given color
     * 
     * @param p position
     * @param other_color Color
     * @return true if marker exists, flase otherwise
     */
    public boolean check_any_marker_at(Position p, Color other_color) {
        boolean isMarker = false;
        if (other_color == Color.RED) {
            for (boolean marker : world[p.x][p.y].getRed()) {
                if (marker) {
                    return true;
                }
            }
            return false;
        } else {
            for (boolean marker : world[p.x][p.y].getBlack()) {
                if (marker) {
                    return true;
                }
            }
            return false;
        }
    }
    
    /********************************************
    Phenomenology
    ********************************************/
    /**
     * Checks if a cell at a given position matches a given condition for a color.
     * 
     * 
     * @param p Position
     * @param cond Condition ~ See condition package
     * @param c Color
     * @return true if matches condition, false otherwise
     * @throws Exception if condition invalid
     */
    public boolean cell_matches(Position p, Condition cond, Color c) throws Exception {
        if (this.world[p.x][p.y].rocky()) {
            return cond instanceof Rock;
        } else {
            if (cond instanceof Friend) {
                return (some_ant_is_at(p) && ant_at(p).color() == c);
            } else if (cond instanceof Foe) {
                return (some_ant_is_at(p) && ant_at(p).color() != c);
            } else if (cond instanceof FriendWithFood) {
                return (some_ant_is_at(p) && ant_at(p).color() == c &&
                        ant_at(p).has_food());
            } else if (cond instanceof FoeWithFood) {
                return (some_ant_is_at(p) && ant_at(p).color() != c &&
                        ant_at(p).has_food());
            } else if (cond instanceof Food) {
                return food_at(p) > 0;
            } else if (cond instanceof Rock) {
                return false;
            } else if (cond instanceof Marker) {
                Marker marker = (Marker)cond;
                return check_marker_at(p, c, marker.getMarker());
            } else if (cond instanceof FoeMarker) {
                return check_any_marker_at(p, other_color(c));
            } else if (cond instanceof Home) {
                return anthill_at(p, c);
            } else if (cond instanceof FoeHome) {
                return anthill_at(p, other_color(c));
            } else {
                throw new Exception();
            }
        }
    }
    
    /********************************************
    Martial Arts
    ********************************************/
    /**
     * Finds how many ants, of a given color, are adjacent to a given position
     * 
     * @param p position
     * @param c color
     * @return number of adjacent ants
     * @throws Exception 
     */
    public int adjacent_ants(Position p, Color c) throws Exception {
        int n = 0;
        for (int d = 0; d <= 5; d++) {
            Position cel = adjacent_cell(p, d);
            if (some_ant_is_at(cel) && ant_at(cel).color() == c) {
                n++;
            }
        }
        return n;
    }
    /**
     * Given a position check if the ant is surrounded.
     * 
     * @param p Position
     * @throws Exception 
     */
    public void check_for_surrounded_ant_at(Position p) throws Exception {
        if (some_ant_is_at(p)) {
            Ant a = ant_at(p);
            if (adjacent_ants(p, other_color(a.color())) >= 5) {
                kill_ant_at(a.getId(), p);
                set_food_at(p, food_at(p) + 3 + ((a.has_food()) ? 1 : 0));
            }
        }
    }
    /**
     * Given a position check all adjacent cells for surrounded ants.
     * 
     * @param p position
     * @throws Exception 
     */
    public void check_for_surrounded_ants(Position p) throws Exception {
        check_for_surrounded_ant_at(p);
        for (int d = 0; d <= 5; d++) {
            check_for_surrounded_ant_at(adjacent_cell(p,d));
        }
    }
    
    /**********************************************
    Game Play
    **********************************************/
    /**
     * Goes through every cell, top left to bottom right. A single ant is placed
     * in each ant hill cell of the respective color
     */
    public void initialiseWorld() {
        for (int y = 0; y < this.world.length; y++) {
            for (int x = 0; x < this.world[y].length; x++) {
                if (this.world[x][y].antHill()) {
                    Ant ant = new Ant(this.ants.size(), this.world[x][y].getAntHillColor(), new Position(x, y));
                    this.world[x][y].setAnt(ant);
                    this.ants.add(ant);
                }
            }
        }
    }

    /**********************************************
    Getters and Setters
    **********************************************/
    /**
     * Gets the list of ants in the world
     * @return list of ants
     */
    public List<Ant> getAnts() {
        return ants;
    }
    /**
     * Sets the list of ants in the world
     * @param ants list of ant objects
     */
    public void setAnts(List<Ant> ants) {
        this.ants = ants;
    }
    /**
     * Gets the total food for a given color of ant.
     * 
     * @param color of ant
     * @return number of food particles at anthill for given color.
     */
    public int getTotalFood(Color color) {
        int food = 0;
        for (int x = 0; x < this.world.length; x++) {
            for (int y = 0; y < this.world[x].length; y++) {
                if (this.world[x][y].antHill() && this.world[x][y].getAntHillColor().equals(color)) {
                    food = food + this.world[x][y].getFood();
                }
            }
        }
        return food;
    }
    
    
}
