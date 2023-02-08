
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

/**
 * The test class MyQueueTest.
 *
 * @author  Armaghan Ejaz
 * @version 04-09-2022
 */
public class MyQueueTest
{
    /**
     * Default constructor for test class MyQueueTest
     */
    public MyQueueTest()
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
    * Tests add method by using the get method
    *
    */
    @Test
    @DisplayName("Test method1.")
    public void test_meth_add(){
        //standard test for add
        //uses add to attach new node at the back

        Queue<Integer> intQueue=new Queue<Integer>();
        intQueue.add(1);
        intQueue.add(2);
        intQueue.add(3);

        //uses get method to determine data 
        assertEquals(1,intQueue.get(0));
        assertEquals(2,intQueue.get(1));
        assertEquals(3,intQueue.get(2));

        Queue<Float> floatQueue=new Queue<Float>();
        Float var=(float)1.0;
        Float var2=(float)2.0;
        Float var3=(float)3.0;
        Float var4=(float)4.0;

        floatQueue.add(var);
        floatQueue.add(var2);
        floatQueue.add(var3);
        floatQueue.add(var4);

        //uses get method to determine data 
        assertTrue(floatQueue.get(0)==1.0);
        assertTrue(floatQueue.get(1)==2.0);
        assertTrue(floatQueue.get(2)==3.0);

        Queue<String> stringQueue=new Queue<String>();
        stringQueue.add("one");
        stringQueue.add("two");
        stringQueue.add("three");
        stringQueue.add("four");

        //uses get method to determine data 
        assertEquals("one",stringQueue.get(0));
        assertEquals("two",stringQueue.get(1));
        assertEquals("three",stringQueue.get(2));
        assertEquals("four",stringQueue.get(3));

    }

    /**
    * Tests remove method by using the get method
    *
    */
    @Test
    @DisplayName("Test method2.")
    public void test_meth_remove(){
        //standard test for remove
        //uses add to attach new node at the back

        Queue<Integer> intQueue=new Queue<Integer>();

        //boolean to test NullPointerException
        boolean errorCaught=false;

        //test for when nothing to be removed
        try{
            intQueue.remove();
        }
        catch(NullPointerException e){
            errorCaught=true;
        }
        assertTrue(errorCaught);

        //standard test removes added nodes
        intQueue.add(1);
        intQueue.add(2);
        intQueue.add(3);

        assertEquals(1,intQueue.get(0));
        intQueue.remove();
        assertEquals(2,intQueue.get(0));
        intQueue.remove();
        assertEquals(3,intQueue.get(0));

        Queue<Float> floatQueue=new Queue<Float>();

        errorCaught=false;
        //test for when nothing to be removed
        try{
            floatQueue.remove();
        }
        catch(NullPointerException e){
            errorCaught=true;
        }
        assertTrue(errorCaught);

        Float var=(float)1.0;
        Float var2=(float)2.0;
        Float var3=(float)3.0;
        Float var4=(float)4.0;

        floatQueue.add(var);
        floatQueue.add(var2);
        floatQueue.add(var3);
        floatQueue.add(var4);
        //standard test removes added nodes
        assertTrue(floatQueue.get(0)==1.0);
        floatQueue.remove();
        assertTrue(floatQueue.get(0)==2.0);
        floatQueue.remove();
        assertTrue(floatQueue.get(0)==3.0);

        Queue<String> stringQueue=new Queue<String>();
        errorCaught=false;
        //test for when nothing to be removed
        try{
            stringQueue.remove();
        }
        catch(NullPointerException e){
            errorCaught=true;
        }
        assertTrue(errorCaught);

        stringQueue.add("one");
        stringQueue.add("two");
        stringQueue.add("three");
        //standard test removes added nodes
        assertEquals("one",stringQueue.get(0));
        stringQueue.remove();
        assertEquals("two",stringQueue.get(0));
        stringQueue.remove();
        assertEquals("three",stringQueue.get(0));

    }

    /**
    * Tests peek method by checking added objects 
    *
    */
    @Test
    @DisplayName("Test method3.")
    public void test_meth_peek(){

        Queue<Integer> intQueue=new Queue<Integer>();
        boolean errorCaught=false;

        //for testing when node is empty
        try{
            intQueue.peek();
        }
        catch(NullPointerException e){
            errorCaught=true;
        }
        assertTrue(errorCaught);

        //standard test by adding objects and retrieving them
        intQueue.add(1);
        intQueue.add(2);

        assertEquals(1,intQueue.peek());

        Queue<Float> floatQueue=new Queue<Float>();
        errorCaught=false;

        //for testing when node is empty
        try{
            floatQueue.peek();
        }
        catch(NullPointerException e){
            errorCaught=true;
        }
        assertTrue(errorCaught);

        Float var=(float)1.0;
        Float var2=(float)2.0;

        floatQueue.add(var);
        floatQueue.add(var2);

        //standard test by adding objects and retrieving them
        assertTrue(1.0==floatQueue.peek());

        Queue<String> stringQueue=new Queue<String>();
        errorCaught=false;

        //for testing when node is empty
        try{
            stringQueue.peek();
        }
        catch(NullPointerException e){
            errorCaught=true;
        }
        assertTrue(errorCaught);

        stringQueue.add("one");
        stringQueue.add("two");
        stringQueue.add("three");
        stringQueue.add("four");

        //standard test by adding objects and retrieving them
        assertEquals("one",stringQueue.peek());

    }
}

