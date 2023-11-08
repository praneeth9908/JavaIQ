public class Stack {
    private int size;
    private int[] stack;
    private int top;

    Stack(int size){
        this.size = size;
        this.stack = new int[size];
        this.top = -1;
    }

    public void push(int val){
        if(isFull()){
            System.out.println("Stack is Full");
        }
        else{
            stack[++top] = val;
        }
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        else{
            return stack[top--]; 
        }
    }
    
    public int peak(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        else{
            return stack[top]; 
        }
    }


    public boolean isEmpty(){
        if(top == -1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(top == size-1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Pop Element:- "+stack.pop());
        System.out.println("Peak Element:- "+stack.peak());

        stack.push(4);
        stack.push(5);

        System.out.println("Peak Element:- "+stack.peak());
        System.out.println("Pop Element:- "+stack.pop());
        System.out.println("Peak Element:- "+stack.peak());

    }
}
