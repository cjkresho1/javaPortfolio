/**
 * 
 */
package collercoaster;

import student.TestCase;

/**
 * @author Charles Kresho
 * @verson 2016.4.7
 */
public class ComparePersonHeightTest extends TestCase 
{
    private Person short1;
    private Person short2;
    private Person short3;
    private Person tall1;
    private Person short1Copy;
    private ComparePersonHeight compare;
    
    /**
     * Sets up the variables for tests
     */
    public void setUp()
    {
        short1 = new Person("Alberta", 10);
        short1Copy = new Person("Alberta", 10);
        short2 = new Person("b", 20);
        short3 = new Person("Charlie", 10);
        new Person("d", 40);
        new Person("e", 50);
        tall1 = new Person("a", 110);
        new Person("a", 110);
        new Person("b", 120);
        new Person("c", 130);
        new Person("d", 140);
        new Person("e", 150);
        compare = new ComparePersonHeight();
    }
    
    /**
     * Tests compare
     */
    public void testCompare()
    {
        assertEquals(0, compare.compare(short1, short1Copy));
        assertEquals(-10, compare.compare(short1, short2));
        assertEquals(-100, compare.compare(short1, tall1));
        assertEquals(10, compare.compare(short2, short1));
        assertEquals(100, compare.compare(tall1, short1));
        assertEquals(2, compare.compare(short1, short3));
        assertEquals(-2, compare.compare(short3, short1));
    }
}
