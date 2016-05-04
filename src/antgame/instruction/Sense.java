/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antgame.instruction;
import antgame.condition.Condition;

/**
 *
 * @author ht226
 */
public class Sense implements Instruction {
    SenseDir sense_dir;
    int state1;
    int state2;
    Condition condition;

    public Sense(SenseDir sense_dir, int state1, int state2, Condition condition) {
        this.sense_dir = sense_dir;
        this.state1 = state1;
        this.state2 = state2;
        this.condition = condition;
    }

    public SenseDir getSense_dir() {
        return sense_dir;
    }

    public void setSense_dir(SenseDir sense_dir) {
        this.sense_dir = sense_dir;
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

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
