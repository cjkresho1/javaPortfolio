/**
 * 
 */
package prj5;

/**
 * @author Charles Kresho
 * @version 2016.4.15
 */
public class NodeTest extends student.TestCase
{
    private Node<String> first;
    private Node<String> second;
    
    /**
     * Sets up the variables for the tests
     */
    public void setUp()
    {
        first = new Node<String>("First");
        second = new Node<String>("Second");
    }
    
    /**
     * Tests setNext(Node<E>
     */
    public void testSetNext()
    {
        setUp();
        assertNull(first.getNext());
        first.setNext(second);
        assertEquals(second, first.getNext());
    }
    
    /**
     * Tests getNext()
     */
    public void testGetNext()
    {
        setUp();
        assertNull(first.getNext());
    }
    
    /**
     * Tests getData()
     */
    public void testGetData()
    {
        setUp();
        assertEquals("First", first.getData());
        assertEquals("Second", second.getData());
    }
    
    /**
     * Tests toString()
     */
    public void testToString()
    {
        setUp();
        assertEquals("First", first.toString());
        assertEquals("Second", second.toString());
    }
}