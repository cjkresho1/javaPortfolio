/**
 * 
 */
package collercoaster;

import queue.EmptyQueueException;
import queue.QueueInterface;

/**
 * @author Charles Kresho
 * @version 2016.4.7
 */
public class ArrayQueue<T> implements QueueInterface<T> 
{
    private static final int DEFAULT_CAPACITY = 10;
    
    private T[] queue;
    private int enqueueIndex;
    private int dequeueIndex;
    private int size;
    
    /**
     * Creates a new ArrayQueue object
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue()
    {
        enqueueIndex = 0;
        dequeueIndex = 0;
        size = DEFAULT_CAPACITY;
        this.queue = (T[]) new Object[size + 1];
    }
    
    /**
     * Gets the number of elements in the queue
     * @return  the length of the queue
     */
    public int getLength()
    {
        if (enqueueIndex >= dequeueIndex)
        {
            return enqueueIndex - dequeueIndex;
        }
        else
        {
            return (enqueueIndex - dequeueIndex) + (size + 1);
        }
    }
    
    /**
     * Gets the size of the queue
     * @return  the size of the queue
     */
    public int getSize()
    {
        return size;
    }
    
    /**
     * Checks if the queue is empty
     * @return  true if the queue is empty
     *          false if the queue isn't empty
     */
    public boolean isEmpty()
    {
        return enqueueIndex == dequeueIndex;
    }
    
    /**
     * Checks if the queue is full
     * @return  true if the queue is full
     *          false if the queue isn't full
     */
    private boolean isFull()
    {
        return getLength() == size;
    }
    
    /**
     * Puts a new object in the back of the queue
     * @param obj - object to be added to the queue
     * @throws IllegalStateException if the the queue tries to add too many 
     * elements
     */
    public void enqueue(T obj)
    {
        ensureCapacity();
        if (getLength() == 100)
        {
            throw new IllegalStateException("There cannot be more than 100 "
                    + "elements in the queue.");
        }
        queue[enqueueIndex] = obj;
        enqueueIndex = incrementIndex(enqueueIndex);
    }
    
    /**
     * Makes sure the queue isn't full, and will increase the size if necessary
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity()
    {
        if (isFull())
        {
            T[] newQueue = (T[]) new Object[size + 1];
            int j = 0;
            while (!isEmpty())
            {
                newQueue[j] = dequeue();
                j++;
            }
            this.queue = (T[]) new Object[size * 2 + 1];
            for (int i = 0; i < newQueue.length; i++)
            {
                queue[i] = newQueue[i];
            }
            dequeueIndex = 0;
            enqueueIndex = size;
            size *= 2;
        }

    }
    
    /**
     * Removes an object from the queue
     * @return  T, the object at the front of the queue
     * @throws EmptyQueueException() if the queue is empty
     */
    public T dequeue()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException("There are no enteries in the queue "
                    + "to be removed.");
        }
        T data = (T) queue[dequeueIndex];
        queue[dequeueIndex] = null;
        dequeueIndex = incrementIndex(dequeueIndex);
        return data;
    }
    
    /**
     * Returns the object from the front of the queue, but doesn't remove it
     * @return  T, the object at the front of the queue
     * @throws EmptyQueueException() if the queue is empty
     */
    public T getFront()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException("There are no enteries in the queue "
                    + "to be found.");
        }
        return (T)queue[dequeueIndex];
    }
    
    /**
     * Clears all the objects from the queue
     */
    public void clear()
    {
        enqueueIndex = 0;
        dequeueIndex = 0;
    }
    
    /**
     * Increments the specified index, ensuring that it wraps around the array
     * @param index - current location of the index
     * @return  new location of the index
     */
    private int incrementIndex(int index)
    {
        return ((index + 1) % queue.length);
    }
    
    /**
     * Returns an array containing the current objects in the queue
     * @return  an array representation of the queue
     */
    @SuppressWarnings("unchecked")
    public T[] toArray()
    {
        T[] temp = (T[]) new Object[getLength()];
        for (int i = 0; i < getLength(); i++)
        {
            temp[i] = queue[(dequeueIndex + i) % queue.length];
        }
        return temp;
    }
    
    /**
     * Returns a string representation of the queue
     * @return  [o1.toString, o2.toString, ..., on.toString]
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        int dequeue = dequeueIndex;
        int length = getLength();
        builder.append("[");
        if (this.isEmpty())
        {
            builder.append("]");
            return builder.toString();
        }
        builder.append(queue[dequeueIndex].toString());
        dequeueIndex = incrementIndex(dequeueIndex);
        for (int i = 1; i < length; i++)
        {
            builder.append(", ");
            builder.append(queue[dequeueIndex].toString());
            dequeueIndex = incrementIndex(dequeueIndex);
        }
        dequeueIndex = dequeue;
        builder.append("]");
        return builder.toString();
    }
    
    /**
     * Determines if the two objects are equal based on the elements, and 
     * the order of the elements
     * @param other - other object to be compared
     * @return  true if the queue's have the same data
     *          false if the queue's don't have the same data
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public boolean equals(Object other)
    {
        if (other == null || other.getClass() != this.getClass())
        {
            return false;
        }
        if (other == this)
        {
            return true;
        }
        if (this.getLength() != ((ArrayQueue)other).getLength())
        {
            return false;
        }
        for (int i = 0; i < getLength(); i++)
        {
            T myElement = queue[(dequeueIndex + i) % queue.length];
            T otherElement = (T) ((ArrayQueue)other).queue[(((ArrayQueue)other)
                    .dequeueIndex + i) % ((ArrayQueue)other).queue.length];
            if (!myElement.equals(otherElement))
            {
                return false;
            }
        }
        return true;
    }
}
