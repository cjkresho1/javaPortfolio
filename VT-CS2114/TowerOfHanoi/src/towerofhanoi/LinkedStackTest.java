/**
 * 
 */
package towerofhanoi;

import java.awt.Color;
import java.util.EmptyStackException;

import student.TestCase;

/**
 * @author Charles Kresho
 * @version 2016.3.16
 */
public class LinkedStackTest extends TestCase 
{
    private LinkedStack<Color> empty;
    private LinkedStack<Color> stack1;
    private LinkedStack<Color> stack2;
    private LinkedStack<Color> stack3;
    
    /**
     * Sets up the variables for the test
     */
    public void setUp()
    {
        empty = new LinkedStack<Color>();
        
        stack1 = new LinkedStack<Color>();
        stack1.push(Color.RED);
        stack2 = new LinkedStack<Color>();
        stack2.push(Color.RED);
        stack3 = new LinkedStack<Color>();
        stack3.push(Color.RED);
        stack3.push(Color.BLACK);
    }
    
    /**
     * Tests the method clear()
     */
    public void testClear()
    {
        setUp();
        assertEquals(2, stack3.size());
        stack3.clear();
        assertEquals(0, stack3.size());
    }
    
    /**
     * Tests the method isEmpty
     */
    public void testIsEmpty()
    {
        setUp();
        assertTrue(empty.isEmpty());
        assertFalse(stack2.isEmpty());
    }
    
    /**
     * Tests the method peek
     */
    public void testPeek()
    {
        setUp();
        assertEquals(stack1.size(), 1);
        assertEquals(stack1.peek(), Color.RED);
        assertEquals(stack1.size(), 1);
        boolean caught = false;
        try
        {
            empty.peek();
        }
        catch (EmptyStackException e)
        {
            caught = true;
        }
        assertTrue(caught);
    }
    
    /**
     * Tests the method pop
     */
    public void testPop()
    {
        setUp();
        assertEquals(stack1.size(), 1);
        assertEquals(stack1.pop(), Color.RED);
        assertEquals(stack1.size(), 0);
        boolean caught = false;
        try
        {
            empty.pop();
        }
        catch (EmptyStackException e)
        {
            caught = true;
        }
        assertTrue(caught);
    }
    
    /**
     * Tests the method push
     */
    public void testPush()
    {
        setUp();
        assertEquals(stack1.size(), 1);
        stack1.push(Color.BLACK);
        assertEquals(stack1.size(), 2);
    }
    
    /**
     * Tests the size method
     */
    
    public void testSize()
    {
        assertEquals(stack1.size(), 1);
    }
    
    /**
     * Tests the method toString
     */
    public void testToString()
    {
        assertEquals("[]", empty.toString());
        assertEquals("[" + Color.BLACK.toString() + " " + Color.RED.toString()
            + "]", stack3.toString());
        assertEquals("[" + Color.RED.toString() + "]", stack1.toString());
    }
}
