package WorldClasses;
import AntClasses.*;

/**
 * Class to represent a cell. Many cell classes used to represent world.
 * @author George
 */
public class Cell {
   private boolean rocky;
   private int food;
   private boolean occupied;
   private boolean isAnthill;
   private Marker redMarker;
   private Marker blackMarker;
   private Ant ant;
   
   /**
    * Constructor for Cell object. ~ needs fine tuning.
    * @param _rocky
    * @param _food
    * @param _isAnthill 
    */
   public Cell(boolean _rocky, int _food, boolean _isAnthill){
       rocky = _rocky;
       food = _food;
       isAnthill = _isAnthill;
   }
   
   /**
    * Check is cell is rocky, if is rocky return true, otherwise false.
    * @return True for rocky, false for not.
    */
   public boolean isRocky(){
       return rocky;
   }
   
   /**
    * Check if cell is occupied by an ant
    * @return True if occupied, false otherwise.
    */
   public boolean isOccupied(){
       return occupied;
   }
   
   /**
    * Check if cell is part of an Anthill
    * @return True if part of anthill, false otherwise
    */
   public boolean isAnthill(){
       return isAnthill;
   }
   
   /**
    * Get number of food on cell
    * @return int between 0-9
    */
   public int getFood(){
       return food;
   }
   
   /**
    * Set number of food on cell. Must be between greater than 0.
    * @param numbFood 
    * @throws java.lang.Exception 
    */
   public void setFood(int numbFood) throws Exception{
       if(numbFood >= 0){
           food = numbFood;
       }else{
           throw new Exception("The value of food in cell cannot be negative");
       }
   }
   
   /**
    * Get marker specific to colour
    * @param c Colour, red / black
    * @return redMarker if colour Red, blackMarker if colour Black
    */
   public Marker getMarker(Colour c){
       if(c.equals(Colour.RED)){
           return redMarker;
       }else{
           return blackMarker;
       }
   }
   
   /**
    * NEEDS IMPLEMENTATION
    */
   public void setMarker(){
       //Needs implementation
   }
   
   /**
    * Set the Ant in cell. Sets occupied to true
    * @param a An Ant
    */
   public void setAnt(Ant a){
       ant = a;
       occupied = true;
   }
   
   /**
    * Clears Ant in cell if occupied.
    * Sets ant = null, occupied to false.
    */
   public void clear_ant(){
       if(isOccupied()){
           ant = null;
           occupied = false;
       }else{
           System.err.println("Tried to remove ant from cell where ant does not exist");
       }
   }
   
   /**
    * Gets Ant in cell.
    * @return Ant object.
    */
   public Ant getAnt(){
       return ant;
   }
}
