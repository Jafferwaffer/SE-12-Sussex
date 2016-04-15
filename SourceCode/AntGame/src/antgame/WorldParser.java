/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antgame;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author ht226
 */
public class WorldParser {
    
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
            for (int x = 0; x < splitStringList.size(); x++) {
                String[] splitString = splitStringList.get(x);
                if (splitString.length == xSize) {
                    for (int y = 0; y < splitString.length; y++) {
                        String cellString = splitString[y];
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
