package antgame;

import antgame.instruction.*;
import java.util.Random;

/**
 *
 * @author Software Engineering Group 12
 * 
 * Class to represent an instance of the game. This includes a World, two AntBrains
 * and a RandomInt object. For more details on each see classes.
 */
public class GameInstance {
    World gameWorld;
    AntBrain blackBrain;
    AntBrain redBrain;
    RandomInt randomInt;
    /**
     * Constructor for a game instance.
     * Takes an array of cells to represent the world. Two AntBrains are also passed
     * to the GameInstance. Initialised world is called to setup ants at the anthills.
     * A random int is also generated.
     * @param gameWorld Array of cells
     * @param blackBrain AntBrain for the black ants
     * @param redBrain AntBrain for the red ants
     */
    public GameInstance(Cell[][] gameWorld, AntBrain blackBrain, AntBrain redBrain) {
        this.gameWorld = new World(gameWorld);
        this.blackBrain = blackBrain;
        this.redBrain = redBrain;
        this.gameWorld.initialiseWorld();
        this.randomInt = new RandomInt(12345);
    }
    
    /************************************************
    Neurology
    ************************************************/
    /**
     * Given a color and a state use the associated to the brain to get the next
     * instruction.
     * 
     * @param color Enum
     * @param state as an int
     * @return Instruction
     */
    public Instruction get_instruction(Color color, int state) {
        return (color == Color.BLACK) ? blackBrain.getInstructions().get(state) : redBrain.getInstructions().get(state);
    }
    
    /********************************************
    Kinetics
    ********************************************/
    /**
     * Given an id of an ant a check is done to see if the ant is alive.
     * The ants resting is decremented by 1 if greater than 0. If 0 the instruction,
     * retrieved through {@link} get_instruction method. The instruction is then checked
     * to determine the course of action.
     * 
     * @param id Of Ant
     * @throws Exception 
     */
    public void step(int id) throws Exception {
        if (this.gameWorld.ant_is_alive(id)) {
            Position p = this.gameWorld.find_ant(id);
            Ant a = this.gameWorld.ant_at(p);
            if (a.resting() > 0) {
                a.set_resting(a.resting() - 1);
            } else {
                Instruction instruction = get_instruction(a.color(), a.state());
                if (instruction instanceof Sense) {
                    Sense sense = (Sense)instruction;
                    Position p_1 = this.gameWorld.sensed_cell(p, a.direction(), sense.getSense_dir());
                    int st = (this.gameWorld.cell_matches(p_1, sense.getCondition(), a.color())) 
                            ? sense.getState1() : sense.getState2();
                    a.set_state(st);
                } else if (instruction instanceof Mark) {
                    Mark mark = (Mark)instruction;
                    this.gameWorld.set_marker_at(p, a.color(), mark.getMarker());
                    a.set_state(mark.getState());
                } else if (instruction instanceof Unmark) {
                    Unmark unmark = (Unmark)instruction;
                    this.gameWorld.clear_marker_at(p, a.color(), unmark.getMarker());
                    a.set_state(unmark.getState());
                } else if (instruction instanceof PickUp) {
                    PickUp pickup = (PickUp)instruction;
                    if (a.has_food() || this.gameWorld.food_at(p) == 0) {
                        a.set_state(pickup.getState2());
                    } else {
                        //System.out.println("Ant " + a.getId() + " has picked up some food");
                        this.gameWorld.set_food_at(p, this.gameWorld.food_at(p) - 1);
                        a.set_has_food(true);
                        a.set_state(pickup.getState1());
                    }
                } else if (instruction instanceof Drop) {
                    //System.out.println("Ant " + a.getId() + " has dropped some food");
                    Drop drop = (Drop)instruction;
                    if (a.has_food()) {
                        this.gameWorld.set_food_at(p, this.gameWorld.food_at(p) + 1);
                        a.set_has_food(false);
                    }
                    a.set_state(drop.getState());
                } else if (instruction instanceof Turn) {
                    //System.out.println("Ant " + a.getId() + " has turned");
                    Turn turn = (Turn)instruction;
                    a.set_direction(this.gameWorld.turn(turn.getLeft_or_right(), a.direction()));
                    a.set_state(turn.getState());
                } else if (instruction instanceof Move) {
                    Move move = (Move)instruction;
                    Position newp = this.gameWorld.adjacent_cell(p, a.direction());
                    if (this.gameWorld.world[newp.x][newp.y].rocky() || this.gameWorld.some_ant_is_at(newp)) {
                        a.set_state(move.getState2());
                    } else {
                        //System.out.println("Ant " + a.getId() + " has moved");
                        this.gameWorld.clear_ant_at(p);
                        this.gameWorld.set_ant_at(newp, a);
                        a.setPosition(new Position(newp.x, newp.y));
                        a.set_state(move.getState1());
                        a.set_resting(14);
                        this.gameWorld.check_for_surrounded_ants(newp);
                    }
                } else if (instruction instanceof Flip) {
                    Flip flip = (Flip)instruction;
                    Random randomGenerator = new Random();
                    // randomGenerator.nextInt(10)
                    int st = (this.randomInt.randomInt(flip.getI()) == 0) ? flip.getState1() : flip.getState2();
                    a.set_state(st);
                }
            }
        }
    }
    
    /*************************************/
    
    /**
     * Runs a round of the game, returns the world as array of cell objects.
     * For each ant, performs the step method.
     * 
     * @return The game world
     * @throws Exception 
     */
    public Cell[][] runRound() throws Exception {
        for (Ant ant : this.gameWorld.getAnts()) {
            step(ant.getId());
        }
        return this.gameWorld.getWorld();
    }
    /**
     * Checks the number of food particles for each team. The winner is the
     * team with the greatest number of food particles at their ant hill.
     * 
     * @return Winning colour as string. 
     */
    public String getWinner() {
        int blackFood = this.gameWorld.getTotalFood(Color.BLACK);
        int redFood = this.gameWorld.getTotalFood(Color.RED);
        
        System.out.println(blackFood);
        System.out.println(redFood);
        
        if (blackFood == redFood) {
            return "DRAW";
        } else if (blackFood > redFood) {
            return "BLACK";
        } else {
            return "RED";
        }
    }
}
