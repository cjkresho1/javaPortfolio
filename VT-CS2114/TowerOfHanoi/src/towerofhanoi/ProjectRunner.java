/**
 * 
 */
package towerofhanoi;

/**
 * @author Charles Kresho
 *
 */
public class ProjectRunner {

    /**
     * @param args
     */
    public static void main(String[] args) 
    {
        GameWindow gameWindow = new GameWindow(new HanoiSolver(15));
    }

}
