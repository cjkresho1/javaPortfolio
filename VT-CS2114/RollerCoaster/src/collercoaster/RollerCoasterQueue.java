/**
 * 
 */
package collercoaster;

import list.AList;

/**
 * @author Charles Kresho
 * @version 2016.4.6
 */
public class RollerCoasterQueue 
{
    /**
     * Represents the minimum height of a person to be able to ride the ride
     */
    public static final int MIN_PERSON_HEIGHT = 96;
    private ArrayQueue<WaitingParty> queue;
    private AList<WaitingParty> rejectedParties;
    
    /**
     * Creates a new RollerCoasterQueue object
     */
    public RollerCoasterQueue()
    {
        queue = new ArrayQueue<WaitingParty>();
        rejectedParties = new AList<WaitingParty>();
    }
    
    /**
     * Gets the list of rejected parties
     * @return  list of rejected parties
     */
    public AList<WaitingParty> getRejectedParties()
    {
        return rejectedParties;
    }
    
    /**
     * Gets the queue of waiting parties
     * @return  queue of waiting parties
     */
    public ArrayQueue<WaitingParty> getQueue()
    {
        return queue;
    }
    
    /**
     * Checks to see if the queue of waiting parties is empty
     * @return  true if the queue of waiting parties is empty
     *          false if the queue of waiting parties isn't empty
     */
    public boolean isEmpty()
    {
        return queue.isEmpty();
    }
    
    /**
     * Gets the WaitingParty that is at the front of the queue
     * @return  the WaitingParty that is at the front of the queue
     * @throws NullPointerException if there is no first element
     */
    public WaitingParty getFront()
    {
        if (isEmpty())
        {
            throw new NullPointerException();
        }
        return queue.getFront();
    }
    
    /**
     * Gets the minimum height for the ride
     * @return MIN_PERSON_HEIGHT
     */
    public int getMinimumHeight()
    {
        return MIN_PERSON_HEIGHT;
    }
    
    /**
     * Places a party in the end of the queue if there are no people in the 
     * party below the minimum height.  If anyone is below the minimum height,
     * and the party is willing to split, anyone too short will be placed into
     * a reject party and placed on the rejectedParty list.  Anyone left will
     * be placed in a party and put into the queue.  If the party isn't willing
     * to split, the entire party is placed into the rejectedParty list.
     * @param   party - party to be placed in the queue
     */
    public void enqueueParty(WaitingParty party)
    {
        
        WaitingParty rejectedParty = new WaitingParty(party.getWillSplit());
        for (int i = 0; i < party.getLength(); i++)
        {
            if (party.getEntry(i).getHeight() < MIN_PERSON_HEIGHT)
            {
                if (!party.getWillSplit())
                {
                    rejectedParties.add(party);
                    return;
                }
                rejectedParty.add(party.remove(i));
                i--;
            }
        }
        if (party.getLength() != 0)
        {
            queue.enqueue(party);
        }
        if (rejectedParty.getLength() != 0)
        {
            rejectedParties.add(rejectedParty);
        }
    }
    
    /**
     * Removes the party at the front of the queue from the queue
     * @param seatsAvailable - number of seats available to be filled
     * @return  a WaitingParty of size < seatsAvailable of valid people if a 
     *              valid party can be derived from the party at the front of 
     *              the queue
     *          null if the queue is empty or the WaitingParty isn't valid and
     *              can't be split
     */
    public WaitingParty dequeueParty(int seatsAvailable)
    {
        WaitingParty legitParty = queue.getFront().splitParty(seatsAvailable);
        if (legitParty != null && legitParty.equals(queue.getFront()))
        {
            queue.dequeue();
        }
        return legitParty;
    }
    
    /**
     * Returns an array representation of the queue
     * @return  an array representation of the queue, with the front at index 0
     */
    public Object[] toArray()
    {
        return queue.toArray();
    }
    
    /**
     * Returns a String representation of the queue
     * @return  "Line with minimum height (MIN_PERSON_HEIGHT) cm. 
     *          (queue.toString())"
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Line with minimum height " + MIN_PERSON_HEIGHT 
                + "cm.\n");
        builder.append(queue.toString());
        return builder.toString();
    }
    
    /**
     * Tests for equality of two RollerCoasterQueue's
     * @param other - other object to be tested
     * @return  true if both objects have identical queue's and rejectedParty 
     *              lists
     *          false otherwise
     */
    @Override
    public boolean equals(Object other)
    {
        if (other == null || other.getClass() != this.getClass())
        {
            return false;
        }
        if (other == this)
        {
            return true;
        }
        if (queue.equals(((RollerCoasterQueue)other).queue) && rejectedParties
                .equals(((RollerCoasterQueue)other).rejectedParties))
        {
            return true;
        }
        return false;
    }
}
