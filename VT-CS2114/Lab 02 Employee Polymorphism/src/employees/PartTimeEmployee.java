/**
 * 
 */
package employees;

/**
 * @author Charles Kresho
 * @version 2016.1.29
 */
public class PartTimeEmployee extends Employee {
    private int hours;
    
    /**
     * Creates a PartTimeEmployee using the Employee constructor
     * @param name - name of the employee
     * @param pay - pay rate of the employee
     * @param time - time worked by the employee
     */
    public PartTimeEmployee(String name, double pay, int time)
    {
        super(name, pay);
        hours = time;
    }
    
    /**
     * Returns the hours worked by the PartTimeEmployee
     * @return hours - the hours worked
     */
    public int getHoursWorked()
    {
        return hours;
    }
    
    /**
     * Calculates the pay of the PartTimeEmployee based on the hours 
     * worked and pay rate
     * @return the pay of the PartTimeEmployee this week
     */
    public double weeklyPay()
    {
        return this.getHoursWorked() * this.getHourlyRate();
    }
}
