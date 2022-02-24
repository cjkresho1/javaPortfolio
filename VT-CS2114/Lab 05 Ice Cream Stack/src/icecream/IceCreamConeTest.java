/**
 * 
 */
package icecream;

/**
 * @author Charles Kresho
 * @version 2016.2.19
 *
 */
public class IceCreamConeTest extends student.TestCase
{
    private IceCreamCone cone1;
    private IceCreamCone cone2;
    private IceCreamCone cone3;
    private IceCreamCone cone4;
    private IceCreamCone nullCone = null;
    private IceCreamCone emptyCone;
    
    /**
     * Sets up the objects for the tester methods
     */
    public void setUp()
    {
        cone1 = new IceCreamCone();
        cone1.addScoop("Vanilla");
        cone1.addScoop("Strawberry");
        cone1.addScoop("Chocolate");
        cone1.addScoop("Fruit");
        
        cone2 = new IceCreamCone();
        cone2.addScoop("Chocolate");
        
        cone3 = new IceCreamCone();
        cone3.addScoop("Vanilla");
        cone3.addScoop("Strawberry");
        cone3.addScoop("Chocolate");
        cone3.addScoop("Fruit");
        
        cone4 = new IceCreamCone();
        cone4.addScoop("Vanilla");
        cone4.addScoop("Strawberry");
        cone4.addScoop("Fruit");
        cone4.addScoop("Chocolate");
        
        
        emptyCone = new IceCreamCone();
    }
    
    /**
     * Tests the eatScoop() method
     */
    public void testEatScoop()
    {
        setUp();
        assertEquals(cone1.numScoops(), 4);
        assertTrue(cone1.eatScoop().equals("Fruit"));
        assertEquals(cone1.numScoops(), 3);
    }
    
    /**
     * Tests the addScoop() method
     */
    public void testAddScoop()
    {
        setUp();
        assertEquals(cone1.numScoops(), 4);
        cone1.addScoop("Yummy");
        assertEquals(cone1.numScoops(), 5);
        cone1.addScoop(null);
    }
    
    /**
     * Tests the numScoops() method
     */
    public void testNumScoops()
    {
        setUp();
        assertEquals(cone1.numScoops(), 4);
    }
    
    /**
     * Tests the contains() method
     */
    public void testContains()
    {
        setUp();
        assertFalse(cone1.contains("Yummy"));
        assertTrue(cone1.contains("Chocolate"));
        assertFalse(cone1.contains(null));
    }
    
    /**
     * Tests the emptyCone() method
     */
    public void testEmptyCone()
    {
        setUp();
        assertFalse(cone1.emptyCone());
        assertTrue(emptyCone.emptyCone());
        cone2.eatScoop();
        cone2.eatScoop();
        assertTrue(cone2.emptyCone());
    }
    
    /**
     * Tests the currentScoop() method
     */
    public void testCurrentScoop()
    {
        setUp();
        assertEquals(cone1.currentScoop(), "Fruit");
        assertNull(emptyCone.currentScoop());
    }
    
    /**
     * Tests the equals() method
     */
    public void testEquals()
    {
        setUp();
        assertTrue(cone1.equals(cone1));
        assertFalse(cone1.equals(nullCone));
        assertFalse(cone1.equals(new Object()));
        assertFalse(cone1.equals(cone2));
        assertTrue(cone1.equals(cone3));
        assertFalse(cone1.equals(cone4));
    }
    
    /**
     * Tests the toString() method
     */
    public void testToString()
    {
        assertEquals(cone2.toString(), "[Chocolate]");
        assertEquals(cone1.toString(), "[Vanilla, Strawberry, Chocolate, "
                + "Fruit]");
    }
}
