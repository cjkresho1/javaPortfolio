import java.util.Random;

// DoubleList.java

/**
 * This doubly linked list was created using code from CPSC340, taught by Ian Finlayson.
 * @author Charles Kresho
 * @version 2020.10.02
 *
 * @param <Type> the type of data to be stored in the list
 */
class DoubleList<Type>
{
    // added functionality for size of the list as a static variable
    private int size;
    

    /**
     * A simple node for a doubly linked list. 
     * @author Ian Finlayson
     */
    private class Node
    {
        public Type data;
        public Node next;
        public Node prev;
        
        // added simple default and parameritized constructor
        /**
         * Creates a completly empty node;
         */
        public Node()
        {
            
        }
        
        /**
         * Creates an unlinked node with data in it.
         * @param t data to be stored in the node.
         */
        public Node(Type t)
        {
            data = t;
            next = null;
            prev = null;
        }
    }

    // we keep references to the first and last nodes
    private Node head;
    private Node tail;

    /**
     * Creates a new, empty doubly linked list.
     */
    public DoubleList()
    {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds an item to the beginning of the list. 
     * @param item the item to be added. 
     */
    public void addStart(Type item)
    {
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = head;
        newNode.prev = null;
        if (tail == null)
        {
            tail = newNode;
        }
        else
        {
            head.prev = newNode;
        }
        head = newNode;
        
        size++;
    }

    /**
     * Adds an item to the end of the list. 
     * @param item the item to be added. 
     */
    public void addEnd(Type item)
    {
        Node newNode = new Node();
        newNode.data = item;
        newNode.prev = tail;
        newNode.next = null;
        if (head == null)
        {
            head = newNode;
        }
        else
        {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    /**
     * Print the list in order.
     */
    void print()
    {
        Node current = head;
        while (current != null)
        {
            System.out.println(current.data);
            current = current.next;
        }
    }

    /**
     * Print the list backwards.
     */
    void printBackwards()
    {
        Node current = tail;
        while (current != null)
        {
            System.out.println(current.data);
            current = current.prev;
        }
    }

    /**
     * Remove all items from the list that match the passed item, and return the number removed. 
     * @param item item to be removed from the list.
     * @return the number of times the item was removed from the list.
     */
    public int remove(Type item)
    {
        Node current = head;
        int removed = 0;

        while (current != null)
        {
            if (current.data.equals(item))
            {
                size--;
                removed++;
                // remove current from list
                if (current.prev != null)
                {
                    current.prev.next = current.next;
                }
                else
                {
                    head = current.next;
                }

                if (current.next != null)
                {
                    current.next.prev = current.prev;
                }
                else
                {
                    tail = current.prev;
                }
            }

            current = current.next;
            
        }
        return removed;
    }
    
    /**
     * Remove a specific indexed item from the list. 
     * @param index index of the item to be removed
     * @return the data of the item removed
     * @throws IndexOutOfBoundsException if the passed index is greater than or less than the bounds of the list
     */
    public Type remove(int index) throws IndexOutOfBoundsException
    {
        if (index >= size || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        
        Type val = null;
        
        //Set head and tail to null if there is only one item in the list
        if (size == 1)
        {
            head = null;
            tail = null;
        }
        //Remove the head if the index is the head node
        else if (index == 0)
        {
            val = head.data;
            head = head.next;
            head.prev = null;
        }
        //Remove the tail if the index is the tail node
        else if (index == size - 1)
        {
            val = tail.data;
            tail = tail.prev;
            tail.next = null;
        }
        //Remove a node in the middle of the list.
        else
        {
            Node cur = head;
            for (int i = 0; i < index - 1; i++)
            {
                cur = cur.next;
            }
            
            Node previous = cur; 
            Node removed = cur.next;
            Node nextNode = removed.next;
            previous.next = nextNode;
            nextNode.prev = previous;
            removed.next = null;
            removed.prev = null;
            val = removed.data;
            
        }
        size--;
        return val;
    }
    
    /**
     * Randomize the order of the list. This creates a new node list, removes nodes from the current list and adds them to the
     * new list, then sets the head and tail to the head and tail of the new list. 
     */
    public void shuffle()
    {
        Random rand = new Random(System.currentTimeMillis());
        Node newHead = null;
        Node newTail = null;
        Node cur;
        int startSize = size;
        int val;
        for (int i = 0; i < startSize; i++)
        {
            val = rand.nextInt(size);
            cur = head;
            for (int j = 0; j < val; j++)
            {
                cur = cur.next;
            }
            
            Node temp = new Node(cur.data);
            remove(val);
            
            if(newHead == null)
            {
                newHead = temp;
                newTail = temp;
            }
            else
            {
                newTail.next = temp;
                temp.prev = newTail;
                newTail = temp;
            }
        }
        
        head = newHead;
        tail = newTail;
        size = startSize;
    }
    
    /**
     * Reverse the order of the list. Just interchanges head, tail, as well as previous and next for all the nodes
     */
    public void reverse()
    {
        Node cur = head;
        while (cur != null)
        {
            Node temp = cur.next;
            cur.next = cur.prev;
            cur.prev = temp;
            
            cur = cur.prev;
        }
        
        Node temp = head;
        head = tail;
        tail = temp;
    }
    
    /**
     * Return the size of the list
     * @return the size of the list
     */
    public int getSize()
    {
        return size;
    }
    
    /**
     * Return the data of a particular indexed item
     * @param index index of the item
     * @return The data of the specified item
     * @throws IndexOutOfBoundsException when the gien index is out of the bounds of the list
     */
    public Type getData(int index) throws IndexOutOfBoundsException
    {
        if (index >= size || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        
        Node cur = head;
        for (int i = 0; i < index; i++)
        {
            cur = cur.next;
        }
        
        return cur.data;
    }
}
