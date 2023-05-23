/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst1;

public class Tree<E extends Comparable<E>> {

    private Node<E> root;

    public Tree() {
        this.root = null;
    }

    // Insert node
    public void insert(E data) {
        this.root = inseartRec(root, data);
    }

    private Node inseartRec(Node root, E data) {
        if (this.root == null) {
            return new Node(data);
        } else {
            if (data.compareTo(this.root.getData()) > 0) {
                root.right = inseartRec(root.right, data);
            } else {
                root.left = inseartRec(root.left, data);
            }
        }
        return root;
    }

    public boolean find(E key) {
        return findNode(root, key);
    }

    private boolean findNode(Node<E> root, E data) {
        if(root == null){
            return false;
        }
        if(data.compareTo(root.getData())>0){
           return findNode(root.getRight(), data);
        }else if(data.compareTo(root.getData())<0){
           return findNode(root.getLeft(), data);
        }else{
            return true;
        } 
    }

//    public boolean delete(E data) {
//      return deleteNode(root,data);  
//    }
//    public boolean deleteNode(Node root, E data){
//        
//    }
    public int findHeight(Node root) {
        if (root == null) {
            return 0;
        } else if (root.getLeft() == null && root.right == null) {
            return 1;
        }
        int l = findHeight(root.left);
        int r = findHeight(root.right);
        return 1 + Math.max(r, l);
    }

    public int countLeaf(Node root) {
        if(root == null) return 0;
        if(root.getLeft() == null && root.getRight() == null) return 1;
        return countLeaf(root.getLeft()) + countLeaf(root.getRight());
    }

    public E findMax(Node root) {
        if(root == null) return null;
        if(root.getRight() == null) return (E) root.getData();
        return findMax(root.getRight());
    }

        public E findMin(Node root) {
        if(root == null) return null;
        if(root.getLeft()== null) return (E) root.getData();
        return findMin(root.getLeft());
    }

    public void inorder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void preorder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void postorder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void breathFirstTraverse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
