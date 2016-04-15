/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antgame;
import antgame.instruction.LeftOrRight;
import antgame.instruction.SenseDir;
import antgame.condition.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ht226
 */
public class World {
    Cell[][] world;
    List<Ant> ants;

    public World(Cell[][] world) {
        this.ants = new ArrayList();
        this.world = world;
    }
    
    /********************************************
    Geometry
    ********************************************/
    public Position adjacent_cell(Position pos, int direction) throws Exception {
        switch (direction) {
            case 0: return new Position(pos.x + 1, pos.y);
            case 1: return (pos.y % 2 == 0) ? new Position(pos.x, pos.y + 1) : new Position(pos.x + 1, pos.y + 1);
            case 2: return (pos.y % 2 == 0) ? new Position(pos.x - 1, pos.y + 1) : new Position(pos.x, pos.y + 1);
            case 3: return new Position(pos.x - 1, pos.y);
            case 4: return (pos.y % 2 == 0) ? new Position(pos.x - 1, pos.y - 1) : new Position(pos.x, pos.y - 1);
            case 5: return (pos.y % 2 == 0) ? new Position(pos.x, pos.y - 1) : new Position(pos.x + 1, pos.y - 1);
            default: throw new Exception();
        }
    }
    
    public int turn(LeftOrRight left_or_right, int direction) throws Exception {
        switch (left_or_right) {
            case LEFT: return (direction + 5) % 6;
            case RIGHT: return (direction + 1) % 6;
            default: throw new Exception();
        }
    }
    
    public Position sensed_cell(Position p, int direction, SenseDir sense_dir) throws Exception {
        switch (sense_dir) {
            case HERE: return p;
            case AHEAD: return adjacent_cell(p, direction);
            case LEFTAHEAD: return adjacent_cell(p, turn(LeftOrRight.LEFT, direction));
            case RIGHTAHEAD: return adjacent_cell(p, turn(LeftOrRight.RIGHT, direction));
            default: throw new Exception();
        }
    }
    
    /********************************************
    Biology
    ********************************************/
    public Color other_color(Color c) throws Exception {
        switch (c) {
            case BLACK: return Color.RED;
            case RED: return Color.BLACK;
            default: throw new Exception();
        }
    }
    
    /********************************************
     Geography
    ********************************************/
    public boolean some_ant_is_at(Position pos) {
        return world[pos.x][pos.y].getAnt() != null;
    }
    
    public Ant ant_at(Position pos) {
        return world[pos.x][pos.y].getAnt();
    }
    
    public void set_ant_at(Position pos, Ant ant) {
        world[pos.x][pos.y].setAnt(ant);
    }
    
    public void clear_ant_at(Position pos) {
        world[pos.x][pos.y].setAnt(null);
    }
    
    public boolean ant_is_alive(int id) {
        return ants.get(id).isAlive();
    }
    
    public Position find_ant(int id) {
        return (ants.get(id).isAlive()) ? ants.get(id).getPosition() : null;
    }
    
    public void kill_ant_at(int id, Position pos) {
        set_ant_at(pos, null);
        ants.get(id).setAlive(false);
        System.out.println("Ant " + id + " died at x pos " + pos.x + " y pos " + pos.y);
    }
    
    public int food_at(Position pos) {
        return world[pos.x][pos.y].getFood();
    }
    
    public void set_food_at(Position pos, int food) {
        world[pos.x][pos.y].setFood(food);
    }
    
    public boolean anthill_at(Position p, Color c) {
        return this.world[p.x][p.y].antHill() && this.world[p.x][p.y].getAntHillColor() == c;
    }
    
    /********************************************
    Chemistry
    ********************************************/
    public void set_marker_at(Position p, Color color, int marker) {
        if (color == Color.RED) {
            this.world[p.x][p.y].setRed(marker);
        } else {
            this.world[p.x][p.y].setBlack(marker);
        }
        
    }

    public void clear_marker_at(Position p, Color color, int marker) {
        if (color == Color.RED) { 
            this.world[p.x][p.y].setRed(marker);
        } else {
            this.world[p.x][p.y].setBlack(marker);
        }
    }

    public boolean check_marker_at(Position p, Color c, int marker) {
        return (c == Color.RED) ? this.world[p.x][p.y].getRed() == marker : 
                this.world[p.x][p.y].getBlack() == marker;
    }

    public boolean check_any_marker_at(Position p, Color other_color) {
        return (other_color == Color.RED) ? this.world[p.x][p.y].getRed() >= 0 :
             this.world[p.x][p.y].getBlack() >= 0;
    }
    
    /********************************************
    Phenomenology
    ********************************************/
    public boolean cell_matches(Position p, Condition cond, Color c) throws Exception {
        if (this.world[p.x][p.y].rocky()) {
            return cond instanceof Rock;
        } else {
            if (cond instanceof Friend) {
                return (some_ant_is_at(p) && ant_at(p).color() == c);
            } else if (cond instanceof Foe) {
                return (some_ant_is_at(p) && ant_at(p).color() != c);
            } else if (cond instanceof FriendWithFood) {
                return (some_ant_is_at(p) && ant_at(p).color() == c &&
                        ant_at(p).has_food());
            } else if (cond instanceof FoeWithFood) {
                return (some_ant_is_at(p) && ant_at(p).color() != c &&
                        ant_at(p).has_food());
            } else if (cond instanceof Food) {
                return food_at(p) > 0;
            } else if (cond instanceof Rock) {
                return false;
            } else if (cond instanceof Marker) {
                Marker marker = (Marker)cond;
                return check_marker_at(p, c, marker.getMarker());
            } else if (cond instanceof FoeMarker) {
                return check_any_marker_at(p, other_color(c));
            } else if (cond instanceof Home) {
                return anthill_at(p, c);
            } else if (cond instanceof FoeHome) {
                return anthill_at(p, other_color(c));
            } else {
                throw new Exception();
            }
        }
    }
    
    /********************************************
    Martial Arts
    ********************************************/
    public int adjacent_ants(Position p, Color c) throws Exception {
        int n = 0;
        for (int d = 0; d <= 5; d++) {
            Position cel = adjacent_cell(p, d);
            if (some_ant_is_at(cel) && ant_at(cel).color() == c) {
                n++;
            }
        }
        return n;
    }
    
    public void check_for_surrounded_ant_at(Position p) throws Exception {
        if (some_ant_is_at(p)) {
            Ant a = ant_at(p);
            if (adjacent_ants(p, other_color(a.color())) >= 5) {
                kill_ant_at(a.getId(), p);
                set_food_at(p, food_at(p) + 3 + ((a.has_food()) ? 1 : 0));
            }
        }
    }
    
    public void check_for_surrounded_ants(Position p) throws Exception {
        check_for_surrounded_ant_at(p);
        for (int d = 0; d <= 5; d++) {
            check_for_surrounded_ant_at(adjacent_cell(p,d));
        }
    }
    
    /**********************************************
    Game Play
    **********************************************/
    public void initialiseWorld() {
        for (int x = 0; x < this.world.length; x++) {
            for (int y = 0; y < this.world[x].length; y++) {
                if (this.world[x][y].antHill()) {
                    Ant ant = new Ant(this.ants.size(), this.world[x][y].getAntHillColor(), new Position(x, y));
                    this.world[x][y].setAnt(ant);
                    this.ants.add(ant);
                }
            }
        }
    }

    /**********************************************
    Getters and Setters
    **********************************************/
    public List<Ant> getAnts() {
        return ants;
    }

    public void setAnts(List<Ant> ants) {
        this.ants = ants;
    }

    public int getTotalFood(Color color) {
        int food = 0;
        for (int x = 0; x < this.world.length; x++) {
            for (int y = 0; y < this.world[x].length; y++) {
                if (this.world[x][y].antHill() && this.world[x][y].getAntHillColor().equals(color)) {
                    food = food + this.world[x][y].getFood();
                }
            }
        }
        return food;
    }
    
    
}
