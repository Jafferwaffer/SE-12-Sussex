/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antgame;

import antgame.instruction.Instruction;
import java.util.List;

/**
 *
 * @author ht226
 */
public class AntBrain {
    List<Instruction> instructions;

    public AntBrain(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }
}
