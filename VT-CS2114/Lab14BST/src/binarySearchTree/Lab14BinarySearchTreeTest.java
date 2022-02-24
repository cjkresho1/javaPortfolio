/**
 * 
 */
package binarySearchTree;

import student.TestCase;

/**
 * @author Charles Kresho (cjkresho)
 * @version 2016.4.29
 */
public class Lab14BinarySearchTreeTest extends TestCase
{
    private Lab14BinarySearchTree<Integer> empty;
    
    /**
     * Sets up the fields for each test
     */
    public void setUp()
    {
        empty = new Lab14BinarySearchTree<Integer>();
    }
    
    /**
     * Tests insert(T)
     */
    public void testInsert()
    {
        setUp();
        assertEquals("()", empty.toString());
        empty.insert(1);
        assertEquals("(1)", empty.toString());
        empty.insert(2);
        assertEquals("(1, 2)", empty.toString());
        empty.insert(3);
        assertEquals("(1, 2, 3)", empty.toString());
        empty.insert(4);
        assertEquals("(1, 2, 3, 4)", empty.toString());
        empty.insert(-1);
        assertEquals("(-1, 1, 2, 3, 4)", empty.toString());
        empty.insert(20);
        assertEquals("(-1, 1, 2, 3, 4, 20)", empty.toString());
    }
    
    /**
     * Tests remove(T);
     */
    public void testRemove()
    {
        setUp();
        //removes the root of an empty tree
        assertEquals("()", empty.toString());
        empty.insert(1);
        assertEquals("(1)", empty.toString());
        empty.remove(1);
        assertEquals("()", empty.toString());
        
        //removes the root of a tree with a left leaf
        setUp();
        assertEquals("()", empty.toString());
        empty.insert(5);
        empty.insert(2);
        assertEquals("(2, 5)", empty.toString());
        empty.remove(5);
        assertEquals("(2)", empty.toString());
        
        //removes the root of a tree with a right leaf
        setUp();
        assertEquals("()", empty.toString());
        empty.insert(5);
        empty.insert(7);
        assertEquals("(5, 7)", empty.toString());
        empty.remove(5);
        assertEquals("(7)", empty.toString());
        
        //removes the left leaf of the root
        setUp();
        assertEquals("()", empty.toString());
        empty.insert(5);
        empty.insert(2);
        assertEquals("(2, 5)", empty.toString());
        empty.remove(2);
        assertEquals("(5)", empty.toString());
        
        //removes the right leaf of the root
        setUp();
        assertEquals("()", empty.toString());
        empty.insert(5);
        empty.insert(7);
        assertEquals("(5, 7)", empty.toString());
        empty.remove(7);
        assertEquals("(5)", empty.toString());
        
        //removes the left leaf of the root that has two children with their 
        //own children
        setUp();
        assertEquals("()", empty.toString());
        empty.insert(8);
        empty.insert(4);
        empty.insert(2);
        empty.insert(1);
        empty.insert(3);
        empty.insert(6);
        empty.insert(5);
        empty.insert(7);
        assertEquals("(1, 2, 3, 4, 5, 6, 7, 8)", empty.toString());
        empty.remove(4);
        assertEquals("(1, 2, 3, 5, 6, 7, 8)", empty.toString());
        
        //removes the right leaf of the root that has two children with their
        //own children
        setUp();
        assertEquals("()", empty.toString());
        empty.insert(8);
        empty.insert(12);
        empty.insert(14);
        empty.insert(15);
        empty.insert(13);
        empty.insert(10);
        empty.insert(9);
        empty.insert(11);
        assertEquals("(8, 9, 10, 11, 12, 13, 14, 15)", empty.toString());
        empty.remove(12);
        assertEquals("(8, 9, 10, 11, 13, 14, 15)", empty.toString());
    }
    
    /**
     * Tests findMin()
     */
    public void testFindMin()
    {
        setUp();
        assertEquals("()", empty.toString());
        assertNull(empty.findMin());
        empty.insert(1);
        assertEquals("(1)", empty.toString());
        assertEquals(1, empty.findMin().intValue());
        empty.insert(2);
        assertEquals("(1, 2)", empty.toString());
        assertEquals(1, empty.findMin().intValue());
        empty.insert(3);
        assertEquals("(1, 2, 3)", empty.toString());
        assertEquals(1, empty.findMin().intValue());
        empty.insert(4);
        assertEquals("(1, 2, 3, 4)", empty.toString());
        assertEquals(1, empty.findMin().intValue());
        empty.insert(-1);
        assertEquals("(-1, 1, 2, 3, 4)", empty.toString());
        assertEquals(-1, empty.findMin().intValue());
        empty.insert(20);
        assertEquals("(-1, 1, 2, 3, 4, 20)", empty.toString());
        assertEquals(-1, empty.findMin().intValue());
    }
    
    /**
     * Tests findMax()
     */
    public void testFindMax()
    {
        setUp();
        assertEquals("()", empty.toString());
        assertNull(empty.findMax());
        empty.insert(1);
        assertEquals("(1)", empty.toString());
        assertEquals(1, empty.findMax().intValue());
        empty.insert(2);
        assertEquals("(1, 2)", empty.toString());
        assertEquals(2, empty.findMax().intValue());
        empty.insert(3);
        assertEquals("(1, 2, 3)", empty.toString());
        assertEquals(3, empty.findMax().intValue());
        empty.insert(4);
        assertEquals("(1, 2, 3, 4)", empty.toString());
        assertEquals(4, empty.findMax().intValue());
        empty.insert(-1);
        assertEquals("(-1, 1, 2, 3, 4)", empty.toString());
        assertEquals(4, empty.findMax().intValue());
        empty.insert(20);
        assertEquals("(-1, 1, 2, 3, 4, 20)", empty.toString());
        assertEquals(20, empty.findMax().intValue());
    }
    
    /**
     * Tests find(T)
     */
    public void testFind()
    {
        setUp();
        assertNull(empty.find(1));
    }
    
    /**
     * Tests makeEmpty()
     */
    public void testMakeEmpty()
    {
        setUp();
        assertTrue(empty.isEmpty());
        empty.insert(1);
        assertFalse(empty.isEmpty());
        empty.insert(27);
        assertFalse(empty.isEmpty());
        empty.makeEmpty();
        assertTrue(empty.isEmpty());
    }
    
    /**
     * Tests isEmpty()
     */
    public void testIsEmpty()
    {
        setUp();
        assertTrue(empty.isEmpty());
        empty.insert(1);
        assertFalse(empty.isEmpty());
        empty.insert(27);
        assertFalse(empty.isEmpty());
        empty.makeEmpty();
        assertTrue(empty.isEmpty());
    }
}
