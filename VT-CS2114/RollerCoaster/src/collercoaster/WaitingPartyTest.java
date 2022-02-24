/**
 * 
 */
package collercoaster;

import java.util.Iterator;
import java.util.NoSuchElementException;

import student.TestCase;

/**
 * @author Charles Kresho
 *
 */
public class WaitingPartyTest extends TestCase
{
    private Person short1;
    private Person short2;
    private Person short3;
    private Person short4;
    private Person short5;
    private Person tall1;
    private Person tall2;
    private Person tall3;
    private Person tall4;
    private Person tall5;
    private WaitingParty yesParty;
    private WaitingParty noParty;
    
    /**
     * Sets up the variables for tests
     */
    public void setUp()
    {
        short1 = new Person("1", 10);
        short2 = new Person("2", 20);
        short3 = new Person("3", 30);
        short4 = new Person("4", 40);
        short5 = new Person("5", 50);
        tall1 = new Person("1", 110);
        tall2 = new Person("2", 120);
        tall3 = new Person("3", 130);
        tall4 = new Person("4", 140);
        tall5 = new Person("5", 150);
        yesParty = new WaitingParty(true);
        noParty = new WaitingParty(false);
    }
    
    /**
     * Tests getWillSplit()
     */
    public void testGetWillSplit()
    {
        setUp();
        assertTrue(yesParty.getWillSplit());
        assertFalse(noParty.getWillSplit());
    }
    
    /**
     * Tests splitParty(int)
     */
    public void testSplitParty()
    {
        setUp();
        noParty.add(short1);
        noParty.add(short2);
        noParty.add(short3);
        noParty.add(short4);
        noParty.add(short5);
        
        assertEquals(noParty, noParty.splitParty(5));
        assertNull(noParty.splitParty(4));
        
        yesParty.add(tall1);
        yesParty.add(tall2);
        yesParty.add(tall3);
        yesParty.add(tall4);
        yesParty.add(tall5);
        
        assertEquals(yesParty, yesParty.splitParty(5));
        WaitingParty splitParty = yesParty.splitParty(3);
        WaitingParty tempParty = yesParty;
        setUp();
        yesParty.add(tall4);
        yesParty.add(tall5);
        noParty.add(tall1);
        noParty.add(tall2);
        noParty.add(tall3);
        assertEquals(splitParty, noParty);
        assertEquals(tempParty, yesParty);
    }
    
    /**
     * Test removePerson(Person)
     */
    public void testRemovePerson()
    {
        setUp();
        noParty.add(short1);
        noParty.add(short2);
        noParty.add(short3);
        noParty.add(short4);
        noParty.add(short5);
        
        yesParty.add(short1);
        yesParty.add(short3);
        yesParty.add(short4);
        yesParty.add(short5);
        
        assertFalse(yesParty.equals(noParty));
        assertFalse(noParty.removePerson(tall1));
        assertFalse(yesParty.removePerson(short2));
        assertTrue(noParty.removePerson(short2));
        assertEquals(yesParty, noParty);
    }
    
    /**
     * Tests toString()
     */
    public void testToString()
    {
        setUp();
        noParty.add(short1);
        noParty.add(short2);
        noParty.add(short3);
        noParty.add(short4);
        noParty.add(short5);
        
        
        
        yesParty.add(tall1);
        yesParty.add(tall2);
        yesParty.add(tall3);
        yesParty.add(tall4);
        yesParty.add(tall5);
        
        assertEquals("Party of size 5 will not split. [1 10cm, 2 20cm,"
                + " 3 30cm, 4 40cm, 5 50cm]", noParty.toString());
        assertEquals("Party of size 5 will split. [1 110cm, 2 120cm, 3 130cm, "
                + "4 140cm, 5 150cm]", yesParty.toString());
    }
    
    /**
     * Tests equals()
     */
    public void testEquals()
    {
        setUp();
        WaitingParty nullParty = null;
        
        yesParty.add(short1);
        yesParty.add(short2);
        yesParty.add(short3);
        yesParty.add(short4);
        yesParty.add(short5);
        
        noParty.add(short5);
        noParty.add(short2);
        noParty.add(short3);
        noParty.add(short4);
        
        assertFalse(yesParty.equals(nullParty));
        assertFalse(yesParty.equals(new Object()));
        assertTrue(yesParty.equals(yesParty));
        assertFalse(yesParty.equals(noParty));
        noParty.add(short1);
        assertTrue(yesParty.equals(noParty));
    }
    
    /**
     * Tests the class' iterator
     */
    public void testIterator()
    {
        yesParty.add(short3);
        yesParty.add(short4);
        yesParty.add(short2);
        yesParty.add(short1);
        yesParty.add(short5);
        Iterator<Person> iter = yesParty.iterator();
        
        assertTrue(iter.hasNext());
        assertEquals(short3, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(short4, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(short2, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(short1, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(short5, iter.next());
        assertFalse(iter.hasNext());
        boolean caught = false;
        try
        {
            iter.next();
        }
        catch(NoSuchElementException e)
        {
            caught = true;
        }
        assert(caught);
    }
}
