package prj5;

/**
 * 
 *
 * @author Cody Hornberger (cjh2259)
 *         Charles Kresho (cjkresho)
 *         Josh Fowler (chrls93)
 * @version 2016.04.10
 */
public class Input {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        if (args.length == 2) {
            ListReader reader = new ListReader(args[0], args[1]);
        }
        else {

            ListReader reader = new ListReader(
                "MusicSurveyDataTest1.csv", "SongListTest1.csv");
        }
    }
}