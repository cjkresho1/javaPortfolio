package binarySearch;

import student.TestCase;

/**
 * tests the static find methods for EventFinder
 * @author margaretellis
 * @version 11-11-2015
 *
 */
public class EventFinderTest extends TestCase 
{
    private HistoricEvent first;
    private HistoricEvent second;
    private HistoricEvent third;
    private HistoricEvent fourth;
    private HistoricEvent fifth;
    private HistoricEvent sixth;
    private HistoricEvent seventh;
    private HistoricEvent[] events;
    
    /**
     * method for initializing scenario between test methods
     */
    public void setUp() 
    {
        
        new EventFinder();
        new TimelineEvents();
        
        first = new HistoricEvent(2000, "Alpha", "This is a test");
        second = new HistoricEvent(2001, "Bravo", "This is a test");
        third = new HistoricEvent(2002, "Charlie", "This is a test");
        fourth = new HistoricEvent(2003, "Delta", "This is a test");
        fifth = new HistoricEvent(2004, "Epsilon", "This is a test");
        sixth = new HistoricEvent(2005, "Foxtrot", "This is a test");
        seventh = new HistoricEvent(2006, "Golf", "This is a test");
        
        events = new HistoricEvent[4];
        events[0] = second;
        events[1] = third;
        events[2] = fourth;
        events[3] = sixth;
    }
    
    /**
     * Tests find(HistoricEvent, HistoricEvent[])
     */
    public void testFind1()
    {
        setUp();
        assertEquals(0, EventFinder.find(first, events));
        assertEquals(0, EventFinder.find(second, events));
        assertEquals(1, EventFinder.find(third, events));
        assertEquals(2, EventFinder.find(fourth, events));
        assertEquals(3, EventFinder.find(fifth, events));
        assertEquals(3, EventFinder.find(sixth, events));
        assertEquals(4, EventFinder.find(seventh, events));
        events = new HistoricEvent[0];
        assertEquals(0, EventFinder.find(first, events));
    }
    
    /**
     * Tests find(HistoricEvent, HistoricEvent[], int, int)
     */
    public void testFind2()
    {
        setUp();
        assertEquals(0, EventFinder.find(first, events));
        assertEquals(2, EventFinder.find(first, events, 2, 3));
        assertEquals(2, EventFinder.find(fourth, events, 2, 3));
        assertEquals(0, EventFinder.find(second, events));
        assertEquals(1, EventFinder.find(third, events));
        assertEquals(2, EventFinder.find(fourth, events));
        assertEquals(3, EventFinder.find(fifth, events));
        assertEquals(3, EventFinder.find(sixth, events));
        assertEquals(4, EventFinder.find(seventh, events));
        assertEquals(2, EventFinder.find(seventh, events, 0, 1));
        assertEquals(2, EventFinder.find(seventh, events, 2, 1));
        assertEquals(2, EventFinder.find(fourth, events, 2, 2));
    }
}
