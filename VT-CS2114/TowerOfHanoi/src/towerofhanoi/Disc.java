/**
 * 
 */
package towerofhanoi;

import java.awt.Color;

import CS2114.Shape;
import student.TestableRandom;

/**
 * @author Charles Kresho
 * @version 2016.3.16
 */
public class Disc extends Shape implements Comparable<Disc> 
{
    
    /**
     * Creates a new Disk object
     * @param width - width of the disk
     */
    public Disc(int width)
    {
        super(0, 0, width, 9);
        TestableRandom random = new TestableRandom();
        Color backgroundColor = new Color(random.nextInt(256), 
                random.nextInt(256), random.nextInt(256));
        this.setBackgroundColor(backgroundColor);
    }
    
    /**
     * Compares one disk to another
     * @param other - the other disk to be compared
     * @return  The differences of the widths of the two disks.  Negative if
     * the other disk is larger, positive if this disk is larger, 
     * 0 if they are the same size
     * @throws IllegalArgumentException - If the other is null
     */
    @Override
    public int compareTo(Disc other) 
    {
        if (other == null)
        {
            throw new IllegalArgumentException();
        }
        
        return this.getWidth() - other.getWidth();
    }
    
    /**
     * Returns the width of the disk as a string
     * @return The width of the disk as a string
     */
    @Override
    public String toString()
    {
        return "" + this.getWidth();
    }
    
    /**
     * Checks for equality of this and the other object
     * @param other - other object to be tested
     * @return true if the other object is a disk with a similar width, false
     * otherwise
     */
    @Override
    public boolean equals(Object other)
    {
        if (other == this)
        {
            return true;
        }
        
        if (other == null || other.getClass() != this.getClass())
        {
            return false;
        }
        
        return this.getWidth() == ((Disc)other).getWidth();
    }
}