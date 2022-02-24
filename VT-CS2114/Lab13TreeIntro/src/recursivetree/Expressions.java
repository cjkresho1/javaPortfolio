/**
 * 
 */
package recursivetree;

/**
 * @author Charles Kresho
 * @version 2016.4.23
 */
public class Expressions 
{

    /**
     * @param args
     */
    public static void main(String[] args) 
    {
        BinaryTree<String> first = new BinaryTree<String>("d");
        BinaryTree<String> second = new BinaryTree<String>("c");
        BinaryTree<String> third = new BinaryTree<String>("+", second, first);
        BinaryTree<String> fourth = new BinaryTree<String>("e");
        BinaryTree<String> fifth = new BinaryTree<String>("/", third, fourth);
        BinaryTree<String> sixth = new BinaryTree<String>("a");
        BinaryTree<String> seventh = new BinaryTree<String>("b");
        BinaryTree<String> eighth = new BinaryTree<String>("-", sixth, seventh);
        BinaryTree<String> ninth = new BinaryTree<String>("*", eighth, fifth);
    }

}
