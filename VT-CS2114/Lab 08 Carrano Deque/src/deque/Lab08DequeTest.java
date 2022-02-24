package deque;

import student.TestCase;

/**
 * Tests for the DLinkedDeque class.
 *
 * @author Charles Kresho cjkresho
 * @version 2016.3.18
 */
public class Lab08DequeTest extends TestCase
{

    private Lab08Deque<String> deque;

    /**
     * Creates two brand new, empty sets for each test method.
     */
    public void setUp()
    {
        deque = new Lab08Deque<String>();
    }

    /**
     * Tests the addToFront method
     */
    public void testAddToFront()
    {
        setUp();
        assertEquals(0, deque.size());
        deque.addToFront("First");
        assertEquals(1, deque.size());
        assertEquals(deque.getFront(), deque.getBack());
        assertEquals(deque.getFront(), "First");
        deque.addToFront("Second");
        assertEquals(2, deque.size());
        assertEquals(deque.getFront(), "Second");
        assertEquals(deque.getBack(), "First");
    }
    
    /**
     * Tests the addToBack method
     */
    public void testAddToBack()
    {
        setUp();
        assertEquals(0, deque.size());
        deque.addToBack("Second");
        assertEquals(1, deque.size());
        assertEquals(deque.getFront(), deque.getBack());
        assertEquals(deque.getFront(), "Second");
        deque.addToBack("First");
        assertEquals(2, deque.size());
        assertEquals(deque.getFront(), "Second");
        assertEquals(deque.getBack(), "First");
    }
    
    /**
     * Tests the removeFront method
     */
    public void testRemoveFront()
    {
        setUp();
        assertEquals(0, deque.size());
        deque.addToFront("First");
        assertEquals(1, deque.size());
        assertEquals(deque.getFront(), deque.getBack());
        assertEquals(deque.getFront(), "First");
        deque.addToFront("Second");
        assertEquals(2, deque.size());
        assertEquals(deque.getFront(), "Second");
        assertEquals(deque.getBack(), "First");
        assertEquals(deque.removeFront(), "Second");
        assertEquals(1, deque.size());
        assertEquals(deque.getFront(), deque.getBack());
        assertEquals(deque.getFront(), "First");
        assertEquals(deque.removeFront(), "First");
        assertEquals(0, deque.size());
        assertNull(deque.firstNode);
        assertNull(deque.lastNode);
        boolean caught = false;
        try
        {
            deque.removeFront();
        }
        catch (EmptyQueueException e)
        {
            caught = true;
        }
        assertTrue(caught);
    }
    
    /**
     * Tests the removeBack method;
     */
    public void testRemoveBack()
    {
        setUp();
        assertEquals(0, deque.size());
        deque.addToBack("Second");
        assertEquals(1, deque.size());
        assertEquals(deque.getFront(), deque.getBack());
        assertEquals(deque.getFront(), "Second");
        deque.addToBack("First");
        assertEquals(2, deque.size());
        assertEquals(deque.getFront(), "Second");
        assertEquals(deque.getBack(), "First");
        assertEquals(deque.removeBack(), "First");
        assertEquals(1, deque.size());
        assertEquals(deque.getFront(), deque.getBack());
        assertEquals(deque.getFront(), "Second");
        assertEquals(deque.removeBack(), "Second");
        assertEquals(0, deque.size());
        assertNull(deque.firstNode);
        assertNull(deque.lastNode);
        boolean caught = false;
        try
        {
            deque.removeBack();
        }
        catch (EmptyQueueException e)
        {
            caught = true;
        }
        assertTrue(caught);
    }
    
    /**
     * Tests the getFront method
     */
    public void testGetFront()
    {
        setUp();
        boolean caught = false;
        try
        {
            deque.getFront();
        }
        catch (EmptyQueueException e)
        {
            caught = true;
        }
        assertTrue(caught);
        assertEquals(0, deque.size());
        deque.addToFront("First");
        assertEquals("First", deque.getFront());
        assertEquals(1, deque.size());
        assertEquals(deque.getFront(), deque.getBack());
        assertEquals(deque.getFront(), "First");
        deque.addToFront("Second");
        assertEquals("Second", deque.getFront());
        assertEquals(2, deque.size());
        assertEquals(deque.getFront(), "Second");
        assertEquals(deque.getBack(), "First");
    }
    
    /**
     * Tests the getBack method
     */
    public void testGetBack()
    {
        setUp();
        boolean caught = false;
        try
        {
            deque.getBack();
        }
        catch (EmptyQueueException e)
        {
            caught = true;
        }
        assertTrue(caught);
        assertEquals(0, deque.size());
        deque.addToBack("Second");
        assertEquals("Second", deque.getBack());
        assertEquals(1, deque.size());
        assertEquals(deque.getFront(), deque.getBack());
        assertEquals(deque.getFront(), "Second");
        deque.addToBack("First");
        assertEquals("First", deque.getBack());
        assertEquals(2, deque.size());
        assertEquals(deque.getFront(), "Second");
        assertEquals(deque.getBack(), "First");
    }
    
    /**
     * Tests the isEmpty method
     */
    public void testIsEmpty()
    {
        setUp();
        assertTrue(deque.isEmpty());
        deque.addToBack("Something");
        assertFalse(deque.isEmpty());
    }
    
    /**
     * Tests the clear method
     */
    public void testClear()
    {
        setUp();
        assertEquals(0, deque.size());
        deque.addToFront("First");
        assertEquals(1, deque.size());
        assertEquals(deque.getFront(), deque.getBack());
        assertEquals(deque.getFront(), "First");
        deque.addToFront("Second");
        assertEquals(2, deque.size());
        assertEquals(deque.getFront(), "Second");
        assertEquals(deque.getBack(), "First");
        deque.clear();
        assertEquals(0, deque.size());
        assertNull(deque.firstNode);
        assertNull(deque.lastNode);
    }
    
    /**
     * Tests the toString method
     */
    public void testToString()
    {
        setUp();
        assertEquals("[]", deque.toString());
        assertEquals(0, deque.size());
        deque.addToFront("First");
        assertEquals(1, deque.size());
        assertEquals(deque.getFront(), deque.getBack());
        assertEquals(deque.getFront(), "First");
        deque.addToFront("Second");
        assertEquals(2, deque.size());
        assertEquals(deque.getFront(), "Second");
        assertEquals(deque.getBack(), "First");
        assertEquals("[Second, First]", deque.toString());
    }
}
