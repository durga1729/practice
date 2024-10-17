package practice.linkedlists;

// Java program to detect loop in a linked list

class DetectLoop {
    Node head; // head of list

    /* Linked list Node*/
   static class Node {
        int data;
        Node next;
        Node(int x)
        {
            data = x;
            next = null;
        }
    }

    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    void detectLoop()
    {
        Node slow_p = head, fast_p = head;
        int flag = 0;
        while (slow_p != null && fast_p != null
                && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            System.out.println("Loop Found");
        else
            System.out.println("No Loop");
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        DetectLoop llist = new DetectLoop();

        llist.head = new Node(10);
        llist.head.next = new Node(20);
        llist.head.next.next = new Node(30);
        llist.head.next.next.next = new Node(40);
        llist.head.next.next.next.next = llist.head;

        llist.detectLoop();
    }
}
/* This code is contributed by Rajat Mishra. */
