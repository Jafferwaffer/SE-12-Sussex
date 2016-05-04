package antgame;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Software Engineering 12
 * 
 * This class parses the world file
 */
public class WorldParser {
    
    /**
     * The world is passed to this method in the form of it's filepath.
     * The file is then split line by line and passed to the {@link} createWorld
     * method.
     * 
     * @param filePath of world file
     * @return World as 2D cell array
     * @throws Exception 
     */
    public Cell[][] parseWorld (String filePath) throws Exception {
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
            return createWorld(splitStringList);
        } catch (Exception e){//Catch exception if any
            throw e;
        }
    }
    /**
     * Firstly the dimensions of the world are retrieved through the first 
     * 2 lines of the file.
     * Each character of each line is then checked to create the correct cell object
     * 
     * 
     * @param splitStringList File as lines of strings
     * @return 2D array of cells
     * @throws Exception if dimensions don't match number of lines. Or if a character
     * is invalid.
     */
    private Cell[][] createWorld(ArrayList<String[]> splitStringList) throws Exception {
        if (splitStringList.size() >= 2) {
            String[] xLine = splitStringList.remove(0);
            String[] yLine = splitStringList.remove(0);
            if (xLine.length > 1 || yLine.length > 1) {
                throw new Exception();
            }
            int xSize;
            int ySize;
            try {
                xSize = Integer.parseInt(xLine[0]);
                ySize = Integer.parseInt(yLine[0]);
            } catch (NumberFormatException e) {
                throw e;
            }
            if (splitStringList.size() != ySize) {
                throw new Exception();
            }
            Cell[][] world = new Cell[xSize][ySize];
            for (int y = 0; y < splitStringList.size(); y++) {
                String[] splitString = splitStringList.get(y);
                if (splitString.length == xSize) {
                    for (int x = 0; x < splitString.length; x++) {
                        String cellString = splitString[x];
                        switch (cellString) {
                            case "#":
                                world[x][y] = new Cell(true);
                                break;
                            case ".":
                                world[x][y] = new Cell();
                                break;
                            case "+":
                                world[x][y] = new Cell(0, true, Color.RED);
                                break;
                            case "-":
                                world[x][y] = new Cell(0, true, Color.BLACK);
                                break;
                            default:
                                try {
                                    int food = Integer.parseInt(cellString);
                                    if (food < 1 || food > 9) {
                                        throw new Exception();
                                    }
                                    world[x][y] = new Cell(food, false, null);
                                } catch (NumberFormatException e) {
                                    throw e;
                                }
                        }
                    }
                } else {
                    throw new Exception();
                }
            }
            return world;
        } else {
            throw new Exception();
        }
    }
}
