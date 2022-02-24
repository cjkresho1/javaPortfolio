package groceries;

//-------------------------------------------------------------------------
/**
 * The Grocery Bag class is a bag data structure that holds String objects 
 * that represent grocery store items.
 *
 * @author Megan Rigsbee (mrigsbee)
 * @version 2015.04.25
 * @author Grace Fields
 * @version 2016.02.01
 */
public class GroceryBag extends ArrayBasedBag
{
    //Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates an empty bag using the default capacity.
     */
    public GroceryBag()
    {
        super(10);
    }

    //Public methods ........................................................
    /**
     * If an element is in both bags, then it will be in the 
     * intersection.  If there are multiple occurrences of that
     * element, then the number of occurrences of that element
     * in the intersection will equal the minimum number of occurrences
     * in either set.
     * 
     * Examples:
     * intersection of 
     * ({"apple","apple","cereal","chips"},
     * {"chips", "apple","apple","chips","cake"}) 
     * = {"apple","apple","chips"} 
     * 
     * @param bag Bag to be intersected with.
     * @return The intersection of the two bags.
     */
    public GroceryBag intersection(GroceryBag bag)
    {
        String[] bag1 = bag.contents();
        String[] bag2 = this.contents();
        GroceryBag intersection = new GroceryBag();
        
        for (int i = 0; i < bag1.length; i++)
        {
            for (int j = 0; j < bag2.length; j++)
            {
                if (bag2[j] != null && bag1[i] != null 
                        && bag1[i].equals(bag2[j]))
                {
                    intersection.add(bag1[i]);
                    bag2[j] = null;
                    break;
                } //end if
            } //end for
        } //end for
        
        return intersection;
    } //end intersection()
   

    /**
     * For two bags to be equal they need to contain items 
     * with the exact same value (but not the same item, so 
     * equality not identity).  Order does not matter, but 
     * number of occurrences does.
     * 
     * @param givenBag Other GroceryBag to be compared with for equality.
     * @return Returns true if the two bags have the same items.
     */
    @Override
    public boolean equals(Object givenBag)
    {
        if (givenBag == this)
        {
            return true;
        } //end if
        if (givenBag == null)
        {
            return false;
        } //end if
        if (givenBag.getClass().equals(this.getClass()))
        {
            if (this.size() != ((GroceryBag)givenBag).size())
            {
                return false;
            }
            else
            {
                String[] givenBagString = ((GroceryBag) givenBag).contents();
                String[] thisBag = this.contents();
                int similar = 0;
                for (int i = 0; i < givenBagString.length; i++)
                {
                    for (int j = 0; j < thisBag.length; j++)
                    {
                        if (thisBag[j] != null && givenBagString[i] != null 
                                && givenBagString[i].equals(thisBag[j]))
                        {
                            thisBag[j] = null;
                            similar++;
                            break;
                        } //end if
                    } //end for
                } //end for
                return similar == this.size();
            } //end if
        } //end if
        return false;
    } //end equals()
} // end class
