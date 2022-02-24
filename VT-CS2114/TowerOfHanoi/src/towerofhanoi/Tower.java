/**
 * 
 */
package towerofhanoi;

/**
 * @author Charles Kresho
 * @version 2016.3.16
 */
public class Tower extends LinkedStack<Disc> 
{
    private Position position;
    
    /**
     * Creates a new Tower object
     * @param location - location of the tower, from the Position enum
     */
    public Tower(Position location)
    {
        super();
        position = location;
    }
    
    /**
     * Gets the position of the tower
     * @return - the position of the tower
     */
    public Position position()
    {
        return position;
    }
    
    /**
     * Puts a new disk onto the tower
     * @param data - disk to be added to the tower
     * @throws IllegalStateException if the disk is larger than the top disk
     */
    @Override
    public void push(Disc data)
    {
        if (this.size() == 0 || data.compareTo(this.peek()) < 0)
        {
            super.push(data);
        }
        else
        {
            throw new IllegalStateException();
        }
    }
}
