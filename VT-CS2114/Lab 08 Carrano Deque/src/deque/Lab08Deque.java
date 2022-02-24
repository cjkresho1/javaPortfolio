package deque;

/**
 * A deque implemented using a doubly-linked chain with sentinel nodes at each
 * end.
 *
 * @param <T>
 *            The type of elements contained in the deque.
 *
 * @author Charles Kresho cjkresho
 * @version 2016.3.18
 */
public class Lab08Deque<T> extends DLinkedDeque<T>
{

    /**
     * Inserts a new item at the front of the deque.
     * 
     * @param newEntry
     *            the item to insert.
     */
    public void addToFront(T newEntry)
    {
        DLNode<T> newNode = new DLNode<T>(this.firstNode, newEntry, null);
        if (this.size > 0)
        {
            this.firstNode.setNextNode(newNode);
        }
        else
        {
            this.lastNode = newNode;
        }
        this.size++;
        this.firstNode = newNode;
    } // end addToFront

    /**
     * Insert a new item at the rear of the deque.
     * 
     * @param newEntry
     *            the item to insert.
     */
    public void addToBack(T newEntry)
    {
        DLNode<T> newNode = new DLNode<T>(null, newEntry, this.lastNode);
        if (size > 0)
        {
            this.lastNode.setPreviousNode(newNode);
        }
        else
        {
            this.firstNode = newNode;
        }
        this.size++;
        this.lastNode = newNode;
    } // end addToBack

    /**
     * Remove the item at the front of the deque.
     * 
     * @return The item that was removed
     * @throws EmptyQueueException
     *             if there is not an element at the front
     */
    public T removeFront()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        T data = this.firstNode.getData();
        if (size != 1)
        {
            this.firstNode = this.firstNode.getPreviousNode();
            this.firstNode.setNextNode(null);
            this.size--;
        }
        else
        {
            clear();
        }
        return data;
    } // end removeFront

    /**
     * Remove the item at the rear of the deque.
     * 
     * @return The item that was removed
     * @throws EmptyQueueException
     *                  if there is no element at the front
     */
    public T removeBack()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        T data = this.lastNode.getData();
        if (this.size != 1)
        {
            this.lastNode = this.lastNode.getNextNode();
            this.lastNode.setPreviousNode(null);
            this.size--;
        }
        else
        {
            this.clear();
        }
        return data;
    } // end removeBack

    /**
     * Get the item at the front (the head) of the deque. Does not alter the
     * deque.
     * 
     * @return the item at the front of the deque.
     * @throws EmptyQueueException
     *                     if no element at the front
     */
    public T getFront()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        return this.firstNode.getData();
    } // end getFront

    /**
     * Get the item at the rear (the tail) of the deque. Does not alter the
     * deque.
     * 
     * @return the item at the rear of the deque.
     * @throws EmptyQueueException
     *              if  no element at rear
     *            
     */
    public T getBack()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        return this.lastNode.getData();
    } // end getBack

    /**
     * Check if the deque is empty
     * 
     * @return true if the deque has no items
     */
    public boolean isEmpty()
    {
        return this.size == 0;
    } // end isEmpty

    /**
     * Empty the deque.
     */
    public void clear()
    {
        this.firstNode = null;
        this.lastNode = null;
        this.size = 0;
    } // end clear

    // ----------------------------------------------------------
    /**
     * Returns a string representation of this deque. A deque's string
     * representation is written as a comma-separated list of its contents (in
     * front-to-rear order) surrounded by square brackets, like this:
     * 
     * [52, 14, 12, 119, 73, 80, 35]
     * 
     * An empty deque is simply [].
     *
     * @return a string representation of the deque
     */
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("[");
        DLNode<T> p = firstNode;
        while (p != null)
        {
            if (s.length() > 1)
            {
                s.append(", ");
            }
            s.append(p.getData());
            p = p.getPreviousNode();
        }
        s.append("]");
        return s.toString();
    }

}
