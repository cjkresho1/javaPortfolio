
/**
 * @author Charles Kresho
 * @version 2020.10.02
 */
public class Song
{
    private String artist;
    private String title;
    
    /**
     * Create a new song object
     * @param _artist artist of the song
     * @param _title title of the song
     */
    public Song(String _artist, String _title)
    {
        artist = _artist;
        title = _title;
    }
    
    /**
     * @return the artist
     */
    public String getArtist()
    {
        return artist;
    }
    /**
     * @param artist the artist to set
     */
    public void setArtist(String artist)
    {
        this.artist = artist;
    }
    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }
    /**
     * @param title the title to set
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    
   @Override
    public String toString()
    {
        String val = artist + " - " + title;
        return val;
    }
    
   @Override
    public boolean equals(Object o)
    {
        if (o == null)
        {
            return false;
        }
        if (o == this)
        {
            return true;
        }
        if (o.getClass() != this.getClass())
        {
            return false;
        }
        Song oSong = (Song)o;
        if (oSong.getTitle().equals(title) && oSong.getArtist().equals(artist))
        {
            return true;
        }
        
        return false;
    }
}


