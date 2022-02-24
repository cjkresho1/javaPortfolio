/**
 * 
 */
package recursion;

import student.TestCase;

/**
 * @author Charles Kresho
 * @version 2016.3.4
 */
public class ReverseStringGeneratorTest extends TestCase 
{
    private ReverseStringGenerator generator;
    
    /**
     * Sets up the fields for the tests
     */
    public void setUp()
    {
        generator = new ReverseStringGenerator();
    }
    
    /**
     * Tests the method reverse
     */
    public void testReverse()
    {
        setUp();
        generator = new ReverseStringGenerator();
        assertNotNull(generator);
        assertEquals(ReverseStringGenerator.reverse("potato"), "otatop");
        assertEquals(ReverseStringGenerator.reverse("ThIsIs WeIrd 12345"), 
                "54321 drIeW sIsIhT");
    }
}
