/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst1;
public interface IBSTree <E> {
    public void find(E key);
    public void insert(E id);
    public void delete(E id);
    public void findHeight();
    public void countLeaf();
    public E findMax();
    public E findMin();
    public boolean contains(E data);
    public void inorder();
    public void preorder();
    public void postorder();
    void breathFirstTraverse();
}
