package linked_list;
public class Linked_List <T>{
 protected Node<T> head, tail;

    public Linked_List() {
        head = tail = null;
    }
     public void Add(T e1) {
         Node node = new Node(e1);
        if (head == null) {
           head = tail = node;     
        }else {
          tail.next = node;
          node.prev = tail;
          tail = node;
       } 
    }
    public boolean isEmpty() {
        return head == null;
    }

    //  Add node to head   
    public void Addfirst(Node node) {
        node.next = head;
        head.prev = node;
        head = node;
    }

    public void addToHead(T e1) {
        Node newNode = new Node(e1);
        if (head == null) {
            firstNode(newNode);
        } else {
            this.Addfirst(newNode);
        }
    }

    public void firstNode(Node<T> node) {
        head = node;
        tail = node;
        head.prev = null;
        tail.next = null;
    }

    //Add Node to tail   
    public void addToTail(T e1) {
        Node newNode = new Node(e1);
        Node last = head;

        newNode.next = null;
        if (isEmpty()) {
            newNode.prev = null;
            head = newNode;
            return;
        }
        while (last.next != null) {
            last = last.next;
            last.next = newNode;
            newNode.prev = last;
        }
    }

    public T deleteFromHead() {
        if (isEmpty()) {
            return null;
        }
        T e1 = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        return e1;
    }

    public T deleteFromTail() {
        T e1 = tail.data;
        if (isEmpty()) {
            return null;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            Node<T> tmp;
            for (tmp = head; tmp.next != tail; tmp = tmp.next);
            tmp.next = null;
            tail = tmp;
        }

        return e1;
    }

    public Node Find(T data) {
        Node now = head;
        while (now != null) {
            if (now.data == data) {
                return now;
            }

        }
        return null;
    }

    public void delete(T e1) {
        Node newNode = new Node(e1);
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.data == newNode.data) {
            this.deleteFromHead();
            return;
        }
        Node nodeAtPos = this.Find(e1);
        if (nodeAtPos == null) {
            System.out.println("Can not found node with data = e1");
            return;
        }
        if (nodeAtPos.next == null) {
            this.deleteFromTail();
            return;
        }
        nodeAtPos.prev.next = nodeAtPos.next;
        nodeAtPos.next.prev = nodeAtPos.prev;
    }

    public void printAll() {
        Node now = head;
        while (now != null) {
            now.Print();
            now = now.next;
        }
    }

    public boolean isInList(T e1) {
        Node<T> tmp;
        for (tmp = head; tmp != null && !tmp.data.equals(e1); tmp = tmp.next);
        return tmp != null;
    }  
}
