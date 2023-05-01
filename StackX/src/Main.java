// This is a class for implementing a stack data structure
class StackX
{
    private int maxSize;        // maximum size of the stack
    private long[] stackArray;  // array to hold the stack elements
    private int top;            // index of the top element in the stack

    // Constructor to initialize the stack
    public StackX(int s)
    {
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }

    // Method to add an element to the top of the stack
    public void push(int i)
    {
        stackArray[++top] = i;
    }

    // Method to remove an element from the top of the stack
    public long pop()
    {
        return stackArray[top--];
    }

    // Method to peek at the top element of the stack
    public long peek()
    {
        return stackArray[top];
    }

    // Method to check if the stack is empty
    public boolean isEmpty()
    {
        return (top == -1);
    }

    // Method to check if the stack is full
    public boolean isFull()
    {
        return (top == maxSize-1);
    }
}

// This is a class for implementing a queue data structure
class Queue
{
    private int maxSize;        // maximum size of the queue
    private long[] queArray;    // array to hold the queue elements
    private int front;          // index of the front element in the queue
    private int rear;           // index of the rear element in the queue
    private int nItems;         // number of elements in the queue

    // Constructor to initialize the queue
    public Queue(int s)
    {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    // Method to add an element to the rear of the queue
    public void insert(long j)
    {
        if(rear == maxSize-1)
            rear = -1;
        queArray[++rear] = j;
        nItems++;
    }

    // Method to remove an element from the front of the queue
    public long remove()
    {
        long temp = queArray[front++];
        if(front == maxSize)
            front = 0;
        nItems--;
        return temp;
    }

    // Method to get the element at a specific position in the queue
    public long itemAtOrder(int k) {

        if(k <= 0) {
            System.out.println("Error");
            return -1;
        }
        if(k > nItems){
            System.out.println("Error");
            return -1;
        }

        long temp = queArray[k-1];
        return temp;

    }

    // Method to get the position of a specific element in the queue
    public long orderOfItem(long N){

        int m = 0;
        int i;
        for(i=0 ; i<nItems ; i++)
            if(queArray[i] == N) {
                m = i+1;
                return m;
            }
        System.out.println("Error");
        return -1;
    }

    // Method to peek at the front element of the queue
    public long peekFront()
    {
        return queArray[front];
    }

    // Method to check if the queue is empty
    public boolean isEmpty()
    {
        return (nItems==0);
    }

    // Method to check if the queue is full
    public boolean isFull()
    {
        return (nItems==maxSize);
    }

    // Method to get the number of elements in the queue
    public int size()
    {
        return nItems;
    }
}

// This is a class for implementing a priority queue data structure
class PriorityQ
{
    private int maxSize;        // maximum size of the priority queue
    private long[] queArray;    // array to hold the priority queue elements
    private int nItems;         // number of elements in the priority queue

    // Constructor to initialize the priority queue
    public PriorityQ(int s)
    {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }

    // Method to add an element to the priority queue
    public void insert(long item)
    {
        queArray[nItems++] = item;
    }

    // Method to remove the minimum element from the priority queue
    public long remove()
    {
        long min;
        for(int i=0; i<nItems-1; i++){
            if(queArray[i] < queArray[i+1])
            {
                min = queArray[i];
                queArray[i] = queArray[i+1];
                queArray[i+1] = min;
            }
        }
        return queArray[--nItems];
    }

    // Method to peek at the minimum element in the priority queue
    public long peekMin()
    {
        return queArray[nItems-1];
    }

    // Method to check if the priority queue is empty
    public boolean isEmpty()
    {
        return (nItems==0);
    }

    // Method to check if the priority queue is full
    public boolean isFull()
    {
        return (nItems == maxSize);
    }
}
// This is the main class that contains the main method
class Main
{
    // The main method is the entry point of the program
    public static void main(String[] args) {
        // Create a queue object with a capacity of 5
        Queue theQueue = new Queue(5);
        // Create a matcher object
        Main matcher = new Main();

        // Test the matchIfElse method with different arrays
        String[] arr1 = {"if", "else", "else", "if", "if", "else", "else"};
        String[] arr2 = {"if","for","while","else","if","else"};
        String[] arr3 = {"if","if","else","for","if", "if", "else"};
        String[] arr4 = {"for","if","while","else","else","for","if","while","if"};

        matcher.matchIfElse(arr1);
        System.out.println("");
        matcher.matchIfElse(arr2);
        System.out.println("");
        matcher.matchIfElse(arr3);
        System.out.println("");
        matcher.matchIfElse(arr4);
        System.out.println("");

        // Test the queue methods
        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);
        theQueue.insert(50);

        System.out.println(theQueue.itemAtOrder(0));
        System.out.println(theQueue.itemAtOrder(1));
        System.out.println(theQueue.itemAtOrder(3));
        System.out.println(theQueue.itemAtOrder(2));
        System.out.println(theQueue.itemAtOrder(4));
        System.out.println(theQueue.itemAtOrder(5));
        System.out.println(theQueue.itemAtOrder(6));
        System.out.print("\n");

        System.out.println(theQueue.orderOfItem(20));
        System.out.println(theQueue.orderOfItem(30));
        System.out.println(theQueue.orderOfItem(40));
        System.out.println(theQueue.orderOfItem(10));
        System.out.println(theQueue.orderOfItem(60));
        System.out.print("\n");

        while( !theQueue.isEmpty() )
        {
            long n = theQueue.remove();
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println("\n");

        // Test the priority queue methods
        PriorityQ thePQ = new PriorityQ(5);
        thePQ.insert(90);
        thePQ.insert(60);
        thePQ.insert(20);
        thePQ.insert(70);
        thePQ.insert(35);

        while( !thePQ.isEmpty() )
        {
            long item = thePQ.remove();
            System.out.print(item + " ");
        }
        System.out.println("");

    }

    // This method matches if statements with their corresponding else statements
    public void matchIfElse(String[] b)  {

        // Create a stack object with a capacity equal to the length of the array
        StackX theStack = new StackX(b.length);

        // Loop through the array
        for (int i = 0; i < b.length; i++) {
            if (b[i].equals("if")) {
                // Push the index of the if statement onto the stack
                theStack.push(i);
            } else if (b[i].equals("else")) {
                if (theStack.isEmpty())
                    // If there is no matching if statement, print an error message
                    System.out.println("Error: else at index " + i + " has no matching if");
                else {
                    // If there is a matching if statement, print the indices of the if and else statements
                    System.out.println("if at index " + theStack.pop() + " matches with else at index " + i);
                }
            }

        }
        // If there are any remaining if statements on the stack, print an error message
        while (!theStack.isEmpty()) {
            System.out.println("if at index " + theStack.pop() + " has no matching else");
        }

    }