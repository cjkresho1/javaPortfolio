package linkedlist;

/**
 * This is a basic implementation of a linked list
 *
 * @author Mark Wiggans (mmw125)
 * @version 4/14/2015
 * @author Christina Olk (colk)
 * @version 9.4.15
 * @author Grace Fields
 * @version 10.26.15
 * 
 * @param <E>
 *            This is the type of object that this class will store
 */

public class SinglyLinkedList<E> implements LList<E> 
{

    /**
     * This represents a node in a singly linked list. This node stores data
     * along with having a pointer to the next node in the list
     *
     * @param <D>
     *            This is the type of object that this class will store
     * @author Mark Wiggans (mmw125)
     * @author Christina Olk (colk)
     * @author maellis1
     * @version 4/14/2015
     * @version 9.4.15
     * @version 10.29.15
     */
    public static class Node<D> 
    {

        // The data element stored in the node.
        private D data;

        // The next node in the sequence.
        private Node<D> next;

        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(D d) 
        {
            data = d;
        }

        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<D> n) 
        {
            next = n;
        }

        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<D> next() 
        {
            return next;
        }

        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public D getData() 
        {
            return data;
        }
    }

    // the head of the linked list
    private Node<E> head;

    // the size of the linked list
    private int size;

    /**
     * Creates a new LinkedList object
     */
    public SinglyLinkedList() 
    {
        head = null;
        size = 0;
    }

    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    @Override
    public int size() 
    {
        return size;
    }

    /**
     * Adds the object to the position in the list
     *
     * @precondition obj cannot be null
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    @Override
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
            head.next = next;
        }
        // all other cases
        else 
        {
            Node<E> current = head;
            int currentIndex = 0;
            boolean found = false;
            while (!found) 
            {
                if (index == currentIndex + 1) 
                {
                    Node<E> nextNext = current.next;
                    Node<E> newNode = new Node<E>(obj);
                    current.setNext(newNode);
                    newNode.setNext(nextNext);
                    found = true;

                }
                current = current.next();
                currentIndex++;
            }
        }
        size++;
    }

    /**
     * Adds the object to the end of the list.
     *
     * @precondition obj cannot be null
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException
     *             if obj is null
     */
    @Override
    public void add(E obj) 
    {
        // check if the object is null
        if (null == obj) 
        {
            throw new IllegalArgumentException("Object is null");
        }

        Node<E> current = head;

        // empty stack case
        if (isEmpty()) 
        {
            head = new Node<E>(obj);
        }

        // other cases
        else 
        {
            while (current.next != null) 
            {
                current = current.next;
            }
            current.setNext(new Node<E>(obj));
        }
        size++;
    }

    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    @Override
    public boolean isEmpty() 
    {
        return (0 == size);
    }

    /**
     * Removes the first instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful
     */
    @Override
    public boolean remove(E obj) 
    {
        Node<E> current = head;

        // account for matching head
        if ((null != head) && (obj.equals(current.data))) 
        {
            head = head.next;
            size--;
            return true;
        }

        // account for 2+ size
        while (size() >= 2 && null != current.next) 
        {
            if ((obj.equals(current.next.data))) 
            {
                current.setNext(current.next.next);
                size--;
                return true;
            }
            current = current.next;
        }

        // this accounts for the isEmpty case or the object does not exist
        return false;
    }

    /**
     * Removes the object at the given position
     *
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    @Override
    public boolean remove(int index) 
    {
        // // if the index is invalid
        if (index < 0 || index >= size) 
        {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        } 
        else 
        {

            Node<E> current = head;
            int currentIndex = 0;

            // account for 1 size
            if ((0 == index)) 
            {
                head = head.next;
                size--;
                return true;
            }

            // account for 2+ size
            while (null != current) 
            {
                if (index == currentIndex + 1) 
                {
                    Node<E> newNext = current.next.next;
                    current.setNext(newNext);
                    size--;
                    return true;
                }
                current = current.next;
                currentIndex++;
            }
            return false;
        }
    }

    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if no node at the given index
     */
    @Override
    public E get(int index) 
    {
        Node<E> current = head;
        int currentIndex = 0;
        E data = null;
        while (null != current) 
        {
            if (index == currentIndex) 
            {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        // check if the data was null...
        if (null == data) 
        {
            // ... if so throw an exception
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }

    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    @Override
    public boolean contains(E obj) 
    {
        Node<E> current = head;
        while (null != current) 
        {
            if (obj.equals(current.data)) 
            {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    /**
     * Removes all of the elements from the list
     */
    @Override
    public void clear() 
    {
        // make sure we don't call clear on an empty list
        if (head != null) 
        {
            head.setNext(null);
            head = null;
        }
        size = 0;
    }

    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    @Override
    public int lastIndexOf(E obj) 
    {
        int lastIndex = -1;
        Node<E> current = head;
        int currentIndex = 0;
        while (null != current) 
        {
            if (obj.equals(current.data)) 
            {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;

        }
        return lastIndex;
    }

    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString() 
    {
        String result = "{";

        Node<E> current = head;
        while (null != current) 
        {
            result += "" + current.data;
            current = current.next;
            if (null != current) 
            {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }
}
