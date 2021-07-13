import java.util.LinkedList;

public class SimpleList {
    
    public static SimpleList list = new SimpleList();

    public class Node{
        public int item;
        public Node next;
    }

    private Node headM;
    private int sizeM;

    public SimpleList(Node headM, int sizeM)
    {
        this.headM = headM;
        this.sizeM = sizeM;
    }
    public int get(int n)
    {
        if(n < 0 || n >= sizeM)
        {
            System.out.println("\n Illegal Access. Program Terminates...");
            System.exit(0);
        }

        Node p = headM;
        for(int i = 0; i < n; i++)
            p = p.next;

        return p.data;

    }


    public void set(int n, int v)
    {
        if(n < 0 || n >= sizeM)
        {
            System.out.println("\n Illegal Access. Program Terminates...");
            System.exit(0);
        }
        
        Node p = headM;
        for(int i = 0; i < n; i++)
            p = p.next;

        p.data = v;
    }

    public void pushback(int data)
    {
        Node new_node = new Node();
        if(new_node == null)
        {
            System.out.println("\nNo memory available to create a node");
            System.exit(0);
        }

        new_node.data = data;

        if(headM == 0)
        {
            new_node.next = headM;
            headM = new_node;
        }
        else
        {
            Node p = headM;
            while(p.next != null)
                p = p.next;
            
            p.next = new_node;
            new_node.next = null;
        }
        sizeM++;
    }

    public void pushfront(int data)
    {
        Node new_node = new Node();
        new_node.data = data;
        new_node.next = headM;
        headM = new_node;
        sizeM++;
    }

    public void insert(int dataA, int n)
    {
        if(n < 0 || n > sizeM)
            return;
        else if(n == 0)
            pushfront(dataA);
        else if(n == sizeM)
            pushback(dataA);
        else{
            Node new_node = new Node();
            if(new_node == NULL)
            {
                System.out.println("Sorry memory is unavailable to create a new node. \n");
                return;
            }
            new_node.data = dataA;

            Node before = headM;
            Node after = headM.next;
            int i = 1;
            while(i < n)
            {
                before = after;
                after = after.next;
                i++;
            }
            new_node.next = after;
            before.next = new_node;
            sizeM++;
        }
    }

    public void clear()
    {
        Node p = headM;

        while(p)
        {
            headM = headM.next;
            p = null;
            p = headM;
            
        }

        headM = 0;
        sizeM = 0;
    }

    public void remove(int n)
    {
        if(headM == 0 || n < 0 || n >= sizeM)
            return;
        Node be_deleted;
        Node before;

        if(n == 0)
        {
            be_deleted = headM;
            headM = headM.next;
        }
        else
        {
            before = headM;
            be_deleted = before.next;

            int i = 1;
            while(i < n)
            {
                before = be_deleted;
                be_deleted = before.next;
                i++;
            }

            before.next = be_deleted.next;
        }
        be_deleted = null;
        sizeM--;
    }
    public static void main (String []args){
    
        
        
        System.out.println("List just after creation -- is empty.");

        list.push_front(50);
        System.out.println("\nAfter calling push_front. list must have: 50\n");




    }


    
}
