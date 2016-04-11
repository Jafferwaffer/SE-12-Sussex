package WorldClasses;
import AntClasses.*;
/**
 * World object used for game, comprised of cell objects.
 * @author George
 */
public class World {
    Cell gameBoard[][];
    
    /**
     * Create new game board to represent World of size [X][Y]
     * @param x dimension
     * @param y dimension
     */
    public World(int x, int y){
        gameBoard = new Cell[x][y];
    }
    
    //**GEOMETRY**
    
    /**
     * Find the position of an adjacent cell in the given direction
     * from the current position.
     * @param p Position with X,Y coordinates
     * @param d Direction enum
     * @return Position of adjacent cell.
     */
    public Position adjacent_cell(Position p, Direction d){
        int x = p.getX(); //X coordinate
        int y = p.getY(); //Y coordinate
        switch(d){
            case EAST: x++; //EAST
                break;
            case SOUTHEAST: if(y%2==0){y++;} else {x++;y++;}; //SOUTH EAST
                break;
            case SOUTHWEST: if(y%2==0){x--;y++;} else {y++;}; //SOUTH WEST
                break;
            case WEST: x--; //WEST
                break;
            case NORTHWEST: if(y%2==0){x--;y--;} else {y--;}; //NORTH WEST
                break;
            case NORTHEAST: if(y%2==0){y--;} else {x++;y--;}; //NORTH EAST
                break;
            default: System.err.println("No cell adjacent in given direction");
                break;
        }
        return new Position(x,y);
    }
    
    //**GEOGRAPHY**
    
    /**
     * Check if there is Ant at specified position [X][Y]
     * @param p Position with X,Y coordinates
     * @return True if ant at position, false otherwise. 
     */
    public boolean some_ant_is_at(Position p){
        return gameBoard[p.getX()][p.getY()].isOccupied();
    }
    
    /**
     * Get Ant at specified position
     * @param p Position with X,Y coordinates
     * @return Ant object at location.
     */
    public Ant ant_at(Position p){
        return gameBoard[p.getX()][p.getY()].getAnt();
    }
   
    /**
     * Set Ant at specified position
     * @param p Position with X,Y coordinates
     * @param a Ant
     */
    public void set_ant_at(Position p, Ant a){
        gameBoard[p.getX()][p.getY()].setAnt(a);
    }
    
    /**
     * Clear Ant from specified position.
     * If cell not occupied prints error message.
     * @param p Position with X,Y coordinates
     */
    public void clear_ant_at(Position p){
        gameBoard[p.getX()][p.getY()].clear_ant();
    }
    
    //Following methods need implementation.
    //************************************************
    public boolean ant_is_alive(int id){
       //IMPLEMENT
    }
    public Position find_ant(int id){
        //IMPLEMENT
    }
    public void kill_ant_at(Position p){
        //IMPLEMENT
    }
    public boolean anthill_at(Position p, Colour c){
        //IMPLEMENT
    }
    
    //************************************************
    
    /**
     * Get food at specified position
     * @param p Position with X,Y coordinates
     * @return Integer representing number of food at position.
     */
    public int food_at(Position p){
        return gameBoard[p.getX()][p.getY()].getFood();
    }
    
    /**
     * Set food at specified position.
     * The value food must be positive
     * @param p Position with X,Y coordinates
     * @param numbFood Number of food to put on cell. Must be positive.
     * @throws Exception if number of food is a negative int.
     */
    public void set_food_at(Position p, int numbFood) throws Exception{
        gameBoard[p.getX()][p.getY()].setFood(numbFood);
    }
    
    //**MARTIAL ARTS**
    
    /**
     * Find how many ants are adjacent to specified position
     * @param p Position with X,Y coordinates
     * @param c Colour RED/BLACK
     * @return number of adjacent ants
     */
    public int adjacent_ants(Position p, Colour c){
        int numbAnts = 0;
        for(Direction d : Direction.values()){
           Position adjP = adjacent_cell(p,d);
           if(some_ant_is_at(adjP) && ant_at(adjP).getColour() == c){
               numbAnts++;
           }
        }
        return numbAnts;
    }
    
    /**
     * Checks if an ant at given position is surrounded.
     * If the ant is surrounded then the ant is killed and is turned to food.
     * This food plus any food already in cell, plus 1 if ant was carrying food
     * is placed in this cell.
     * @param p Position with X,Y coordinates
     */
    public void check_for_surrounded_ant_at(Position p){
        if(some_ant_is_at(p)){
            Ant a = ant_at(p);
            if(adjacent_ants(p,otherColour(a.getColour())) >= 5){
                kill_ant_at(p);
                int carried = 0;
                if(has_food(a)){
                    carried = 1;
                }
                int food = food_at(p) + 3 + carried;
                set_food_at(p,food);
            }
        }
    }
    
    /**
     * Checks current cell, and all adjacent cells for
     * surrounded ants. Uses the check_for_surrounded_ant_at method.
     * See this method's java doc for more details.
     * @param p Position with X,Y coordinates
     */
    public void check_for_surrounded_ants(Position p){
        check_for_surrounded_ant_at(p);
        for(Direction d: Direction.values()){
            check_for_surrounded_ant_at(adjacent_cell(p,d));
        }
    }
    
    //**PHENOMENOLOGY
    //REQUIRES IMPLEMENTATION
    public boolean cell_matches(Position p, Condition cond, Colour c){
        
    }
    
    //**KINETICS**
    //REQUIRES IMPLEMENTATION
    public void step(int id){
        
    }
    
}
