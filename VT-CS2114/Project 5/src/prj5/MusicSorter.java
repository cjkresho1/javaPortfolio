package prj5;

import java.util.Iterator;

//import binarySearch.HistoricEvent;

/**
 * @author Josh Fowler (chrls93)
 * @version 2016.04.10
 */
public class MusicSorter {
    private LinkedList<MusicData> hobbyMusic;
    private LinkedList<MusicData> hobbyReading;
    private LinkedList<MusicData> hobbySports;
    private LinkedList<MusicData> hobbyArt;
    private LinkedList<MusicData> majorCS;
    private LinkedList<MusicData> majorOE;
    private LinkedList<MusicData> majorMath;
    private LinkedList<MusicData> majorOther;
    private LinkedList<MusicData> stateNE;
    private LinkedList<MusicData> stateSE;
    private LinkedList<MusicData> stateUS;
    private LinkedList<MusicData> stateOU;
    
    public MusicSorter(LinkedList<MusicData> hob1,
            LinkedList<MusicData> hob2,
            LinkedList<MusicData> hob3,
            LinkedList<MusicData> hob4,
            LinkedList<MusicData> maj1, 
            LinkedList<MusicData> maj2, 
            LinkedList<MusicData> maj3, 
            LinkedList<MusicData> maj4, 
            LinkedList<MusicData> stat1,
            LinkedList<MusicData> stat2,
            LinkedList<MusicData> stat3,
            LinkedList<MusicData> stat4){
    hobbyMusic = hob1;
    hobbyReading = hob2;
    hobbySports = hob3;
    hobbyArt = hob4;
    majorCS = maj1;
    majorOE = maj2;
    majorMath = maj3;
    majorOther = maj4;
    stateNE = stat1;
    stateSE = stat2;
    stateUS = stat3;
    stateOU = stat4;
    }
    /**
     * Getter method for the list fields
     * @param rep the enum to tell us which list to get
     * @return the list from designated enum
     */
    public LinkedList<MusicData> getList(RepresentationEnum rep) {
        if (rep.name().equals("HobbyMusic")) {
            return hobbyMusic;
        }
        else if (rep.name().equals("HobbyReading")) {
            return hobbyReading;
        }
        else if (rep.name().equals("HobbySports")) {
            return hobbySports;
        }
        else if (rep.name().equals("HobbyArt")) {
            return hobbyArt;
        }
        else if (rep.name().equals("StateNE")) {
            return stateNE;
        }
        else if (rep.name().equals("StateSE")) {
            return stateSE;
        }
        else if (rep.name().equals("StateUS")) {
            return stateUS;
        }
        else if (rep.name().equals("StateOU")) {
            return stateOU;
        }
        else if (rep.name().equals("MajorCS")) {
            return majorCS;
        }
        else if (rep.name().equals("MajorOE")) {
            return majorOE;
        }
        else if (rep.name().equals("MajorMath")) {
            return majorMath;
        }
        else if (rep.name().equals("MajorOther")) {
            return majorOther;
        }
        else {
            return null;
        }
        
    }
   
    /**
     * Sorts a list by taking each node needing to be sorted
     * and giving to the helper method 
     * @param list the list to sort
     */
    public void sortBySong(LinkedList<MusicData> list) {
        if (list.size() > 1) {
            Node<MusicData> unsorted = list.getFirstNode().getNext();
            list.getFirstNode().setNext(null);
            while (unsorted != null) {
                Node<MusicData> insert = unsorted;
                unsorted = unsorted.getNext();
                insertSongInOrder(insert, list);
            }
        }
    }
    /**
     *  Helper method for song insertion sort
     *  Compares the current node data to next via song name
     * @param nodeToInsert the node for insertion sort
     * @param list the list to sort
     */
    private void insertSongInOrder(Node<MusicData> nodeToInsert, LinkedList<MusicData> list) {
        Node<MusicData> curr = list.getFirstNode();
        Node<MusicData> prev = null;
        while((curr != null) && ((nodeToInsert.getData().compareTo(curr.getData()) > 0))) {
            prev = curr;
            curr = curr.getNext();
        }
        if (prev != null) {
            prev.setNext(nodeToInsert);
            nodeToInsert.setNext(curr);
        }
        else {
            nodeToInsert.setNext(list.getFirstNode());
            list.setFirstNode(nodeToInsert);
        }
    }
    /**
     * Sorts a list by taking each node needing to be sorted
     * and giving to the helper method 
     * @param list the list to sort
     */
    public void sortByArtist(LinkedList<MusicData> list) {
        if (list.size() > 1) {
            Node<MusicData> unsorted = list.getFirstNode().getNext();
            list.getFirstNode().setNext(null);
            while (unsorted != null) {
                Node<MusicData> insert = unsorted;
                unsorted = unsorted.getNext();
                insertArtistInOrder(insert, list);
            }
        }
    }
    /**
     *  helper method for artist insertion sort
     *  Compares the current node data to next via artist name
     * @param nodeToInsert the node for insertion sort
     * @param list the list to sort
     */
    private void insertArtistInOrder(Node<MusicData> nodeToInsert, LinkedList<MusicData> list) {
        Node<MusicData> curr = list.getFirstNode();
        Node<MusicData> prev = null;
        while((curr != null) && ((nodeToInsert.getData().compareToArtist(curr.getData()) > 0))) {
            prev = curr;
            curr = curr.getNext();
        }
        if (prev != null) {
            prev.setNext(nodeToInsert);
            nodeToInsert.setNext(curr);
        }
        else {
            nodeToInsert.setNext(list.getFirstNode());
            list.setFirstNode(nodeToInsert);
        }
    }
    /**
     * Sorts a list by taking each node needing to be sorted
     * and giving to the helper method 
     * @param list the list to sort
     */
    public void sortByGenre(LinkedList<MusicData> list) {
        if (list.size() > 1) {
            Node<MusicData> unsorted = list.getFirstNode().getNext();
            list.getFirstNode().setNext(null);
            while (unsorted != null) {
                Node<MusicData> insert = unsorted;
                unsorted = unsorted.getNext();
                insertGenreInOrder(insert, list);
            }
        }
    }
    /**
     *  helper method for genre insertion sort
     *  Compares the current node data to next via genre
     * @param nodeToInsert the node for insertion sort
     * @param list the list to sort
     */
    private void insertGenreInOrder(Node<MusicData> nodeToInsert, LinkedList<MusicData> list) {
        Node<MusicData> curr = list.getFirstNode();
        Node<MusicData> prev = null;
        while((curr != null) && ((nodeToInsert.getData().compareToGenre(curr.getData()) > 0))) {
            prev = curr;
            curr = curr.getNext();
        }
        if (prev != null) {
            prev.setNext(nodeToInsert);
            nodeToInsert.setNext(curr);
        }
        else {
            nodeToInsert.setNext(list.getFirstNode());
            list.setFirstNode(nodeToInsert);
        }
    }
    /**
     * Sorts a list by taking each node needing to be sorted
     * and giving to the helper method 
     * @param list the list to sort
     */
    public void sortByDate(LinkedList<MusicData> list) {
        if (list.size() > 1) {
            Node<MusicData> unsorted = list.getFirstNode().getNext();
            list.getFirstNode().setNext(null);
            while (unsorted != null) {
                Node<MusicData> insert = unsorted;
                unsorted = unsorted.getNext();
                insertDateInOrder(insert, list);
            }
        }
    }
    /**
     *  helper method for date insertion sort
     *  Compares the current node data to next via date
     * @param nodeToInsert the node for insertion sort
     * @param list the list to sort
     */
    private void insertDateInOrder(Node<MusicData> nodeToInsert, LinkedList<MusicData> list) {
        Node<MusicData> curr = list.getFirstNode();
        Node<MusicData> prev = null;
        while((curr != null) && ((nodeToInsert.getData().compareToDate(curr.getData()) > 0))) {
            prev = curr;
            curr = curr.getNext();
        }
        if (prev != null) {
            prev.setNext(nodeToInsert);
            nodeToInsert.setNext(curr);
        }
        else {
            nodeToInsert.setNext(list.getFirstNode());
            list.setFirstNode(nodeToInsert);
        }
    }
    
    public void printHobby()
    {
        Iterator<MusicData> iter4 = hobbyMusic.iterator();
        Iterator<MusicData> iter1 = hobbyReading.iterator();
        Iterator<MusicData> iter3 = hobbySports.iterator();
        Iterator<MusicData> iter2 = hobbyArt.iterator();
        
        while (iter1.hasNext())
        {
            MusicData data1 = iter1.next();
            MusicData data2 = iter2.next();
            MusicData data3 = iter3.next();
            MusicData data4 = iter4.next();
            System.out.println("Song Title: " + data1.getSong());
            System.out.println("Song Artist: " + data1.getArtist());
            System.out.println("Song Genre: " + data1.getGenre());
            System.out.println("Song Year: " + data1.getDate());
            System.out.println("Heard");
            System.out.print("reading:" + (int)(((double)data1.getHaveHeard()
                    )/data1.getTotalPeopleHeard() * 100));
            System.out.print(" art:" + (int)(((double)data2.getHaveHeard()
                    )/data2.getTotalPeopleHeard() * 100));
            System.out.print(" sports:" + (int)(((double)data3.getHaveHeard()
                    )/data3.getTotalPeopleHeard() * 100));
            System.out.println(" music:" + (int)(((double)data4.getHaveHeard()
                    )/data4.getTotalPeopleHeard() * 100));
            System.out.println("Likes");
            System.out.print("reading:" + (int)(((double)data1.getDoLike())/
                    data1.getTotalPeopleLiked() * 100));
            System.out.print(" art:" + (int)(((double)data2.getDoLike())/
                    data2.getTotalPeopleLiked() * 100));
            System.out.print(" sports:" + (int)(((double)data3.getDoLike())/
                    data3.getTotalPeopleLiked() * 100));
            System.out.println(" music:" + (int)(((double)data4.getDoLike())/
                    data4.getTotalPeopleLiked() * 100) + "\n");
        }
    }
    
    
}
