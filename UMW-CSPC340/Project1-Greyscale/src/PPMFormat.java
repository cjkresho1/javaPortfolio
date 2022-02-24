import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Holds the raw pixel information for a .ppm picture file, and can perform functions related to it. 
 * @author Charles Kresho
 *
 */
public class PPMFormat
{
    /**
     * Holds the pixel array of the original ppm picture. Should never be modified. 
     */
    private Pixel OGpixel[][];
    
    /**
     * Stores the current pixel array of the modified ppm picture.
     */
    private Pixel pixel[][];
    
    /**
     * Stores the height of the picture in pixels.
     */
    private int height;
    
    /**
     * Stores the width of the picture in pixels.
     */
    private int width;
    
    /**
     * Creates a new PPMFormat from the passed picture. If the file isn't formatted like a PPM picture, throws exception.
     * @param picture file location of the ppm picture.
     * @throws IOException if the file doesn't exist, isn't formatted like a PPM picture, or unexpected I/O error occurs. 
     */
    public PPMFormat(File picture) throws IOException
    {
        Scanner scan = new Scanner(picture);
        
        String tempLine = scan.nextLine();
        if (!tempLine.equals("P3"))
        {
            System.out.println("This file is not formatted as a PPM picture file.");
            scan.close();
            throw new IOException();
        }
        
        tempLine = scan.nextLine();
        String picSize[] = tempLine.split(" ");
        
        if(picSize.length != 2)
        {
            System.out.println("Size fields not included in the  passed file.");
            scan.close();
            throw new IOException();
        }
        
        //For the purpose of this assignment, these should be 500. But much cooler to design around them as variable. 
        width = Integer.parseInt(picSize[0]);
        height = Integer.parseInt(picSize[1]);
        
        if(scan.hasNextInt())
        {
            tempLine = scan.next();
            
            if(Integer.parseInt(tempLine) != 255)
            {
                System.out.println("Unexpected max color value.");
                scan.close();
                throw new IOException();
            }
        }
        else
        {
            System.out.println("No max color value found.");
            scan.close();
            throw new IOException();
        }
        
        //Start parsing for pixels
        pixel = new Pixel[height][width];
        OGpixel = new Pixel[height][width];
        for (int h = 0; h < height; h++)
        {
            for (int w = 0; w < width; w++)
            {
                try
                {
                    int r = scan.nextInt();
                    int g = scan.nextInt();
                    int b = scan.nextInt(); 
                    
                    pixel[h][w] = new Pixel(r, g, b);
                    OGpixel[h][w] = new Pixel(r, g, b);
                }
                catch(InputMismatchException e)
                {
                    System.out.println("File contains formatting errors, expected int color values, found something else.");
                    scan.close();
                    throw new IOException();
                }
                catch(NoSuchElementException e)
                {
                    System.out.println("File doesn't contain enough pixel color values: Only " + (h * w) + 
                            " pixels found, " + (height * width) + " were expected.");
                    scan.close();
                    throw new NoSuchElementException();
                }
                catch(Exception e)
                {
                    System.out.println("Something happended while trying to get the pixel color values.");
                    scan.close();
                    throw new NoSuchElementException();
                }
            }
        }
        scan.close();
    }
    
    /**
     * Prints the current pixel array to a .ppm file
     * @param filename file location to print the picture to
     * @throws IOException if the FileWriter throws an IOException.
     */
    public void printToFile(String filename) throws IOException
    {
        File file = new File(filename);
        if(file.exists())
        {
            file.delete();
        }
        
        file.createNewFile();
        
        FileWriter picWriter = new FileWriter(file);
        picWriter.write("P3\n");
        picWriter.write("" + width + " " + height + "\n");
        picWriter.write("255");
        
        for (int h = 0; h < height; h++)
        {
            for (int w = 0; w < width; w++)
            {
                if ((((h * height) + w) % 6) == 0)
                {
                    picWriter.write("\n");
                }
                picWriter.write(pixel[h][w].toString() + " ");
            }
        }
        
        picWriter.close();
    }
    
    /**
     * Convert the OGPixel into greyscale, stored in pixel
     * @return the greyscaled pixel array.
     */
    public Pixel[][] toGrey()
    {
        
        for (int h = 0; h < height; h++)
        {
            for (int w = 0; w < width; w++)
            {
                pixel[h][w] = new Pixel(OGpixel[h][w].getRed(), OGpixel[h][w].getGreen(), OGpixel[h][w].getBlue());
                pixel[h][w].toGrey();
            }
        }
        
        return pixel;
    }
    
    /**
     * Convert the OGPixel into negative, stored in pixel
     * @return the negative pixel array.
     */
    public Pixel[][] toNegative()
    {
        for (int h = 0; h < height; h++)
        {
            for (int w = 0; w < width; w++)
            {
                pixel[h][w] = new Pixel(OGpixel[h][w].getRed(), OGpixel[h][w].getGreen(), OGpixel[h][w].getBlue());
                pixel[h][w].toNegative();
            }
        }
        
        return pixel;
    }
    
    /**
     * Convert the OGPixel into redscale, stored in pixel
     * @return the redscaled pixel array.
     */
    public Pixel[][] toRed()
    {
        for (int h = 0; h < height; h++)
        {
            for (int w = 0; w < width; w++)
            {
                pixel[h][w] = new Pixel(OGpixel[h][w].getRed(), OGpixel[h][w].getGreen(), OGpixel[h][w].getBlue());
                pixel[h][w].toRed();
            }
        }
        
        return pixel;
    }
    
    /**
     * Convert the OGPixel into greenscale, stored in pixel
     * @return the greenscale pixel array.
     */
    public Pixel[][] toGreen()
    {
        for (int h = 0; h < height; h++)
        {
            for (int w = 0; w < width; w++)
            {
                pixel[h][w] = new Pixel(OGpixel[h][w].getRed(), OGpixel[h][w].getGreen(), OGpixel[h][w].getBlue());
                pixel[h][w].toGreen();
            }
        }
        
        return pixel;
    }
    
    /**
     * Convert the OGPixel into bluescale, stored in pixel
     * @return the bluescale pixel array.
     */
    public Pixel[][] toBlue()
    {
        for (int h = 0; h < height; h++)
        {
            for (int w = 0; w < width; w++)
            {
                pixel[h][w] = new Pixel(OGpixel[h][w].getRed(), OGpixel[h][w].getGreen(), OGpixel[h][w].getBlue());
                pixel[h][w].toBlue();
            }
        }
        
        return pixel;
    }
    
    /**
     * @return the oGpixel
     */
    public Pixel[][] getOGpixel()
    {
        return OGpixel;
    }

    /**
     * @return the pixel
     */
    public Pixel[][] getPixel()
    {
        return pixel;
    }

    /**
     * @return the height
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * @return the width
     */
    public int getWidth()
    {
        return width;
    }
}
