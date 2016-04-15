/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antgame;

/**
 *
 * @author ht226
 */
public class Cell {
    boolean rocky;
    int food;
    int black;
    int red;
    Ant ant;
    boolean antHill;
    Color antHillColor;
    
    public Cell() {
        this.rocky = false;
        this.food = 0;
        this.black = -1;
        this.red = -1;
        this.ant = null;
        this.antHill = false;
        this.antHillColor = null;
    }
    
    public Cell(boolean rocky) {
        this.rocky = rocky;
        this.food = 0;
        this.black = -1;
        this.red = -1;
        this.ant = null;
        this.antHill = false;
        this.antHillColor = null;
    }

    public Cell(int food, boolean antHill, Color antHillColor) {
        this.food = food;
        this.black = -1;
        this.red = -1;
        this.ant = null;
        this.antHill = antHill;
        this.antHillColor = antHillColor;
    }

    public boolean rocky() {
        return rocky;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getBlack() {
        return black;
    }

    public void setBlack(int black) {
        this.black = black;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public Ant getAnt() {
        return ant;
    }

    public void setAnt(Ant ant) {
        this.ant = ant;
    }

    public boolean antHill() {
        return antHill;
    }

    public Color getAntHillColor() {
        return antHillColor;
    }

    public void setAntHillColor(Color antHillColor) {
        this.antHillColor = antHillColor;
    }
}
