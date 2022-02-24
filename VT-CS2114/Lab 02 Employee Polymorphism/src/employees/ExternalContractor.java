package employees;

/**
 * @author Charles Kresho
 * @version 2016.1.29
 */
public class ExternalContractor extends Employee {
    
    /**
     * Creates a new ExternalContractor using the Employee constructor
     * @param name - the name of the contractor
     * @param pay - the hourly pay rate of the contractor
     */
    public ExternalContractor(String name, double pay)
    {
        super(name, pay);
    }
    
    /**
     * Returns an hourly rate for the projects of the contractor 
     * based on their rank
     * @precondition - rank must be a positive number
     * @param rank - an positive integer
     * @return double - the pay grade of the contractor based on rank
     */
    public double getHourlyRate(int rank)
    {
        if (rank == 1)
        {
            return 38.50;
        }
        else if (rank == 2)
        {
            return 41.75;
        }
        else
        {
            return 45.50;
        }
    }
    
    /**
     * The amount paid per week.
     * @precondition - rank must be positive
     * @param hours - the number of hours worked per week
     * @param rank - the customer's rank
     * @return - the amount paid for a certain week
     */
    public double weeklyPay(int hours, int rank)
    {
        return (hours * this.getHourlyRate(rank));
    }
}
