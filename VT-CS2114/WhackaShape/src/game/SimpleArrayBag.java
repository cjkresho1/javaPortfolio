/**
 * 
 */
package game;

import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * @author Charles Kresho
 * @version 2016.2.16
 * @param <T> - the type of object to be held in the bag
 */
public class SimpleArrayBag<T> implements SimpleBagInterface<T> 
{
    
    private T[] bag;
    private static final int MAX = 25;
    private int numberOfEnteries;
    
    /**
     * Default constructor to set up the bag with a size of 25
     */
    public SimpleArrayBag()
    {
        @SuppressWarnings("unchecked")
            T[] tempbag = (T[]) new Object[MAX];
        bag = tempbag;
        numberOfEnteries = 0;
    }
    
    /**
     * Adds an object to the bag, located at the array location at
     * numberOfEnteries
     * @param anEntry - the object to be added
     * @return false if the object is null or if the array is full, true if
     * the object is added
     */
    @Override
    public boolean add(T anEntry) 
    {
        if (numberOfEnteries == MAX || anEntry == null)
        {
            return false;
        }
        bag[numberOfEnteries] = anEntry;
        numberOfEnteries++;
        return true;
    }

    /**
     * Returns the current size of the bag
     * @return the current size of the bag
     */
    @Override
    public int getCurrentSize() 
    {
        return numberOfEnteries;
    }
    
    /**
     * Finds and returns the index of the array location that contains the 
     * object passed
     * @param anEntry - object to be found
     * @return the index of the array location containing the object
     */
    private int getIndexOf(T anEntry)
    {
        for (int i = 0; i < numberOfEnteries; i++)
        {
            if (bag[i].equals(anEntry))
            {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * @return true if the array is empty, false otherwise
     */
    @Override
    public boolean isEmpty()
    {
        return numberOfEnteries == 0;
    }
    
    /**
     * returns the reference to a random object in the bag
     * @return the reference to a random object in the bag
     */
    @Override
    public T pick()
    {
        if (isEmpty())
        {
            return null;
        }
        TestableRandom generator = new TestableRandom();
        int index = generator.nextInt(numberOfEnteries);
        T data = bag[index];
        return data;
    }
    
    /**
     * Removes an object from the bag
     * @param anEntry - the object to be removed from the bag
     * @return false if the object isn't in the bag, true if it's removed
     */
    @Override
    public boolean remove(T anEntry)
    {
        if (anEntry == null)
        {
            return false;
        }
        int index = getIndexOf(anEntry);
        if (index == -1)
        {
            return false;
        }
        bag[index] = bag[numberOfEnteries - 1];
        bag[numberOfEnteries] = null;
        numberOfEnteries--;
        return true;
    }
}
