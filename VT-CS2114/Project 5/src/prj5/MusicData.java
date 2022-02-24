/**
 * 
 */
package prj5;

/**
 * @author Charles Kresho
 * @version 2016.4.14
 */
public class MusicData implements Comparable<MusicData>
{
    private String artist;
    private String song;
    private String genre;
    private String date;
    private int haveHeard;
    private int doLike;
    private int totalPeopleHeard;
    private int totalPeopleLiked;
    
    /**
     * This constructor initializes all fields.
     * @param artist    is the artist of the song.
     * @param song      is the title of the song.
     * @param genre     is the genre of the song.
     * @param date      is the date of the song.
     */
    public MusicData(String artist, String song, String genre, String date)
    {
        this.setArtist(artist);
        this.setSong(song);
        this.setGenre(genre);
        this.setDate(date);
        haveHeard = 0;
        doLike = 0;
        totalPeopleHeard = 0;
        totalPeopleLiked = 0;
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
     * @return the song
     */
    public String getSong() 
    {
        return song;
    }

    /**
     * @param song the song to set
     */
    public void setSong(String song) 
    {
        this.song = song;
    }

    /**
     * @return the genre
     */
    public String getGenre() 
    {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) 
    {
        this.genre = genre;
    }

    /**
     * @return the date
     */
    public String getDate() 
    {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) 
    {
        this.date = date;
    }

    /**
     * @return the haveHeard
     */
    public int getHaveHeard() 
    {
        return haveHeard;
    }

    /**
     * haveHeard the haveHeard to set
     */
    public void addHeard() 
    {
        haveHeard++;
        totalPeopleHeard++;
    }
    
    /**
     * Adds to how many people have heard.
     */
    public void addHasntHeard() 
    {
        totalPeopleHeard++;
    }

    /**
     * @return the doLike
     */
    public int getDoLike() 
    {
        return doLike;
    }

    /**
     * doLike the doLike to set
     */
    public void addDoLike() 
    {
        doLike++;
        totalPeopleLiked++;
    }
    
    /**
     * Adds to the number of people
     */
    public void addDoesntLike() 
    {
        totalPeopleLiked++;
    }

    /**
     * @return the totalPeople
     */
    public int getTotalPeopleHeard() 
    {
        return totalPeopleHeard;
    }
    
    /**
     * @return the totalPeople
     */
    public int getTotalPeopleLiked() 
    {
        return totalPeopleLiked;
    }

    /**
     * Returns 0 if the objects are the same, negative if the first
     * object comes earlier, and positive if the object comes later.
     * @param o is a MusicData to be compared
     * @return  0, positive, or negative
     */
    @Override
    public int compareTo(MusicData o) {
        if (this.getSong().equals(o.getSong())) {
            if (this.getArtist().equals(o.getArtist())) {
                if (this.getDate().equals(o.getDate())) {
                    if (this.getGenre().equals(o.getGenre())) {
                        return 0;
                    }
                    else {
                        return this.getGenre().compareTo(o.getGenre());
                    }
                }
                else {
                    return this.getDate().compareTo(o.getDate());
                }
            }
            else {
                return this.getArtist().compareTo(o.getArtist());
            }
        }
        else {
            return this.getSong().compareTo(o.getSong());
        }
    }

    /**
     * Returns 0 if the objects are the same, negative if the first
     * object comes earlier, and positive if the object comes later.
     * @param o is a MusicData to be compared
     * @return  0, positive, or negative
     */
    public int compareToArtist(MusicData o) {
        if (this.getArtist().equals(o.getArtist())) {
            if (this.getSong().equals(o.getSong())) {
                if (this.getDate().equals(o.getDate())) {
                    if (this.getGenre().equals(o.getGenre())) {
                        return 0;
                    }
                    else {
                        return this.getGenre().compareTo(o.getGenre());
                    }
                }
                else {
                    return this.getDate().compareTo(o.getDate());
                }
            }
            else {
                return this.getSong().compareTo(o.getSong());
            }
        }
        else {
            return this.getArtist().compareTo(o.getArtist());
        }
    }
    
    /**
     * Returns 0 if the objects are the same, negative if the first
     * object comes earlier, and positive if the object comes later.
     * @param o is a MusicData to be compared
     * @return  0, positive, or negative
     */
    public int compareToGenre(MusicData o) {
        if (this.getGenre().equals(o.getGenre())) {
            if (this.getSong().equals(o.getSong())) {
                if (this.getDate().equals(o.getDate())) {
                    if (this.getArtist().equals(o.getArtist())) {
                        return 0;
                    }
                    else {
                        return this.getArtist().compareTo(o.getArtist());
                    }
                }
                else {
                    return this.getDate().compareTo(o.getDate());
                }
            }
            else {
                return this.getSong().compareTo(o.getSong());
            }
        }
        else {
            return this.getGenre().compareTo(o.getGenre());
        }
    }
    
    /**
     * Returns 0 if the objects are the same, negative if the first
     * object comes earlier, and positive if the object comes later.
     * @param o is a MusicData to be compared
     * @return  0, positive, or negative
     */
    public int compareToDate(MusicData o) {
        if (this.getDate().equals(o.getDate())) {
            if (this.getSong().equals(o.getSong())) {
                if (this.getGenre().equals(o.getGenre())) {
                    if (this.getArtist().equals(o.getArtist())) {
                        return 0;
                    }
                    else {
                        return this.getArtist().compareTo(o.getArtist());
                    }
                }
                else {
                    return this.getGenre().compareTo(o.getGenre());
                }
            }
            else {
                return this.getSong().compareTo(o.getSong());
            }
        }
        else {
            return this.getDate().compareTo(o.getDate());
        }
    }
    
    /**
     * Prints a string representation of the data
     * @return "(Song)(Artist)(Genre)(Date)"
     */
    @Override
    public String toString()
    {
        return "" + song + ", " + artist + ", " + genre + ", " + date;
    }
}