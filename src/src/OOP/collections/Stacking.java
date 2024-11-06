package OOP.collections;

public class Stacking {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(8);
        stack.push(9);
        stack.push(7);
        stack.pop();
        stack.push(8);
        stack.pop();

        System.out.println(stack.pop());
        stack.expandArray();
        System.out.println(stack);
    }

}

class ArrayStack {
    int[] data;
    int top; // Vrchol zásobníku

    void expandArray(){
        int[] newone = new int[data.length*2];
        for (int i = 0; i < data.length; i++) {
            newone[i] = data[i];
        }
        data = newone;
    }
    ArrayStack(int capacity){
        data = new int[capacity];
        top = 0;
    }

    void push(int toAdd){
        if (top < data.length){
            data[top] = toAdd;
            top++;
        } else  {
            System.out.println("Out of capacity");
        }
    }

    int pop(){
        if (top > 0){
            int toReturn = data[top-1];
            top--;
            return toReturn;
//            return data[top--];
        }
        return -1;
    }

    int peek(){
        if (top > 0) {
            return data[top-1];
        }
    return -1;
    }

}
