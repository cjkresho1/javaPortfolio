/**
 * 
 */
package game;

import java.awt.Color;

import CS2114.Button;
import CS2114.CircleShape;
import CS2114.Shape;
import CS2114.SquareShape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * @author Charles Kresho
 * @version 2016.2.21
 */
public class WhackAShape 
{
    private SimpleArrayBag<Shape> bag;
    private Window window;
    private TestableRandom randomGenerator;
    
    /**
     * sets up the bag and the window for the program
     */
    public WhackAShape()
    {
        bag = new SimpleArrayBag<Shape>();
        window = new Window();
        randomGenerator = new TestableRandom();
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);
        bag.add(buildShape("red circle"));
        bag.add(buildShape("blue circle"));
        bag.add(buildShape("red square"));
        bag.add(buildShape("blue square"));
        window.addShape(bag.pick());
    }
    
    /**
     * Sets up the bag and the window for the program
     * @param data - shapes to be added to the bag
     */
    public WhackAShape(String[] data)
    {
        bag = new SimpleArrayBag<Shape>();
        window = new Window();
        randomGenerator = new TestableRandom();
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);
        for(String i:data)
        {
            bag.add(buildShape(i));
        }
        window.addShape(bag.pick());
    }
    
    /**
     * Creates the shape and links it the the method clickedShape()
     * @param shape - description of the shape to be created
     * @return the shape that is created
     * @throws IllegalArgumentException if the string doesn't contain the words
     * red or blue and circle or square
     */
    private Shape buildShape(String shape)
    {
        int size = 100 + randomGenerator.nextInt(101);
        int x = randomGenerator.nextInt(window.getGraphPanelWidth() - size);
        int y = randomGenerator.nextInt(window.getGraphPanelHeight() - size);
        Color color;
        if (shape.contains("red"))
        {
            color = Color.RED;
        }
        else if (shape.contains("blue"))
        {
            color = Color.BLUE;
        }
        else
        {
            throw new IllegalArgumentException();
        }
        if (shape.contains("circle"))
        {
            CircleShape currentShape = new CircleShape(x, y, size, color);
            currentShape.onClick(this, "clickedShape");
            return currentShape;
        }
        else if (shape.contains("square"))
        {
            SquareShape currentShape = new SquareShape(x, y, size, color);
            currentShape.onClick(this, "clickedShape");
            return currentShape;
        }
        else
        {
            throw new IllegalArgumentException();
        }

    }
    
    /**
     * Closes the program when the quit button is quit
     * @param quit - the button that is pressed
     */
    public void clickedQuit(Button quit)
    {
        System.exit(0);
    }
    /**
     * Removes the shape from the window when clicked
     * @param shape - the shape that is clicked
     */
    public void clickedShape(Shape shape)
    {
        window.removeShape(shape);
        bag.remove(shape);
        Shape nextShape = bag.pick();
        if (nextShape == null)
        {
            TextShape text = new TextShape(0, 0, "You Win!");
            text.setX((window.getGraphPanelWidth() - text.getWidth()) / 2);
            text.setY((window.getGraphPanelHeight() - text.getHeight()) / 2); 
            window.addShape(text);
        }
        else
        {
            window.addShape(nextShape);
        }
    }
    
    /**
     * Returns the reference to the bag
     * @return the reference to the bag
     */
    public SimpleBagInterface<Shape> getBag()
    {
        return bag;
    }
    
    /**
     * Returns the reference to the window
     * @return the reference to the window
     */
    public Window getWindow()
    {
        return window;
    }
}