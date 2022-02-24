/**
 * 
 */
package project1;

import bag.BagInterface;
import CS2114.TextShape;

import java.awt.Color;
import CS2114.Window; 
import CS2114.Button; 
import CS2114.WindowSide;

/**
 * @author Charles Kresho
 * @version 2016.1.29
 * 
 */
public class ShapeWindow {

    Window window;
    TextShape textShape;
    Button quitButton;
    Button chooseButton;
    BagInterface<String> itemBag;
    
    /**
     * Constructor sets up the window and the bag of Strings
     * @param bag - the bag that contains the Strings to be displayed
     */
    public ShapeWindow(BagInterface<String> bag)
    {
        window = new Window();
        window.setTitle("Project 1");
        itemBag = bag;
        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);
        chooseButton = new Button("Choose");
        chooseButton.onClick(this, "clickedChoose");
        window.addButton(chooseButton, WindowSide.SOUTH);
        textShape = new TextShape(0, 0, "");
        window.addShape(textShape);
    }
    
    /**
     * Defines the program that makes the quit button close the program
     * @param button - the quit button on the window
     */
    public void clickedQuit(Button button)
    {
        System.exit(0);
    }
    
    /**
     * Defines the program that makes the choose button display a new string
     * @param button - the choose button on the window
     */
    public void clickedChoose(Button button)
    {
        if(!itemBag.isEmpty())
        {
            textShape.setText(itemBag.remove());
        }
        else
        {
            textShape.setText("No more items");
        }
        colorText();
        centerText();
    }
    
    /**
     * Sets the color of the text in the window to match the text it displays
     */
    public void colorText()
    {
        if(textShape.getText().contains("blue"))
        {
            textShape.setForegroundColor(Color.BLUE);
        }
        else if(textShape.getText().contains("red"))
        {
            textShape.setForegroundColor(Color.RED);
        }
        else
        {
            textShape.setForegroundColor(Color.BLACK);
        }
    }
    
    /**
     * Sets the text in the window to be centered
     */
    public void centerText()
    {
        //Sets the location to the average of the window height/width
        textShape.setX((window.getGraphPanelWidth()-textShape.getWidth())/2);
        textShape.setY((window.getGraphPanelHeight()-textShape.getHeight())/2);
    }
}