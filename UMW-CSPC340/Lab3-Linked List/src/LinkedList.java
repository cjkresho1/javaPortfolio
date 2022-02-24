// LinkedList.java

public class LinkedList<Type>
{
    // a Node of the list
    private class Node
    {
        public Type data;
        public Node next;
    }
    
    // counter of the number of items in the list
    private int size;

    // the head of the list is first node
    private Node head;

    // the list starts empty
    public LinkedList()
    {
        head = null;
        size = 0;
    }

    // add an item to the list
    public void add(Type item)
    {
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = head;
        head = newNode;
        size++;
    }

    // add an item to the end of the list
    public void append(Type item)
    {
        if (head == null)
        {
            add(item);
        }
        else
        {
            Node newNode = new Node();
            newNode.data = item;
            newNode.next = null;

            Node last = head;
            while (last.next != null)
            {
                last = last.next;
            }

            last.next = newNode;
        }
        size++;
    }

    // remove an item based on the value
    public void remove(Type item)
    {
        Node current = head;
        Node prev = null;

        while (current != null)
        {
            if (current.data.equals(item))
            {
                size--;
                if (prev == null)
                {
                    head = current.next;
                }
                else
                {
                    prev.next = current.next;
                }
            }

            prev = current;
            current = current.next;
        }
    }

    // remove an item based on its index
    public void remove(int index)
    {
        Node current = head;
        Node prev = null;

        for (int i = 0; i < index; i++)
        {
            if (current == null)
            {
                return;
            }

            prev = current;
            current = current.next;
        }

        if (prev == null)
        {
            head = current.next;
        }
        else
        {
            prev.next = current.next;
        }
        size--;
    }

    // print the list from start to finish
    public void print()
    {
        Node current = head;
        while (current != null)
        {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // print a linked list backwards using recursion
    public void printBackwards(Node node)
    {
        if (node != null)
        {
            printBackwards(node.next);
            System.out.println(node.data);
        }
    }

    // helper function to begin printing a linked list backwards
    public void printBackwards()
    {
        printBackwards(head);
    }
    
    //Returns the number of elements in the list
    public int size()
    {
        return size;
    }
    
    public boolean contains(Type item)
    {
        Node current = head;
        
        while (current != null)
        {
            if (current.data.equals(item))
            {
                return true;
            }
            current = current.next;
        }
        
        return false;
    }
    
    public Type get (int index)
    {
        Node current = head;
        
        for (int i = 0; i < index; i++)
        {
            current = head.next;
        }
        
        return current.data;
    }
}
