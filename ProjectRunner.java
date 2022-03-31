
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
