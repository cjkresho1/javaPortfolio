/**
 * 
 */
package collercoaster;


import queue.EmptyQueueException;
import student.TestCase;

/**
 * @author Charles Kresho
 * @version 2016.4.7
 */
public class ArrayQueueTest extends TestCase 
{
    private ArrayQueue<String> emptyQueue;
    private ArrayQueue<String> fullQueue;
    private ArrayQueue<String> nullQueue;
    private ArrayQueue<String> fullCircularQueue;
    private ArrayQueue<String> emptyQueueCopy;
    private ArrayQueue<String> fullQueueCopy;
    private ArrayQueue<String> fullCircularQueueCopy;
    private ArrayQueue<String> queue1;
    private ArrayQueue<String> queue1Copy;
    private ArrayQueue<String> expandedQueue;
    private ArrayQueue<String> expandedQueueCopy;
    
    /**
     * Sets up the variables for each test
     */
    public void setUp()
    {
        emptyQueue = new ArrayQueue<String>();
        
        fullQueue = new ArrayQueue<String>();
        fullQueue.enqueue("First");
        fullQueue.enqueue("Second");
        fullQueue.enqueue("Third");
        fullQueue.enqueue("Fourth");
        fullQueue.enqueue("Fifth");
        fullQueue.enqueue("Sixth");
        fullQueue.enqueue("Seventh");
        fullQueue.enqueue("Eighth");
        fullQueue.enqueue("Ninth");
        fullQueue.enqueue("Tenth");
        
        nullQueue = null;
        
        fullCircularQueue = new ArrayQueue<String>();
        fullCircularQueue.enqueue("First");
        fullCircularQueue.dequeue();
        fullCircularQueue.enqueue("First");
        fullCircularQueue.dequeue();
        fullCircularQueue.enqueue("First");
        fullCircularQueue.enqueue("Second");
        fullCircularQueue.enqueue("Third");
        fullCircularQueue.enqueue("Fourth");
        fullCircularQueue.enqueue("Fifth");
        fullCircularQueue.enqueue("Sixth");
        fullCircularQueue.enqueue("Seventh");
        fullCircularQueue.enqueue("Eighth");
        fullCircularQueue.enqueue("Ninth");
        fullCircularQueue.enqueue("Tenth");
        
        emptyQueueCopy = new ArrayQueue<String>();
        
        
        fullQueueCopy = new ArrayQueue<String>();
        fullQueueCopy.enqueue("First");
        fullQueueCopy.enqueue("Second");
        fullQueueCopy.enqueue("Third");
        fullQueueCopy.enqueue("Fourth");
        fullQueueCopy.enqueue("Fifth");
        fullQueueCopy.enqueue("Sixth");
        fullQueueCopy.enqueue("Seventh");
        fullQueueCopy.enqueue("Eighth");
        fullQueueCopy.enqueue("Ninth");
        fullQueueCopy.enqueue("Tenth");
        
        fullCircularQueueCopy = new ArrayQueue<String>();
        fullCircularQueueCopy.enqueue("First");
        fullCircularQueueCopy.dequeue();
        fullCircularQueueCopy.enqueue("First");
        fullCircularQueueCopy.dequeue();
        fullCircularQueueCopy.enqueue("First");
        fullCircularQueueCopy.enqueue("Second");
        fullCircularQueueCopy.enqueue("Third");
        fullCircularQueueCopy.enqueue("Fourth");
        fullCircularQueueCopy.enqueue("Fifth");
        fullCircularQueueCopy.enqueue("Sixth");
        fullCircularQueueCopy.enqueue("Seventh");
        fullCircularQueueCopy.enqueue("Eighth");
        fullCircularQueueCopy.enqueue("Ninth");
        fullCircularQueueCopy.enqueue("Tenth");
        
        queue1 = new ArrayQueue<String>();
        queue1.enqueue("First");
        queue1.enqueue("Second");
        queue1.enqueue("Third");
        queue1.enqueue("Fourth");
        queue1.enqueue("Fifth");
        queue1.enqueue("Sixth");
        queue1.enqueue("Seventh");
        queue1.enqueue("Eighth");
        queue1.enqueue("Ninth");
        queue1.dequeue();
        queue1.dequeue();
        queue1.dequeue();
        queue1.dequeue();
        queue1.dequeue();
        queue1.dequeue();
        queue1.dequeue();
        queue1.dequeue();
        queue1.dequeue();
        queue1.enqueue("I");
        queue1.enqueue("hate");
        queue1.enqueue("test");
        queue1.enqueue("classes");
        
        queue1Copy = new ArrayQueue<String>();
        queue1Copy.enqueue("First");
        queue1Copy.enqueue("Second");
        queue1Copy.enqueue("Third");
        queue1Copy.enqueue("Fourth");
        queue1Copy.enqueue("Fifth");
        queue1Copy.enqueue("Sixth");
        queue1Copy.enqueue("Seventh");
        queue1Copy.enqueue("Eighth");
        queue1Copy.enqueue("Ninth");
        queue1Copy.dequeue();
        queue1Copy.dequeue();
        queue1Copy.dequeue();
        queue1Copy.dequeue();
        queue1Copy.dequeue();
        queue1Copy.dequeue();
        queue1Copy.dequeue();
        queue1Copy.dequeue();
        queue1Copy.dequeue();
        queue1Copy.enqueue("I");
        queue1Copy.enqueue("hate");
        queue1Copy.enqueue("test");
        queue1Copy.enqueue("classes");
        
        expandedQueue = new ArrayQueue<String>();
        expandedQueue.enqueue("First");
        expandedQueue.dequeue();
        expandedQueue.enqueue("First");
        expandedQueue.dequeue();
        expandedQueue.enqueue("First");
        expandedQueue.dequeue();
        expandedQueue.enqueue("First");
        expandedQueue.enqueue("Second");
        expandedQueue.enqueue("Third");
        expandedQueue.enqueue("Fourth");
        expandedQueue.enqueue("Fifth");
        expandedQueue.enqueue("Sixth");
        expandedQueue.enqueue("Seventh");
        expandedQueue.enqueue("Eighth");
        expandedQueue.enqueue("Ninth");
        expandedQueue.enqueue("Tenth");
        expandedQueue.enqueue("11th");
        expandedQueue.enqueue("12th");
        
        expandedQueueCopy = new ArrayQueue<String>();
        expandedQueueCopy.enqueue("First");
        expandedQueueCopy.dequeue();
        expandedQueueCopy.enqueue("First");
        expandedQueueCopy.dequeue();
        expandedQueueCopy.enqueue("First");
        expandedQueueCopy.dequeue();
        expandedQueueCopy.enqueue("First");
        expandedQueueCopy.enqueue("Second");
        expandedQueueCopy.enqueue("Third");
        expandedQueueCopy.enqueue("Fourth");
        expandedQueueCopy.enqueue("Fifth");
        expandedQueueCopy.enqueue("Sixth");
        expandedQueueCopy.enqueue("Seventh");
        expandedQueueCopy.enqueue("Eighth");
        expandedQueueCopy.enqueue("Ninth");
        expandedQueueCopy.enqueue("Tenth");
        expandedQueueCopy.enqueue("11th");
        expandedQueueCopy.enqueue("12th");
    }
    
    /**
     * Tests getLength()
     */
    public void testGetLength()
    {
        setUp();
        assertEquals(0, emptyQueue.getLength());
        assertEquals(10, fullQueue.getLength());
        assertEquals(10, fullCircularQueue.getLength());
        assertEquals(4, queue1.getLength());
        assertEquals(12, expandedQueue.getLength());
    }
    
    /**
     * Tests getSize()
     */
    public void testGetSize()
    {
        setUp();
        assertEquals(10, emptyQueue.getSize());
        assertEquals(10, fullQueue.getSize());
        assertEquals(10, fullCircularQueue.getSize());
        assertEquals(10, queue1.getSize());
        assertEquals(20, expandedQueue.getSize());
    }
    
    /**
     * Tests isEmpty()
     */
    public void testIsEmpty()
    {
        setUp();
        assertTrue(emptyQueue.isEmpty());
        assertFalse(fullQueue.isEmpty());
        assertFalse(fullCircularQueue.isEmpty());
        assertFalse(queue1.isEmpty());
        assertFalse(expandedQueue.isEmpty());
    }
    
    /**
     * Tests enqueue(T)
     */
    public void testEnqueue()
    {
        setUp();
        for (int i = 0; i < 11; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                if (i == 10)
                {
                    assertEquals(100, emptyQueue.getLength());
                    boolean caught = false;
                    try
                    {
                        emptyQueue.enqueue("" + (i * 10) + j + 1);
                    }
                    catch (IllegalStateException e)
                    {
                        caught = true;
                    }
                    assertTrue(caught);
                }
                else
                {
                    emptyQueue.enqueue("" + ((i * 10) + j + 1));
                    assertEquals((i * 10) + j + 1, emptyQueue.getLength());
                }
            }
        }
        setUp();
        for (int i = 0; i < 20; i++)
        {
            assertEquals(0, emptyQueue.getLength());
            assertEquals(10, emptyQueue.getSize());
            emptyQueue.enqueue("" + i);
            assertEquals(1, emptyQueue.getLength());
            assertEquals(10, emptyQueue.getSize());
            assertEquals("" + i, emptyQueue.dequeue());
            assertEquals(0, emptyQueue.getLength());
            assertEquals(10, emptyQueue.getSize());
        }
    }
    
    /**
     * Tests dequeue()
     */
    public void testDequeue()
    {
        setUp();
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                    emptyQueue.enqueue("" + ((i * 10) + j + 1));
                    assertEquals((i * 10) + j + 1, emptyQueue.getLength());
            }
        }
        assertEquals(100, emptyQueue.getLength());
        assertEquals(160, emptyQueue.getSize());
        
        for (int i = 0; i < 11; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                if (i == 10)
                {
                    assertEquals(0, emptyQueue.getLength());
                    boolean caught = false;
                    try
                    {
                        emptyQueue.dequeue();
                    }
                    catch (EmptyQueueException e)
                    {
                        caught = true;
                    }
                    assertTrue(caught);
                }
                else
                {
                    assertEquals("" + ((i * 10) + j + 1), emptyQueue.dequeue());
                    assertEquals(100 - ((i * 10) + j + 1), 
                            emptyQueue.getLength());
                }
            }
            
        }
        assertEquals(0, emptyQueue.getLength());
        assertEquals(160, emptyQueue.getSize());
        
        assertTrue(fullQueue.equals(fullQueueCopy));
        assertEquals(10, fullQueue.getLength());
        assertEquals("[First, Second, Third, Fourth, Fifth, Sixth, Seventh, "
                + "Eighth, Ninth, Tenth]", fullQueue.toString());
        assertEquals("First", fullQueue.dequeue());
        assertEquals(9, fullQueue.getLength());
        assertEquals("[Second, Third, Fourth, Fifth, Sixth, Seventh, "
                + "Eighth, Ninth, Tenth]", fullQueue.toString());
        setUp();
        for (int i = 0; i < 20; i++)
        {
            assertEquals(0, emptyQueue.getLength());
            assertEquals(10, emptyQueue.getSize());
            emptyQueue.enqueue("" + i);
            assertEquals(1, emptyQueue.getLength());
            assertEquals(10, emptyQueue.getSize());
            assertEquals("" + i, emptyQueue.dequeue());
            assertEquals(0, emptyQueue.getLength());
            assertEquals(10, emptyQueue.getSize());
        }
    }
    
    /**
     * Tests getFront()
     */
    public void getFront()
    {
        boolean caught = false;
        try
        {
            emptyQueue.dequeue();
        }
        catch (EmptyQueueException e)
        {
            caught = true;
        }
        assertTrue(caught);
        caught = false;
        
        assertTrue(fullQueue.equals(fullQueueCopy));
        assertEquals(10, fullQueue.getLength());
        assertEquals("[First, Second, Third, Fourth, Fifth, Sixth, Seventh, "
                + "Eighth, Ninth, Tenth]", fullQueue.toString());
        assertEquals("First", fullQueue.getFront());
        assertEquals(10, fullQueue.getLength());
        assertEquals("[First, Second, Third, Fourth, Fifth, Sixth, Seventh, "
                + "Eighth, Ninth, Tenth]", fullQueue.toString());
        setUp();
        for (int i = 0; i < 20; i++)
        {
            assertEquals(0, emptyQueue.getLength());
            assertEquals(10, emptyQueue.getSize());
            emptyQueue.enqueue("" + i);
            assertEquals(1, emptyQueue.getLength());
            assertEquals(10, emptyQueue.getSize());
            assertEquals("1", emptyQueue.getFront());
            assertEquals(i, emptyQueue.getLength());
            assertEquals((10 * (i / 10)), emptyQueue.getSize());
        }
    }
    
    /**
     * Tests clear()
     */
    public void testClear()
    {
        setUp();
        assertEquals(0, emptyQueue.getLength());
        assertEquals(10, fullQueue.getLength());
        assertEquals(10, fullCircularQueue.getLength());
        assertEquals(4, queue1.getLength());
        assertEquals(12, expandedQueue.getLength());
        assertEquals(10, emptyQueue.getSize());
        assertEquals(10, fullQueue.getSize());
        assertEquals(10, fullCircularQueue.getSize());
        assertEquals(10, queue1.getSize());
        assertEquals(20, expandedQueue.getSize());
        emptyQueue.clear();
        fullQueue.clear();
        fullCircularQueue.clear();
        queue1.clear();
        expandedQueue.clear();
        assertEquals(0, emptyQueue.getLength());
        assertEquals(0, fullQueue.getLength());
        assertEquals(0, fullCircularQueue.getLength());
        assertEquals(0, queue1.getLength());
        assertEquals(0, expandedQueue.getLength());
        assertEquals(10, emptyQueue.getSize());
        assertEquals(10, fullQueue.getSize());
        assertEquals(10, fullCircularQueue.getSize());
        assertEquals(10, queue1.getSize());
        assertEquals(20, expandedQueue.getSize());
    }
    
    /**
     * Tests toArray()
     */
    public void testToArray()
    {
        setUp();
        assertEquals(0, emptyQueue.getLength());
        assertEquals(10, fullQueue.getLength());
        assertEquals(10, fullCircularQueue.getLength());
        assertEquals(4, queue1.getLength());
        assertEquals(12, expandedQueue.getLength());
        assertEquals(10, emptyQueue.getSize());
        assertEquals(10, fullQueue.getSize());
        assertEquals(10, fullCircularQueue.getSize());
        assertEquals(10, queue1.getSize());
        assertEquals(20, expandedQueue.getSize());
        Object[] temp = fullQueue.toArray();
        assertTrue(fullQueue.equals(fullQueueCopy));
        for (int i = 0; i < temp.length; i++)
        {
            assertEquals(fullQueue.dequeue(), temp[i]);
        }
        Object[] temp2 = fullCircularQueue.toArray();
        assertTrue(fullCircularQueue.equals(fullCircularQueueCopy));
        for (int i = 0; i < temp2.length; i++)
        {
            assertEquals(fullCircularQueue.dequeue(), temp2[i]);
        }
        Object[] temp3 = queue1.toArray();
        assertTrue(queue1.equals(queue1Copy));
        for (int i = 0; i < temp3.length; i++)
        {
            assertEquals(queue1.dequeue(), temp3[i]);
        }
        Object[] temp4 = expandedQueue.toArray();
        assertTrue(expandedQueue.equals(expandedQueueCopy));
        for (int i = 0; i < temp4.length; i++)
        {
            assertEquals(expandedQueue.dequeue(), temp4[i]);
        }
    }
    
    /**
     * Tests toString()
     */
    public void testToString()
    {
        setUp();
        assertEquals(0, emptyQueue.getLength());
        assertEquals(10, fullQueue.getLength());
        assertEquals(10, fullCircularQueue.getLength());
        assertEquals(4, queue1.getLength());
        assertEquals(12, expandedQueue.getLength());
        assertEquals(10, emptyQueue.getSize());
        assertEquals(10, fullQueue.getSize());
        assertEquals(10, fullCircularQueue.getSize());
        assertEquals(10, queue1.getSize());
        assertEquals(20, expandedQueue.getSize());
        assertEquals("[]", emptyQueue.toString());
        assertEquals(emptyQueue, emptyQueueCopy);
        assertEquals("[First, Second, Third, Fourth, Fifth, Sixth, Seventh, "
                + "Eighth, Ninth, Tenth]", fullQueue.toString());
        assertEquals(fullQueue, fullQueueCopy);
        assertEquals("[First, Second, Third, Fourth, Fifth, Sixth, Seventh, "
                + "Eighth, Ninth, Tenth]", fullCircularQueue.toString());
        assertEquals(fullCircularQueue, fullCircularQueueCopy);
        assertEquals("[I, hate, test, classes]", queue1.toString());
        assertEquals(queue1, queue1Copy);
        assertEquals("[First, Second, Third, Fourth, Fifth, Sixth, Seventh, "
                + "Eighth, Ninth, Tenth, 11th, 12th]", 
                expandedQueue.toString());
        assertEquals(expandedQueue, expandedQueueCopy);
    }
    
    /**
     * Tests equals()
     */
    public void testEquals()
    {
        setUp();
        assertFalse(queue1.equals(nullQueue));
        assertFalse(queue1.equals(new Object()));
        assertTrue(queue1.equals(queue1));
        assertFalse(queue1.equals(fullQueue));
        assertTrue(emptyQueue.equals(emptyQueueCopy));
        assertTrue(fullQueue.equals(fullQueueCopy));
        assertTrue(fullCircularQueue.equals(fullCircularQueueCopy));
        assertTrue(queue1.equals(queue1Copy));
        assertTrue(expandedQueue.equals(expandedQueueCopy));
        expandedQueue.dequeue();
        expandedQueue.enqueue("13th");
        assertFalse(expandedQueue.equals(expandedQueueCopy));
    }
}
