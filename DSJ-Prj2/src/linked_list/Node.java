package linked_list;

public class Node<T> {

        T data;
        Node next;
        Node prev;

        public Node() {
        }

        public Node(T e1) {
            data = e1;
            next = null;
            prev = null;
        }

        public Node(T data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        public void Print() {
            System.out.println(this.data);
        }
    
}
