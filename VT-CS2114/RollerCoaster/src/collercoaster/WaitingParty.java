/**
 * 
 */
package collercoaster;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import list.AList;

/**
 * @author Charles Kresho
 * @version 2016.4.7
 */
public class WaitingParty extends AList<Person> implements Iterable<Person> 
{
    private final boolean willSplit;
    
    /**
     * Creates a new WaitingParty object
     * @param willSplit - indicates if the part is willing to split
     */
    public WaitingParty(boolean willSplit)
    {
        this.willSplit = willSplit;
    }
    
    /**
     * Gets willSplit
     * @return the value of willSplit
     */
    public boolean getWillSplit()
    {
        return willSplit;
    }
    
    /**
     * Tries to split the party if the size of the party is larger than maxSize
     * @param maxSize - max size of a party for the ride
     * @return  this if the party's size is less than maxSize
     *          null if the party is too large and will not split
     *          splitParty, containing maxSize people from the front of the
     *              line, if the party is too large and will split.  Removes
     *              the maxSize people from this party
     */
    public WaitingParty splitParty(int maxSize)
    {
        if (this.getLength() <= maxSize)
        {
            return this;
        }
        if (this.willSplit)
        {
            WaitingParty splitParty = new WaitingParty(true);
            for (int i = 0; i < maxSize; i++)
            {
                splitParty.add(this.remove(0));
            }
            return splitParty;
        }
        return null;
    }
    
    /**
     * Attempts to remove a specified person from the list
     * @param person - person to be removed
     * @return  true if the person is found and removed
     *          false if the person isn't found
     */
    public boolean removePerson(Person person)
    {
        Iterator<Person> iter = this.iterator();
        int index = 0;
        while (iter.hasNext())
        {
            if (iter.next().equals(person))
            {
                this.remove(index);
                return true;
            }
            index++;
        }
        return false;
    }
    
    /**
     * Returns a string interpretation of the WaitingParty
     * @return  {"Party of size ", length, " will ", optional "not ", "split. "
     *              "Each person in the list"}
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Party of size ");
        builder.append(this.getLength());
        if (willSplit)
        {
            builder.append(" will split. ");
        }
        else
        {
            builder.append(" will not split. ");
        }
        builder.append(super.toString());
        return builder.toString();
        
    }
    
    /**
     * Checks for equality of two WaitingParty objects
     * @param other - object to be checked for equality
     * @return false if other is null or not a WaitingParty
     *         false if other doesn't have the same people in the list as this
     *         true if other is this or has the same people in the list as this
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
        Object[] items = this.toArray();
        Object[] otherItems = ((WaitingParty)other).toArray();
        ComparePersonHeight comparer = new ComparePersonHeight();
        Arrays.sort(items, comparer);
        Arrays.sort(otherItems, comparer);
        return Arrays.equals(items, otherItems);
    }
    
    /**
     * Creates an new iterator for this WaitingParty
     * @return new WaitingPartyIterator
     */
    @Override
    public Iterator<Person> iterator() 
    {
        return new WaitingPartyIterator<Person>();
    }
    
    private class WaitingPartyIterator<A> implements Iterator<Person>
    {
        private int index;
        
        /**
         * Creates a new WaitingPartyIterator object
         */
        private WaitingPartyIterator()
        {
            index = 0;
        }

        /**
         * Checks to see if there is another Person in the WaitingParty
         * @return  true if there is another Person in the party
         *          false if there isn't another Person in the party
         */
        @Override
        public boolean hasNext() 
        {
            return index < getLength();
        }

        /**
         * Iterates to the next Person in the party, if there is one
         * @return  the next Person in the party if hasNext() is true
         * @throws NoSuchElementException if hasNext() is false
         */
        @Override
        public Person next() 
        {
            if(!hasNext())
            {
                throw new NoSuchElementException("Cannot call next(), there is"
                        + " no next element.");
            }
            index++;
            return getEntry(index - 1);
        }
    }
}
