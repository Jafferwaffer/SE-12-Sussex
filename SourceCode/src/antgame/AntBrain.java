package antgame;

import antgame.instruction.Instruction;
import java.util.List;

/**
 *  
 * @author ht226 - Software Engineering Group 12
 */
/**
 * Represents the brain of the Ant. The AntBrain is created through
 * parsing a text file with the AntBrainParser class.
 * {@link} AntBrainParser
 */
public class AntBrain {
    List<Instruction> instructions;
    /**
     * Constructor for AntBrain, take a list of instruction as parameter
     * @param instructions List of instructions.
     */
    public AntBrain(List<Instruction> instructions) {
        this.instructions = instructions;
    }
    /**
     * Gets the list of instructions associated with the ant brain object.
     * --See instruction package for more details
     * @return instructions as a list
     */
    public List<Instruction> getInstructions() {
        return instructions;
    }
}
