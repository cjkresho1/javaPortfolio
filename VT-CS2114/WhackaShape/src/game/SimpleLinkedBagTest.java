/**
 * 
 */
package game;

import java.awt.Color;

import student.TestCase;
import student.TestableRandom;

/**
 * @author Charles Kresho
 * @version 2016.2.21
 */
public class SimpleLinkedBagTest extends TestCase 
{
    private SimpleLinkedBag<Color> bag;
    private SimpleLinkedBag<Color> bag2;
    private SimpleLinkedBag<Color> bag3;
    private SimpleLinkedBag<Color> emptyBag = new SimpleLinkedBag<Color>();
   
    /**
     * Sets up the bags for the tests
     */
    public void setUp()
    {
        bag = new SimpleLinkedBag<Color>();
        bag.add(Color.BLUE);
        bag.add(Color.RED);
        bag.add(Color.GREEN);
        
        bag2 = new SimpleLinkedBag<Color>();
        bag2.add(Color.BLUE);
        bag2.add(Color.RED);
        bag2.add(Color.GREEN);
        bag2.add(Color.YELLOW);
        
        bag3 = new SimpleLinkedBag<Color>();
        bag3.add(Color.GREEN);
        bag3.add(Color.RED);
    }
    
    /**
     * Tests the add() method
     */
    public void testAdd()
    {
        setUp();
        assertFalse(bag.add(null));
        assertEquals(bag.getCurrentSize(), 3);
        bag.add(Color.YELLOW);
        TestableRandom.setNextInts(0, 0, 1, 1, 2, 2, 3, 3);
        for (int i = 0; i < 3; i++)
        {
            assertEquals(bag.pick(), bag2.pick());
        }
    }
    
    /**
     * Tests the getCurrentSize() method
     */
    public void testGetCurrentSize()
    {
        setUp();
        assertEquals(bag.getCurrentSize(), 3);
        assertEquals(bag2.getCurrentSize(), 4);
        bag.add(Color.BLACK);
        bag2.remove(Color.YELLOW);
        assertEquals(bag2.getCurrentSize(), 3);
        assertEquals(bag.getCurrentSize(), 4);
    }
    
    /**
     * Tests the isEmpty() method
     */
    public void testIsEmpty()
    {
        setUp();
        assertFalse(bag.isEmpty());
        assertTrue(emptyBag.isEmpty());
    }
    
    /**
     * Tests the pick() method
     */
    public void testPick()
    {
        setUp();
        assertNull(emptyBag.pick());
        TestableRandom.setNextInts(2);
        assertEquals(bag.pick(), Color.BLUE);
    }
    
    /**
     * Tests the remove() method
     */
    public void testRemove()
    {
        setUp();
        assertFalse(bag.remove(null));
        assertEquals(bag.getCurrentSize(), 3);
        bag.remove(Color.BLUE);
        TestableRandom.setNextInts(0, 0, 1, 1);
        for (int i = 0; i < 2; i++)
        {
            assertEquals(bag.pick(), bag3.pick());
        }
    }
}
