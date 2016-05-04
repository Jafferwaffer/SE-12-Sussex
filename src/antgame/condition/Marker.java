/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antgame.condition;

/**
 *
 * @author ht226
 */
public class Marker implements Condition {
    int marker;

    public Marker(int marker) {
        this.marker = marker;
    }

    public int getMarker() {
        return marker;
    }

    public void setMarker(int marker) {
        this.marker = marker;
    }
}
