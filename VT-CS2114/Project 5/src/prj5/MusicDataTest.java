/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * @author Charles Kresho
 * @version 2016.4.15
 */
public class MusicDataTest extends TestCase 
{
    private MusicData data;
    private MusicData other;
    
    /**
     * Sets up the variables for tests
     */
    public void setUp()
    {
        data = new MusicData("Charlie", "My Song", "Country", "Now");
        other = new MusicData("Charlie", "Alphabet", "Ahhh", "After");
    }
    
    /**
     * Tests getArtist()
     */
    public void testGetSong()
    {
        setUp();
        assertEquals("My Song", data.getSong());
    }
    
    /**
     * Tests setArtist(String)
     */
    public void testSetSong()
    {
        setUp();
        assertEquals("My Song", data.getSong());
        data.setSong("Not Charlie");
        assertEquals("Not Charlie", data.getSong());
    }
    
    /**
     * Tests getArtist()
     */
    public void testGetGenre()
    {
        setUp();
        assertEquals("Country", data.getGenre());
    }
    
    /**
     * Tests setArtist(String)
     */
    public void testSetGenre()
    {
        setUp();
        assertEquals("Country", data.getGenre());
        data.setGenre("Not Charlie");
        assertEquals("Not Charlie", data.getGenre());
    }
    
    /**
     * Tests getArtist()
     */
    public void testGetDate()
    {
        setUp();
        assertEquals("Now", data.getDate());
    }
    
    /**
     * Tests setArtist(String)
     */
    public void testSetDate()
    {
        setUp();
        assertEquals("Now", data.getDate());
        data.setDate("Not Charlie");
        assertEquals("Not Charlie", data.getDate());
    }
    
    /**
     * Tests getArtist()
     */
    public void testGetArtist()
    {
        setUp();
        assertEquals("Charlie", data.getArtist());
    }
    
    /**
     * Tests setArtist(String)
     */
    public void testSetArtist()
    {
        setUp();
        assertEquals("Charlie", data.getArtist());
        data.setArtist("Not Charlie");
        assertEquals("Not Charlie", data.getArtist());
    }
    
    /**
     * Tests getHaveHeard()
     */
    public void getHaveHeard() 
    {
        setUp();
        assertEquals(0, data.getHaveHeard());
    }

    /**
     * Tests addHeard()
     */
    public void testAddHeard() 
    {
        setUp();
        assertEquals(0, data.getHaveHeard());
        assertEquals(0, data.getTotalPeopleHeard());
        data.addHeard();
        assertEquals(1, data.getHaveHeard());
        assertEquals(1, data.getTotalPeopleHeard());
    }
    
    /**
     * Tests addHasntHeard
     */
    public void testAddHasntHeard() 
    {
        setUp();
        assertEquals(0, data.getHaveHeard());
        assertEquals(0, data.getTotalPeopleHeard());
        data.addHasntHeard();
        assertEquals(0, data.getHaveHeard());
        assertEquals(1, data.getTotalPeopleHeard());
    }

    /**
     * Tests getDoLike()
     */
    public void testGetDoLike() 
    {
        setUp();
        assertEquals(0, data.getDoLike());
    }

    /**
     * Tests addDoLike()
     */
    public void testAddDoLike() 
    {
        setUp();
        assertEquals(0, data.getDoLike());
        assertEquals(0, data.getTotalPeopleLiked());
        data.addDoLike();
        assertEquals(1, data.getDoLike());
        assertEquals(1, data.getTotalPeopleLiked());
    }
    
    /**
     * Tests addDoesntLike()
     */
    public void testAddDoesntLike() 
    {
        setUp();
        assertEquals(0, data.getDoLike());
        assertEquals(0, data.getTotalPeopleLiked());
        data.addDoesntLike();
        assertEquals(0, data.getDoLike());
        assertEquals(1, data.getTotalPeopleLiked());
    }

    /**
     * Tests getTotalPeopleHeard()
     */
    public void testGetTotalPeopleHeard() 
    {
        setUp();
        assertEquals(0, data.getHaveHeard());
        assertEquals(0, data.getTotalPeopleHeard());
        data.addHeard();
        assertEquals(1, data.getHaveHeard());
        assertEquals(1, data.getTotalPeopleHeard());
    }
    
    /**
     * Tests getTotalPeopleLiked()
     */
    public void testGetTotalPeopleLiked() 
    {
        setUp();
        assertEquals(0, data.getDoLike());
        assertEquals(0, data.getTotalPeopleLiked());
        data.addDoLike();
        assertEquals(1, data.getDoLike());
        assertEquals(1, data.getTotalPeopleLiked());
    }
    
    /**
     * Tests toString()
     */
    public void testToString()
    {
        setUp();
        assertEquals("My Song, Charlie, Country, Now", data.toString());
    }
    
    /**
     * Tests compareTo(MusicData)
     */
    public void testCompareTo()
    {
        setUp();
        other.setSong("Alpha");
        assertTrue(data.compareTo(other) > 0);
        other.setSong("Zach");
        assertTrue(data.compareTo(other) < 0);
        
        other.setSong("My Song");
        other.setArtist("Alpha");
        assertTrue(data.compareTo(other) > 0);
        other.setArtist("Zach");
        assertTrue(data.compareTo(other) < 0);
        
        other.setArtist("Charlie");
        other.setDate("Alpha");
        assertTrue(data.compareTo(other) > 0);
        other.setDate("Zach");
        assertTrue(data.compareTo(other) < 0);
        
        other.setDate("Now");
        other.setGenre("Alpha");
        assertTrue(data.compareTo(other) > 0);
        other.setGenre("Zach");
        assertTrue(data.compareTo(other) < 0);
        
        other.setGenre("Country");
        assertEquals(0, data.compareTo(other));
    }
    
    /**
     * Tests compareToArtist(MusicData)
     */
    public void testCompareToArtist()
    {
        setUp();
        other.setArtist("Alpha");
        assertTrue(data.compareToArtist(other) > 0);
        other.setArtist("Zach");
        assertTrue(data.compareToArtist(other) < 0);
        
        other.setArtist("Charlie");
        other.setSong("Alpha");
        assertTrue(data.compareToArtist(other) > 0);
        other.setSong("Zach");
        assertTrue(data.compareToArtist(other) < 0);
        
        other.setSong("My Song");
        other.setDate("Alpha");
        assertTrue(data.compareToArtist(other) > 0);
        other.setDate("Zach");
        assertTrue(data.compareToArtist(other) < 0);
        
        other.setDate("Now");
        other.setGenre("Alpha");
        assertTrue(data.compareToArtist(other) > 0);
        other.setGenre("Zach");
        assertTrue(data.compareToArtist(other) < 0);
        
        other.setGenre("Country");
        assertEquals(0, data.compareToArtist(other));
    }
    
    /**
     * Tests compareToGenre(MusicData)
     */
    public void testCompareToGenre()
    {
        setUp();
        other.setGenre("Alpha");
        assertTrue(data.compareToGenre(other) > 0);
        other.setGenre("Zach");
        assertTrue(data.compareToGenre(other) < 0);
        
        other.setGenre("Country");
        other.setSong("Alpha");
        assertTrue(data.compareToGenre(other) > 0);
        other.setSong("Zach");
        assertTrue(data.compareToGenre(other) < 0);
        
        other.setSong("My Song");
        other.setDate("Alpha");
        assertTrue(data.compareToGenre(other) > 0);
        other.setDate("Zach");
        assertTrue(data.compareToGenre(other) < 0);
        
        other.setDate("Now");
        other.setArtist("Alpha");
        assertTrue(data.compareToGenre(other) > 0);
        other.setArtist("Zach");
        assertTrue(data.compareToGenre(other) < 0);
        
        other.setArtist("Charlie");
        assertEquals(0, data.compareToGenre(other));
    }
    
    /**
     * Tests compareToDate(MusicData)
     */
    public void testcompareToDate()
    {
        setUp();
        other.setDate("Alpha");
        assertTrue(data.compareToDate(other) > 0);
        other.setDate("Zach");
        assertTrue(data.compareToDate(other) < 0);
        
        other.setDate("Now");
        other.setSong("Alpha");
        assertTrue(data.compareToDate(other) > 0);
        other.setSong("Zach");
        assertTrue(data.compareToDate(other) < 0);
        
        other.setSong("My Song");
        other.setGenre("Alpha");
        assertTrue(data.compareToDate(other) > 0);
        other.setGenre("Zach");
        assertTrue(data.compareToDate(other) < 0);
        
        other.setGenre("Country");
        other.setArtist("Alpha");
        assertTrue(data.compareToDate(other) > 0);
        other.setArtist("Zach");
        assertTrue(data.compareToDate(other) < 0);
        
        other.setArtist("Charlie");
        assertEquals(0, data.compareToDate(other));
    }
}
