
public class Pixel
{
    /**
     * Stores the red value of a pixel.
     */
    private int red;
    
    /**
     * Stores the green value of a pixel.
     */
    private int green;
    
    /**
     * Stores the blue value of a pixel.
     */
    private int blue;
    
    /**
     * Creates a new pixel with RGB color scheme.
     * @param r red color value
     * @param g green color value
     * @param b blue color value
     */
    public Pixel (int r, int g, int b)
    {
        red = r;
        green = g;
        blue = b;
    }
    
    /**
     * Converts the pixel to negative.
     */
    public void toNegative()
    {
        red = 255 - red;
        green = 255 - green;
        blue = 255 - blue;
    }
    
    /**
     * Converts the pixel to greyscale.
     */
    public void toGrey()
    {
        int average = red + green + blue;
        average = average / 3;
        red = average;
        green = average;
        blue = average;
    }
    
    /**
     * Converts the pixel to redscale.
     */
    public void toRed() 
    {
        int average = red + green + blue;
        average = average / 3;
        red = average;
        green = 0;
        blue = 0;
    }
    
    /**
     * Converts the pixel to greenscale.
     */
    public void toGreen()
    {
        int average = red + green + blue;
        average = average / 3;
        red = 0;
        green = average;
        blue = 0;
    }
    
    /**
     * Converts the pixel to bluescale.
     */
    public void toBlue()
    {
        int average = red + green + blue;
        average = average / 3;
        red = 0;
        green = 0;
        blue = average;
    }
    
    /**
     * @return the red
     */
    public int getRed()
    {
        return red;
    }

    /**
     * @param red the red to set
     */
    public void setRed(int red)
    {
        this.red = red;
    }

    /**
     * @return the green
     */
    public int getGreen()
    {
        return green;
    }

    /**
     * @param green the green to set
     */
    public void setGreen(int green)
    {
        this.green = green;
    }

    /**
     * @return the blue
     */
    public int getBlue()
    {
        return blue;
    }

    /**
     * @param blue the blue to set
     */
    public void setBlue(int blue)
    {
        this.blue = blue;
    }
    
    /**
     * Prints a string representation of the pixel as space separated integer color values
     */
    public String toString()
    {
        String val = "" + red + " " + green + " " + blue;
        return val;
    }
    
    
}
