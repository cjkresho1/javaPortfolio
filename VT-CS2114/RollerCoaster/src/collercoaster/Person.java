/**
 * 
 */
package collercoaster;

/**
 * @author Charles Kresho
 * version 2016.4.6
 */
public class Person 
{
    private String name;
    private int height;
    
    /**
     * Creates a new person with a name and a height
     * @param name - name of the person
     * @param height - height of the person
     */
    public Person(String name, int height)
    {
        this.name = name;
        this.height = height;
    }
    
    /**
     * Gets the name of the person
     * @return  name of the person
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Gets the height of the person
     * @return  height of the person
     */
    public int getHeight()
    {
        return height;
    }
    
    /**
     * Returns a string representation of the person
     * @return "(Name) (height)cm"
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append(" " + height + "cm");
        return builder.toString();
    }
    
    /**
     * Checks for equality of two people
     * @param other - other object to be tested
     * @return  true if the two people have the same name and height
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
        if (((Person)other).height == height 
                && ((Person)other).name.equals(name))
        {
            return true;
        }
        return false;
    }
}
