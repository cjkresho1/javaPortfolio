/**
 * 
 */
package icecream;

import java.util.Stack;

/**
 * @author Charles Kresho
 * @version 2016.2.19
 */
public class IceCreamCone implements IceCreamConeADT {

    private Stack<String> stack;
    private int numOfScoops;
    
    /**
     * Creates the data storage for a new IceCreamCone object
     */
    public IceCreamCone()
    {
        stack = new Stack<String>();
        numOfScoops = 0;
    }
    
    /**
     * Eat the top scoop of ice cream.
     * 
     * @precondition There exists at least one flavor of ice cream in the ice
     *               cream cone. (The cone isn't empty).
     * @return The flavor of the scoop eaten.
     */
    @Override
    public String eatScoop() 
    {
        if (!this.emptyCone())
        {
            numOfScoops--;
            return stack.pop(); 
        }
        return null;
    }

    /**
     * Add a scoop of ice cream to the top of the ice cream cone.
     * 
     * @precondition The flavor isn't null.
     * @param flavor
     *            Flavor of ice cream to be added.
     */
    @Override
    public void addScoop(String flavor) 
    {
        if (flavor != null)
        {
            stack.push(flavor);
            numOfScoops++;
        }
    }

    /**
     * The number of scoops on the cone.
     * 
     * @return Returns the number of scoops on the cone.
     */
    @Override
    public int numScoops() 
    {
        return numOfScoops;
    }

    /**
     * Check if your cone already contains a specific flavor of ice cream.
     * 
     * @precondition The flavor isn't null.
     * @param flavor
     *            Flavor to be checked for.
     * @return Returns true if the cone already contains the desired flavor.
     */
    @Override
    public boolean contains(String flavor) 
    {
        if (flavor != null)
        {
            return stack.search(flavor) != -1;
        }
        return false;
    }

    /**
     * Checks if any scoops of ice cream are left.
     * 
     * @return Returns true if there are no ice cream scoops left in the cone.
     */
    @Override
    public boolean emptyCone() 
    {
        return numOfScoops == 0;
    }

    /**
     * The flavor of the ice cream at the top of the cone.
     * 
     * @precondition There exists at least one flavor of ice cream in the ice
     *               cream cone. (The cone isn't empty).
     * @return Returns the flavor of the top of the cone.
     */
    @Override
    public String currentScoop() 
    {
        if (!this.emptyCone())
        {
            return stack.peek();
        }
        return null;
    }
    
    /**
     * Checks for equality of two different IceCreamCones, based upon the fact
     * that they have the same scoops in the same order
     * @param other - object to be tested for equality
     * @return True if two IceCreamCones are equal
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
        return ((IceCreamCone)other).toString().equals(this.toString());
    }
    
    /**
     * Returns a string representation of the ice cream cone. Format: The
     * flavors are surrounded by brackets: [] The flavors are separated by
     * commas. Example: [Vanilla, Chocolate, Rocky Road] Orientation: Flavors
     * are appended to the right when pushed onto the stack. Flavors are removed
     * from the right when popped off the stack.
     * 
     * @return The string of the ice cream flavors.
     */
    @Override
    public String toString()
    {
        String scoops = "[";
        for (int i = 0; i < numOfScoops - 1; i++)
        {
            scoops = scoops.concat(stack.elementAt(i));
            scoops = scoops.concat(", ");
        }
        scoops = scoops.concat(stack.elementAt(numOfScoops - 1));
        return scoops.concat("]");
    }

}
