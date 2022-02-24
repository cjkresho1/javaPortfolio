/**
 * 
 */
package collections;

/**
 * @author Charles Kresho (cjkresho)
 * @version 2016.2.5
 */
public class MovieTest extends student.TestCase {
    
    private Movie movie;
    
    /**
     * Sets up the fields for the tests
     */
    public void setUp()
    {
        movie = new Movie("Spiderman");
    }
    
    /**
     * Tests the getTitle() method
     */
    public void testGetTitle()
    {
        setUp();
        assertTrue(movie.getTitle().equals("Spiderman"));
        assertFalse(movie.getTitle().equals("Superman"));
    }
    
    /**
     * Tests the getGenre() method and the setGenre(String genre) method
     */
    public void testGenre()
    {
        setUp();
        movie.setGenre("Super Heroes");
        assertTrue(movie.getGenre().equals("Super Heroes"));
    }
    
    /**
     * Tests the getRating() and the setRating(int rating) methods
     */
    public void testRating()
    {
        setUp();
        movie.setRating(100);
        assertEquals(movie.getRating(), 100);
    }
    
    /**
     * Tests the getYear() and the setYear(int year) methods
     */
    public void testYear()
    {
        setUp();
        movie.setYear(100);
        assertEquals(movie.getYear(), 100);
    }
    
    /**
     * Tests the equals(Object other) method
     */
    public void testEquals()
    {
        setUp();
        Movie nullMovie = null;
        Movie sameMovie = new Movie("Spiderman");
        Movie otherMovie = new Movie("Superman");
        Object notMovie = new Object();
        
        assertTrue(movie.equals(movie));
        assertTrue(movie.equals(sameMovie));
        assertFalse(movie.equals(nullMovie));
        assertFalse(movie.equals(otherMovie));
        assertFalse(movie.equals(notMovie));
    }
}
