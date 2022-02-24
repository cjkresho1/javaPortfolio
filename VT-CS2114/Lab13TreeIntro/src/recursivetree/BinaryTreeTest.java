/**
 * 
 */
package recursivetree;

import student.TestCase;

/**
 * @author Charles Kresho (cjkresho)
 * @version 2016.4.22
 */
public class BinaryTreeTest extends TestCase 
{
    private BinaryTree<String> one;
    private BinaryTree<String> two;
    private BinaryTree<String> three;
    private BinaryTree<String> four;
    private BinaryTree<String> five;
    private BinaryTree<String> six;
    private BinaryTree<String> seven;
    private BinaryTree<String> special;
    private BinaryTree<String> a;
    private BinaryTree<String> b;
    private BinaryTree<String> c;
    
    /**
     * Sets up the Trees for testing
     */
    public void setUp()
    {

        BinaryTree<String> fourSubLeft;
        BinaryTree<String> fiveSubLeft;
        BinaryTree<String> sixSubRight;
        BinaryTree<String> sevenSubRight;
        BinaryTree<String> d;
        BinaryTree<String> e;
        BinaryTree<String> f;
        BinaryTree<String> g;
        a = new BinaryTree<String>("A");
        b = new BinaryTree<String>("B");
        c = new BinaryTree<String>("C");
        d = new BinaryTree<String>("D");
        e = new BinaryTree<String>("E");
        f = new BinaryTree<String>("F");
        g = new BinaryTree<String>("G");
        one = new BinaryTree<String>("A", null, null);
        two = new BinaryTree<String>("A", b, null);
        three = new BinaryTree<String>("A", b, c);
        fourSubLeft = new BinaryTree<String>("B", d, null);
        fiveSubLeft = new BinaryTree<String>("B", d, e);
        sixSubRight = new BinaryTree<String>("C", f, null);
        sevenSubRight = new BinaryTree<String>("C", f, g);
        four = new BinaryTree<String>("A", fourSubLeft, c);
        five = new BinaryTree<String>("A", fiveSubLeft, c);
        six = new BinaryTree<String>("A", fiveSubLeft, sixSubRight);
        seven = new BinaryTree<String>("A", fiveSubLeft, sevenSubRight);
        special = new BinaryTree<String>("A", null, sevenSubRight);
    }
    
    /**
     * Tests getElement()
     */
    public void testGetElement()
    {
        setUp();
        assertEquals(a.getElement(), "A");
        assertEquals(b.getElement(), "B");
        assertEquals(c.getElement(), "C");
        assertEquals(one.getElement(), "A");
        assertEquals(two.getElement(), "A");
        assertEquals(three.getElement(), "A");
    }
    
    /**
     * Tests setElement(T)
     */
    public void testSetElement()
    {
        setUp();
        assertEquals(a.getElement(), "A");
        assertEquals(b.getElement(), "B");
        assertEquals(c.getElement(), "C");
        assertEquals(one.getElement(), "A");
        assertEquals(two.getElement(), "A");
        assertEquals(three.getElement(), "A");
        a.setElement("D");
        b.setElement("E");
        c.setElement("F");
        one.setElement("G");
        two.setElement("H");
        three.setElement("I");
        assertEquals(a.getElement(), "D");
        assertEquals(b.getElement(), "E");
        assertEquals(c.getElement(), "F");
        assertEquals(one.getElement(), "G");
        assertEquals(two.getElement(), "H");
        assertEquals(three.getElement(), "I");
    }
    
    /**
     * Tests getLeft()
     */
    public void testGetLeft()
    {
        setUp();
        assertNull(one.getLeft());
        assertEquals(b, two.getLeft());
        assertEquals(b, three.getLeft());
    }
    
    /**
     * Tests setLeft(BiniaryTree<T>)
     */
    public void testSetLeft()
    {
        setUp();
        assertNull(one.getLeft());
        assertEquals(b, two.getLeft());
        assertEquals(b, three.getLeft());
        one.setLeft(c);
        three.setLeft(a);
        two.setLeft(b);
        assertEquals(c, one.getLeft());
        assertEquals(b, two.getLeft());
        assertEquals(a, three.getLeft());
    }
    
    /**
     * Tests getRight()
     */
    public void testGetRight()
    {
        setUp();
        assertNull(one.getRight());
        assertNull(two.getRight());
        assertEquals(c, three.getRight());
    }
    
    /**
     * Tests setRight(BinaryTree<T>)
     */
    public void testSetRight()
    {
        setUp();
        assertNull(one.getRight());
        assertNull(two.getRight());
        assertEquals(c, three.getRight());
        one.setRight(a);
        two.setRight(c);
        three.setRight(b);
        assertEquals(a, one.getRight());
        assertEquals(c, two.getRight());
        assertEquals(b, three.getRight());
    }
    
    /**
     * Tests size()
     */
    public void testSize()
    {
        setUp();
        assertEquals(1, one.size());
        assertEquals(2, two.size());
        assertEquals(3, three.size());
        assertEquals(4, four.size());
        assertEquals(5, five.size());
        assertEquals(6, six.size());
        assertEquals(7, seven.size());
        assertEquals(4, special.size());
    }
    
    /**
     * Tests height()
     */
    public void testHeight()
    {
        setUp();
        assertEquals(1, one.height());
        assertEquals(2, two.height());
        assertEquals(2, three.height());
        assertEquals(3, four.height());
        assertEquals(3, five.height());
        assertEquals(3, six.height());
        assertEquals(3, seven.height());
        assertEquals(3, special.height());
    }
    
    /**
     * Tests toPreOrderString()
     */
    public void testToPreOrderString()
    {
        setUp();
        assertEquals("(A)", one.toPreOrderString());
        assertEquals("(A(B))", two.toPreOrderString());
        assertEquals("(A(B)(C))", three.toPreOrderString());
        assertEquals("(A(B(D))(C))", four.toPreOrderString());
        assertEquals("(A(B(D)(E))(C))", five.toPreOrderString());
        assertEquals("(A(B(D)(E))(C(F)))", six.toPreOrderString());
        assertEquals("(A(B(D)(E))(C(F)(G)))", seven.toPreOrderString());
    }
    
    /**
     * Tests toInOrderString()
     */
    public void testToInOrderString()
    {
        setUp();
        assertEquals("(A)", one.toInOrderString());
        assertEquals("((B)A)", two.toInOrderString());
        assertEquals("((B)A(C))", three.toInOrderString());
        assertEquals("(((D)B)A(C))", four.toInOrderString());
        assertEquals("(((D)B(E))A(C))", five.toInOrderString());
        assertEquals("(((D)B(E))A((F)C))", six.toInOrderString());
        assertEquals("(((D)B(E))A((F)C(G)))", seven.toInOrderString());
    }
    
    /**
     * Tests toPostOrderString()
     */
    public void testToPostOrderString()
    {
        setUp();
        assertEquals("(A)", one.toPostOrderString());
        assertEquals("((B)A)", two.toPostOrderString());
        assertEquals("((B)(C)A)", three.toPostOrderString());
        assertEquals("(((D)B)(C)A)", four.toPostOrderString());
        assertEquals("(((D)(E)B)(C)A)", five.toPostOrderString());
        assertEquals("(((D)(E)B)((F)C)A)", six.toPostOrderString());
        assertEquals("(((D)(E)B)((F)(G)C)A)", seven.toPostOrderString());
    }
}
