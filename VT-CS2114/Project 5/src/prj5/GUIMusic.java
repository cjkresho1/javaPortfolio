package prj5;

import java.awt.Color;
import java.util.Iterator;

import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * 
 *
 * @author Cody Hornberger (cjh2259)
 *         Charles Kresho (cjkresho)
 *         Josh Fowler (chrls93)
 * @version 2016.04.10
 */
public class GUIMusic {
    private MusicSorter sorter;
    private final int WINDOW_WIDTH = 1500;
    private final int WINDOW_HEIGHT = 800;
    private final int XSPACER = WINDOW_WIDTH / 5;
    private final int YSPACER = WINDOW_HEIGHT / 4;
    private final int WIDTH = (WINDOW_WIDTH + WINDOW_HEIGHT) / 80;
    private final int HEIGHT = 4 * WIDTH;
    private Button previous;
    private Button next;
    private Button quit;
    private Button artist;
    private Button title;
    private Button year;
    private Button genre;
    private Button hobby;
    private Button major;
    private Button region;
    private Window window;
    private String legendText;
    private String purpleText;
    private String blueText;
    private String yellowText;
    private String greenText;
    private int currentPage = 1;
    private RepresentationEnum firstEnum;
    private RepresentationEnum secondEnum;
    private RepresentationEnum thirdEnum;
    private RepresentationEnum fourthEnum;


    public GUIMusic(MusicSorter tempSorter) {
        sorter = tempSorter;
        window = new Window("cjh2259  cjkresho  chrls93");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        previous = new Button("<- Prev");
        artist = new Button("Sort by Artist Name");
        title = new Button("Sort by Song Title");
        year = new Button("Sort by Release Year");
        genre = new Button("Sort by Genre");
        next = new Button("Next ->");
        hobby = new Button("Represent Hobby");
        major = new Button("Represent Major");
        region = new Button("Represent Region");
        quit = new Button("Quit");
        window.addButton(previous, WindowSide.NORTH);
        window.addButton(artist, WindowSide.NORTH);
        window.addButton(title, WindowSide.NORTH);
        window.addButton(year, WindowSide.NORTH);
        window.addButton(genre, WindowSide.NORTH);
        window.addButton(next, WindowSide.NORTH);
        window.addButton(hobby, WindowSide.SOUTH);
        window.addButton(major, WindowSide.SOUTH);
        window.addButton(region, WindowSide.SOUTH);
        window.addButton(quit, WindowSide.SOUTH);
        previous.onClick(this, "clickedPrevious");
        artist.onClick(this, "clickedArtist");
        title.onClick(this, "clickedTitle");
        year.onClick(this, "clickedYear");
        genre.onClick(this, "clickedGenre");
        next.onClick(this, "clickedNext");
        hobby.onClick(this, "clickedHobby");
        major.onClick(this, "clickedMajor");
        region.onClick(this, "clickedRegion");
        quit.onClick(this, "clickedQuit");
        artist.disable();
        clickedHobby(hobby);
        clickedArtist(artist);
    }

    /**
     * 
     */
    public void update() {
        window.removeAllShapes();
        updateLegend();
        createGlyphs();
        if (currentPage == 1) {
            previous.disable();
        }
    }

    /**
     * 
     */
    public void updateLegend() {
        TextShape legend = new TextShape(4 * XSPACER + 8, 
                window.getGraphPanelHeight() / 2 + 8, legendText, Color.BLACK);
        TextShape purple = new TextShape(4 * XSPACER + 8, 
                window.getGraphPanelHeight() / 2 + 28, purpleText, 
                Color.MAGENTA);
        TextShape blue = new TextShape(4 * XSPACER + 8, 
                window.getGraphPanelHeight() / 2 + 48, blueText, Color.BLUE);
        TextShape yellow = new TextShape(4 * XSPACER + 8, 
                window.getGraphPanelHeight() / 2 + 68, yellowText, 
                Color.YELLOW);
        TextShape green = new TextShape(4 * XSPACER + 8, 
                window.getGraphPanelHeight() / 2 + 88, greenText, Color.GREEN);
        legend.setBackgroundColor(Color.WHITE);
        purple.setBackgroundColor(Color.WHITE);
        blue.setBackgroundColor(Color.WHITE);
        yellow.setBackgroundColor(Color.WHITE);
        green.setBackgroundColor(Color.WHITE);
        window.addShape(legend);
        window.addShape(purple);
        window.addShape(blue);
        window.addShape(yellow);
        window.addShape(green);
        TextShape songTitle = new TextShape((int) (4.5 * XSPACER - 36), 
                window.getGraphPanelHeight() / 2 + 108, "Song Title");
        songTitle.setBackgroundColor(Color.WHITE);
        window.addShape(songTitle);
        TextShape heard = new TextShape((int) (4.5 * XSPACER - 66), 
                (int) (window.getGraphPanelHeight() / 2 + 118 + (.5 * HEIGHT)),
                "Heard");
        heard.setBackgroundColor(Color.WHITE);
        window.addShape(heard);
        TextShape likes = new TextShape((int) (4.5 * XSPACER + WIDTH), 
                (int) (window.getGraphPanelHeight() / 2 + 118 + (.5 * HEIGHT)),
                "Likes");
        likes.setBackgroundColor(Color.WHITE);
        window.addShape(likes);
        Shape shape = new Shape((int) (XSPACER * 4.5 - .5 * WIDTH),
                window.getGraphPanelHeight() / 2 + 128, 
                WIDTH, HEIGHT, Color.BLACK);
        window.addShape(shape);
        Shape white = new Shape(4 * XSPACER + 4, window.getGraphPanelHeight() / 
                2 + 4, XSPACER - 26, window.getGraphPanelHeight() / 2 - 8,
                Color.WHITE);
        window.addShape(white);
        Shape trim = new Shape(4 * XSPACER, window.getGraphPanelHeight() / 2,
                XSPACER - 18, window.getGraphPanelHeight() / 2, Color.BLACK);
        window.addShape(trim); 
    }

    /**
     * 
     */
    public void createGlyphs() {
        Shape shape;
        int yMin = WINDOW_HEIGHT / 14;
        TextShape song;
        Iterator<MusicData> iter1 = sorter.getList(firstEnum).iterator();
        Iterator<MusicData> iter2 = sorter.getList(secondEnum).iterator();
        Iterator<MusicData> iter3 = sorter.getList(thirdEnum).iterator();
        Iterator<MusicData> iter4 = sorter.getList(fourthEnum).iterator();
        for (int i = 1; i < currentPage; i++) {
            for (int j = 0; j < 9; j++) {
                iter1.next();
                iter2.next();
                iter3.next();
                iter4.next();
            }
        }
        for (int i = 0; i < 9; i++) {
            MusicData data1 = iter1.next();
            MusicData data2 = iter2.next();
            MusicData data3 = iter3.next();
            MusicData data4 = iter4.next();
            int barLeft1 = (int)(((double)data1.getHaveHeard())
                    / data1.getTotalPeopleHeard() * HEIGHT);
            int barLeft2 = (int)(((double)data2.getHaveHeard())
                    / data2.getTotalPeopleHeard() * HEIGHT);
            int barLeft3 = (int)(((double)data3.getHaveHeard())
                    / data3.getTotalPeopleHeard() * HEIGHT);
            int barLeft4 = (int)(((double)data4.getHaveHeard())
                    / data4.getTotalPeopleHeard() * HEIGHT);
            int barRight1 = (int)(((double)data1.getDoLike()) /
                    data1.getTotalPeopleLiked() * HEIGHT);
            int barRight2 = (int)(((double)data2.getDoLike()) /
                    data2.getTotalPeopleLiked() * HEIGHT);
            int barRight3 = (int)(((double)data3.getDoLike()) /
                    data3.getTotalPeopleLiked() * HEIGHT);
            int barRight4 = (int)(((double)data4.getDoLike()) /
                    data4.getTotalPeopleLiked() * HEIGHT);

            song = new TextShape(XSPACER * (i % 3 + 1) + WIDTH / 2, (int) (yMin
                    + (.5 * yMin + YSPACER) * (i / 3)) - 40,
                    data1.getSong());
            song.setX(song.getX() - (song.getWidth() / 2));
            song.setBackgroundColor(Color.WHITE);
            window.addShape(song);
            song = new TextShape(XSPACER * (i % 3 + 1) + WIDTH / 2, (int) (yMin 
                    + (.5 * yMin + YSPACER) * (i / 3)) - 20, 
                    data1.getArtist());
            song.setX(song.getX() - (song.getWidth() / 2));
            song.setBackgroundColor(Color.WHITE);
            window.addShape(song);
            shape = new Shape(XSPACER * (i % 3 + 1), (int) (yMin + (.5 * yMin +
                    YSPACER) * (i / 3)), WIDTH, HEIGHT, Color.BLACK);
            window.addShape(shape);
            shape = new Shape(XSPACER * (i % 3 + 1) - barLeft1, (int) (yMin + 
                    (.5 * yMin + YSPACER) * (i / 3)), barLeft1, WIDTH, 
                    Color.MAGENTA);
            window.addShape(shape);
            shape = new Shape(XSPACER * (i % 3 + 1) + WIDTH, (int) (yMin + 
                    (.5 * yMin + YSPACER) * (i / 3)), barRight1, WIDTH, 
                    Color.MAGENTA);
            window.addShape(shape);
            shape = new Shape(XSPACER * (i % 3 + 1) - barLeft2, (int) (yMin + 
                    (.5 * yMin + YSPACER) * (i / 3)) + WIDTH, barLeft2, WIDTH, 
                    Color.BLUE);
            window.addShape(shape);
            shape = new Shape(XSPACER * (i % 3 + 1) + WIDTH, (int) (yMin + 
                    (.5 * yMin + YSPACER) * (i / 3)) + WIDTH, barRight2, WIDTH, 
                    Color.BLUE);
            window.addShape(shape);
            shape = new Shape(XSPACER * (i % 3 + 1) - barLeft3, (int) (yMin + 
                    (.5 * yMin + YSPACER) * (i / 3)) + 2 * WIDTH, barLeft3, 
                    WIDTH, Color.YELLOW);
            window.addShape(shape);
            shape = new Shape(XSPACER * (i % 3 + 1) + WIDTH, (int) (yMin + 
                    (.5 * yMin + YSPACER) * (i / 3)) + 2 * WIDTH, barRight3, 
                    WIDTH, Color.YELLOW);
            window.addShape(shape);
            shape = new Shape(XSPACER * (i % 3 + 1) - barLeft4, (int) (yMin + 
                    (.5 * yMin + YSPACER) * (i / 3)) + 3 *WIDTH, barLeft4, 
                    WIDTH, Color.GREEN);
            window.addShape(shape);
            shape = new Shape(XSPACER * (i % 3 + 1) + WIDTH, (int) (yMin + 
                    (.5 * yMin + YSPACER) * (i / 3)) + 3 * WIDTH, barRight4, 
                    WIDTH, Color.GREEN);
            window.addShape(shape);
            if (!iter1.hasNext()) {
                i = 9;
                next.disable();
            }
        }
    }

    /**
     * 
     * @param button    sets the method in motion.
     */
    public void clickedPrevious(Button button) {
        currentPage--;
        next.enable();
        update();
    }

    /**
     * 
     * @param button    sets the method in motion.
     */
    public void clickedNext(Button button) {
        currentPage++;
        previous.enable();
        update();
    }

    /**
     * 
     * @param button    sets the method in motion.
     */
    public void clickedQuit(Button button) {
        System.exit(0);;
    }

    /**
     * 
     * @param button    sets the method in motion.
     */
    public void clickedArtist(Button button) {
        artist.disable();
        title.enable();
        year.enable();
        genre.enable();

        sorter.sortByArtist(sorter.getList(RepresentationEnum.HobbyArt));
        sorter.sortByArtist(sorter.getList(RepresentationEnum.HobbyMusic));
        sorter.sortByArtist(sorter.getList(RepresentationEnum.HobbyReading));
        sorter.sortByArtist(sorter.getList(RepresentationEnum.HobbySports));
        sorter.sortByArtist(sorter.getList(RepresentationEnum.MajorCS));
        sorter.sortByArtist(sorter.getList(RepresentationEnum.MajorMath));
        sorter.sortByArtist(sorter.getList(RepresentationEnum.MajorOE));
        sorter.sortByArtist(sorter.getList(RepresentationEnum.MajorOther));
        sorter.sortByArtist(sorter.getList(RepresentationEnum.StateNE));
        sorter.sortByArtist(sorter.getList(RepresentationEnum.StateOU));
        sorter.sortByArtist(sorter.getList(RepresentationEnum.StateSE));
        sorter.sortByArtist(sorter.getList(RepresentationEnum.StateUS));
        currentPage = 1;
        next.enable();

        update();
    }

    /**
     * 
     * @param button    sets the method in motion.
     */
    public void clickedTitle(Button button) {
        artist.enable();
        title.disable();
        year.enable();
        genre.enable();

        sorter.sortBySong(sorter.getList(RepresentationEnum.HobbyArt));
        sorter.sortBySong(sorter.getList(RepresentationEnum.HobbyMusic));
        sorter.sortBySong(sorter.getList(RepresentationEnum.HobbyReading));
        sorter.sortBySong(sorter.getList(RepresentationEnum.HobbySports));
        sorter.sortBySong(sorter.getList(RepresentationEnum.MajorCS));
        sorter.sortBySong(sorter.getList(RepresentationEnum.MajorMath));
        sorter.sortBySong(sorter.getList(RepresentationEnum.MajorOE));
        sorter.sortBySong(sorter.getList(RepresentationEnum.MajorOther));
        sorter.sortBySong(sorter.getList(RepresentationEnum.StateNE));
        sorter.sortBySong(sorter.getList(RepresentationEnum.StateOU));
        sorter.sortBySong(sorter.getList(RepresentationEnum.StateSE));
        sorter.sortBySong(sorter.getList(RepresentationEnum.StateUS));
        currentPage = 1;
        next.enable();

        update();
    }

    /**
     * 
     * @param button    sets the method in motion.
     */
    public void clickedYear(Button button) {
        artist.enable();
        title.enable();
        year.disable();
        genre.enable();

        sorter.sortByDate(sorter.getList(RepresentationEnum.HobbyArt));
        sorter.sortByDate(sorter.getList(RepresentationEnum.HobbyMusic));
        sorter.sortByDate(sorter.getList(RepresentationEnum.HobbyReading));
        sorter.sortByDate(sorter.getList(RepresentationEnum.HobbySports));
        sorter.sortByDate(sorter.getList(RepresentationEnum.MajorCS));
        sorter.sortByDate(sorter.getList(RepresentationEnum.MajorMath));
        sorter.sortByDate(sorter.getList(RepresentationEnum.MajorOE));
        sorter.sortByDate(sorter.getList(RepresentationEnum.MajorOther));
        sorter.sortByDate(sorter.getList(RepresentationEnum.StateNE));
        sorter.sortByDate(sorter.getList(RepresentationEnum.StateOU));
        sorter.sortByDate(sorter.getList(RepresentationEnum.StateSE));
        sorter.sortByDate(sorter.getList(RepresentationEnum.StateUS));
        currentPage = 1;
        next.enable();

        update();
    }

    /**
     * 
     * @param button    sets the method in motion.
     */
    public void clickedGenre(Button button) {
        artist.enable();
        title.enable();
        year.enable();
        genre.disable();

        sorter.sortByGenre(sorter.getList(RepresentationEnum.HobbyArt));
        sorter.sortByGenre(sorter.getList(RepresentationEnum.HobbyMusic));
        sorter.sortByGenre(sorter.getList(RepresentationEnum.HobbyReading));
        sorter.sortByGenre(sorter.getList(RepresentationEnum.HobbySports));
        sorter.sortByGenre(sorter.getList(RepresentationEnum.MajorCS));
        sorter.sortByGenre(sorter.getList(RepresentationEnum.MajorMath));
        sorter.sortByGenre(sorter.getList(RepresentationEnum.MajorOE));
        sorter.sortByGenre(sorter.getList(RepresentationEnum.MajorOther));
        sorter.sortByGenre(sorter.getList(RepresentationEnum.StateNE));
        sorter.sortByGenre(sorter.getList(RepresentationEnum.StateOU));
        sorter.sortByGenre(sorter.getList(RepresentationEnum.StateSE));
        sorter.sortByGenre(sorter.getList(RepresentationEnum.StateUS));
        currentPage = 1;
        next.enable();

        update();
    }

    /**
     * 
     * @param button    sets the method in motion.
     */
    public void clickedHobby(Button button) {
        hobby.disable();
        major.enable();
        region.enable();
        legendText = "Hobby Legend";
        purpleText = "Read";
        blueText = "Art";
        yellowText = "Sports";
        greenText = "Music";

        currentPage = 1;
        firstEnum = RepresentationEnum.HobbyReading;
        secondEnum = RepresentationEnum.HobbyArt;
        thirdEnum = RepresentationEnum.HobbySports;
        fourthEnum = RepresentationEnum.HobbyMusic;
        next.enable();

        update();
    }

    /**
     * 
     * @param button    sets the method in motion.
     */
    public void clickedMajor(Button button) {
        hobby.enable();
        major.disable();
        region.enable();
        legendText = "Major Legend";
        purpleText = "Computer Science";
        blueText = "Other Engineering";
        yellowText = "Math or CMDA";
        greenText = "Other";

        currentPage = 1;
        firstEnum = RepresentationEnum.MajorCS;
        secondEnum = RepresentationEnum.MajorOE;
        thirdEnum = RepresentationEnum.MajorMath;
        fourthEnum = RepresentationEnum.MajorOther;
        next.enable();

        update();
    }

    /**
     * 
     * @param button    sets the method in motion.
     */
    public void clickedRegion(Button button) {
        hobby.enable();
        major.enable();
        region.disable();
        legendText = "Region Legend";
        purpleText = "Northeast US";
        blueText = "Southeast US";
        yellowText = "Western US";
        greenText = "Foreign";

        currentPage = 1;
        firstEnum = RepresentationEnum.StateNE;
        secondEnum = RepresentationEnum.StateSE;
        thirdEnum = RepresentationEnum.StateUS;
        fourthEnum = RepresentationEnum.StateOU;
        next.enable();

        update();
    }
}
