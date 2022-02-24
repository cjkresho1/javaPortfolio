/**
 * 
 */
package collercoaster;

import student.TestCase;

/**
 * @author Charles Kresho
 * @verson 2016.4.7
 */
public class PersonTest extends TestCase 
{
    private Person short1;
    private Person short2;
    private Person short3;
    private Person short4;
    private Person short5;
    private Person tall1;
    private Person tall2;
    private Person tall3;
    private Person tall4;
    private Person tall5;
    private Person short1Copy;
    private Person tall1Copy;
    private Person nullPerson;
    
    /**
     * Sets up the variables for tests
     */
    public void setUp()
    {
        short1 = new Person("1", 10);
        short1Copy = new Person("1", 10);
        short2 = new Person("2", 20);
        short3 = new Person("3", 30);
        short4 = new Person("4", 40);
        short5 = new Person("5", 50);
        tall1 = new Person("1", 110);
        tall1Copy = new Person("1", 110);
        tall2 = new Person("2", 120);
        tall3 = new Person("3", 130);
        tall4 = new Person("4", 140);
        tall5 = new Person("5", 150);
        nullPerson = null;
    }
    
    /**
     * Tests getName()
     */
    public void testGetName()
    {
        setUp();
        assertEquals("1", short1.getName());
        assertEquals("1", short1Copy.getName());
        assertEquals("2", short2.getName());
        assertEquals("3", short3.getName());
        assertEquals("4", short4.getName());
        assertEquals("5", short5.getName());
        assertEquals("1", tall1.getName());
        assertEquals("1", tall1Copy.getName());
        assertEquals("2", tall2.getName());
        assertEquals("3", tall3.getName());
        assertEquals("4", tall4.getName());
        assertEquals("5", tall5.getName());
    }
    /**
     * Test getHeight()
     */
    public void testGetHeight()
    {
        setUp();
        assertEquals(10, short1.getHeight());
        assertEquals(10, short1Copy.getHeight());
        assertEquals(20, short2.getHeight());
        assertEquals(30, short3.getHeight());
        assertEquals(40, short4.getHeight());
        assertEquals(50, short5.getHeight());
        assertEquals(110, tall1.getHeight());
        assertEquals(110, tall1Copy.getHeight());
        assertEquals(120, tall2.getHeight());
        assertEquals(130, tall3.getHeight());
        assertEquals(140, tall4.getHeight());
        assertEquals(150, tall5.getHeight());
    }
    
    /**
     * Test toString()
     */
    public void testToString()
    {
        assertEquals("1 10cm", short1.toString());
        assertEquals("1 10cm", short1Copy.toString());
        assertEquals("2 20cm", short2.toString());
        assertEquals("3 30cm", short3.toString());
        assertEquals("4 40cm", short4.toString());
        assertEquals("5 50cm", short5.toString());
        assertEquals("1 110cm", tall1.toString());
        assertEquals("1 110cm", tall1Copy.toString());
        assertEquals("2 120cm", tall2.toString());
        assertEquals("3 130cm", tall3.toString());
        assertEquals("4 140cm", tall4.toString());
        assertEquals("5 150cm", tall5.toString());
    }
    
    /**
     * Tests equals()
     */
    public void testEquals()
    {
        assertFalse(short1.equals(nullPerson));
        assertFalse(short1.equals(new Object()));
        assertTrue(short1.equals(short1));
        assertTrue(short1.equals(short1Copy));
        assertFalse(short1.equals(short2));
        assertFalse(short1.equals(tall1));
    }
}
