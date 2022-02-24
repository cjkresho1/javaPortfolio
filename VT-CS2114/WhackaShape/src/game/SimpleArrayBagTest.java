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
public class SimpleArrayBagTest extends TestCase 
{
    private SimpleArrayBag<Color> bag;
    private SimpleArrayBag<Color> bag2;
    private SimpleArrayBag<Color> bag3;
    private SimpleArrayBag<Color> emptyBag = new SimpleArrayBag<Color>();
    private SimpleArrayBag<Color> fullBag;
    
    /**
     * Sets up the bags for each test
     */
    public void setUp()
    {
        bag = new SimpleArrayBag<Color>();
        bag.add(Color.BLUE);
        bag.add(Color.RED);
        bag.add(Color.GREEN);
        
        bag2 = new SimpleArrayBag<Color>();
        bag2.add(Color.BLUE);
        bag2.add(Color.RED);
        bag2.add(Color.GREEN);
        bag2.add(Color.YELLOW);
        
        bag3 = new SimpleArrayBag<Color>();
        bag3.add(Color.GREEN);
        bag3.add(Color.RED);
        
        fullBag = new SimpleArrayBag<Color>();
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
        fullBag.add(Color.BLACK);
    }
    
    /**
     * Tests the method testAdd()
     */
    public void testAdd()
    {
        setUp();
        assertEquals(bag.getCurrentSize(), 3);
        bag.add(Color.YELLOW);
        TestableRandom.setNextInts(0, 0, 1, 1, 2, 2, 3, 3);
        for (int i = 0; i < 3; i++)
        {
            assertEquals(bag.pick(), bag2.pick());
        }
        assertFalse(bag.add(null));
        assertFalse(fullBag.add(Color.BLACK));
    }
    
    /**
     * Tests the method getCurrentSize()
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
     * Tests the method isEmpty()
     */
    public void testIsEmpty()
    {
        setUp();
        assertFalse(bag.isEmpty());
        assertTrue(emptyBag.isEmpty());
    }
    
    /**
     * Tests the method pick()
     */
    public void testPick()
    {
        setUp();
        assertNull(emptyBag.pick());
        TestableRandom.setNextInts(0);
        assertEquals(bag.pick(), Color.BLUE);
    }
    
    /**
     * Tests the method remove()
     */
    public void testRemove()
    {
        setUp();
        assertFalse(bag.remove(null));
        assertFalse(bag.remove(Color.CYAN));
        assertEquals(bag.getCurrentSize(), 3);
        bag.remove(Color.BLUE);
        TestableRandom.setNextInts(0, 0, 1, 1);
        for (int i = 0; i < 2; i++)
        {
            assertEquals(bag.pick(), bag3.pick());
        }
    }
}
