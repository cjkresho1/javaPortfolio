/**
 * 
 */
package collercoaster;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Charles Kresho
 * @version 2016.4.6
 */
public class CoasterTrain 
{
    /**
     * Represents the total amount of seats that are available on the train
     */
    public static final int SEATS = 20;
    private Person[] seats;
    private int firstAvailable;
    
    /**
     * Creates a new CoasterTrain object
     */
    public CoasterTrain()
    {
        seats = new Person[SEATS];
        firstAvailable = 0;
    }
    
    /**
     * Gets the number of open seats on the train
     * @return  number of open seats on the train
     */
    public int getOpenSeats()
    {
        return SEATS - firstAvailable;
    }
    
    /**
     * Checks to see if the train is empty
     * @return  true if the train is empty
     *          false otherwise
     */
    public boolean isEmpty()
    {
        return firstAvailable == 0;
    }
    
    /**
     * Empties the train
     */
    public void clear()
    {
        seats = new Person[SEATS];
        firstAvailable = 0;
    }
    
    /**
     * Places the people from the party into the train without altering the 
     * original party
     * @param party - party of people to be placed into the train
     * @throws IllegalStateException if the party is too large to be placed on
     *                               the train
     */
    public void seatParty(WaitingParty party)
    {
        if (party.getLength() > (this.getOpenSeats()))
        {
            throw new IllegalStateException();
        }
        
        Iterator<Person> iter = party.iterator();
        while (iter.hasNext())
        {
            seats[firstAvailable] = iter.next();
            firstAvailable++;
        }
    }
    
    /**
     * Returns an array representation of the train
     * @return  the seats on the train
     */
    public Person[] toArray()
    {
        return seats.clone();
    }
    
    /**
     * Returns a String representation of the train
     * @return  "[seats.toString()]"
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Person firstPerson = seats[0];
        if (firstPerson == null)
        {
            builder.append("]");
            return builder.toString();
        }
        builder.append(firstPerson.toString());
        for (Person i:seats)
        {
            if (i == null)
            {
                break;
            }
            
            if (!i.equals(firstPerson))
            {
                builder.append(", ");
                builder.append(i.toString());
            }
        }
        builder.append("]");
        return builder.toString();
    }
    
    /**
     * Checks for equality of two CoasterTrains
     * @param other - other object to be tested
     * @return  true if the two trains have the exact same people in the exact
     *              same order (based on name and height)
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
        return Arrays.equals(this.seats, ((CoasterTrain)other).seats);
    }
}
