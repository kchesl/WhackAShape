package game;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Kirsten Chesley (kchesley888)

import CS2114.Button;
import CS2114.CircleShape;
import CS2114.Shape;
import CS2114.SquareShape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;
import bag.SimpleBagInterface;
import student.TestableRandom;
import java.awt.Color;
import java.lang.IllegalArgumentException;

/**
 *
 * @author Kirsten Chesley (kchesley888)
 * @version (2020-Mar-01)
 */
public class WhackAShape {

    private SimpleBagInterface<Shape> bag;
    private Window window;
    private TestableRandom randomGenerator;

    /**
     * default constructor
     */
    public WhackAShape() {
        bag = new SimpleArrayBag<Shape>();
        window = new Window();
        window.setTitle("WhackAShape");
        Button quit = new Button("Quit");
        window.addButton(quit, WindowSide.SOUTH);
        quit.onClick(this, "clickedQuit");
        String[] shap = { "red circle", "blue circle", "red square",
            "blue square" };
        randomGenerator = new TestableRandom();
        int bagSize = randomGenerator.nextInt(6) + 7;
        for (int i = 0; i < bagSize; i++) {
            bag.add(this.buildShape(shap[randomGenerator.nextInt(4)]));
        }
        window.addShape(bag.pick());
    }


    /**
     * constructor that fills the bag with shapes
     */
    public WhackAShape(String[] string) {
        bag = new SimpleArrayBag<Shape>();
        window = new Window();
        window.setTitle("WhackAShape");
        Button quit = new Button("Quit");
        window.addButton(quit, WindowSide.SOUTH);
        quit.onClick(this, "clickedQuit");
        for (int i = 0; i < string.length; i++) {
            Shape s = null;
            try {
                s = this.buildShape(string[i]);
            }
            catch (RuntimeException e) {
                e.printStackTrace();
            }
            if (s != null) {
                bag.add(s);
            }
        }
        window.addShape(bag.pick());
    }


    /**
     * gets the bag
     * 
     * @return
     */
    public SimpleBagInterface<Shape> getBag() {
        return bag;
    }


    /**
     * returns a window
     * 
     * @return returns a window
     */
    public Window getWindow() {
        return window;
    }


    /**
     * quits window
     * 
     * @param b
     *            button
     */
    public void clickedQuit(Button b) {
        System.exit(0);
    }


    /**
     * clicks shape
     */
    public void clickedShape(Shape s) {
        window.removeShape(s);
        bag.remove(s);
        Shape nextShape = bag.pick();
        if (nextShape == null) {
            TextShape win = new TextShape(window.getGraphPanelWidth(), window
                .getGraphPanelHeight(), "You Win!");
            window.addShape(win);
        }
        else {

            window.addShape(nextShape);
        }
    }


    /**
     * builds the shape
     * 
     * @return shape
     */
    private Shape buildShape(String s) {
        TestableRandom generator = new TestableRandom();
        int size = generator.nextInt(101) + 100;
        int x = generator.nextInt(window.getGraphPanelWidth() - size);
        int y = generator.nextInt(window.getGraphPanelHeight() - size);
        Color color;
        Shape currentShape;
        if (!s.contains("red") && (!s.contains("blue"))) {
            throw new IllegalArgumentException();
        }
        else if (s.contains("red")) {
            color = Color.red;
        }
        else {
            color = Color.blue;
        }
        if (!s.contains("circle") && !s.contains("square")) {
            throw new IllegalArgumentException();
        }
        else if (s.contains("circle")) {
            currentShape = new CircleShape(x, y, size, color);
        }
        else {
            currentShape = new SquareShape(x, y, size, color);
        }
        currentShape.onClick(this, "clickedShape");
        return currentShape;
    }
}
