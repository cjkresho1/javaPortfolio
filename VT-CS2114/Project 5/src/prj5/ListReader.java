package prj5;
import java.io.File;
import java.util.Scanner;
/**
 * @author Josh Fowler (chrls93)
 * @version 2016.04.10
 */
 public class ListReader {
    public ListReader(String fileName, String otherFile) {
        MusicSorter sorter = readQueueFile(otherFile, fileName);
        @SuppressWarnings("unused")
        GUIMusic window = new GUIMusic(sorter);
        sorter.sortByGenre(sorter.getList(RepresentationEnum.HobbyArt));
        sorter.sortByGenre(sorter.getList(RepresentationEnum.HobbyMusic));
        sorter.sortByGenre(sorter.getList(RepresentationEnum.HobbySports));
        sorter.sortByGenre(sorter.getList(RepresentationEnum.HobbyReading));
        sorter.printHobby();
        sorter.sortBySong(sorter.getList(RepresentationEnum.HobbyArt));
        sorter.sortBySong(sorter.getList(RepresentationEnum.HobbyMusic));
        sorter.sortBySong(sorter.getList(RepresentationEnum.HobbySports));
        sorter.sortBySong(sorter.getList(RepresentationEnum.HobbyReading));
        sorter.printHobby();
    }
    /**
     * The constructor that takes two files as inputs, one to 
     * give the songs, and another to give the student data
     * @param fileName the song file
     * @param otherFile the file with the student data
     * @return the created music sorter for out GUI
     */
    public MusicSorter readQueueFile(String fileName, String otherFile) {
    LinkedList<MusicData> hobbyMu = new LinkedList<MusicData>();
    LinkedList<MusicData> majorCs = new LinkedList<MusicData>();
    LinkedList<MusicData> stateSE = new LinkedList<MusicData>();
    LinkedList<MusicData> hobbyRd = new LinkedList<MusicData>();
    LinkedList<MusicData> majorOE = new LinkedList<MusicData>();
    LinkedList<MusicData> stateNE = new LinkedList<MusicData>();
    LinkedList<MusicData> hobbySp = new LinkedList<MusicData>();
    LinkedList<MusicData> majorMa = new LinkedList<MusicData>();
    LinkedList<MusicData> stateUS = new LinkedList<MusicData>();
    LinkedList<MusicData> hobbyAr = new LinkedList<MusicData>();
    LinkedList<MusicData> majorOt = new LinkedList<MusicData>();
    LinkedList<MusicData> stateOU = new LinkedList<MusicData>();
    Scanner file = null;
    try {
        file = new Scanner(new File(fileName));
    }
    catch (Exception exception) {
        System.exit(0);
    }
    file.nextLine();
    while (file.hasNextLine()) {    
        String line = file.nextLine();
        String[] data = line.split(", *");
        hobbyMu.add(new MusicData(data[1], data[0], data[3], data[2]));
        hobbyRd.add(new MusicData(data[1], data[0], data[3], data[2]));
        hobbySp.add(new MusicData(data[1], data[0], data[3], data[2]));
        hobbyAr.add(new MusicData(data[1], data[0], data[3], data[2]));
        majorCs.add(new MusicData(data[1], data[0], data[3], data[2]));
        majorOE.add(new MusicData(data[1], data[0], data[3], data[2]));
        majorMa.add(new MusicData(data[1], data[0], data[3], data[2]));
        majorOt.add(new MusicData(data[1], data[0], data[3], data[2]));
        stateNE.add(new MusicData(data[1], data[0], data[3], data[2]));
        stateSE.add(new MusicData(data[1], data[0], data[3], data[2]));
        stateUS.add(new MusicData(data[1], data[0], data[3], data[2]));
        stateOU.add(new MusicData(data[1], data[0], data[3], data[2]));
    }
    try {
        file = new Scanner(new File(otherFile));
    }
    catch (Exception exception) {
        System.exit(0);
    }
    file.nextLine();
    while (file.hasNextLine()) {
        String line = file.nextLine();
        String data[] = line.split(", *");
        Node<MusicData> major;
        Node<MusicData> hobby;
        Node<MusicData> region;
        if (data.length < 5)
        {
            
        }
        else
        {
            // third column
            if (data[2].equals("Computer Science")) {
                major = majorCs.getFirstNode();
            }
            else if(data[2].equals("Other Engineering")){
                major = majorOE.getFirstNode();
            }
            else if(data[2].equals("Math or CMDA")) {
                major = majorMa.getFirstNode();
            }
            else {
                major = majorOt.getFirstNode();
            }   
            // fourth column
            if (data[3].equals("Southeast")) {
                region = stateSE.getFirstNode();
            }
            else if(data[3].equals("Northeast")){
                region = stateNE.getFirstNode();
            }
            else if(data[3].equals("United States (other than Southeast or Northwest)")) {
                region = stateUS.getFirstNode();
            }
            else {
                region = stateOU.getFirstNode();
            }     
         // fifth column
            if (data[4].equals("sports")) {
                hobby = hobbySp.getFirstNode();
            }
            else if(data[4].equals("reading")){
                hobby = hobbyRd.getFirstNode();
            }
            else if(data[4].equals("music")) {
                hobby = hobbyMu.getFirstNode();
            }
            else {
                hobby = hobbyAr.getFirstNode();
            }
            
            for (int i = 5; i < data.length; i+=2) {
                if (data[i].equals("Yes")) {
                    major.getData().addHeard();
                    hobby.getData().addHeard();
                    region.getData().addHeard();
                }
                else if (data[i].equals("No")) {
                    major.getData().addHasntHeard();
                    hobby.getData().addHasntHeard();
                    region.getData().addHasntHeard();
                }
                if (i == data.length - 1) {
                    major.getData().addDoesntLike();
                    hobby.getData().addDoesntLike();;
                    region.getData().addDoesntLike();;
                }
                else if (data[i+1].equals("Yes")) {
                    major.getData().addDoLike();
                    hobby.getData().addDoLike();
                    region.getData().addDoLike();
                }
                else if (data[i].equals("No")) {
                    major.getData().addDoesntLike();
                    hobby.getData().addDoesntLike();;
                    region.getData().addDoesntLike();;
                } 
                major = major.getNext();
                hobby = hobby.getNext();
                region = region.getNext();
            }
        }
    }
    MusicSorter toReturn = new MusicSorter(hobbyMu, hobbyRd,
            hobbySp, hobbyAr, majorCs, majorOE, majorMa, majorOt, 
            stateSE, stateNE, stateUS, stateOU);
    return toReturn;
    }
 }