/**
 * 
 */
package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * @author Charles Kresho
 *
 */
public class GameWindow implements Observer 
{
    private HanoiSolver game;
    private Shape left;
    private Shape right;
    private Shape middle;
    private Window window;
    private final int DISK_GAP = 4;
    private final int DISK_HEIGHT = 5;
    private final int DISK_WIDTH = 10;

    /* (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    @Override
    public void update(Observable arg0, Object arg1) 
    {
        if(arg1.getClass() == Position.class)
        {
            Position arg = ((Position)arg1);
            moveDisk(arg);
            sleep();
        }
    }
    
    public GameWindow(HanoiSolver solver)
    {
        game = solver;
        solver.addObserver(this);
        window = new Window("Tower of Hanoi");
        Color color = new Color(0, 0, 225);
        left = new Shape(100, window.getHeight() - 200, 5, 100, color);
        middle = new Shape(window.getWidth()/2, window.getHeight() - 200, 5, 100, color);
        middle.moveTo((window.getWidth() - middle.getWidth()) / 2, middle.getY());
        right = new Shape(window.getWidth(), window.getHeight() - 200, 5, 100, color);
        right.moveTo(window.getWidth() - right.getWidth() - 100, right.getY());
        
        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.SOUTH);
        for (int i = game.discs(); i > 0 ;i--)
        {
            Disc newDisk = new Disc(DISK_WIDTH * i);
            window.addShape(newDisk);
            game.getTower(Position.LEFT).push(newDisk);
            moveDisk(Position.LEFT);
        }
        solve.onClick(this, "clickedSolve");
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
    }
    
    public Window getWindow()
    {
        return window;
    }
    
    private void moveDisk(Position location)
    {
        Tower tower = game.getTower(location);
        Disc currentDisk = tower.peek();
        Shape currentPole;
        switch (location)
        {
        case LEFT: currentPole = left;
        break;
        case MIDDLE: currentPole = middle;
        break;
        case RIGHT: currentPole = right;
        break;
        default: currentPole = left;
        }
        int x = currentPole.getX() - currentDisk.getWidth() / 2 + currentPole.getWidth() / 2;
        int y = currentPole.getY() + currentPole.getHeight() + DISK_GAP - (tower.size()) * (DISK_GAP + DISK_HEIGHT);
        currentDisk.moveTo(x, y);
    }
    
    private void sleep() {
        try {
            Thread.sleep(1);
        } catch (Exception e) {
        }
    } // end sleep

    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }
}
