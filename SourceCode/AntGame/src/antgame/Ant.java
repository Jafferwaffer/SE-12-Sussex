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
public class Ant {
    int id;
    Color color;
    int state;
    int resting;
    int direction;
    boolean hasFood;
    boolean alive;
    Position position;

    public Ant(int id, Color color, Position position) {
        this.id = id;
        this.color = color;
        this.state = 0;
        this.resting = 0;
        this.direction = 0;
        this.hasFood = false;
        this.alive = true;
        this.position = position;
    }
    
    /************************************************
    Biology
    ************************************************/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Color color() {
        return color;
    }
    
    public int state() {
        return state;
    }
    
    public void set_state(int state) {
        this.state = state;
    }
    
    public int resting() {
        return resting;
    }

    public void set_resting(int resting) {
        this.resting = resting;
    }
    
    public int direction() {
        return this.direction;
    }
    
    public void set_direction(int direction) {
        this.direction = direction;
    }
    
    public boolean has_food() {
        return hasFood;
    }

    public void set_has_food(boolean hasFood) {
        this.hasFood = hasFood;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    
    /************************************************
    Chemistry (Possibly relocated to World)
    ************************************************/
    
    
    /************************************************
    Ant Brain (possibly relocated to classes of their own)
    ************************************************/
    
    /************************************************
    Number Theory 
    ************************************************/
}
