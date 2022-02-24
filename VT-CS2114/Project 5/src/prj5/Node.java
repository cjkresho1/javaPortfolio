package prj5;

/**
 * @author Charles Kresho
 * @version 2016.4.12
 * @param <E>
 *            type of data to be stored in the node
 */
public class Node<E> 
{
    private Node<E> next;
    private E data;

    /**
     * Creates a new Node object
     * 
     * @param data
     *            the data to put inside the node
     */
    public Node(E data)
    {
        this.data = data;
        next = null;
    }

    /**
     * Sets the next node
     * 
     * @param next
     *            the node after this one
     */
    public void setNext(Node<E> next) 
    {
        this.next = next;
    }

    /**
     * Returns the next node
     * 
     * @return the next node
     */
    public Node<E> getNext() 
    {
        return next;
    }

    /**
     * Returns the data in the node
     * 
     * @return the data in the node
     */
    public E getData() 
    {
        return data;
    }

    /**
     * Returns data.toString()
     * 
     * @return data.toString()
     */
    @Override
    public String toString() 
    {
        return data.toString();
    }
}
