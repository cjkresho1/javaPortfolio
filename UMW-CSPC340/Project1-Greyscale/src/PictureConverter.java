import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

/**
 * Modifies a .ppm picture based on different effects, including greyscale and negative. See the help information for more info.
 * @author Charles Kresho
 *
 */
public class PictureConverter
{
    /**
     * The number of effects currently implemented. Used for random switch statement. 
     */
    private static final int NUM_EFFECTS = 4;
    
    /**
     * Filename for the greyscale effect printing. 
     */
    private static final String GREY_PRINT_FILE_NAME = "greyscale.ppm";
    
    /**
     * Filename used for any non-greyscale effect printing.
     */
    private static final String EXTRA_PRINT_FILE_NAME = "extra.ppm";

    /**
     * Main method. Parses user input and decides on effects.
     * @param args Should be .ppm file and optional flags. See help for more details. 
     */
    public static void main(String[] args)
    {
        //If there is only one additional argument passed, check if it's a file or the -help flag
        if (args.length == 1)
        {
            if (args[0].equals("-help")) //Print the help for the different options
            {
                System.out.println("Usage for PictureConverter is as follows:");
                System.out.println("-help: Print this help documentation.");
                System.out.println("[PPM File]: Creates a greyscale copy of the passed image as greyscale.ppm, and a " +
                        " copy of the image modified by a random extra effect as extra.ppm.");
                System.out.println("-negative [PPM File]: Creates a greyscale copy of the passed image as greyscale.ppm, and a " + 
                        "negative copy of the image as extra.ppm.");
                System.out.println("-red [PPM File]: Creates a greyscale copy of the passed image as greyscale.ppm, and a" +
                        " redscale copy of the image as extra.ppm.");
                System.out.println("-green [PPM File]: Creates a greyscale copy of the passed image as greyscale.ppm, and a" +
                        " greenscale copy of the image as extra.ppm.");
                System.out.println("-blue [PPM File]: Creates a greyscale copy of the passed image as greyscale.ppm, and a" +
                        " blue copy of the image as extra.ppm.");
            }
            else //Try to parse the argument for a .ppm file
            {
                PPMFormat ppm = createPPMArray(args[0]);
                toGrey(ppm);
                
                switch (new Random().nextInt(NUM_EFFECTS)) //Generate a random extra effect in addition to the greyscale
                {
                case(0):
                {
                    toNegative(ppm);
                    break;
                }
                case(2):
                {
                    toRed(ppm);
                    break;
                }
                case(3):
                {
                    toGreen(ppm);
                    break;
                }
                case(4):
                {
                    toBlue(ppm);
                    break;
                }
                default:
                {
                    System.out.println("This shouldn't have happened. Please report to the author.");
                    break;
                }
                }
            }
        }
        else if (args.length == 2) //Try to read a filename and a flag
        {
            String flag = args[0];
            String filename = args[1];
            
            PPMFormat ppm = createPPMArray(filename);
            switch(flag)
            {
            case("-negative"):
            {
                toNegative(ppm);
                break;
            }
            case("-red"):
            {
                toRed(ppm);
                break;
            }
            case("-green"):
            {
                toGreen(ppm);
                break;
            }
            case("-blue"):
            {
                toBlue(ppm);
                break;
            }
            default:
            {
                System.out.println("Invalid flag passed. Pass flag -help to see a list of all options.");
                System.exit(0);
            }
            }
            
            toGrey(ppm);
            
        }
        else
        {
            System.out.println("Invalid number of arguemnts. Please use -help for valid command usage.");
        }
    }

    /**
     * Attempts to read a .ppm file, and translate it into a PPMFormat object. 
     * @param filename filename of a .ppm file.
     * @return A PPMFormat object of the passed image.
     */
    private static PPMFormat createPPMArray(String filename)
    {
        File picture = new File(filename);
        if (!picture.exists())
        {
            System.out.println("This file doesn't exist.");
            System.exit(0);
        }
        
        try
        {
            PPMFormat ppm = new PPMFormat(picture);
            return ppm;
        }
        catch (FileNotFoundException e)
        {
            //Shouldn't happen, but check anyways.
            System.out.println("This file doesn't exist.");
        }
        catch (IOException e)
        {
            System.out.println("Error processing image. Closing.");
            System.exit(0);
        }
        
        return null;
    }
    
    /**
     * Prints a greyscale .ppm to greyscale.ppm
     * @param ppm the PPMFormat object to be converted to greyscale.
     */
    private static void toGrey(PPMFormat ppm)
    {
        ppm.toGrey();
        try
        {
            ppm.printToFile(GREY_PRINT_FILE_NAME);
        }
        catch (IOException e)
        {
            System.out.println("Something went wrong writing to greyscale.ppm.");
        }
    }
    
    /**
     * Prints a negative .ppm to extra.ppm
     * @param ppm the PPMFormat object to be converted to negative.
     */
    private static void toNegative(PPMFormat ppm)
    {
        ppm.toNegative();
        try
        {
            ppm.printToFile(EXTRA_PRINT_FILE_NAME);
        }
        catch (IOException e)
        {
            System.out.println("Something went wrong writing to extra.ppm.");
        }
    }
    
    /**
     * Prints a red-scaled .ppm to extra.ppm.
     * @param ppm the PPMFormat object to be converted to red-scale.
     */
    private static void toRed(PPMFormat ppm)
    {
        ppm.toRed();
        try
        {
            ppm.printToFile(EXTRA_PRINT_FILE_NAME);
        }
        catch (IOException e)
        {
            System.out.println("Something went wrong writing to extra.ppm.");
        }
    }
    
    /**
     * Prints a greens-scaled .ppm to extra.ppm
     * @param ppm the PPMFormat object to be converted to green-scale.
     */
    private static void toGreen(PPMFormat ppm)
    {
        ppm.toGreen();
        try
        {
            ppm.printToFile(EXTRA_PRINT_FILE_NAME);
        }
        catch (IOException e)
        {
            System.out.println("Something went wrong writing to extra.ppm.");
        }
    }
    
    /**
     * Prints a blue-scaled .ppm to extra.ppm
     * @param ppm the PPMFormat object to be converted to green-scale.
     */
    private static void toBlue(PPMFormat ppm)
    {
        ppm.toBlue();
        try
        {
            ppm.printToFile(EXTRA_PRINT_FILE_NAME);
        }
        catch (IOException e)
        {
            System.out.println("Something went wrong writing to extra.ppm.");
        }
    }
}
