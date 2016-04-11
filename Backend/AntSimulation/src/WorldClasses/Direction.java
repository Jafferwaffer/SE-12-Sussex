package WorldClasses;

/**
 * Enum to represent Direction.
 * Each enum associated with int.
 * @author George
 */
public enum Direction {
    EAST(0),
    SOUTHEAST(1),
    SOUTHWEST(2),
    WEST(3),
    NORTHWEST(4),
    NORTHEAST(5);
    
    private final int value;

    Direction(final int newValue){
        value = newValue;
    }
    
    /**
     * Get value for enum
     * @return integer between 0-5
     */
    public int getValue(){
        return value;
    }
}
