/**
 * 
 */
package employees;

/**
 * @author Charles Kresho
 * @version 2016.1.29
 */
public class PartTimeEmployeeTest extends student.TestCase
{
    private PartTimeEmployee employee6;
    private PartTimeEmployee employee7;
    private PartTimeEmployee employee8;
    
    /**
     * Sets up the employees to be tested
     */
    public void setUp()
    {
        employee6 = new PartTimeEmployee("Bob", 2.0, 17);
        employee7 = new PartTimeEmployee("Joe", 15.5, 10);
        employee8 = new PartTimeEmployee("Bob", 94, 39);
    }
    /**
     * tests the method getHoursWorked()
     */
    public void testHoursWorked()
    {
        setUp();
        assertEquals(17, employee6.getHoursWorked(), .1);
        assertEquals(10, employee7.getHoursWorked(), .1);
        assertEquals(39, employee8.getHoursWorked(), .1);
    }
    
    /**
     * Tests the method weeklyPay()
     */
    public void testWeeklyPay()
    {
        setUp();
        assertEquals((2 * 17), employee6.weeklyPay(), .1);
        assertEquals((15.5 * 10), employee7.weeklyPay(), .1);
        assertEquals((94 * 39), employee8.weeklyPay(), .1);
    }
}
