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
public class Move implements Instruction {
    int state1;
    int state2;

    public Move(int state1, int state2) {
        this.state1 = state1;
        this.state2 = state2;
    }

    public int getState1() {
        return state1;
    }

    public void setState1(int state1) {
        this.state1 = state1;
    }

    public int getState2() {
        return state2;
    }

    public void setState2(int state2) {
        this.state2 = state2;
    }
}
