package antgame;

/**
 *
 * @author Software Engineering Group 12
 * 
 * RNG - to the specifications of the requirements
 */
public class RandomInt {
    int s;
    
    /**
     * Constructor for RandomInt. Takes a seed as parameter.
     * 
     * @param s seed
     */
    public RandomInt(int s) {
        this.s = s;
        for (int i = 0; i < 4; i++) {
            this.s = (this.s * 22695477 + 1 & 1073741823);
        }
    }
    /**
     * Get the next random int
     * 
     * @param n Upper bound
     * @return next random int
     */
    public int randomInt(int n) {
        int last = ((this.s / 65536) % 16384);
        this.s = (this.s * 22695477 + 1) & (Integer.MAX_VALUE);
        return last % n;
    }
}
