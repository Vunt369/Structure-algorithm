package linked_list;
public class SSLNode <T> {
    T data;
    SSLNode<T> next;
    SSLNode<T> prev;

    public SSLNode() {
    }
    public SSLNode(T e1){
        data = e1;
        next = null;
        prev = null;
    }
    public SSLNode(T data, SSLNode<T> next, SSLNode<T> prev) {
        this.data= data;
        this.next = next;
        this.prev = prev;
    }
    public void Print() {
       System.out.println(this.data); 
     }
}
