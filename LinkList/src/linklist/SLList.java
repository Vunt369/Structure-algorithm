package linklist;
public class SLList<T> {
    Node head;
    Node tail;
    int size = 0;
    public SLList() {
        head = tail = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
       return size;
    }
    
    public T first(){
        if(isEmpty() == true) return null;
        return (T) head.getInfo();
    }
     public T last(){
        if(isEmpty() == true) return null;
        return (T) tail.getInfo();
    }
    //Add elements into head
    public void addToHead(T info){
         head = new Node<T>(info, head.next);
        if(tail == null) head = tail;
        size++;
    }
    //Add elements to the end of list
    public void addToLast(T info){
        Node node = new Node(info, null);        
        if(isEmpty() == true) head = node;
        tail.setNext(node);
        tail = node;
        size++;
    }
    //Remove head and return node that is removed
    public T deleteFromHead(){
       if(isEmpty() == true) return null; 
       T result =(T) head.getInfo();
       head = head.getNext();
       size--;
       if(size==0) tail = null;
       return result;
    }
    //Remove tail and return
    public T deleteFromTail(){
        if(isEmpty() == true) return null;
        T result = (T) tail.getInfo();
        if(size() == 1) tail = head = null;
        else{
            Node tmp;
            for(tmp = head; tmp.next != tail; tmp = tmp.next);
            tail = tmp;
            tail.next = null;
            size--;
        }
        return result;
    }
    //delete element with value 
    public T delete(T info){
        T result = null;
        if(isEmpty() == true) return null;
        else{
            if(head == tail && info.equals(head.getInfo()) == true) head = tail = null;
            else if(info.equals(head.getInfo()) == true) result = deleteFromHead();
            else if(info.equals(tail.getInfo()) == true) result = deleteFromTail();
            else{
                for(Node tmp = head; tmp.next.getInfo() != info; tmp = tmp.next);
            }
        }
     return result;
    }
}
