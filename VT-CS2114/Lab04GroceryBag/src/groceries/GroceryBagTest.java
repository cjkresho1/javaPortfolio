/**
 * 
 */
package groceries;

/**
 * @author Charles Kresho
 * @version 2016.2.12
 */
public class GroceryBagTest extends student.TestCase 
{
    private GroceryBag bag1;    // unordered
    private GroceryBag bag2;    // unordered with repeat items
    private GroceryBag bag3;    // ordered
    private GroceryBag bag4;    // ordered with repeat items
    private GroceryBag equalsBag1; //bag equal to bag1
    private GroceryBag notEqualsBag1; //bag not equal to bag1
    private GroceryBag equalsBag2; //bag equal to bag1
    private GroceryBag equalsBag3; //bag equal to bag1
    private GroceryBag equalsBag4; //bag equal to bag1
    private GroceryBag intersection; //bag equal to the intersection of
    //bag 1 and bag 2

    /**
     * Sets up each test method.
     */
    public void setUp()    
    {
        bag1 = new GroceryBag();
        bag1.add("apples");
        bag1.add("chips");
        bag1.add("yogurt");
        bag1.add("chicken");
        bag1.add("pasta");
        
        notEqualsBag1 = new GroceryBag();
        notEqualsBag1.add("apples");
        notEqualsBag1.add("chips");
        notEqualsBag1.add("yogurt");
        notEqualsBag1.add("chicken");
        notEqualsBag1.add("lololololololol");
        
        bag2 = new GroceryBag();
        bag2.add("pizza");
        bag2.add("broccoli");
        bag2.add("pasta");
        bag2.add("pasta");
        bag2.add("apples");
        
        intersection = new GroceryBag();
        intersection.add("apples");
        intersection.add("pasta");
        
        equalsBag2 = new GroceryBag();
        equalsBag2.add("pizza");
        equalsBag2.add("broccoli");
        equalsBag2.add("pasta");
        equalsBag2.add("pasta");
        equalsBag2.add("apples");

        bag3 = new GroceryBag();
        bag3.add("apples");
        bag3.add("chicken");
        bag3.add("chicken");
        bag3.add("pasta");
        bag3.add("pizza");
        bag3.add("soda");
        bag3.add("yogurt");
        bag3.add("wheat");
        
        equalsBag3 = new GroceryBag();
        equalsBag3.add("apples");
        equalsBag3.add("chicken");
        equalsBag3.add("chicken");
        equalsBag3.add("pasta");
        equalsBag3.add("pizza");
        equalsBag3.add("soda");
        equalsBag3.add("yogurt");
        equalsBag3.add("wheat");

        bag4 = new GroceryBag();
        bag4.add("chicken");
        bag4.add("chicken");
        bag4.add("pasta");
        bag4.add("pasta");
        bag4.add("yogurt");
        
        equalsBag4 = new GroceryBag();
        equalsBag4.add("chicken");
        equalsBag4.add("chicken");
        equalsBag4.add("pasta");
        equalsBag4.add("pasta");
        equalsBag4.add("yogurt");
        
        equalsBag1 = new GroceryBag();
        equalsBag1.add("pasta");
        equalsBag1.add("apples");
        equalsBag1.add("chips");
        equalsBag1.add("yogurt");
        equalsBag1.add("chicken");
        
    } //End setUp()
    
    /**
     * Tests the intersection() method
     */
    public void testIntersection()
    {
        setUp();
        
        assertTrue(bag1.equals(bag1.intersection(bag1)));
        assertTrue(intersection.equals(bag1.intersection(bag2)));
        assertFalse(intersection.equals(bag3.intersection(bag4)));
    }
    
    /**
     * Tests the equals() method
     */
    public void testEquals()
    {
        setUp();
        GroceryBag nullBag = null;
        assertTrue(bag1.equals(bag1));
        assertFalse(bag1.equals(nullBag));
        assertFalse(bag1.equals(new Object()));
        assertFalse(bag1.equals(bag3));
        assertFalse(bag1.equals(notEqualsBag1));
        assertTrue(bag1.equals(equalsBag1));
        assertTrue(bag2.equals(equalsBag2));
        assertTrue(bag3.equals(equalsBag3));
        assertTrue(bag4.equals(equalsBag4));
    }
} //End class
