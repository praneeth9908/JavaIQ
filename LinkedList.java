class Node{
    int data;
    Node next;


    public Node(int new_data){
        this.data = new_data;
        this.next = null;
    }
}

public class LinkedList {
    private Node head;

    LinkedList(){
        head = null;
    }

    public void insertEnd(int data){
        Node newNode = new Node(data);

        if( head == null ){
            head = newNode;
        }else{
            Node currNode = head;
            while( currNode.next != null ){
                currNode = currNode.next;
            }
            currNode.next = newNode;
        }
    }

    public void insertFront(int data){
        Node newNode = new Node(data);

        if( head == null ){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void insertMiddle(int data, int prevData){
        Node newNode = new Node(data);

        if( head == null ){
            head = newNode;
            return;
        }

        Node currNode = head;
        while( currNode != null && currNode.data != prevData){
            currNode = currNode.next;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
    }

    public void delete(int data){
        if( head == null )return;
        if( head.data == data ){
            head = head.next;
            return;
        }
        Node currNode = head;
        while( currNode.next != null && currNode.next.data != data ){
            currNode = currNode.next;
        }
        currNode.next = currNode.next.next;
    }

    public boolean search(int data){
        Node currNode = head;
        while( currNode != null ){
            if( currNode.data == data )return true;
            currNode = currNode.next;
        }
        return false;
    }

    public void reverse(){
        Node prevNode = null;
        Node currNode = head;
        Node follNode = null;
        while ( currNode != null ) {
            follNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = follNode;
        }
        head = prevNode;
    }

    public void display(){
        Node currNode = head;
        while( currNode != null){
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("Null");
    }
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertEnd(1);
        ll.insertEnd(2);
        ll.insertEnd(3);
        ll.insertEnd(4);

        System.out.println("Original LinkedList :");
        ll.display();

        ll.reverse();
        System.out.println("Reversed LinkedList :");
        ll.display();

        ll.insertEnd(5);
        System.out.println("Updated LinkedList :");
        ll.display();

        ll.delete(4);
        System.out.println("Front Deletion :");
        ll.display();

        ll.delete(5);
        System.out.println("End Deletion :");
        ll.display();

        ll.delete(2);
        System.out.println("Middle Deletion :");
        ll.display();

        if(ll.search(3))System.out.println("3 is Present");
        if(ll.search(1))System.out.println("1 is Present");
        ll.insertEnd(6);
        if(ll.search(1))System.out.println("1 is Present");

        ll.insertFront(7);
        System.out.println("Front Insertion LinkedList :");
        ll.display();

        ll.insertMiddle(8, 1);
        System.out.println("Middle Insertion LinkedList :");
        ll.display();
    }
    
}
