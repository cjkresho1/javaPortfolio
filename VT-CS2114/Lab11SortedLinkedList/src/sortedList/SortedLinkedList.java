/**
 * 
 */
package sortedList;

import java.util.AbstractList;
import java.util.Comparator;

/**
 * @author Charles Kresho
 * @version 2016.4.8
 * @param <E> - data to be stored in the list
 */
public class SortedLinkedList<E> extends AbstractList<E>
{
    private Node<E> head;
    private Comparator<? super E> compare;
    private int size;
    
    /**
     * Creates a new SortedLinkedList object
     * @param comp - Comparator object that will sort the data
     */
    public SortedLinkedList(Comparator<? super E> comp)
    {
        head = null;
        compare = comp;
        size = 0;
    }
    
    /**
     * Get's the element at the index.
     * @param index - index to retrieve the element from.
     * @return The element at the index.
     * @throws IndexOutOfBoundsException if index < 0 or index >= size()
     */
    @Override
    public E get(int index)
    {
        if (head == null || index >= size || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++)
        {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Returns the number of elements in the list.
     * @return The number of elements in the list.
     */
    @Override
    public int size()
    {
        return size;
    }
    
    /**
     * Adds the data to the sorted list, maintaining the integrity of the list
     * @param data - data to be added to the list
     * @return true
     */
    @Override
    public boolean add(E data)
    {
        Node<E> newNode = new Node<E>(data);
        //If the list is empty
        size++;
        if (head == null)
        {
            head = newNode;
            return true;
        }
        //If the data goes before head
        if (compare.compare(newNode.data, head.data) <= 0)
        {
            newNode.setNext(head);
            head = newNode;
            return true;
        }
        //If the data goes somewhere in the list
        Node<E> current = head;
        while (current.next() != null)
        {
            if (compare.compare(newNode.data, current.next.data) <= 0)
            {
                newNode.next = current.next;
                current.next = newNode;
                return true;
            }
            current = current.next;
        }
        //If the data goes at the end of the list
        current.next = newNode;
        return true;
    }
    
    /**
     * Gets a new IntegerComparator
     * @return a new IntegerComparator
     */
    public static Comparator<Integer> integerComparator()
    {
        return new IntegerComparator();
    }
    
    /**
     * Gets a new StringComparator
     * @return a new StringComparator
     */
    public static Comparator<String> stringComparator()
    {
        return new StringComparator();
    }
    
    /**
     * @author Charles Kresho
     * @version 2016.4.8
     * @param <D> - type of data to be stored in the Node
     */
    public static class Node<D> 
    {

        private D data;
        private Node<D> next;

        /**
         * Creates a new node with the given data
         * @param d - the data to put inside the node
         */
        public Node(D d) 
        {
            data = d;
            next = null;
        }

        /**
         * Sets the node after this node
         * @param n - the node after this one
         */
        public void setNext(Node<D> n) 
        {
            next = n;
        }

        /**
         * Gets the next node
         * @return the next node
         */
        public Node<D> next() 
        {
            return next;
        }

        /**
         * Gets the data in the node
         * @return the data in the node
         */
        public D getData() 
        {
            return data;
        }
    }
    
    private static class IntegerComparator implements Comparator<Integer>
    {
        /**
         * Comparator that sorts Integers
         */
        @Override
        public int compare(Integer i1, Integer i2) 
        {
            return i1 - i2;
        }
    }
    
    private static class StringComparator implements Comparator<String>
    {
        /**
         * Comparator that sorts Strings
         */
        @Override
        public int compare(String s1, String s2)
        {
            return s1.compareTo(s2);
        }
    }
}
