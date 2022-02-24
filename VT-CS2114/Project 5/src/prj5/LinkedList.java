package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A linked list with a head reference
 * @author Charles Kresho
 * @version 2016.4.16
 * @param <E> The type of object the list will store
 */
public class LinkedList<E> implements Iterable<E>
{
    private int size;
    private Node<E> head;

    /**
     * Create a new DoublyLinkedList object.
     */
    public LinkedList() 
    {
        head = null;
        size = 0;
    }

    /**
     * Checks if the list is empty
     * @return true if the array is empty
     */
    public boolean isEmpty() 
    {
        return size == 0;
    }
    
    /**
     * Gets the first Node
     * @return head
     */
    public Node<E> getFirstNode() 
    {
        return head;
    }
    
    /**
     * Sets the first node
     * @param node to be set as first;
     */
    public void setFirstNode(Node<E> node) 
    {
        head = node;
    }

    /**
     * Returns the number of elements in the list
     * @return the number of elements
     */
    public int size() 
    {
        return size;
    }

    /**
     * Removes all of the elements from the list
     */
    public void clear() 
    {
        head = null;
        size = 0;
    }

    /**
     * Checks if the list contains the given object
     * @param obj the object to check for
     * @return true if it contains the object
     */
    public boolean contains(E obj) 
    {
        Iterator<E> iter = this.iterator();
        while (iter.hasNext())
        {
            if (iter.next().equals(obj))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the object at the given position
     * @param index where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException if there no node at the given index
     */
    public E get(int index) 
    {
        return getNodeAtIndex(index).getData();
    }

    /**
     * Adds a element to the end of the list
     * @param newEntry the element to add to the end
     */
    public void add(E newEntry) 
    {
        add(size(), newEntry);
    }

    /**
     * Adds the object to the position in the list
     * @param index where to add the object
     * @param obj the object to add
     * @throws IndexOutOfBoundsException if index is less than zero or greater 
     *                                   than size
     * @throws IllegalArgumentException if obj is null
     */
    public void add(int index, E obj) 
    {
     // check if the object is null
        if (null == obj) 
        {
            throw new IllegalArgumentException("Object is null");
        }

        // check if the index is out of bounds
        if ((0 > index) || (size() < index)) 
        {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        // empty stack case or first index case
        if (isEmpty() || index == 0)
        {
            Node<E> next = head;
            head = new Node<E>(obj);
            head.setNext(next);
        }
        else 
        {
            Node<E> previous = getNodeAtIndex(index - 1);
            Node<E> temp = new Node<E>(obj);
            temp.setNext(previous.getNext());
            previous.setNext(temp);
        }
        size++;
    }

    /**
     * Gets the node at that index
     * @param index to get the node at
     * @return node at the index
     * @throws IndexOutOfBoundsException if the index is less than 0 or greater
     *         than size
     */
    private Node<E> getNodeAtIndex(int index)
    {
        if (index < 0 || size() <= index) 
        {
            throw new IndexOutOfBoundsException("Index isn't in the list");
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) 
        {
            current = current.getNext();
        }
        return current;
    }

    /**
     * Removes the element at the specified index from the list
     * @param index where the object is located
     * @throws IndexOutOfBoundsException if there is not an element at the 
     *                                   index
     * @return true if successful
     */
    public boolean remove(int index) 
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Can't remove an object that "
                    + "doesn't exist");
        }
        //remove first node case
        if (index == 0)
        {
            head = head.getNext();
            size--;
            return true;
        }
        //All other cases
        else
        {
            Node<E> current = getNodeAtIndex(index - 1);
            current.setNext(current.getNext().getNext());
            size--;
            return true;
        }
    }

    /**
     * Removes the first instance of the object
     * @param obj the object to remove
     * @return true if the object was found and removed, false otherwise
     */
    public boolean remove(E obj) 
    {
        Node<E> current = head;
        for (int i = 0; i < size; i++)
        {
            if (obj.equals(current.getData()))
            {
                remove(i);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Returns a string representation of the list
     * @return {(Data of the list)}
     */
    @Override
    public String toString() 
    {
        StringBuilder builder = new StringBuilder("{");
        if (!isEmpty())
        {
            builder.append(head.getData().toString());
            Node<E> current = head.getNext();
            for (int i = 1; i < size; i++)
            {
                builder.append(", ");
                builder.append(current.getData().toString());
                current = current.getNext();
            }
        }
        builder.append("}");
        return builder.toString();
    }
    
    /**
     * Returns a new Iterator object for the list
     * @return Iterator<E> an iterator for the list
     */
    @Override
    public Iterator<E> iterator() 
    {
        return new ListIterator<E>();
    }
    
    /**
     * @author Charles Kresho
     * @version 2016.4.12
     * @param <A> - type of data to be parsed by the Iterator
     */
    private class ListIterator<A> implements Iterator<E> 
    {
        private Node<E> nextNode;
        
        /**
        * Creates a new DLListIterator
        */
        public ListIterator() 
        {
            nextNode = head;
        }

        /**
         * Checks if there are more elements in the list
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() 
        {
            return nextNode != null;
        }

        /**
        *Gets the next value in the list
        * @return the next value
        * @throws NoSuchElementException if there are no nodes left in the list
        */
        @Override
        public E next() 
        {
            if (hasNext())
            {
                Node<E> returnNode = nextNode;
                nextNode = nextNode.getNext();
                return returnNode.getData();
            }
            else
            {
                throw new NoSuchElementException("Illegal call to next(); " 
                        + "iterator is after end of list.");
            }
        }
    }
}