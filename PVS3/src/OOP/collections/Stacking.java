package OOP.collections;

import java.util.EmptyStackException;

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

    void expandArray() {
        int[] newone = new int[data.length * 2];
        System.arraycopy(data, 0, newone, 0, data.length);
        data = newone;
    }

    ArrayStack(int capacity) {
        data = new int[capacity];
        top = 0;
    }

    void push(int toAdd) {
        if (top < data.length) {
            data[top] = toAdd;
            top++;
        } else {
            System.out.println("Out of capacity");
        }
    }

    int pop() {
        if (top > 0) {
            int toReturn = data[top - 1];
            top--;
            return toReturn;
//            return data[top--];
        }
        return -1;
    }

    int peek() {
        if (top > 0) {
            return data[top - 1];
        }
        return -1;
    }

}

class Link {
    int data;
    Link next;
}

class LinkStack {
    Link top;

    LinkStack() {
        top = null;
    }

    void push(int toAdd) {
        // První prvek
        if (top == null) {
            top = new Link();
            top.data = toAdd;
        } //Už tam něco je
        else {
            Link newtop = new Link();
            newtop.data = toAdd;
            newtop.next = top;
            top = newtop;//Prohlásím za nový vrchol
        }
    }

    int pop() {
        if (top == null) {
            //Ideálně hodit chybu
            throw new EmptyStackException();
        }
        int toReturn = top.data;
        top = top.next; //to, co bylo pod topem, je nyní top;

        return toReturn;
    }

    int peak() {
        if (top == null) {
            throw new NullPointerException();
        }
        return top.data;
    }
}