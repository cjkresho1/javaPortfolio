/**
 * 
 */
package towerofhanoi;

import java.util.Observable;

/**
 * @author Charles Kresho
 * @version 2016.3.16
 */
public class HanoiSolver extends Observable 
{
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;
    
    /**
     * Creates a new HanoiSolver object
     * @param num - the number of disks to solve the towers of hanoi for
     */
    public HanoiSolver(int num)
    {
        numDisks = num;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }
    
    /**
     * Gets the number of disks
     * @return - the number of disks
     */
    public int discs()
    {
        return numDisks;
    }
    
    /**
     * Moves one disk from one tower to another, and notifies the window
     * @param source - tower to take the ring from
     * @param destination - the tower to put the ring on
     */
    private void move(Tower source, Tower destination)
    {
        destination.push(source.pop());
        setChanged();
        notifyObservers(destination.position());
    }
    
    /**
     * Makes the call to start the solving process
     */
    public void solve()
    {
        solveTowers(numDisks, left, middle, right);
    }
    
    /**
     * Uses recursion to move the disks on the startPole to the endPole
     * @param currentDisks - the number of disks on the startPole
     * @param startPole - The pole on which the disks start
     * @param tempPole - The pole which the disks use as a midpoint
     * @param endPole - the pole on which the disks will come to a rest on
     */
    private void solveTowers(int currentDisks, Tower startPole, Tower tempPole,
            Tower endPole)
    {
        if (currentDisks == 1)
        {
            move(startPole, endPole);
        }
        else
        {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }
    
    /**
     * Prints the contents of the three towers from left to right
     * @return the contents of the three towers
     *         [left tower][middle tower][right tower]
     */
    @Override
    public String toString()
    {
        StringBuilder data = new StringBuilder(left.toString().trim());
        data.append(middle.toString().trim());
        data.append(right.toString().trim());
        return data.toString();
    }
    
    /**
     * Returns the tower at the target location
     * @param location - a location from the Position enum
     * @return the tower at the location, the left tower of no valid location
     * is passed
     */
    public Tower getTower(Position location)
    {
        switch (location)
        {
            case LEFT: 
                return left;
            case MIDDLE: 
                return middle;
            case RIGHT: 
                return right;
            default: 
                return left;
        }
    }
}
