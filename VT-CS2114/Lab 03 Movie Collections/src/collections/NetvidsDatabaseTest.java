/**
 * 
 */
package collections;

import java.util.NoSuchElementException;

/**
 * @author Charles Kresho (cjkresho)
 * @version 2016.2.5
 */
public class NetvidsDatabaseTest extends student.TestCase
{
    
    private NetvidsDatabase netvids;
    private Movie movie;
    
    /**
     * Sets up the fields for the test methods
     */
    public void setUp()
    {
        netvids =  new NetvidsDatabase();
        movie = new Movie("Spiderman");
    }
    
    /**
     * Tests the method addMovie(Movie a Movie)
     */
    public void testAddMovie()
    {
        setUp();
        assertEquals(netvids.size(), 0);
        assertTrue(netvids.addMovie(movie));
        assertEquals(netvids.size(), 1);
        assertFalse(netvids.addMovie(movie));
    }
    
    /**
     * Tests the method remove(Movie movie) when the movie is a movie
     */
    public void testRemove()
    {
        setUp();
        netvids.addMovie(movie);
        assertEquals(netvids.size(), 1);
        assertTrue(netvids.remove(movie).equals(movie));
        assertEquals(netvids.size(), 0);
        assertFalse(netvids.contains(movie));
    }
    
    /**
     * Tests the method remove(Movie movie) when the movie is null
     */
    public void testRemoveNull()
    {
        setUp();
        Movie nullMovie = null;
        
        Exception exception = null;
        
        try
        {
            netvids.remove(nullMovie);
        }
        catch (IllegalArgumentException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }
    
    /**
     * Tests the remove(Movie movie) method when the movie isn't present
     */
    public void testRemoveNo()
    {
        setUp();
        Movie notPresent = new Movie("Superman");
        
        netvids.addMovie(movie);
        
        Exception exception = null;
        
        try
        {
            netvids.remove(notPresent);
        }
        catch (NoSuchElementException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }
    
    /**
     * Tests the contains(Movie movie) method
     */
    public void testContains()
    {
        setUp();
        assertFalse(netvids.contains(movie));
        netvids.addMovie(movie);
        assertTrue(netvids.contains(movie));
    }
    
    /**
     * Tests the isEmpty() method
     */
    public void testIsEmpty()
    {
        setUp();
        assertTrue(netvids.isEmpty());
        netvids.addMovie(movie);
        assertFalse(netvids.isEmpty());
    }
    
    /**
     * Tests the size() method
     */
    public void testSize()
    {
        setUp();
        assertEquals(netvids.size(), 0);
        netvids.addMovie(movie);
        assertEquals(netvids.size(), 1);
    }
    
    /**
     * Tests the capacity() method
     */
    public void testCapacity()
    {
        setUp();
        assertEquals(netvids.capacity(), 10);
    }
    
    /**
     * Tests the extendCapacity() method
     */
    public void testExpandCapacity()
    {
        setUp();
        assertEquals(netvids.capacity(), 10);
        for (int i = 0; i < netvids.capacity(); i++)
        {
            netvids.addMovie(new Movie("" + i));
        }
        assertEquals(netvids.capacity(), netvids.size());
        netvids.addMovie(movie);
        assertEquals(netvids.capacity(), 20);
    }
}
