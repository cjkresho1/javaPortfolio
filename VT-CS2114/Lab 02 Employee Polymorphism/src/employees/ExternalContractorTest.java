/**
 * 
 */
package employees;

/**
 * 
 * @author Charles Kresho
 * @version 2016.1.29
 */
public class ExternalContractorTest extends student.TestCase
{
    private ExternalContractor employee1;
    /**
     * Sets up the employees for testing
     */
    public void setUp()
    {
        employee1 = new ExternalContractor("Bob", 10);
    }
    
    /**
     * tests the method getHourlyRate()
     */
    public void testHourlyRate()
    {
        setUp();
        assertEquals(38.5, employee1.getHourlyRate(1), .1);
        assertEquals(41.75, employee1.getHourlyRate(2), .1);
        assertEquals(45.5, employee1.getHourlyRate(3), .1);
    }
    
    /**
     * tests the method weeklyPay()
     */
    public void testWeeklyPay()
    {
        setUp();
        assertEquals(0, employee1.weeklyPay(0, 1), .1);
        assertEquals(41.75 * 10, employee1.weeklyPay(10, 2), .1);
        assertEquals(45.5 * 15, employee1.weeklyPay(15, 3), .1);
    }
}
