/**
 * 
 */
package project1;

/**
 * @author Charles Kresho
 * @version 2016.1.29
 *
 */
public class ProjectRunner {
    public static void main(String[] args) {
        DisplayCollection display = new DisplayCollection();
        ShapeWindow window = new ShapeWindow(display.getItemBag());
    }
}