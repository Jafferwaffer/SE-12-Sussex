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
public class AntGame {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        SetUp setup = new SetUp();
        setup.addPlayer("Hayden");
        setup.addPlayer("Loser");
        setup.loadAntBrain("N:\\Documents\\sample.txt");
        setup.loadAntBrain("N:\\Documents\\sample.txt");
        setup.loadWorld("N:\\Documents\\tiny.txt");
        setup.runTwoPlayer();
    }
    
}
