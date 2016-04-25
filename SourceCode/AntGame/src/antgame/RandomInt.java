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
public class RandomInt {
    int s;

    public RandomInt(int s) {
        this.s = s;
        for (int i = 0; i < 4; i++) {
            this.s = (this.s * 22695477 + 1 & 1073741823);
        }
    }
    
    public int randomInt(int n) {
        int last = ((this.s / 65536) % 16384);
        this.s = (this.s * 22695477 + 1) & (Integer.MAX_VALUE);
        return last % n;
    }
}
