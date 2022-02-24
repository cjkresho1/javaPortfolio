/**
 * 
 */
package project1;

import bag.BagInterface;
import student.TestCase;

/**
 * @author Charles Kresho
 * @version 2016.1.29
 *
 */
public class DisplayCollectionTest extends TestCase {
    
    /**
     * The setUp() method is left intentionally blank, as there isn't 
     * anything to be set up for this test class
     */
    public void setUp()
    {
        //This method is left black
    }
    
    /**
     * Tests to make sure that the bag contains only Strings from 
     * the predefined STRINGS array in the DisplayCollection class.
     */
    public void testBagContents()
    {
        DisplayCollection display = new DisplayCollection();
        BagInterface<String> bag = display.getItemBag();
        for (int i = 0; i < bag.getCurrentSize(); i++)
        {
            String content = bag.remove();
            boolean isIncluded = false;
            for (int k = 0; k < 4; k++)
            {
                if (content.equals(DisplayCollection.STRINGS[k]))
                {
                    isIncluded = true;
                }
            }
            assertTrue(isIncluded);
        }
    }
    
    /**
     * Tests to make sure that the bag varies in size between 5 and 15
     */
    public void testBagSize()
    {
        for (int i = 0; i < 20; i++)
        {
            DisplayCollection display = new DisplayCollection();
            BagInterface<String> bag = display.getItemBag();
            assertTrue(5 <= bag.getCurrentSize() && bag.getCurrentSize() <= 15);
        }
    }
}
