/**
 * 
 */
package towerofhanoi;

import java.util.EmptyStackException;

import stack.StackInterface;

/**
 * @author Charles Kresho
 * @version 2016.3.16
 * @param <T> - Type of data stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> 
{
    private int size;
    private Node<T> topNode;
    
    /**
     * Creates a new LinkedStack object
     */
    public LinkedStack()
    {
        topNode = null;
        size = 0;
    }
    
    /**
     * Clears the stack
     */
    @Override
    public void clear() 
    {
        topNode = null;
        size = 0;
    }

    /**
     * Checks to see if the stack is empty
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() 
    {
        return size == 0;
    }

    /**
     * Returns the top of the stack without modifying the stack
     * @return the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public T peek() 
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return topNode.data;
    }

    /**
     * Removes and returns the top of the stack
     * @return the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public T pop() 
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        
        T data = topNode.getData();
        topNode = topNode.getNextNode();
        size--;
        return data;
    }

    /**
     * Places a new entry on the top of the stack
     * @param newEntry - new object to be placed on the stack
     */
    @Override
    public void push(T newEntry) 
    {
        
        Node<T> newNode = new Node<T>(newEntry, topNode);
        topNode = newNode;
        size++;
    }
    
    /**
     * Gets the size of the stack
     * @return the size of the stack
     */
    public int size()
    {
        return size;
    }
    
    /**
     * Returns a string representation of the stack
     * @return a string representation of the stack
     *         "[]" if the stack is empty
     *         "[top of stack, middle of stack, bottom of stack] otherwise
     */
    @Override
    public String toString()
    {
        String contents = "[";
        if (isEmpty())
        {
            contents = contents.concat("]");
            return contents;
        }
        
        LinkedStack<T> copy = new LinkedStack<T>();
        LinkedStack<T> temp = new LinkedStack<T>();
        while (!this.isEmpty())
        {
            temp.push(this.pop());
        }
        while (!temp.isEmpty())
        {
            copy.push(temp.peek());
            this.push(temp.pop());
        }
        T currentData = copy.pop();
        contents = contents.concat(currentData.toString());
        while (copy.topNode != null)
        {
            currentData = copy.pop();
            contents = contents.concat(" " + currentData.toString());
        }
        return contents.concat("]");
    }
    
    /**
     * Node class for use in the stack
     * @author Charles Kresho
     * @version 2016.3.16
     * @param <T> - type of object to be held in the stack
     */
    @SuppressWarnings("hiding")
    private class Node<T>
    {
        private T data;
        private Node<T> nextNode;
        
        /**
         * Creates a new node object
         * @param information - data to be held in the node
         * @param node - node to be the next node of the new node
         */
        public Node(T information, Node<T> node)
        {
            data = information;
            this.setNextNode(node);
        }
        
        /**
         * Returns the next node in the link
         * @return the next node in the link
         */
        public Node<T> getNextNode()
        {
            return nextNode;
        }
        
        /**
         * Gets the data of the current node
         * @return - data stored by the node
         */
        public T getData()
        {
            return data;
        }
        
        /**
         * Sets the next node of the current node
         * @param node - node to be the next node
         */
        public void setNextNode(Node<T> node)
        {
            nextNode = node;
        }
    }
}
