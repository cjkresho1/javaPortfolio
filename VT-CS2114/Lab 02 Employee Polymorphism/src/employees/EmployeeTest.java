/**
 * 
 */
package employees;

/**
 * @author Charles Kresho
 * @version 2016.1.29
 */
public class EmployeeTest extends student.TestCase
{
    
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private Employee employee4;
    private Object employee5;
    /**
     * Sets up the employees to be tested
     */
    public void setUp()
    {
        employee1 = new Employee("Bob", 2.00);
        employee2 = new Employee("Joe", 15.5);
        employee3 = new Employee("Joe", 0.0);
        employee4 = null;
        employee5 = new Object();
    }
    
    /**
     * Tests the getName() method
     */
    public void testGetName()
    {
        setUp();
        assertEquals("Bob", employee1.getName());
        assertEquals("Joe", employee2.getName());
    }
    
    /**
     * Tests the GetHourlyRate() method
     */
    public void testGetHourlyRate()
    {
        setUp();
        assertEquals(2.0, employee1.getHourlyRate(), .1);
        assertEquals(15.5, employee2.getHourlyRate(), .1);
    }
    
    /**
     * Tests the WeeklyPay() method
     */
    public void testWeeklyPay()
    {
        assertEquals(80, employee1.weeklyPay(), .1);
        assertEquals((15.5 * 40), employee2.weeklyPay(), .1);
    }
    
    /**
     * Tests the Equals() method
     */
    public void testEquals()
    {
        assertTrue(employee1.equals(employee1));
        assertFalse(employee1.equals(employee4));
        assertFalse(employee1.equals(employee2));
        assertTrue(employee2.equals(employee3));
        assertFalse(employee1.equals(employee5));
    }
    
}
