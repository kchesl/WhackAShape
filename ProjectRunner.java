package game;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Kirsten Chesley (kchesley888)

/**
 *
 * @author Kirsten Chesley (kchesley888)
 * @version (2020-Mar-01)
 */
public class ProjectRunner {

    /**
     * creates the shapes
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            WhackAShape w = new WhackAShape(args);
        }
        else {
            WhackAShape w = new WhackAShape();
        }
    }
}
