/**
 * 
 */
package arraystack;

import java.util.EmptyStackException;

/**
 * @author Charles Kresho
 * @version 2016.2.26
 * @param <T> - the data type to be stored in the stack
 */
public class ArrayBasedStack<T> implements StackADT<T> 
{
    private T[] stackArray;
    private int size;
    private int capacity;
    
    /**
     * Creates a new object ArrayBasedStack() with a capacity of 100
     */
    public ArrayBasedStack()
    {
        this(100);
    }
    /**
     * Creates a new object ArrayBasedStack() with a capacity of maxCapacity
     * @param maxCapacity - the capacity of the new Stack
     */
    @SuppressWarnings("unchecked")
    public ArrayBasedStack(int maxCapacity)
    {
        capacity = maxCapacity;
        size = 0;
        stackArray = (T[]) new Object[capacity];
    }
    
    /**
     * Checks if the Stack is empty
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() 
    {
        return size == 0;
    }

    /**
     * Gets the top entry in the Stack
     * @return the entry at the top of the Stack
     */
    @Override
    public T peek() 
    {
        if (size == 0)
        {
            throw new EmptyStackException();
        }
        return stackArray[size - 1];
    }

    /**
     * Gets and removes the top entry in the Stack
     * @return the top entry in the Stack
     */
    @Override
    public T pop() 
    {
        T data = this.peek();
        stackArray[size - 1] = null;
        size--;
        return data;
    }

    /**
     * Places a new item on the top of the stack, doubling the capacity of the 
     * Stack if need be
     * @param item - new item to be added
     */
    @Override
    public void push(T item) 
    {
        if (size == capacity)
        {
            expandCapacity();
        }
        stackArray[size] = item;
        size++;
    }

    /**
     * Checks to see if the item is contained in the Stack
     * @param item - item to be found
     * @return true if the item is in the Stack, false otherwise
     */
    @Override
    public boolean contains(T item)
    {
        for (int i = 0; i < size; i++)
        {
            if (stackArray[i].equals(item))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the number of entries in the Stack
     * @return - size of the Stack
     */
    @Override
    public int size() 
    {
        return size;
    }

    /**
     * Removes all entries from the Stack
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() 
    {
        stackArray = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * Returns a array containing the objects in the Stack, with the "top" 
     * object located at the last entry in the new array
     * @return the array with duplicate objects
     */
    @Override
    public T[] toArray() 
    {
        @SuppressWarnings("unchecked")
        T[] copy =   (T[]) new Object[this.size()];
        for (int i = 0; i < this.size(); i++) 
        {
            copy[i] = this.stackArray[i];
        }
        return copy;
    }
    
    /**
     * Expands the capacity of the stack by doubling its current capacity.
     */
    private void expandCapacity() 
    {
        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[this.capacity * 2];
        for (int i = 0; i < this.capacity; i++) 
        {
            newArray[i] = this.stackArray[i];
        }
        this.stackArray = newArray;
        this.capacity *= 2;
    }
    
    /**
     * Returns the string representation of the stack.
     * </p>
     * <ul>
     *   <li>[] (if the stack is empty)</li>
     *   <li>[bottom, item, ..., item, top] (if the stack contains items)</li>
     * </ul>
     * 
     * @return the string representation of the stack.
     */
    @Override
    public String toString() 
    {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        boolean firstItem = true;
        for (int i = 0; i < this.size(); i++) 
        {
            if (!firstItem) 
            {
                builder.append(", ");
            }
            else 
            {
                firstItem = false;
            }
            // String.valueOf will print null or the toString of the item
            builder.append(String.valueOf(this.stackArray[i]));
        }
        builder.append(']');
        return builder.toString();
    }
    
    /**
     * Two stacks are equal iff they both have the same size and contain the
     * same elements in the same order.
     *
     * @param other
     *            the other object to compare to this
     *
     * @return {@code true}, if the stacks are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object other) 
    {
        if (this == other) 
        {
            return true;
        }
        if (other == null) 
        {
            return false;
        }
        if (this.getClass().equals(other.getClass())) 
        {
            ArrayBasedStack<?> otherStack = (ArrayBasedStack<?>) other;
            if (this.size() != otherStack.size()) 
            {
                return false;
            }
            Object[] otherArray = otherStack.toArray();
            for (int i = 0; i < this.size(); i++) 
            {
                if (!(this.stackArray[i].equals(otherArray[i]))) 
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
