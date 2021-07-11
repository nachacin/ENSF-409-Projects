

class Node {
    Node next;
    int item;
    public Node(int item){
        this.item = item;
    }
}

class LinkedList {
    Node headM;
    int sizeM;
    
    public LinkedList() {
        headM = null;
        sizeM = 0;
    }

    public int get(int n) {
        if (n < 0 || n >= sizeM) {
            System.out.println("Illegal Access. Program Terminates...");
            System.exit(1);
        }

        Node p = headM;
        for(int i = 0; i < n; i++) {
            p = p.next;
        }
        return p.item;
    }

    public void set(int n, int v){
        if (n < 0 || n >= sizeM) {
            System.out.println("Illegal Access. Program Terminates...");
            System.exit(1);
        }

        Node p = headM;
        for(int i = 0; i < n; i++) {
            p = p.next;
        }
        p.item = v;
    }

    public void pushBack(int item) {
        Node newNode = new Node(item);
        
        if (headM == null) {
            newNode.next = headM;
            headM = newNode;
        }
        else {
            Node p = headM;
            while (p.next != null) {
                p = p.next;
            }
            p.next = newNode;
            newNode.next = null;
        }
        sizeM++;
    }

    public void pushFront(int item) {
        Node newNode = new Node(item);
        newNode.next = headM;
        headM = newNode;
        sizeM++;
    }

    public void insert(int itemA, int n) {
        if (n < 0 || n > sizeM) {
            return;
        }
        else if (n == 0) {
            pushFront(itemA);
        }
        else if (n == sizeM) {
            pushBack(itemA);
        }
        else {
            Node newNode = new Node(itemA);

            Node before = headM;        // will point to node in front of the new node
            Node after = headM.next;    // will be 0 or point to node after new node
            int i = 1;
            while (i < n) {
                before = after;
                after = after.next;
                i++;
            }
            newNode.next = after;
            before.next = newNode;
            sizeM++;
        }
    }

    public void clear() {
        headM = null;
        sizeM = 0;
    }

    public void remove(int n) {
        if (headM == null || n < 0 || n >= sizeM) {
            return;
        }
        Node beDeleted;
        Node before;
        
        if (n == 0) {
            beDeleted = headM;
            headM = headM.next;
        }
        else {
            before = headM;
            beDeleted = before.next;
            
            int i = 1;
            while (i < n) {
                before = beDeleted;
                beDeleted = before.next;
                i++;
            }
            before.next = beDeleted.next;
        }
        sizeM--;
    }
    public String toString() {
        String result = "";
        Node current = headM;
        while (current != null) {
            result += String.valueOf(current.item);
            if (current.next != null) {
                result += ", ";
            }
            current = current.next;
        }
        return result;
    }
}

public class SimpleList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.println("List just after creation -- is empty");

        list.pushFront(50);
        System.out.println("After calling out pushFront, list must have: 50\n" + list.toString());

        list.pushBack(440);

        list.set(0, 770);
        System.out.println("After calling push_back and set function list must have: 770  440\n" + list.toString());

        list.pushBack(330);
        list.pushBack(220);
        list.pushBack(110);

        System.out.println("After three more calls to push_back, list must have: 770, 440, 330, 220, 110 \n" + list.toString());

        list.remove(0);
        list.remove(2);

        System.out.println("After removing two nodes. list must have: 440, 330, 110\n" + list.toString());

        list.insert(40, 3);
        list.insert(20, -1);
        list.insert(30, 30000);
        list.insert(10, 0);
        list.insert(33, 2);

        System.out.println("Two  more nodes inserted, must have: 10, 440, 33, 330, 110, 40\n" + list.toString());

        list.remove(0);
        list.remove(1);
        list.remove(2);
        list.remove(3);
        list.remove(4);
        list.remove(5);

        System.out.println("After 6 removes, list must have: 440, 330, 40: \n" + list.toString());

        list.clear();

        System.out.println("After call to clear, list must be empty:\n");

        list.pushBack(331);
        list.pushBack(221);
        list.pushBack(111);

        System.out.println("After three calls to push_back, list must have: 331, 221, 111\n" + list.toString());
        
        return;
    }
}
