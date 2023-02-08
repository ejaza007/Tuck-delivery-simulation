
/**
 * Class creates generic Queue data strucure with First-in-Last-out functionality
 *
 * @author Armaghan Ejaz
 * @version 09-04-2022
 */
public class PriorityQueue <E> 
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

    public void add(E e)
    {
        // Allocate the Node, put in data, set next as null

        Node new_node = new Node(e);

        //If the Linked List is empty, then make the new node as head

        if (head == null)
        {

            head = new Node(e);

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

        int temp=0;
        int i=0;
        
        bubbleSort();
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

    public int size() {
        Node temp=head;
        int counter=1;
        if(temp!=null) {
            while(temp.next!=null) {
                temp=temp.next;
                counter++;
            }
            return counter;

        }
        return 0;
    }

    public void bubbleSort() {

        if (head != null) {

            Node current = null,
            new_head = null,
            move_node = null,
            prev = null;

            while (head != null) {
                prev = null;
                current = head;
                move_node = head;
                while (current != null) {

                    //When current node value is grator than previous node
                    if (current.next != null && (int)current.next.data > (int)move_node.data) {
                        //Swap node values
                        move_node = current.next;
                        prev = current;

                    }
                    current = current.next;
                }
                if (move_node == head) {
                    head = (head).next;
                }

                if (prev != null) {
                    prev.next = move_node.next;
                }
                move_node.next = new_head;
                new_head = move_node;
            }
            //make new head
            head = new_head;

        } else {
            System.out.println("Empty Linked list");
        }
    }

}