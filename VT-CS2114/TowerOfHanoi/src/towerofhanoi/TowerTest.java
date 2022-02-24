/**
 * 
 */
package towerofhanoi;

import student.TestCase;

/**
 * @author Charles Kresho
 * @version 2016.3.16
 */
public class TowerTest extends TestCase 
{
    private Tower tower1;
    private Disc disk1;
    private Disc disk2;
    
    /**
     * Sets up the variables for each test
     */
    public void setUp()
    {
        tower1 = new Tower(Position.LEFT);
        disk1 = new Disc(10);
        disk2 = new Disc(8);
    }
    
    /**
     * Tests the method position
     */
    public void testPosition()
    {
        setUp();
        assertEquals(Position.LEFT, tower1.position());
    }
    
    /**
     * Tests the method push
     */
    public void testPush()
    {
        setUp();
        assertEquals(0, tower1.size());
        tower1.push(disk1);
        assertEquals(1, tower1.size());
        tower1.push(disk2);
        assertEquals(2, tower1.size());
        tower1.pop();
        tower1.pop();
        assertTrue(tower1.isEmpty());
        tower1.push(disk2);
        assertEquals(1, tower1.size());
        boolean caught = false;
        try
        {
            tower1.push(disk1);
        }
        catch (IllegalStateException e)
        {
            caught = true;
        }
        assertTrue(caught);
        assertEquals(1, tower1.size());
    }
}
