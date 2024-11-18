package OOP.collections;

public class Queues {
    public static void main(String[] args) {
        LinkingQue<Player> players = new LinkingQue<>();
        players.enqueue(new Player("Jarmil"));
        players.enqueue(new Player("Adam"));
        players.enqueue(new Player("Stein"));
        players.enqueue(new Player("Karel"));
        players.enqueue(new Player("Boris"));
        players.enqueue(new Player("Tom"));
        // Ve frontě je jenom 1 prvek
        while (players.start != players.end) {
            System.out.println("Právě hraje: " + players.peek().name);
            magicPause();
            Player playerTurn = players.dequeue();
            if (Math.random() <= 0.16) {
                System.out.println(playerTurn.name + ", gg Alkane");
            } else {
                System.out.println(playerTurn.name + ", přežil");
                players.enqueue(playerTurn);
            }
        }
        System.out.println("Last man standing: " + players.peek().name);
    }

    static void magicPause() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}

class Player {
    String name;

    public Player(String name) {
        this.name = name;
    }
}

class LinkQue<E> {
    E data;
    LinkQue<E> next;
}

class LinkingQue<E> {
    LinkQue<E> start;
    LinkQue<E> end;

    void enqueue(E data) {
        LinkQue<E> newLink = new LinkQue<>();
        newLink.data = data;
        if (start == null) { //Fronta je prázdná
            start = newLink;
            end = start;
        } else {
            end.next = newLink;
            end = newLink;
        }
    }

    E peek() {
        if (start == null) {
            return null; //idealně chybu
        } else {
            return start.data;
        }
    }

    E dequeue() {
        if (start == null) {
            return null;
        }
        E tmp = start.data;
        start = start.next;
        return tmp;
    }
}

class ArrayQue {
    int[] array;
    int first, count;

    public ArrayQue(int capacity) {
        this.array = new int[capacity];
        first = 0;
        count = 0;
    }

    void expandArray() {
        int[] newArray = new int[array.length * 2];
//        System.arraycopy(array,0, newArray,0,array.length);
//        array = newArray;
        // Fungovat nebude

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[(first + i) % array.length];
        }
        array = newArray;
        first = 0;


    }

    int peek() {
        if (count > 0) {
            return array[first];
        } else {
            return -1;
        }
    }

    void enqueue(int toAdd) {
        array[(first + count) % array.length] = toAdd;
        count++;
    }

    int dequeue() {
        int toReturn = array[first];
        if (count > 0) {
            first = (first + 1) % array.length;
            count--;
            return toReturn;
        } else {
            return -1;
        }
    }
}