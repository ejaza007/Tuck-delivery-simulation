
/**
 * Class creates generic Queue data strucure with First-in-Last-out functionality
 *
 * @author Armaghan Ejaz
 * @version 09-04-2022
 */
public class Queue <E> 
{
    Node <E> head; // head of list
    E returner;

    /**
     * Class creates Nodes used to create a linked list
     *
     * @author Armaghan Ejaz
     * @version 09-04-2022
     */
    class Node<E>
    {
        E data;
        Node next;
        Node(E d) {data = d; next = null; }
    }

    public E add(E e)
    {
        // Allocate the Node, put in data, set next as null

        Node new_node = new Node(e);

        //If the Linked List is empty, then make the new node as head

        if (head == null)
        {

            head = new Node(e);
            return e;
        }

        //This new node is going to be the last node, so
        //make next of it as null
        new_node.next = null;

        //Else traverse till the last node

        Node last = head;
        while (last.next != null)
            last = last.next;

        //Change the next of last node
        last.next = new_node;
        return e;
    }

    public E peek(){
        //returns data in head node
        return head.data;
    }

    public E remove(){
        //sets temp as node
        Node temp = head;
        E returner=head.data;
        // Change head
        head = temp.next;

        return returner;
    }

    /**
     *Method returns the Object at the specified index
     *
     * @param int index
     * 
     * @return E Object
     * 
     */ 
    public E get(int index){
        int i=0;
        //sets current as head
        Node<E> current=head;
        
        //iterates through list
        while(current.next!=null && i!=index) {
            i++;
            current=current.next;

        }

        return current.data;
    }
}