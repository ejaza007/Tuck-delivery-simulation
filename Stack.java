/**
 * Class creates generic Stack data strucure with First-in-First-out functionality
 *
 * @author Armaghan Ejaz
 * @version 09-04-2022
 */
public class Stack <E> 
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
    
    public Stack(){
        
    }

    public boolean empty(){
        //condition for empty head
        if(head==null) {
            return true;
        }
        return false;
    }

    public E peek(){
        //returns data of head
        E returner=head.data;
        return returner;

    }

    public E pop(){
        //sets data of head to variabe
        E returner=head.data;
        // Change head
        Node temp=head;
        head = temp.next; 

        return returner;
    }

    public E push(E item){
        // Allocate the Node
        //Put in the data
        Node new_node = new Node(item);

        if (head == null)
        {
            head = new Node(item);
            head.next=null;
            return item;
        }

        //Make next of new Node as head
        new_node.next = head;

        //Move the head to point to new Node
        head = new_node;

        return item;
    }

    public int search(E o){
        //sets temo to head
        Node temp=head;
        //counter for distance
        int counter=1;
        E search=o;
        //iterates through list
        while(temp.next!=null && temp.data!=search){
            counter++;
            temp=temp.next;

        }
        //condition if object does not exist
        if(temp.next==null && temp.data!=search){
            return -1;
        }
        return counter;

    }
}