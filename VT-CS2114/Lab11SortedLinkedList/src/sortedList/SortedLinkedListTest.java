/**
 * 
 */
package sortedList;

import java.util.Arrays;
import student.TestCase;

/**
 * @author Charles Kresho
 * @version 2016.4.8
 */
public class SortedLinkedListTest extends TestCase 
{
    private SortedLinkedList<Integer> intList;
    private int[] intArray = new int[100];
    private SortedLinkedList<String> stringList;
    private String[] stringArray = new String[10];
    
    /**
     * Sets up the variables for the tests.
     */
    public void setUp()
    {
        intList = new SortedLinkedList<Integer>(SortedLinkedList
                .integerComparator());
        boolean caught = false;
        try
        {
            intList.get(0);
        }
        catch (IndexOutOfBoundsException e)
        {
            caught = true;
        }
        assertTrue(caught);
        
        for (int i = 0; i < 100; i++)
        {
            int data = (int) ((Math.random() * 100) + 1);
            intList.add(new Integer(data));
            intArray[i] = data;
        }
        Arrays.sort(intArray);
        stringList = new SortedLinkedList<String>(SortedLinkedList
                .stringComparator());
        stringArray[0] = "Bravo";
        stringArray[1] = "Alpha";
        stringArray[2] = "Golf";
        stringArray[3] = "Charlie";
        stringArray[4] = "Delta";
        stringArray[5] = "Foxtrot";
        stringArray[6] = "Zulu";
        stringArray[7] = "Romeo";
        stringArray[8] = "Kilo";
        stringArray[9] = "Quebec";
        for (int i = 0; i < 10; i++)
        {
            stringList.add(stringArray[i]);
        }
        Arrays.sort(stringArray);
    }
    
    /**
     * Tests get(index)
     */
    public void testGet()
    {
        setUp();
        
        for (int i = 0; i < 100; i++)
        {
            assertEquals(intArray[i], intList.get(i).intValue());
        }
        
        for (int i = 0; i < 10; i++)
        {
            assertEquals(stringArray[i], stringList.get(i));
        }
        boolean caught = false;
        try
        {
            intList.get(1000);
        }
        catch (IndexOutOfBoundsException e)
        {
            caught = true;
        }
        assertTrue(caught);
        try
        {
            intList.get(-5);
        }
        catch (IndexOutOfBoundsException e)
        {
            caught = true;
        }
        assertTrue(caught);
    }
    
    /**
     * Tests size()
     */
    public void testSize()
    {
        setUp();
        assertEquals(100, intList.size());
        assertEquals(10, stringList.size());
    }
}
