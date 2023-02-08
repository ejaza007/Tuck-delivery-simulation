
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

/**
 * The test class MyStackTest.
 *
 * @author  Armaghan Ejaz
 * @version 04-09-2022
 */
public class MyStackTest
{
    /**
     * Default constructor for test class MyStackTest
     */
    public MyStackTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    /**
    * Tests push and peek method by pushing objects in front of the stack
    * and using peek to retrieve the head
    *
    */
    @Test
    @DisplayName("Test method1.")
    public void test_meth_peek_push(){
        //standard test for peek
        //uses push to make new head

        Stack<Integer> intStack=new Stack<Integer>();

        boolean errorCaught= false;

        //test for null value
        try{
            intStack.peek();
        }
        catch(NullPointerException e){
            errorCaught=true;
        }
        assertTrue(errorCaught);

        //tests for when something is added to front of the stack
        intStack.push(1);
        assertEquals(1,intStack.peek());

        intStack.push(2);
        assertEquals(2,intStack.peek());

        intStack.push(3);
        assertEquals(3,intStack.peek());

     Stack<String> stringStack=new Stack<String>();

        errorCaught= false;

        //test for null value
        try{
            stringStack.peek();
        }
        catch(NullPointerException e){
            errorCaught=true;
        }
        assertTrue(errorCaught);

        //standard test
        //adds new values and checks the first one
        stringStack.push("a");
        assertEquals("a",stringStack.peek());

        stringStack.push("b");
        assertEquals("b",stringStack.peek());

        stringStack.push("c");
        assertEquals("c",stringStack.peek());

        Stack<Float> floatStack=new Stack<Float>();

        errorCaught= false;

        //test for null value
        try{
            floatStack.peek();
        }
        catch(NullPointerException e){
            errorCaught=true;
        }
        assertTrue(errorCaught);

        //adds new values and checks the first one
        Float var1=(float)1.0;
        floatStack.push(var1);
        assertEquals(var1,floatStack.peek());

        Float var2=(float)2.0;
        floatStack.push(var2);
        assertEquals(var2,floatStack.peek());

        Float var3=(float)3.0;
        floatStack.push(var3);
        assertEquals(var3,floatStack.peek());

    }

    /**
    * Tests pop method by removing the head and returning it and checking that the removed head is
    * equak to what was expected
    *
    */
    @Test
    @DisplayName("Test method2.")
    public void test_meth_pop(){
        boolean errorCaught=false;

        //uses push to make new head

        Stack<Integer> intStack=new Stack<Integer>();

        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        //removes head and returns value
        assertEquals(3,intStack.pop());
        assertEquals(2,intStack.pop());
        assertEquals(1,intStack.pop());

        //test for when nothing to be removed
        try{
            intStack.pop();
        }
        catch(NullPointerException e){
            errorCaught=true;
        }
        assertTrue(errorCaught);

        Stack<String> stringStack=new Stack<String>();
        //uses push to make new head
        stringStack.push("a");
        stringStack.push("b");
        stringStack.push("c");

        //removes head and returns value
        assertEquals("c",stringStack.pop());
        assertEquals("b",stringStack.pop());
        assertEquals("a",stringStack.pop());

        //test for when nothing to be removed
        try{
            stringStack.pop();
        }
        catch(NullPointerException e){
            errorCaught=true;
        }
        assertTrue(errorCaught);

        Stack<Float> floatStack=new Stack<Float>();

        Float var1=(float)1.0;
        floatStack.push(var1);
        Float var2=(float)2.0;
        floatStack.push(var2);
        Float var3=(float)3.0;
        floatStack.push(var3);

        //removes head and returns value
        assertEquals(var3,floatStack.pop());
        assertEquals(var2,floatStack.pop());
        assertEquals(var1,floatStack.pop());

        //test for when nothing can be removed
        try{
            floatStack.pop();
        }
        catch(NullPointerException e){
            errorCaught=true;
        }
        assertTrue(errorCaught);

    }

    /**
    * Tests empty method by testing empty and non-empty stacks
    *
    */
    @Test
    @DisplayName("Test method3.")
    public void test_meth_empty(){
        Stack<Integer> intStack=new Stack<Integer>();

        //test when list is empty
        assertTrue(intStack.empty());

        //test when something is added in the list
        intStack.push(1);
        assertFalse(intStack.empty());

        Stack<Float> floatStack=new Stack<Float>();

        //test when list is empty
        assertTrue(floatStack.empty());

        //test when something is added in the list
        float var=(float)1.0;
        floatStack.push(var);
        assertFalse(floatStack.empty());

        Stack<String> stringStack=new Stack<String>();

        //test when list is empty
        assertTrue(stringStack.empty());

        //test when something is added in the list
        stringStack.push("one");
        assertFalse(stringStack.empty());

    }

    /**
    * Tests search method by adding objects and comparing the expected distance from the head to the returned distance
    *
    */
    @Test
    @DisplayName("Test method4.")
    public void test_meth_search(){
        Stack<Integer> intStack=new Stack<Integer>();

        //adds objects to the stack
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        //test for search method when Object is found
        assertEquals(3,intStack.search(1));
        assertEquals(2,intStack.search(2));
        assertEquals(1,intStack.search(3));
        //test for when desired obbject is not in the stack
        assertEquals(-1,intStack.search(4));

        Stack<String> stringStack=new Stack<String>();

        //adds objects to the stack
        stringStack.push("a");
        stringStack.push("b");
        stringStack.push("c");

        //test for search method when Object is found
        assertEquals(3,stringStack.search("a"));
        assertEquals(2,stringStack.search("b"));
        assertEquals(1,stringStack.search("c"));
        //test for when desired obbject is not in the stack
        assertEquals(-1,stringStack.search("d"));

        Stack<Float> floatStack=new Stack<Float>();

        //adds objects to the stack
        Float var1=(float)1.0;
        floatStack.push(var1);
        Float var2=(float)2.0;
        floatStack.push(var2);
        Float var3=(float)3.0;
        floatStack.push(var3);
        Float var4=(float)4.0;

        //test for search method when Object is found
        assertEquals(3,floatStack.search(var1));
        assertEquals(2,floatStack.search(var2));
        assertEquals(1,floatStack.search(var3));
        //test for when desired obbject is not in the stack
        assertEquals(-1,floatStack.search(var4));

    }
}

