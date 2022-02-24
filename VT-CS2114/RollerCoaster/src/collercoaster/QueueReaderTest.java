/**
 * 
 */
package collercoaster;

import student.TestCase;

/**
 * @author Charles Kresho
 * @version 2016.4.7
 */
public class QueueReaderTest extends TestCase 
{
    /**
     * Tests everything there is to do with QueueReader and the whole program
     */
    public void setUp()
    {
        new QueueReader("input.txt");
        new QueueReader("input2.txt");
        new QueueReader("input3.txt");
        new QueueReader("input4.txt");
    }
}
