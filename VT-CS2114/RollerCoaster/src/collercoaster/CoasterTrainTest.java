/**
 * 
 */
package collercoaster;

import student.TestCase;

/**
 * @author Charles Kresho
 * @version 2016.4.7
 */
public class CoasterTrainTest extends TestCase 
{
    private CoasterTrain emptyTrain;
    private CoasterTrain fullTrain;
    private CoasterTrain nullTrain;
    private CoasterTrain train1;
    private CoasterTrain emptyTrainCopy;
    private CoasterTrain fullTrainCopy;
    private CoasterTrain train1Copy;
    
    private Person short1;
    private Person short2;
    private Person short3;
    private Person short4;
    private Person short5;
    private Person short6;
    private Person short7;
    private Person short8;
    private Person short9;
    private Person short10;
    private Person tall1;
    private Person tall2;
    private Person tall3;
    private Person tall4;
    private Person tall5;
    private Person tall6;
    private Person tall7;
    private Person tall8;
    private Person tall9;
    private Person tall10;
    private WaitingParty yesParty;
    private WaitingParty noParty;
    
    /**
     * Sets up the variables for each test method
     */
    public void setUp()
    {
        short1 = new Person("1", 10);
        short2 = new Person("2", 20);
        short3 = new Person("3", 30);
        short4 = new Person("4", 40);
        short5 = new Person("5", 50);
        short6 = new Person("6", 60);
        short7 = new Person("7", 70);
        short8 = new Person("8", 80);
        short9 = new Person("9", 90);
        short10 = new Person("10", 100);
        tall1 = new Person("1", 110);
        tall2 = new Person("2", 120);
        tall3 = new Person("3", 130);
        tall4 = new Person("4", 140);
        tall5 = new Person("5", 150);
        tall6 = new Person("6", 160);
        tall7 = new Person("7", 170);
        tall8 = new Person("8", 180);
        tall9 = new Person("9", 190);
        tall10 = new Person("10", 200);
        
        emptyTrain = new CoasterTrain();
        
        emptyTrainCopy = new CoasterTrain();
        
        yesParty = new WaitingParty(true);
        
        fullTrain = new CoasterTrain();
        for (int i = 0; i < 2; i++)
        {
            yesParty.add(short1);
            yesParty.add(short2);
            yesParty.add(short3);
            yesParty.add(short4);
            yesParty.add(short5);
            yesParty.add(short6);
            yesParty.add(short7);
            yesParty.add(short8);
            yesParty.add(short9);
            yesParty.add(short10);
        }
        fullTrain.seatParty(yesParty);
        
        fullTrainCopy = new CoasterTrain();
        fullTrainCopy.seatParty(yesParty);
        
        train1 = new CoasterTrain();
        noParty = new WaitingParty(false);
        noParty.add(short1);
        noParty.add(short2);
        noParty.add(short3);
        noParty.add(short4);
        noParty.add(short5);
        noParty.add(short6);
        noParty.add(short7);
        noParty.add(short8);
        noParty.add(short9);
        noParty.add(short10);
        noParty.add(tall1);
        train1.seatParty(noParty);
        
        train1Copy = new CoasterTrain();
        train1Copy.seatParty(noParty);
    }
    
    /**
     * Tests getOpenStats()
     */
    public void testGetOpenSeats()
    {
        setUp();
        assertEquals(20, emptyTrain.getOpenSeats());
        assertEquals(0, fullTrain.getOpenSeats());
        assertEquals(9, train1.getOpenSeats());
    }
    
    /**
     * Tests clear()
     */
    public void testClear()
    {
        setUp();
        assertFalse(emptyTrain.equals(fullTrain));
        assertEquals(0, fullTrain.getOpenSeats());
        fullTrain.clear();
        assertTrue(emptyTrain.equals(fullTrain));
        assertEquals(20, fullTrain.getOpenSeats());
        assertFalse(emptyTrain.equals(train1));
        assertEquals(9, train1.getOpenSeats());
        train1.clear();
        assertEquals(emptyTrain, train1);
        assertEquals(20, train1.getOpenSeats());
    }
    
    /**
     * Test isEmpty()
     */
    public void testIsEmpty()
    {
        setUp();
        assertTrue(emptyTrain.isEmpty());
        assertFalse(fullTrain.isEmpty());
        assertFalse(train1.isEmpty());
    }
    
    /**
     * Tests seatParty(WaitingParty)p
     */
    public void testSeatParty()
    {
        setUp();
        WaitingParty party1 = new WaitingParty(true);
        party1.add(tall2);
        boolean caught = false;
        try
        {
            
            fullTrain.seatParty(party1);
        }
        catch(IllegalStateException e)
        {
            caught = true;
        }
        assertTrue(caught);
        caught = false;
        
        party1.add(tall3);
        party1.add(tall4);
        party1.add(tall5);
        party1.add(tall6);
        party1.add(tall7);
        party1.add(tall8);
        party1.add(tall9);
        party1.add(tall10);
        assertEquals(9, train1.getOpenSeats());
        train1.seatParty(party1);
        assertEquals(0, train1.getOpenSeats());
        try
        {
            train1.seatParty(party1);
        }
        catch(IllegalStateException e)
        {
            caught = true;
        }
        assertTrue(caught);
    }
    
    /**
     * Test toArray()
     */
    public void testToArray()
    {
        setUp();
        Person[] testArray = {short1, short2, short3, short4, short5, short6, 
                short7, short8, short9, short10, short1, short2, short3, short4
                , short5, short6, short7, short8, short9, short10};
        Person[] thisArray = fullTrain.toArray();
        for (int i = 0; i < testArray.length; i++)
        {
            assertEquals(testArray[i], thisArray[i]);
        }
    }
    
    /**
     * Tests toString()
     */
    public void testToString()
    {
        setUp();
        assertEquals("[]", emptyTrain.toString());
        assertEquals("[1 10cm, 2 20cm, 3 30cm, 4 40cm, 5 50cm, 6 60cm, 7 70cm,"
                + " 8 80cm, 9 90cm, 10 100cm, 1 110cm]", train1.toString());
        assertEquals(emptyTrain, emptyTrainCopy);
        assertEquals(train1, train1Copy);
    }
    
    /**
     * Tests equals()
     */
    public void testEquals()
    {
        setUp();
        assertTrue(emptyTrain.equals(emptyTrainCopy));
        assertTrue(fullTrain.equals(fullTrainCopy));
        assertTrue(train1.equals(train1Copy));
        assertFalse(train1.equals(nullTrain));
        assertFalse(train1.equals(new Object()));
        assertTrue(train1.equals(train1));
        assertFalse(train1.equals(fullTrain));
    }
}
