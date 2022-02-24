import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Charles Kresho
 * @version 2020.10.02
 */
public class PlaylistManager
{
    private static Scanner scan;
    private static DoubleList<Song> list;
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        //Create the initial system values, then enter the IO loop
        scan = new Scanner(System.in);
        list = new DoubleList<Song>();
        IOLoop();
        scan.close();
    }
    
    private static void IOLoop()
    {
        boolean run = true;
        String cmd;
        String cmdArray[];
        System.out.println("*** Playlist Manager ***");
        System.out.print("Commands:\n"
                + "add - add a new song to the playlist\n"
                + "remove - remove a song from the playlist\n"
                + "count - display how many songs are in the playlist\n"
                + "play - print the playlist in order\n"
                + "shuffle - randomize the playlist order\n"
                + "reverse - reverse the order of the playlist\n"
                + "save - save the playlist to a file\n"
                + "load - load the playlist from a file\n"
                + "quit - quit the program. Does not save data\n\n");
        while (run)
        {
            System.out.print(":");
            cmd = scan.nextLine();
            cmdArray = cmd.split(" ");
            if (cmdArray.length != 1)
            {
                System.out.println("Invalid command!\n");
            }
            else
            {
                cmdArray[0] = cmdArray[0].toLowerCase();
                switch(cmdArray[0])
                {
                case "add":
                    add();
                    break;
                case "remove":
                    remove();
                    break;
                case "count":
                    count();
                    break;
                case "play":
                    play();
                    break;
                case "shuffle":
                    shuffle();
                    break;
                case "reverse":
                    reverse();
                    break;
                case "save":
                    save();
                    break;
                case "load":
                    load();
                    break;
                case "quit":
                    run = false;
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
                }
            }
            
            System.out.print("\n");
        }
    }
    
    /**
     * Add a new song with a title and artist to the list.
     */
    private static void add()
    {
        System.out.print("Enter Artist: ");
        String artist = scan.nextLine();
        System.out.print("Enter Title: ");
        String title = scan.nextLine();
        
        Song song = new Song(artist, title);
        list.addEnd(song);
    }
    
    /**
     * Remove a song from the list with the matching artist and title. Print out how many were removed.
     */
    private static void remove()
    {
        System.out.print("Enter Artist: ");
        String artist = scan.nextLine();
        System.out.print("Enter Title: ");
        String title = scan.nextLine();
        
        Song song = new Song(artist, title);
        int removed = list.remove(song);
        System.out.println("" + removed + " instances of this song were removed from the playlist.");
    }
    
    /**
     * Print out how many songs are in the playlist.
     */
    private static void count() 
    {
        int size = list.getSize();
        System.out.println(size);
    }
    
    /**
     * List the songs in the playlist.
     */
    private static void play()
    {
        list.print();
    }
    
    /**
     * Randomize the songs in the list.
     */
    private static void shuffle()
    {
        list.shuffle();
    }
    
    /**
     * Reverse the song order in the playlist.
     */
    private static void reverse()
    {
        list.reverse();
    }
    
    /**
     * Attempt to save the songs in the playlist to a given file.
     */
    private static void save()
    {
        System.out.print("Enter a filename: ");
        String filename = scan.nextLine();
        
        File file = new File(filename);
        if (file.exists())
        {
            file.delete();
        }
        try
        {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            Song cur = null;
            for (int i = 0; i < list.getSize(); i++)
            {
                cur = list.getData(i);
                writer.write("" + cur.getArtist() + "," + cur.getTitle() + "\n");
            }
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("There was an issue creating or writing to the save file!");
        }
    }
    
    /**
     * Attempt to load a list of songs from a given list, and append them to the end of the existing list.
     */
    private static void load()
    {
        System.out.print("Enter a filename: ");
        String filename = scan.nextLine();
        
        File file = new File(filename);
        if (!file.exists())
        {
            System.out.println("That file doesn't exist.");
            return;
        }
        try
        {
            Scanner fileScan = new Scanner(file);
            while(fileScan.hasNextLine())
            {
                String songString = fileScan.nextLine();
                String[] songArray = songString.split(",");
                if (songArray.length != 2)
                {
                    fileScan.close();
                    throw new IOException();
                }
                list.addEnd(new Song(songArray[0], songArray[1]));
            }
            
            fileScan.close();
        }
        catch (IOException e)
        {
            System.out.println("There was an issue reading from the save file!");
        }
    }
}
