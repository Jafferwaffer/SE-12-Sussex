/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antgame.instruction;
/**
 *
 * @author ht226
 */
public class Turn implements Instruction {
    LeftOrRight left_or_right;
    int state;

    public Turn(LeftOrRight left_or_right, int state) {
        this.left_or_right = left_or_right;
        this.state = state;
    }

    public LeftOrRight getLeft_or_right() {
        return left_or_right;
    }

    public void setLeft_or_right(LeftOrRight left_or_right) {
        this.left_or_right = left_or_right;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
