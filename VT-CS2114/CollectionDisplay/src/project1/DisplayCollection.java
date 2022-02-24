/**
 * 
 */
package project1;

import bag.Bag; 
import bag.BagInterface;
import java.util.Random;

/**
 * @author Charles Kresho
 * @version 2016.1.29
 *
 */


public class DisplayCollection {
    
    /**
     * STRINGS contains all of the possible strings to be  placed in the bag
     */
    public static final String[] STRINGS = {"red circle", "blue circle", 
        "red square", "blue square"};
    private BagInterface<String> itemBag;
    
    /**
     * Constructor that sets up the bag of strings to a random size 
     * between 5 and 15
     */
    public DisplayCollection()
    {
        this.itemBag = new Bag<>();
        Random random = new Random();
        int size = 5 + random.nextInt(11);
        for (int i = 0; i < size; i++)
        {
            itemBag.add(STRINGS[random.nextInt(4)]);
        }
    }
    
    /**
     * Get's the itemBag
     * @return the itemBag
     */
    public BagInterface<String> getItemBag()
    {
        return this.itemBag;
    }
}
