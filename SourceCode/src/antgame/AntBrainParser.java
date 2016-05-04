/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antgame;

import antgame.condition.*;
import antgame.instruction.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Software Engineering Group 12
 * Class used to parse the ant brain which is passed the file path of the ant brain
 * ant file, determines if the brain is syntactically correct
 */
public class AntBrainParser {
    
    /**
     * Parses the ant brain file which is passed in the form of a file path. This file
     * path is used to read the file in through an input stream. The file is then read
     * line by line. The array list storing each line is then passed to the 
     * @link createInstructionList method and returned.
     * 
     * @param filePath Of ant brain file
     * @return List of instructions
     * @throws Exception If reading of the file fails.
     */
    public List<Instruction> parseAntBrain(String filePath) throws Exception {
        try {
            FileInputStream fstream = new FileInputStream(filePath);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String fileLine;
            ArrayList<String[]> splitStringList = new ArrayList();
            //Read File Line By Line
            while ((fileLine = br.readLine()) != null)   {
                splitStringList.add(fileLine.split("\\s+"));
            }
            return createInstructionList(splitStringList);
        } catch (Exception e){//Catch exception if any
            throw e;
        }
    }
    /**
     * Takes Array which is iterated through. A switch case checks the first word of
     * each string. Each string is then passed to the relevant method which in turn
     * parses the string to return an instruction.
     * 
     * @param splitStringList Arraylist of strings to be parsed
     * @return List of instructions
     * @throws Exception if any parsing fails
     */
    private List<Instruction> createInstructionList(ArrayList<String[]> splitStringList) throws Exception {
        ArrayList<Instruction> instructions = new ArrayList();
        for (String[] splitString: splitStringList) {
            switch (splitString[0]) {
                case "Drop": 
                    instructions.add(parseDrop(splitString));
                    break;
                case "Flip": 
                    instructions.add(parseFlip(splitString));
                    break;
                case "Mark": 
                    instructions.add(parseMark(splitString));
                    break;
                case "Move": 
                    instructions.add(parseMove(splitString));
                    break;
                case "PickUp": 
                    instructions.add(parsePickUp(splitString));
                    break;
                case "Sense": 
                    instructions.add(parseSense(splitString));
                    break;
                case "Turn": 
                    instructions.add(parseTurn(splitString));
                    break;
                case "Unmark": 
                    instructions.add(parseUnmark(splitString));
                    break;
                default: throw new Exception();
            }
            
        }
        return instructions;
    }
    /**
     * Given an array of strings check that the array is of the corrected
     * length for the instruction Drop. The array should be the word 'Drop'
     * followed by an int representing state in order to parse
     * 
     * @param splitString Array of strings to be turned to instruction
     * @return Drop instruction if passes parsing
     * @throws Exception if does not meet Drop requirements
     */
    private Drop parseDrop(String[] splitString) throws Exception {
        if (splitString.length == 2) {
            try {
                int state = Integer.parseInt(splitString[1]);
                return new Drop(state);
            } catch (NumberFormatException e) {
                throw e;
            }
            
        } else {
            throw new Exception();
        }
    }
    /**
     * Given array of strings check that the array is of the correct length
     * for the instruction Flip. The array should contain the word 'Flip' followed
     * by three ints. The first is a random number, the second 2 are states.
     * 
     * @param splitString Array of strings to be turned to instruction
     * @return Flip instruction is passes parsing
     * @throws Exception if does not meet Flip requirements
     */
    private Flip parseFlip(String[] splitString) throws Exception {
        if (splitString.length == 4) {
            try {
                int i = Integer.parseInt(splitString[1]);
                int state1 = Integer.parseInt(splitString[2]);
                int state2 = Integer.parseInt(splitString[3]);
                return new Flip(i, state1, state2);
            } catch (NumberFormatException e) {
                throw e;
            }
            
        } else {
            throw new Exception();
        }
    }
    /**
     * Given array of strings check that the array is of the correct length
     * for the instruction Mark. The array should contain the word 'Mark' followed
     * by two ints one representing the marker, the other state
     * 
     * @param splitString Array of strings to be turned to instruction
     * @return Mark instruction is passes parsing
     * @throws Exception if does not meet mark requirements
     */
    private Mark parseMark(String[] splitString) throws Exception {
        if (splitString.length == 3) {
            try {
                int marker = Integer.parseInt(splitString[1]);
                if (marker > 5) {
                    throw new Exception();
                }
                int state = Integer.parseInt(splitString[2]);
                return new Mark(marker, state);
            } catch (NumberFormatException e) {
                throw e;
            }
            
        } else {
            throw new Exception();
        }
    }
     /**
     * Given array of strings check that the array is of the correct length
     * for the instruction Move. The array should contain the word 'Move' followed
     * by two ints representing state
     * 
     * @param splitString Array of strings to be turned to instruction
     * @return Move instruction is passes parsing
     * @throws Exception if does not meet mark requirements
     */
    private Move parseMove(String[] splitString) throws Exception {
        if (splitString.length == 3) {
            try {
                int state1 = Integer.parseInt(splitString[1]);
                int state2 = Integer.parseInt(splitString[2]);
                return new Move(state1, state2);
            } catch (NumberFormatException e) {
                throw e;
            }
            
        } else {
            throw new Exception();
        }
    }
         /**
     * Given array of strings check that the array is of the correct length
     * for the instruction PickUp. The array should contain the word 'PickUp' followed
     * by two ints representing state
     * 
     * @param splitString Array of strings to be turned to instruction
     * @return PickUp instruction is passes parsing
     * @throws Exception if does not meet mark requirements
     */
    private PickUp parsePickUp(String[] splitString) throws Exception {
        if (splitString.length == 3) {
            try {
                int state1 = Integer.parseInt(splitString[1]);
                int state2 = Integer.parseInt(splitString[2]);
                return new PickUp(state1, state2);
            } catch (NumberFormatException e) {
                throw e;
            }
            
        } else {
            throw new Exception();
        }
    }
     /**
     * Given array of strings check that the array is of the correct length
     * for the instruction Sense. The array should contain the word 'Sense' followed
     * by a {@link}SenseDir enum, two ints representing state, and a condition
     * 
     * @param splitString Array of strings to be turned to instruction
     * @return Sense instruction is passes parsing
     * @throws Exception if does not meet mark requirements
     */
    private Sense parseSense(String[] splitString) throws Exception {
        if (splitString.length == 5 || splitString.length == 6) {
            try {
                SenseDir senseDir;
                if (SenseDir.HERE.toString().equalsIgnoreCase(splitString[1])) {
                    senseDir = SenseDir.HERE;
                } else if (SenseDir.AHEAD.toString().equalsIgnoreCase(splitString[1])) {
                    senseDir = SenseDir.AHEAD;
                } else if (SenseDir.LEFTAHEAD.toString().equalsIgnoreCase(splitString[1])) {
                    senseDir = SenseDir.LEFTAHEAD;
                } else if (SenseDir.RIGHTAHEAD.toString().equalsIgnoreCase(splitString[1])) {
                    senseDir = SenseDir.RIGHTAHEAD;
                } else {
                    throw new Exception();
                }
                int state1 = Integer.parseInt(splitString[2]);
                int state2 = Integer.parseInt(splitString[3]);
                Condition condition;
                if (splitString.length == 5) {
                    condition = parseCondition(splitString[4]);
                } else if (splitString[4].equals("Marker")){
                    condition = parseCondition(splitString[5]);
                } else {
                    throw new Exception();
                }
                return new Sense(senseDir, state1, state2, condition);
            } catch (NumberFormatException e) {
                throw e;
            }
            
        } else {
            throw new Exception();
        }
    }
         /**
     * Given array of strings check that the array is of the correct length
     * for the instruction Turn. The array should contain the word 'Turn' followed
     * by LeftOrRight enum and an int representing state.
     * 
     * @param splitString Array of strings to be turned to instruction
     * @return Turn instruction is passes parsing
     * @throws Exception if does not meet mark requirements
     */
    private Turn parseTurn(String[] splitString) throws Exception {
        if (splitString.length == 3) {
            try {
                LeftOrRight leftOrRight;
                if (LeftOrRight.LEFT.toString().equalsIgnoreCase(splitString[1])) {
                    leftOrRight = LeftOrRight.LEFT;
                } else if (LeftOrRight.RIGHT.toString().equalsIgnoreCase(splitString[1])) {
                    leftOrRight = LeftOrRight.RIGHT;
                } else {
                    throw new Exception();
                }
                int state = Integer.parseInt(splitString[2]);
                return new Turn(leftOrRight, state);
            } catch (NumberFormatException e) {
                throw e;
            }
            
        } else {
            throw new Exception();
        }
    }
    /**
     * Given array of strings check that the array is of the correct length
     * for the instruction Unmark. The array should contain the word 'Unmark' followed
     * by two ints one representing marker, the other state
     * 
     * @param splitString Array of strings to be turned to instruction
     * @return Unmark instruction is passes parsing
     * @throws Exception if does not meet mark requirements
     */
    private Unmark parseUnmark(String[] splitString) throws Exception {
        if (splitString.length == 3) {
            try {
                int marker = Integer.parseInt(splitString[1]);
                if (marker > 5) {
                    throw new Exception();
                }
                int state = Integer.parseInt(splitString[2]);
                return new Unmark(marker, state);
            } catch (NumberFormatException e) {
                throw e;
            }
            
        } else {
            throw new Exception();
        }
    }
    /**
     * Given a string check which condition it corresponds to.
     * Return the correct condition
     * 
     * @param splitString String to be parsed
     * @return Condition of correct type
     * @throws Exception if no case is matched
    */
    private Condition parseCondition(String splitString) throws Exception {
        switch (splitString) {
            case ("Foe"): return new Foe();
            case ("FoeHome"): return new FoeHome();
            case ("FoeMarker"): return new FoeMarker();
            case ("FoeWithFood"): return new FoeWithFood();
            case ("Food"): return new Food();
            case ("Friend"): return new Friend();
            case ("FriendWithFood"): return new FriendWithFood();
            case ("Home"): return new Home();
            case ("Rock"): return new Rock();
            default:
                try {
                    int marker = Integer.parseInt(splitString);
                    if (marker > 5) {
                        throw new Exception();
                    }
                    return new Marker(marker);
                } catch (NumberFormatException e) {
                    throw e;
                }
        }
    }
}
