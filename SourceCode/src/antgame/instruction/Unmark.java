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
public class Unmark implements Instruction {
    int marker;
    int state;

    public Unmark(int marker, int state) {
        this.marker = marker;
        this.state = state;
    }

    public int getMarker() {
        return marker;
    }

    public void setMarker(int marker) {
        this.marker = marker;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
