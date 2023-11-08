public class Queue {
    private int maxSize;
    private int[] queue;
    private int front;
    private int rear;
    private int currentSize;

    Queue(int size){
        this.maxSize = size;
        this.queue = new int[size];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }

    public void enqueue(int val){
        if(isFull()){
            System.out.println("Queue is Full");
            return;
        }else{
            if(rear == maxSize-1)rear=-1;
            queue[++rear] = val;
            currentSize++;
        }
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }else{
            int dequeuedElement = queue[front++];
            if(front == maxSize)front = 0;
            currentSize--;
            return dequeuedElement;
        }
    }

    public int frontElement(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }else{
            return queue[front];
        }
    }

    public int rearElement(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }else{
            return queue[rear];
        }
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public boolean isFull(){
        return currentSize == maxSize;
    }

    public static void main(String[] args) {
        
        Queue queue = new Queue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("FrontElement:- "+queue.frontElement());
        System.out.println("rearElement:- "+queue.rearElement());

        System.out.println("dequeuedElement:- "+queue.dequeue());
        System.out.println("dequeuedElement:- "+queue.dequeue());       
        
        System.out.println("FrontElement:- "+queue.frontElement());
        System.out.println("rearElement:- "+queue.rearElement());

        queue.enqueue(6);
        queue.enqueue(7);
       
        System.out.println("FrontElement:- "+queue.frontElement());
        System.out.println("rearElement:- "+queue.rearElement());

        System.out.println("dequeuedElement:- "+queue.dequeue());
        System.out.println("dequeuedElement:- "+queue.dequeue());
        System.out.println("dequeuedElement:- "+queue.dequeue());
        System.out.println("dequeuedElement:- "+queue.dequeue());
        System.out.println("dequeuedElement:- "+queue.dequeue());
        System.out.println("dequeuedElement:- "+queue.dequeue());

        System.out.println("FrontElement:- "+queue.frontElement());
        System.out.println("rearElement:- "+queue.rearElement());

    }
}
