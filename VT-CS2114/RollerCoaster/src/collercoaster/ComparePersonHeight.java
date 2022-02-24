/**
 * 
 */
package collercoaster;

import java.util.Comparator;

/**
 * @author Charles Kresho
 * @version 2016.4.4
 */
public class ComparePersonHeight implements Comparator<Object> 
{

    /**
     * Compares to Person objects
     * 
     * @param o1 - first person to be compared
     * @param o2 - second person to be compared
     * 
     * @return diff -   diff > 0 if o1 is taller
     *                  diff < 0 of o2 is taller
     *                  if o1 is the same height as o2
     *                      diff < 0 if o1's name precedes o2's name
     *                      diff > 0 if o2's name precedes o1's name
     *                      diff = 0 if the two names and heights are the same
     */
    @Override
    public int compare(Object o1, Object o2) 
    {
        int diff = ((Person)o1).getHeight() - ((Person)o2).getHeight();
        if (diff == 0)
        {
            String name1 = ((Person)o1).getName();
            String name2 = ((Person)o2).getName();
            diff = name2.compareTo(name1);
            
        }
        return diff;
    }
}
