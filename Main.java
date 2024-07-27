public class Main {
    public static void main(String[] args) {

        CLL cll = new CLL();
        cll.insertLast(23);
        cll.insertLast(22);
        cll.insertLast(21);
        cll.insertFirst(25);
        cll.insertFirst(26);
        cll.insert(3, 3);
        cll.insert(6, 4);
        cll.deleteFirst();
        cll.delete(3);
        cll.display();
    }

}

class CLL {
    Node head;
    Node tail;
    int size;

    CLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // insert at any position
    public void insert(int val, int pos) {
        if (pos == 0) {
            insertFirst(val);
            return;
        }
        if (pos == size - 1) {
            insertLast(val);
            return;
        }
        Node node = new Node(val);
        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    // insert at first
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        tail.next = head;
        size++;

    }

    // insert at last
    public void insertLast(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
        size++;

    }

    // delete at first
    public int deleteFirst() {
        Node temp = head;
        if (head.next != null) {
            head = temp.next;
            tail.next = head;
        }
        if (head.next == null) {
            head = null;
            tail = null;
        }
        int val = temp.value;
        size--;
        return val;
    }

    // getting a particular node
    public Node get(int size) {
        Node temp = head;
        for (int i = 1; i < size; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // delete at any position
    public int delete(int pos) {
        if (pos == 1) {
            return deleteFirst();
        }
        if (pos == size) {
            return deleteLast();
        }
        Node prev = get(pos - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    // delete at last
    public int deleteLast() {
        Node temp = tail;
        Node secondLast = get(size - 1);
        secondLast.next = head;
        tail = secondLast;
        int val = temp.value;
        size--;
        return val;
    }

    // displaying the elements
    public void display() {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.value + "->");
                temp = temp.next;
            } while (temp != head);
            System.out.print("End");
        }
    }

    class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

    }
}
