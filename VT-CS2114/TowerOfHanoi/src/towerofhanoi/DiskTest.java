/**
 * 
 */
package towerofhanoi;

import student.TestCase;

/**
 * @author Charles Kresho
 * @version 2016.3.16
 */
public class DiskTest extends TestCase 
{
    private Disc disk1;
    private Disc disk2;
    private Disc disk3;
    private Disc nullDisk;
    
    /**
     * Sets up the variables for the tests
     */
    public void setUp()
    {
        disk1 = new Disc(1);
        disk2 = new Disc(2);
        disk3 = new Disc(2);
        nullDisk = null;
    }
    
    /**
     * Tests the compareTo method
     */
    public void testCompareTo()
    {
        setUp();
        assertEquals(0, disk3.compareTo(disk2));
        assertEquals(1, disk2.compareTo(disk1));
        assertEquals(-1, disk1.compareTo(disk2));
        boolean caught = false;
        try
        {
            disk1.compareTo(null);
        }
        catch (IllegalArgumentException e)
        {
            caught = true;
        }
        assertTrue(caught);
    }
    
    /**
     * Tests the toString method
     */
    public void testToString()
    {
        setUp();
        assertEquals("1", disk1.toString());
        assertEquals("2", disk2.toString());
    }
    
    /**
     * Tests the equals method
     */
    public void testEquals()
    {
        assertTrue(disk1.equals(disk1));
        assertFalse(disk1.equals(nullDisk));
        assertFalse(disk1.equals(new Object()));
        assertFalse(disk1.equals(disk2));
        assertTrue(disk2.equals(disk3));
    }
}
