package game;

import bag.Node;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * 
 * @author Charles Kresho
 * @version 2016.2.16
 * @param <T> - the type of object to be held in the bag
 */
public class SimpleLinkedBag<T> implements SimpleBagInterface<T> 
{

    private Node<T> firstNode;
    private int numberOfEnteries;
    
    /**
     * Default constructor to set up the bag
     */
    public SimpleLinkedBag()
    {
        firstNode = null;
        numberOfEnteries = 0;
    }
    
    /**
     * Adds an object to the bag, located at the array location at
     * numberOfEnteries
     * @param newEntry - the object to be added
     * @return false if the object is null or if the array is full, true if
     * the object is added
     */
    @Override
    public boolean add(T newEntry) 
    {
        if (newEntry == null)
        {
            return false;
        }
        Node<T> newNode = new Node<T>(newEntry);
        if (!isEmpty())
        {
            newNode.setNext(firstNode);
        }
        firstNode = newNode;
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
     * Finds and returns the reference to the node containing the object
     * @param anEntry - object to be found
     * @return the reference to the node containing the object
     */
    private Node<T> getRefrenceTo(T anEntry)
    {
        Node<T> currentNode = firstNode;
        for (int i = 0; i < numberOfEnteries; i++)
        {
            if (currentNode.data().equals(anEntry))
            {
                return currentNode;
            }
            currentNode = currentNode.next();
        }
        return null;
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
    public T pick()
    {
        if (isEmpty())
        {
            return null;
        }
        Node<T> currentNode;
        TestableRandom generator = new TestableRandom();
        int index = generator.nextInt(numberOfEnteries);
        currentNode = firstNode;
        for (int i = 0; i < index; i++)
        {
            currentNode = currentNode.next();
        }
        T data = currentNode.data();
        return data;
    }

    /**
     * Removes an object from the bag
     * @param anEntry - the object to be removed from the bag
     * @return false if the object isn't in the bag, true if it's removed
     * @throws NullPointerException if anEntry is null
     */
    @Override
    public boolean remove(T anEntry) 
    {
        
        Node<T> thisNode = getRefrenceTo(anEntry);
        if (thisNode == null)
        {
            return false;
        }
        thisNode.setData(firstNode.data());
        firstNode = firstNode.next();
        numberOfEnteries--;
        return true;
    }
}
