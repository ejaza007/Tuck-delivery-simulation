
/**
 * LCLinkedList class  creates a linked list of any class
 *
 * @author Armaghan Ejaz
 * @version 22 feb 2022
 */

public class LCLinkedList <E> {
    // A complete working Java program to demonstrate all insertion methods
    // on linked list

    Node <E> head; // head of list
    private Node<E> counter;
    E returner;

    /**
     * Constructor for objects of class IntLinkedList
     *
     *
     */

    public LCLinkedList(){

    }
    /* Linked list Node*/
    /**
     * Constructor for objects of class Node
     *
     *
     */

    class Node<E>
    {
        E data;
        Node next;
        Node(E d) {data = d; next = null; }
    }

    /* Inserts a new Node at front of the list. */
    /**
     * An example of a method - adds new head to the list
     *
     * @param integer(2)

     */

    public void push(  E new_data)
    {
        /* 1 & 2: Allocate the Node &
        Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /**
     * An example of a method - append the list
     *
     * @param  integer(2)

     */

    public void add(E e)
    {
        /* 1. Allocate the Node &
        2. Put in the data
        3. Set next as null */
        Node new_node = new Node(e);

        /* 4. If the Linked List is empty, then make the
        new node as head */
        if (head == null)
        {
            head = new Node(e);
            return;
        }

        /* 4. This new node is going to be the last node, so
        make next of it as null */
        new_node.next = null;

        /* 5. Else traverse till the last node */
        Node last = head;
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = new_node;
        return;
    }

    /**
     * An example of a method - append the list
     *
     * @param integer(2,2)

     */

    public void add(int index,E e) {
        /* 1. Allocate the Node &
        2. Put in the data
        3. Set next as null */
        Node new_node = new Node(e);
        int i=0;
        Node current=head;
        /* 4. If the Linked List is empty, then make the
        new node as head */
        if (head == null)
        {
            head = new Node(e);
            return;
        }

        while(current.next!=null && i!=index) {
            current=current.next;
            i++;
        }

        Node temp=current.next;

        current.next=new_node;
        new_node.next=temp;

    }

    /**
     * An example of a method - clear the list
     *
     * 

     */

    public void clear(){
        head=null;

    }

    /**
     * An example of a method - check if the list is empty
     *
     * @return true/false

     */

    public boolean isEmpty(){
        if(head==null) {
            return true;
        }
        return false;
    }

    /**
     * An example of a method - remove from the list
     *
     * @param  integer(2)

     */

    public E remove(int index) {
        if (head == null){
            return returner ;
        }

        // Store head node
        Node temp = head;

        // If head needs to be removed
        if (index == 0) {
            returner=head.data;
            head = temp.next; // Change head
        
            return returner;
        }

        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < index - 1;
        i++) {
            temp = temp.next;
        }

        // If position is more than number of nodes
        if (temp == null || temp.next == null) {
            return returner;
        }

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        temp.next.data=returner;
        Node next = temp.next.next;

        temp.next = next;

        return returner;
    }

    /**
     * An example of a method - returns size of the list
     *
     * @return  size of the list

     */

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

    /**
     * An example of a method - returns size
     *
     * @return  size of the list

     */

    public int array_size() {
        Node temp=head;
        int counter=0;
        while(temp.next!=null) {
            temp=temp.next;
            counter++;
        }
        return counter;
    }

    /**
     * An example of a method - obtain value at given index
     *
     * @param  integer(2)
     * @return  the value of the node at the given index
     */
    public E get(int index){
        int i=0;
        Node<E> current=head;

        while(current.next!=null && i!=index) {
            i++;
            current=current.next;

        }

        return current.data;
    }
    }
