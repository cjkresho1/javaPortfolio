package binarySearch;
//-------------------------------------------------------------------------
/**
 * Represents one event in a historical timeline.
 *
 * @author  Stephen Edwards
 * @author maellis1
 * @version 11-10-2015
 */
public class HistoricEvent implements Comparable<HistoricEvent>
{
    //~ Instance/static variables .............................................

    private int year;
    private String title;
    private String description;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Create a new HistoricEvent without a description.
     * @precondition title cannot be null
     * @param year The year the event occurred (A.D.)
     * @param title The title of the event
     */
    public HistoricEvent(int year, String title)
    {
        this(year, title, null);
    }


    // ----------------------------------------------------------
    /**
     * Create a new HistoricEvent.
     * @param year The year the event occurred (A.D.)
     * @param title The title of the event
     * @param description The description for the event
     */
    public HistoricEvent(int year, String title, String description)
    {
        this.year = year;
        if (title == null)
        {
            this.title = "No Title";
        } 
        else
        {
            this.title = title;
        }
        this.description = description;
    }


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Get this event's year.
     * @return This event's year.
     */
    public int getYear()
    {
        return year;
    }


    // ----------------------------------------------------------
    /**
     * Get this event's title.
     * @return This event's title, which may be null.
     */
    public String getTitle()
    {
        return title;
    }


    // ----------------------------------------------------------
    /**
     * Get this event's description.
     * @return This event's description, which may be null.
     */
    public String getDescription()
    {
        return description;
    }


    // ----------------------------------------------------------
    /**
     * Generate a human-readable representation of this event.
     * @return This event in string form.
     */
    public String toString()
    {
        // When concatenating many strings to produce a result, it is more
        // efficient to use a string builder, rather than using '+' on strings.
        StringBuilder result = new StringBuilder();

        result.append('[');
        result.append(year);
        result.append("] ");
        result.append(title);
        if (description != null)
        {
            result.append(": ");
            result.append(description);
        }
        return result.toString();
    }
    
    /**
     * 
     * @param other - other HistoricEvent to be compared
     * @return an int < 0 if this came before other
     *         an int > 0 if other came before this
     *         an int = 0 if these are the same event
     */
    @Override
    public int compareTo(HistoricEvent other) 
    {
        if (this.year - other.year != 0)
        {
            return this.year - other.year;
        }
        return this.title.compareTo(other.title);
    }
}
    
    
    

