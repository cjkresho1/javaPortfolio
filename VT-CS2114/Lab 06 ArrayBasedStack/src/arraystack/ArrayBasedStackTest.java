package arraystack;

import java.awt.Color;
import java.util.EmptyStackException;

import student.TestCase;

/**
 * 
 * @author Charles Kresho
 * @version 2016.2.26
 */
public class ArrayBasedStackTest extends TestCase 
{
    private ArrayBasedStack<Color> emptyStack;
    private ArrayBasedStack<Color> stack1;
    private ArrayBasedStack<Color> fullStack;
    private ArrayBasedStack<Color> nullStack;
    private ArrayBasedStack<Color> stack2;
    private ArrayBasedStack<Color> stack3;
    
    /**
     * Sets up the variables for each test
     */
    public void setUp()
    {
        emptyStack = new ArrayBasedStack<Color>();
        
        stack1 = new ArrayBasedStack<Color>();
        stack1.push(Color.BLACK);
        stack1.push(Color.BLUE);
        stack1.push(Color.YELLOW);
        
        stack2 = new ArrayBasedStack<Color>();
        stack2.push(Color.BLACK);
        stack2.push(Color.BLUE);
        stack2.push(Color.YELLOW);
        
        stack3 = new ArrayBasedStack<Color>();
        stack3.push(Color.BLACK);
        stack3.push(Color.BLACK);
        stack3.push(Color.BLACK);
        
        nullStack = null;
        
        fullStack = new ArrayBasedStack<Color>();
        for (int i = 0; i < 100; i++)
        {
            fullStack.push(Color.BLACK);
        }
    }
    
    /**
     * Tests the method isEmpty
     */
    public void testIsEmpty()
    {
        setUp();
        assertTrue(emptyStack.isEmpty());
        assertFalse(stack1.isEmpty());
    }
    
    /**
     * Tests the method peek
     */
    public void testPeek()
    {
        setUp();
        boolean caught = false;
        try
        {
            emptyStack.peek();
        }
        catch (EmptyStackException exception)
        {
            caught = true;
        }
        assertTrue(caught);
        assertEquals(Color.YELLOW, stack1.peek());
    }
    
    /**
     * Tests the method pop
     */
    public void testPop()
    {
        setUp();
        boolean caught = false;
        try
        {
            emptyStack.pop();
        }
        catch (EmptyStackException exception)
        {
            caught = true;
        }
        assertTrue(caught);
        assertEquals(3, stack1.size());
        assertEquals(Color.YELLOW, stack1.pop());    
        assertEquals(2, stack1.size());
    }
    
    /**
     * Tests the method push
     */
    public void testPush()
    {
        setUp();
        assertEquals(fullStack.size(), 100);
        fullStack.push(Color.BLACK);
        assertEquals(fullStack.size(), 101);
    }
    
    /**
     * Tests the method contains
     */
    public void testContains()
    {
        setUp();
        assertFalse(stack1.contains(Color.CYAN));
        assertTrue(stack1.contains(Color.BLACK));
    }
    
    /**
     * Tests the method size
     */
    public void testSize()
    {
        setUp();
        assertEquals(fullStack.size(), 100);
        assertEquals(3, stack1.size());
    }
    
    /**
     * Tests the method clear
     */
    public void testClear()
    {
        setUp();
        assertEquals(fullStack.size(), 100);
        fullStack.clear();
        assertEquals(fullStack.size(), 0);
        assertEquals(fullStack, emptyStack);
    }
    
    /**
     * Tests the method toArray
     */
    public void testToArray()
    {
        setUp();
        Object[] array1 = stack1.toArray();
        assertEquals(array1.length, stack1.size());
        for (int i = array1.length - 1; i >= 0; i--)
        {
            assertEquals(array1[i], stack1.pop());
        }
    }
    
    /**
     * Tests the method toString
     */
    public void testToString()
    {
        String string = stack1.toString();
        assertEquals(string, "[" + Color.BLACK.toString() + ", " + 
                Color.BLUE.toString() + ", " + Color.YELLOW.toString() + "]");
    }
    
    /**
     * Tests the method equals
     */
    public void testEquals()
    {
        assertTrue(stack1.equals(stack1));
        assertFalse(stack1.equals(nullStack));
        assertFalse(stack1.equals(new Object()));
        assertFalse(stack1.equals(fullStack));
        assertTrue(stack1.equals(stack2));
        assertFalse(stack1.equals(stack3));
    }
}
