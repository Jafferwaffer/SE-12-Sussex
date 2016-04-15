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
 * @author ht226
 */
public class AntBrainParser {

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
