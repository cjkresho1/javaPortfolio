/**
 * 
 */
package linkedlist;


/**
 * @author Charles Kresho
 * @version 2016.3.25
 */
public class SinglyLinkedListTest extends student.TestCase
{
    private SinglyLinkedList<String> emptyList;
    private SinglyLinkedList<String> list1;
    private SinglyLinkedList<String> list2;
    private SinglyLinkedList<String> list2Copy;
    private SinglyLinkedList<String> repeatList;
    
    /**
     * Sets up the variables for the tests
     */
    public void setUp()
    {
        emptyList = new SinglyLinkedList<String>();
                
        list1 = new SinglyLinkedList<String>();
        list1.add("First");
        list1.add("Second");
        list1.add("Third");
        
        list2 = new SinglyLinkedList<String>();
        list2.add("First");
        list2.add("Second");
        
        list2Copy = new SinglyLinkedList<String>();
        list2Copy.add("First");
        list2Copy.add("Second");
        
        repeatList = new SinglyLinkedList<String>();
        repeatList.add("First");
        repeatList.add("Second");
        repeatList.add("Third");
        repeatList.add("First");
    }
    
    /**
     * Tests the size method
     */
    public void testSize()
    {
        setUp();
        assertEquals(emptyList.size(), 0);
        assertEquals(list2.size(), 2);
    }
    
    /**
     * Tests the add method
     * 
     * First tests add(index, object)
     * Then tests add(object)
     */
    public void testAdd()
    {
        setUp();
        String nullString = null;
        boolean caught = false;
        try
        {
            emptyList.add(0, nullString);
        }
        catch (IllegalArgumentException e)
        {
            caught = true;
        }
        assertTrue(caught);
        caught = false;
        
        try
        {
            emptyList.add(-1, "First");
        }
        catch (IndexOutOfBoundsException e)
        {
            caught = true;
        }
        assertTrue(caught);
        caught = false;
        
        try
        {
            emptyList.add(1, "First");
        }
        catch (IndexOutOfBoundsException e)
        {
            caught = true;
        }
        assertTrue(caught);
        
        assertEquals(emptyList.size(), 0);
        emptyList.add(0, "First");
        assertEquals(emptyList.toString(), "{First}");
        assertEquals(emptyList.size(), 1);
        
        assertEquals(list1.size(), 3);
        list1.add(0, "Zeroth");
        assertEquals(list1.toString(), "{Zeroth, First, Second, Third}");
        assertEquals(list1.size(), 4);
        
        assertEquals(list2.size(), 2);
        list2.add(1, "1/2th");
        assertEquals(list2.size(), 3);
        assertEquals(list2.toString(), "{First, 1/2th, Second}");
        
        assertEquals(list2Copy.size(), 2);
        list2Copy.add(2, "Third");
        assertEquals(list2Copy.size(), 3);
        assertEquals(list2Copy.toString(), "{First, Second, Third}");
        
        setUp();
        
        caught = false;
        try
        {
            emptyList.add(nullString);
        }
        catch (IllegalArgumentException e)
        {
            caught = true;
        }
        assertTrue(caught);
        
        assertEquals(emptyList.size(), 0);
        emptyList.add("First");
        assertEquals(emptyList.toString(), "{First}");
        assertEquals(emptyList.size(), 1);
        
        assertEquals(list1.size(), 3);
        list1.add("Fourth");
        assertEquals(list1.toString(), "{First, Second, Third, Fourth}");
        assertEquals(list1.size(), 4);
    }
    
    /**
     * Tests the isEmpty method
     */
    public void testIsEmpty()
    {
        setUp();
        
        assertTrue(emptyList.isEmpty());
        assertFalse(list1.isEmpty());
    }
    
    /**
     * Tests the remove method
     * 
     * First tests remove(object)
     * Then tests remove(index)
     */
    public void testRemove()
    {
        setUp();
        
        assertFalse(emptyList.remove("First"));
        assertFalse(list1.remove("Fourth"));
        
        assertEquals(list1.size(), 3);
        assertTrue(list1.remove("First"));
        assertEquals(list1.size(), 2);
        assertEquals(list1.toString(), "{Second, Third}");
        
        assertEquals(list1.size(), 2);
        assertTrue(list1.remove("Third"));
        assertEquals(list1.size(), 1);
        assertEquals(list1.toString(), "{Second}");
        
        assertEquals(list1.size(), 1);
        assertTrue(list1.remove("Second"));
        assertEquals(list1.size(), 0);
        assertEquals(list1.toString(), "{}");
        
        setUp();
        
        boolean caught = false;
        
        try
        {
            list1.remove(-1);
        }
        catch (IndexOutOfBoundsException e)
        {
            caught = true;
        }
        assertTrue(caught);
        caught = false;
        
        try
        {
            emptyList.remove(0);
        }
        catch (IndexOutOfBoundsException e)
        {
            caught = true;
        }
        assertTrue(caught);
        caught = false;
        
        try
        {
            list1.remove(3);
        }
        catch (IndexOutOfBoundsException e)
        {
            caught = true;
        }
        assertTrue(caught);
        caught = false;
                
        assertEquals(list1.size(), 3);
        assertTrue(list1.remove(2));
        assertEquals(list1.size(), 2);
        assertEquals(list1.toString(), "{First, Second}");
        
        assertEquals(list1.size(), 2);
        assertTrue(list1.remove(1));
        assertEquals(list1.size(), 1);
        assertEquals(list1.toString(), "{First}");
        
        try
        {
            list1.remove(1);
        }
        catch (IndexOutOfBoundsException e)
        {
            caught = true;
        }
        assertTrue(caught);
        
        assertEquals(list1.size(), 1);
        assertTrue(list1.remove(0));
        assertEquals(list1.size(), 0);
        assertEquals(list1.toString(), "{}");
        
        setUp();
        
        assertEquals(list1.size(), 3);
        assertTrue(list1.remove(0));
        assertEquals(list1.size(), 2);
        assertEquals(list1.toString(), "{Second, Third}");
    }
    
    /**
     * Tests the get method
     */
    public void testGet()
    {
        setUp();
        
        boolean caught = false;
        
        try
        {
            emptyList.get(0);
        }
        catch (IndexOutOfBoundsException e)
        {
            caught = true;
        }
        assertTrue(caught);
        caught = false;
        
        try
        {
            list1.get(3);
        }
        catch (IndexOutOfBoundsException e)
        {
            caught = true;
        }
        assertTrue(caught);
        
        assertEquals(list1.size(), 3);
        assertEquals(list1.get(2), "Third");
        assertEquals(list1.size(), 3);
        assertEquals(list1.toString(), "{First, Second, Third}");
        
        assertEquals(list1.size(), 3);
        assertEquals(list1.get(1), "Second");
        assertEquals(list1.size(), 3);
        assertEquals(list1.toString(), "{First, Second, Third}");
        
        assertEquals(list1.size(), 3);
        assertEquals(list1.get(0), "First");
        assertEquals(list1.size(), 3);
        assertEquals(list1.toString(), "{First, Second, Third}");
    }
    
    /**
     * Tests the contains method
     */
    public void testContains()
    {
        setUp();
        
        assertEquals(list1.size(), 3);
        assertTrue(list1.contains("Third"));
        assertEquals(list1.size(), 3);
        assertEquals(list1.toString(), "{First, Second, Third}");
        
        assertEquals(list1.size(), 3);
        assertTrue(list1.contains("Second"));
        assertEquals(list1.size(), 3);
        assertEquals(list1.toString(), "{First, Second, Third}");
        
        assertEquals(list1.size(), 3);
        assertTrue(list1.contains("First"));
        assertEquals(list1.size(), 3);
        assertEquals(list1.toString(), "{First, Second, Third}");
        
        assertEquals(list1.size(), 3);
        assertFalse(list1.contains("Fourth"));
        assertEquals(list1.size(), 3);
        assertEquals(list1.toString(), "{First, Second, Third}");
        
        assertEquals(emptyList.size(), 0);
        assertFalse(emptyList.contains("Anything"));
        assertEquals(emptyList.size(), 0);
        assertEquals(emptyList.toString(), "{}");
    }
    
    /**
     * Tests the clear method
     */
    public void testClear()
    {
        setUp();
        
        assertEquals(emptyList.size(), 0);
        emptyList.clear();
        assertEquals(emptyList.size(), 0);
        assertEquals(emptyList.toString(), "{}");
        
        assertEquals(list1.size(), 3);
        assertEquals(list1.toString(), "{First, Second, Third}");
        list1.clear();
        assertEquals(list1.size(), 0);
        assertEquals(list1.toString(), "{}");
    }
    
    /**
     * Tests the lastIndexOf method
     */
    public void testLastIndexOf()
    {
        setUp();
        
        assertEquals(list1.size(), 3);
        assertEquals(list1.lastIndexOf("First"), 0);
        assertEquals(list1.size(), 3);
        assertEquals(list1.toString(), "{First, Second, Third}");
        
        assertEquals(list1.size(), 3);
        assertEquals(list1.lastIndexOf("Second"), 1);
        assertEquals(list1.size(), 3);
        assertEquals(list1.toString(), "{First, Second, Third}");
        
        assertEquals(list1.size(), 3);
        assertEquals(list1.lastIndexOf("Third"), 2);
        assertEquals(list1.size(), 3);
        assertEquals(list1.toString(), "{First, Second, Third}");
        
        assertEquals(repeatList.size(), 4);
        assertEquals(repeatList.lastIndexOf("First"), 3);
        assertEquals(repeatList.size(), 4);
        assertEquals(repeatList.toString(), "{First, Second, Third, First}");
        
        assertEquals(repeatList.size(), 4);
        assertEquals(repeatList.lastIndexOf("Second"), 1);
        assertEquals(repeatList.size(), 4);
        assertEquals(repeatList.toString(), "{First, Second, Third, First}");
        
        assertEquals(repeatList.size(), 4);
        assertEquals(repeatList.lastIndexOf("Third"), 2);
        assertEquals(repeatList.size(), 4);
        assertEquals(repeatList.toString(), "{First, Second, Third, First}");
    }
    
    /**
     * Tests the toString method
     */
    public void testToString()
    {
        setUp();
        
        assertEquals(emptyList.size(), 0);
        assertEquals(emptyList.toString(), "{}");
        assertEquals(emptyList.size(), 0);
        
        assertEquals(list1.size(), 3);
        assertEquals(list1.toString(), "{First, Second, Third}");
        assertEquals(list1.size(), 3);
    }
}
