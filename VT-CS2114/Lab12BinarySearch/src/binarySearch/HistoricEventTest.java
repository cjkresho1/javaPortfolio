package binarySearch;
import student.TestCase;

//-------------------------------------------------------------------------
/**
 * Tests for the {@link HistoricEvent} class.
 *
 * @author  Charles Kresho (cjkresho)
 * @version 2016.4.15
 */
public class HistoricEventTest extends TestCase
{
    
    //~ Instance/static variables .............................................

    private HistoricEvent event;
    private HistoricEvent fEvent;
    private static final String TITLE = "CS 2114 Lab";
    private static final String MESSAGE =
        "I went to lab today, and I didn't even get a T-shirt.";





    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Starting conditions for all tests in this class.
     */
    public void setUp()
    {
        event = new HistoricEvent(2010, TITLE, MESSAGE);
    }


    // ----------------------------------------------------------
    /**
     * Test the constructor and accessors.
     */
    public void testAccessors()
    {
        assertEquals(2010, event.getYear());
        assertEquals(TITLE, event.getTitle());
        assertEquals(MESSAGE, event.getDescription());
    }

    /**
     * Test the constructor and accessors.
     */
    public void testConstructors()
    {
        String testTitle = null;
        HistoricEvent testEvent = new HistoricEvent(2010, testTitle, MESSAGE);
        assertEquals(2010, testEvent.getYear());
        assertEquals("No Title", testEvent.getTitle());
        assertEquals(MESSAGE, testEvent.getDescription());
    }
    

    // ----------------------------------------------------------
    /**
     * Test toString() on the event created in setUp().
     */
    public void testToString()
    {
        assertEquals("[2010] " + TITLE + ": " + MESSAGE, event.toString());
    }


    // ----------------------------------------------------------
    /**
     * Test toString() on an event with a null title.
     */
    public void testToString2()
    {
        fEvent = new HistoricEvent(2010, MESSAGE);
        assertEquals("[2010] " + MESSAGE, fEvent.toString());
    }


    // ----------------------------------------------------------
    /**
     * Test toString() on an event with a null description.
     */
    public void testToString3()
    {
        fEvent = new HistoricEvent(2010, TITLE, null);
        assertEquals("[2010] " + TITLE, fEvent.toString());
    }
    
    /**
     * Tests compareTo()
     */
    public void testCompareTo()
    {
        setUp();
        //Tests for when event has a date before fEvent
        fEvent = new HistoricEvent(2011, "Bla", "Other Bla");
        assertTrue(event.compareTo(fEvent) < 0);
        
        //Tests for when event has a date after fEvent
        fEvent = new HistoricEvent(2000, "Bla", "Other Bla");
        assertTrue(event.compareTo(fEvent) > 0);
        
        //Tests for when event and fEvent have equal dates, but event comes 
        //alphanumerically before fEvent
        fEvent = new HistoricEvent(2010, "Doughnut", "Other Bla");
        assertTrue(event.compareTo(fEvent) < 0);
        
        //Tests for when event and fEvent have equal dates, but event comes 
        //alphanumerically after fEvent
        fEvent = new HistoricEvent(2010, "Alphabet", "Other Bla");
        assertTrue(event.compareTo(fEvent) > 0);
        
        //Tests for when event and fEvent are the same
        fEvent = new HistoricEvent(2010, TITLE, MESSAGE);
        assertEquals(event.compareTo(fEvent), 0);
    }
}
