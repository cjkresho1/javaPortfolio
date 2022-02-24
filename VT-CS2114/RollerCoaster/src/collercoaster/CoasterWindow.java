/**
 * 
 */
package collercoaster;

import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * @author Charles Kresho
 * @version 2016.4.7
 */
public class CoasterWindow 
{
    private Window window;
    private RollerCoasterQueue coasterQueue;
    private CoasterTrain train;
    private Button seatParty;
    private Button sendTrain;
    private Shape[] shapes;
    
    private static final int QUEUE_STARTX = 100;
    private static final int QUEUE_STARTY = 150;
    private static final int CIRCLE_RADIUS_FACTOR = 10;
    
    public CoasterWindow(RollerCoasterQueue queue)
    {
        window = new Window("Roller Coaster Ride");
        coasterQueue = queue;
        train = new CoasterTrain();
        seatParty = new Button("Seat Party");
        window.addButton(seatParty, WindowSide.SOUTH);
        seatParty.onClick(this, "clickedSeatParty");
        sendTrain = new Button("Send Train");
        window.addButton(sendTrain, WindowSide.SOUTH);
        sendTrain.onClick(this, "clickedSendTrain");
        
    }
    
    public void clickedSeatParty(Button button)
    {
        
    }
    
    public void clickedSendTrain(Button button)
    {
        
    }
}
