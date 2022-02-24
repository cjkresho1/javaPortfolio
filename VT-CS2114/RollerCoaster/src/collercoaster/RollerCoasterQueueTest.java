/**
 * 
 */
package collercoaster;

import list.AList;
import queue.EmptyQueueException;
import student.TestCase;

/**
 * @author Charles Kresho
 * @version 2016.4.7
 */
public class RollerCoasterQueueTest extends TestCase 
{
    private RollerCoasterQueue queue;
    private RollerCoasterQueue nullQueue;
    private RollerCoasterQueue otherQueue;
    
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
    
    /**
     * Sets up the variables for the tests
     */
    public void setUp()
    {
        queue = new RollerCoasterQueue();
        nullQueue = null;
        otherQueue = new RollerCoasterQueue();
        
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
    }
    
    /**
     * Tests getRejectedParties()
     */
    public void testGetRejectedParties()
    {
        setUp();
        AList<WaitingParty> emptyList = new AList<WaitingParty>();
        assertEquals(emptyList, queue.getRejectedParties());
        WaitingParty bad = new WaitingParty(false);
        bad.add(tall1);
        bad.add(short1);
        emptyList.add(bad);
        queue.enqueueParty(bad);
        assertEquals(emptyList, queue.getRejectedParties());
    }
    
    /**
     * Tests getQueue()
     */
    public void testGetQueue()
    {
        setUp();
        ArrayQueue<WaitingParty> emptyQueue = new ArrayQueue<WaitingParty>();
        assertEquals(emptyQueue, queue.getQueue());
        WaitingParty good = new WaitingParty(false);
        good.add(tall1);
        emptyQueue.enqueue(good);
        queue.enqueueParty(good);
        assertEquals(emptyQueue, queue.getQueue());
    }
    
    /**
     * Tests isEmpty()
     */
    public void testIsEmpty()
    {
        setUp();
        assertTrue(queue.isEmpty());
        WaitingParty good = new WaitingParty(false);
        good.add(tall1);
        queue.enqueueParty(good);
        assertFalse(queue.isEmpty());
        queue.dequeueParty(1);
        assertTrue(queue.isEmpty());
    }
    
    /**
     * Tests getFront()
     */
    public void testGetFront()
    {
        setUp();
        boolean caught = false;
        try
        {
            queue.getFront();
        }
        catch (NullPointerException e)
        {
            caught = true;
        }
        assertTrue(caught);
        WaitingParty good = new WaitingParty(false);
        good.add(tall1);
        queue.enqueueParty(good);
        assertEquals(good, queue.getFront());
        assertFalse(queue.isEmpty());
    }
    
    /**
     * Tests getMinimimHeight()
     */
    public void testGetMinimumHeight()
    {
        setUp();
        assertEquals(96, queue.getMinimumHeight());
    }
    
    /**
     * Tests enqueueParty(WaitingParty)
     */
    public void testEnqueueParty()
    {
        setUp();
        WaitingParty goodFalse = new WaitingParty(false);
        WaitingParty goodTrue = new WaitingParty(true);
        WaitingParty badTrue = new WaitingParty(true);
        WaitingParty badFalse = new WaitingParty(false);
        WaitingParty allBadFalse = new WaitingParty(false);
        WaitingParty allBadTrue = new WaitingParty(true);
        WaitingParty allBadTrueCopy = new WaitingParty(true);
        WaitingParty temp = new WaitingParty(false);
        
        goodFalse.add(tall1);
        goodFalse.add(tall2);
        goodFalse.add(tall3);
        goodFalse.add(tall4);
        goodFalse.add(tall5);
        
        goodTrue.add(tall1);
        goodTrue.add(tall2);
        goodTrue.add(tall3);
        goodTrue.add(tall4);
        goodTrue.add(tall5);
        
        badTrue.add(tall1);
        badTrue.add(short1);
        badTrue.add(tall2);
        
        badFalse.add(tall1);
        badFalse.add(short1);
        badFalse.add(tall2);
        
        allBadFalse.add(short1);
        allBadFalse.add(short2);
        allBadFalse.add(short3);
        allBadFalse.add(short4);
        allBadFalse.add(short5);
        
        allBadTrue.add(short1);
        allBadTrue.add(short2);
        allBadTrue.add(short3);
        allBadTrue.add(short4);
        allBadTrue.add(short5);
        
        allBadTrueCopy.add(short1);
        allBadTrueCopy.add(short2);
        allBadTrueCopy.add(short3);
        allBadTrueCopy.add(short4);
        allBadTrueCopy.add(short5);
        
        AList<WaitingParty> emptyList = new AList<WaitingParty>();
        ArrayQueue<WaitingParty> emptyQueue = new ArrayQueue<WaitingParty>();
        assertEquals(emptyQueue, queue.getQueue());
        assertEquals(emptyList, queue.getRejectedParties());
        
        queue.enqueueParty(goodFalse);
        emptyQueue.enqueue(goodFalse);
        assertEquals(emptyQueue, queue.getQueue());
        assertEquals(emptyList, queue.getRejectedParties());
        
        queue.enqueueParty(goodTrue);
        emptyQueue.enqueue(goodTrue);
        assertEquals(emptyQueue, queue.getQueue());
        assertEquals(emptyList, queue.getRejectedParties());
        
        queue.enqueueParty(badTrue);
        badTrue.removePerson(short1);
        temp.add(short1);
        emptyQueue.enqueue(badTrue);
        emptyList.add(temp);
        assertEquals(emptyQueue, queue.getQueue());
        assertEquals(emptyList, queue.getRejectedParties());
        
        queue.enqueueParty(badFalse);
        emptyList.add(badFalse);
        assertEquals(emptyQueue, queue.getQueue());
        assertEquals(emptyList, queue.getRejectedParties());
        
        queue.enqueueParty(allBadFalse);
        emptyList.add(allBadFalse);
        assertEquals(emptyQueue, queue.getQueue());
        assertEquals(emptyList, queue.getRejectedParties());
        
        queue.enqueueParty(allBadTrue);
        emptyList.add(allBadTrueCopy);
        assertEquals(emptyQueue, queue.getQueue());
        assertEquals(emptyList, queue.getRejectedParties());
    }
    
    /**
     * Tests dequeueParty
     */
    public void testDequeueParty()
    {
        setUp();
        WaitingParty goodFalse = new WaitingParty(false);
        WaitingParty goodTrue = new WaitingParty(true);
        WaitingParty badTrue = new WaitingParty(true);
        WaitingParty badFalse = new WaitingParty(false);
        WaitingParty allBadFalse = new WaitingParty(false);
        WaitingParty allBadTrue = new WaitingParty(true);
        WaitingParty allBadTrueCopy = new WaitingParty(true);
        WaitingParty temp = new WaitingParty(false);
        
        goodFalse.add(tall1);
        goodFalse.add(tall2);
        goodFalse.add(tall3);
        goodFalse.add(tall4);
        goodFalse.add(tall5);
        
        goodTrue.add(tall1);
        goodTrue.add(tall2);
        goodTrue.add(tall3);
        goodTrue.add(tall4);
        goodTrue.add(tall5);
        
        badTrue.add(tall1);
        badTrue.add(short1);
        badTrue.add(tall2);
        
        badFalse.add(tall1);
        badFalse.add(short1);
        badFalse.add(tall2);
        
        allBadFalse.add(short1);
        allBadFalse.add(short2);
        allBadFalse.add(short3);
        allBadFalse.add(short4);
        allBadFalse.add(short5);
        
        allBadTrue.add(short1);
        allBadTrue.add(short2);
        allBadTrue.add(short3);
        allBadTrue.add(short4);
        allBadTrue.add(short5);
        
        allBadTrueCopy.add(short1);
        allBadTrueCopy.add(short2);
        allBadTrueCopy.add(short3);
        allBadTrueCopy.add(short4);
        allBadTrueCopy.add(short5);
        
        AList<WaitingParty> emptyList = new AList<WaitingParty>();
        ArrayQueue<WaitingParty> emptyQueue = new ArrayQueue<WaitingParty>();
        assertEquals(emptyQueue, queue.getQueue());
        assertEquals(emptyList, queue.getRejectedParties());
        
        queue.enqueueParty(goodFalse);
        emptyQueue.enqueue(goodFalse);
        assertEquals(emptyQueue, queue.getQueue());
        assertEquals(emptyList, queue.getRejectedParties());
        
        queue.enqueueParty(goodTrue);
        emptyQueue.enqueue(goodTrue);
        assertEquals(emptyQueue, queue.getQueue());
        assertEquals(emptyList, queue.getRejectedParties());
        
        queue.enqueueParty(badTrue);
        badTrue.removePerson(short1);
        temp.add(short1);
        emptyQueue.enqueue(badTrue);
        emptyList.add(temp);
        assertEquals(emptyQueue, queue.getQueue());
        assertEquals(emptyList, queue.getRejectedParties());
        
        queue.enqueueParty(badFalse);
        emptyList.add(badFalse);
        assertEquals(emptyQueue, queue.getQueue());
        assertEquals(emptyList, queue.getRejectedParties());
        
        queue.enqueueParty(allBadFalse);
        emptyList.add(allBadFalse);
        assertEquals(emptyQueue, queue.getQueue());
        assertEquals(emptyList, queue.getRejectedParties());
        
        queue.enqueueParty(allBadTrue);
        emptyList.add(allBadTrueCopy);
        assertEquals(emptyQueue, queue.getQueue());
        assertEquals(emptyList, queue.getRejectedParties());
        
        assertNull(queue.dequeueParty(1));
        assertEquals(goodFalse, queue.dequeueParty(6));
        
        WaitingParty test = new WaitingParty(true);
        test.add(tall1);
        assertEquals(test, queue.dequeueParty(1));
        test.remove(0);
        test.add(tall2);
        test.add(tall3);
        test.add(tall4);
        test.add(tall5);
        assertEquals(test, queue.dequeueParty(5));
        
        setUp();
        boolean caught = false;
        try 
        {
            queue.dequeueParty(100);
        }
        catch (EmptyQueueException e)
        {
            caught = true;
        }
        assertTrue(caught);
    }
    
    /**
     * Tests toArray()
     */
    public void testToArray()
    {
        queue.toArray();
    }
    
    /**
     * Tests toString()
     */
    public void testToString()
    {
        setUp();
        assertEquals("Line with minimum height 96cm.\n" 
                + queue.getQueue().toString(), queue.toString());
    }
    
    /**
     * Tests equals()
     */
    public void testEquals()
    {
        setUp();
        assertFalse(queue.equals(nullQueue));
        assertFalse(queue.equals(new Object()));
        assertTrue(queue.equals(queue));
        assertTrue(queue.equals(otherQueue));
        
        setUp();
        WaitingParty goodFalse = new WaitingParty(false);
        WaitingParty goodTrue = new WaitingParty(true);
        WaitingParty badTrue = new WaitingParty(true);
        WaitingParty badFalse = new WaitingParty(false);
        WaitingParty allBadFalse = new WaitingParty(false);
        WaitingParty allBadTrue = new WaitingParty(true);
        WaitingParty allBadTrueCopy = new WaitingParty(true);
        WaitingParty allBadTrueCopyCopy = new WaitingParty(true);
        WaitingParty temp = new WaitingParty(false);
        
        goodFalse.add(tall1);
        goodFalse.add(tall2);
        goodFalse.add(tall3);
        goodFalse.add(tall4);
        goodFalse.add(tall5);
        
        goodTrue.add(tall1);
        goodTrue.add(tall2);
        goodTrue.add(tall3);
        goodTrue.add(tall4);
        goodTrue.add(tall5);
        
        badTrue.add(tall1);
        badTrue.add(short1);
        badTrue.add(tall2);
        
        badFalse.add(tall1);
        badFalse.add(short1);
        badFalse.add(tall2);
        
        allBadFalse.add(short1);
        allBadFalse.add(short2);
        allBadFalse.add(short3);
        allBadFalse.add(short4);
        allBadFalse.add(short5);
        
        allBadTrue.add(short1);
        allBadTrue.add(short2);
        allBadTrue.add(short3);
        allBadTrue.add(short4);
        allBadTrue.add(short5);
        
        allBadTrueCopy.add(short1);
        allBadTrueCopy.add(short2);
        allBadTrueCopy.add(short3);
        allBadTrueCopy.add(short4);
        allBadTrueCopy.add(short5);
        
        allBadTrueCopyCopy.add(short1);
        allBadTrueCopyCopy.add(short2);
        allBadTrueCopyCopy.add(short3);
        allBadTrueCopyCopy.add(short4);
        allBadTrueCopyCopy.add(short5);
        
        AList<WaitingParty> emptyList = new AList<WaitingParty>();
        ArrayQueue<WaitingParty> emptyQueue = new ArrayQueue<WaitingParty>();
        assertEquals(emptyQueue, queue.getQueue());
        assertEquals(emptyList, queue.getRejectedParties());
        
        queue.enqueueParty(goodFalse);
        assertFalse(queue.equals(otherQueue));
        otherQueue.enqueueParty(goodFalse);
        assertTrue(queue.equals(otherQueue));
        emptyQueue.enqueue(goodFalse);
        assertEquals(emptyQueue, queue.getQueue());
        assertEquals(emptyList, queue.getRejectedParties());
        
        queue.enqueueParty(goodTrue);
        assertFalse(queue.equals(otherQueue));
        otherQueue.enqueueParty(goodTrue);
        assertTrue(queue.equals(otherQueue));
        emptyQueue.enqueue(goodTrue);
        assertEquals(emptyQueue, queue.getQueue());
        assertEquals(emptyList, queue.getRejectedParties());
        
        queue.enqueueParty(badTrue);
        assertFalse(queue.equals(otherQueue));
        badTrue.add(short1);
        otherQueue.enqueueParty(badTrue);
        assertTrue(queue.equals(otherQueue));
        temp.add(short1);
        emptyQueue.enqueue(badTrue);
        emptyList.add(temp);
        assertEquals(emptyQueue, queue.getQueue());
        assertEquals(emptyList, queue.getRejectedParties());
        
        queue.enqueueParty(badFalse);
        assertFalse(queue.equals(otherQueue));
        otherQueue.enqueueParty(badFalse);
        assertTrue(queue.equals(otherQueue));
        emptyList.add(badFalse);
        assertEquals(emptyQueue, queue.getQueue());
        assertEquals(emptyList, queue.getRejectedParties());
        
        queue.enqueueParty(allBadFalse);
        assertFalse(queue.equals(otherQueue));
        otherQueue.enqueueParty(allBadFalse);
        assertTrue(queue.equals(otherQueue));
        emptyList.add(allBadFalse);
        assertEquals(emptyQueue, queue.getQueue());
        assertEquals(emptyList, queue.getRejectedParties());
        
        queue.enqueueParty(allBadTrue);
        assertFalse(queue.equals(otherQueue));
        otherQueue.enqueueParty(allBadTrueCopyCopy);
        assertTrue(queue.equals(otherQueue));
        emptyList.add(allBadTrueCopy);
        assertEquals(emptyQueue, queue.getQueue());
        assertEquals(emptyList, queue.getRejectedParties());
    }
}
