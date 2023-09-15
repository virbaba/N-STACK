import java.util.* ;
import java.io.*; 
public class NStack {
    // Initialize your data structure.
    int[] arr, top, next;
    int freeSpot;
    public NStack(int N, int S) {
        // Write your code here.
        arr = new int[S];
        top = new int[N];
        next = new int[S];
        freeSpot = 0;

        for(int i = 0; i < N; i++){
            top[i] = -1;
        }

        for(int i = 1; i < S; i++){
            next[i - 1] = i;
        }

        next[S-1] = -1;
    }

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
    public boolean push(int x, int m) {
        // Write your code here.
        if(freeSpot == -1)
            return false;
        // fetching the index
        int index = freeSpot;

        // update the freeSpot
        freeSpot = next[index];

        // insert the element
        arr[index] = x;

        // store the index of pre top
        next[index] = top[m-1];

        // update the top
        top[m-1] = index;

        return true;
        
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    public int pop(int m) {
        // Write your code here.
        if(top[m-1] == -1)
            return -1;

        int index = top[m-1];

        top[m-1] = next[index];


        int x = arr[index];

        next[index] = freeSpot;

        freeSpot = index;

        return x;
    }
}
