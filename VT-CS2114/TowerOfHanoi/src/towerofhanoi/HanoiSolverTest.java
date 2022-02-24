/**
 * 
 */
package towerofhanoi;

import student.TestCase;

/**
 * @author Charles Kresho
 * @version 2016.3.16
 */
public class HanoiSolverTest extends TestCase 
{
    private HanoiSolver game;
    private HanoiSolver game1;
    private GameWindow gameWindow;
    private Tower left;
    private Tower middle;
    private Tower right;
    
    /**
     * Sets up the variables for the testers
     */
    public void setUp()
    {
        game = new HanoiSolver(3);
        gameWindow = new GameWindow(game);
        gameWindow.getWindow();
        left = new Tower(Position.LEFT);
        left.push(new Disc(30));
        left.push(new Disc(20));
        left.push(new Disc(10));
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
        game1 = new HanoiSolver(0);
        game1.getTower(Position.LEFT).push(new Disc(10));
        game1.getTower(Position.MIDDLE).push(new Disc(20));
        game1.getTower(Position.RIGHT).push(new Disc(30));
    }
    
    /**
     * Tests the disks method
     */
    public void testDisks()
    {
        setUp();
        assertEquals(3, game.discs());
    }
    
    /**
     * Tests the solve method
     */
    public void testSolve()
    {
        setUp();
        assertEquals("[10 20 30][][]", game.toString());
        game.solve();
        assertEquals("[][][10 20 30]", game.toString());

    }
    
    /**
     * Tests the toString method
     */
    public void testToString()
    {
        setUp();
        assertEquals("[10 20 30][][]", game.toString());
        assertEquals("[10][20][30]", game1.toString());
    }
    
    /**
     * Tests the method getTower
     */
    public void testGetTower()
    {
        gameWindow.getClass();
        setUp();
        assertEquals(left.toString()
                , game.getTower(Position.LEFT).toString());
        assertEquals(middle.toString(), 
                game.getTower(Position.MIDDLE).toString());
        assertEquals(right.toString(), 
                game.getTower(Position.RIGHT).toString());
        assertEquals(left.toString(), game.getTower(Position.OTHER).toString());
    }
}
