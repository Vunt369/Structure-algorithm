/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

import java.io.*;
import java.util.*;

/**
 *
 * @author TuanVu113
 */
class BinarySearchTree<E extends Comparable<E>> {

    //------------------- nested Node class -----------------------
    protected static class Node<E> {

        private E element;          // an element stored at this node
//        private Node<E> parent;   // a reference to the parent node (if any)
        private Node<E> left;       // a reference to the left child (if any)
        private Node<E> right;      // a reference to the right child (if any)

        /**
         * Constructors build a node with the given element and its children.
         *
         * @param e the real data that each node stores
         * @param leftChild left child of the current node
         * @param rightChild right child of the current node
         */
        public Node(E e, Node<E> leftChild, Node<E> rightChild) {
            this.element = e;
//            parent = null;
            this.left = leftChild;
            this.right = rightChild;
        }

        public Node(E e) {
            this.element = e;
//            parent = null;
            this.left = null;
            this.right = null;
        }

        // getter, setter methods
        public E getElement() {
            return this.element;
        }

//        This method will be used later
//        public Node<E> getParent() {
//            return this.parent;
//        }
        public Node<E> getLeft() {
            return this.left;
        }

        public Node<E> getRight() {
            return this.right;
        }

        // update methods
        public void setElement(E e) {
            this.element = e;
        }

//         This method will be used later
//        public void setParent(Node<E> parentNode) {
//            parent = parentNode;
//        }
        public void setLeft(Node<E> leftChild) {
            this.left = leftChild;
        }

        public void setRight(Node<E> rightChild) {
            this.right = rightChild;
        }
    } // --------------- end of nested Node class -----------------

    // Root of BST
    /**
     * Each object belongs to BST has one root node
     */
    private Node<E> root;

    public Node<E> getRoot() {
        return root;
    }

    // Constructor
    BinarySearchTree() {
        this.root = null;
    }

    BinarySearchTree(E e) {
        this.root = null;
    }

    /**
     * Insert a node into the binary search tree
     *
     * @param data data of type E that implements the Comparable interface
     * @return void
     */
    public void insert(E data) {
        this.root = insertRec(this.root, data);
    }

    /**
     * A recursive function to insert a new node with data (e) into BST
     *
     * @param root : the root of the current sub-tree
     * @param e: data field
     * @return root node of the tree after insertion
     */
    private Node<E> insertRec(Node<E> root, E data) {
        /* If the tree is empty, then return a new node */
        if (root == null) {
            return new Node<E>(data);
        } /**
         * If the value of the data being inserted is less than the value of the
         * current root node, then traverse to the left node of the current
         * root, and set the current left node to whatever gets returned from
         * the insert method
         */
        else if (data.compareTo(root.getElement()) < 0) {
            /**
             * Write your code here, it should be: root.left = insertRec(...,
             * ...);
             */
            root.left = insertRec(root.getLeft(), data);
//            root.left = null;
        } /*
         * If the value of the data being inserted is less than the value of the
         * current root node,, then traverse to the right node of the current
         * root,, and set the current right node to whatever gets returned from
         * the insert method
         */ else if (data.compareTo(root.getElement()) > 0) {
            root.right = insertRec(root.getRight(), data);
            /**
             * Write your code here, it should be: root.right = insertRec(...,
             * ...);
             */
//            root.right = null;
        } else {
            // This is emply to explicitly state that we do NOT 
            // allow insert duplicate values into the tree.
            ;
        }
        /* return the (unchanged) node pointer */
        return root;
    }

    /**
     * This method finds the maximum value in the tree
     *
     * @param root root node of the current subtree
     * @return maximum value in the tree
     */
    public E findMax(Node<E> root) {
        // We simply continue traversing to the right until we can't go any more, 
        // That means we have reached the largest element 
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return root.getElement();
        }
//        while (root.getRight() != null) {
//            //Write your code here
//            root = root.right;
//        }

        return findMax(root.getRight());
    }

    public E findMin(Node<E> root) {
        // We simply continue traversing to the right until we can't go any more, 
        // That means we have reached the largest element 
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.getElement();
        }
        while (root.getLeft() != null) {
            //Write your code here
            root = root.left;
        }

        return root.getElement();
    }

    /**
     * Returns true if the value is contained in the binary search tree, false
     * otherwise
     *
     * @param data: the value that's being searched for
     * @return boolean evaluation
     * @see boolean
     */
    public boolean contains(E data) {
        return contains(this.root, data);
    }

    private boolean contains(Node<E> root, E data) {
        // if the root is null, then either the BST is empty or 
        // the value has not been found and traversal cannot continue
        if (root == null) {
            return false;
        } // if the data being searched for is less than the value of the current root's data, 
        // then we check if the data exists in the current root's left sub-tree
        else if (data.compareTo(root.getElement()) < 0) {
            /**
             * Write your code here, it should be: contains(..., ...)
             */
            return contains(root.getLeft(), data);
        } // if the data being searched for is greater than the value of the current root's data, 
        // then we check if the data exists in the current root's right sub-tree
        else if (data.compareTo(root.getElement()) > 0) {
            /**
             * Write your code here, it should be: contains(abc,xyz)
             */
            return contains(root.getRight(), data);
        } // if the data being searched for is equal to the value of the current root's data, then 
        // the search was successful and the method should return true
        else {
            return true;
        }
    }

    /**
     * DFS to print the values stored in the BST via in-Order traversal
     *
     * @param void
     * @return void
     */
    public void inorder() {
        System.out.print("In-order Traversal:");
        inorder(root);
        System.out.println();
    }

    // Sequence to be printed: Left, Node, Right
    // Traverses left as far as possible until a null node is reached, 
    // then prints the root node and 
    // then goes as far right as possible until a null node is reached. 
    private void inorder(Node<E> root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(" " + root.getElement().toString());
        inorder(root.right);
    }

    /**
     * DFS to print the values stored in the BST via pre-Order traversal
     *
     * @param void
     * @return void
     */
    public void preorder() {

        System.out.print("Pre-order Traversal:");
        preorder(root);
        System.out.println();
    }

    // Sequence to be printed: Node, Left, Right
    // Prints the root node, then traverses left as far as possible until a null node is reached, 
    // then goes as far right as possible until a null node is reached.
    private void preorder(Node<E> root) {
        //Write your code here
        if (root == null) {
            return;
        }
        System.out.print(root.getElement().toString() + " ");
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * DFS to print the values stored in the BST via post-Order traversal
     *
     * @param void
     * @return void
     */
    public void postorder() {
        System.out.print("Post-order Traversal:");
        postorder(root);
        System.out.println();
        //Write your code here
    }

    // Sequence to be printed: Left, Right, Node
    // Traverses left as far as possible until a null node is reached, 
    // then goes as far right as possible until a null node is reached,
    // and finally prints the root node.
    private void postorder(Node<E> root) {
        //Write your code here
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(" " + root.getElement().toString());
    }
// get height of tree

    public int getHeight(Node<E> root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }
        int l = getHeight(root.getLeft());
        int r = getHeight(root.getRight());
        return 1 + Math.max(l, r);
    }
    //delete node

    public boolean delete(E data) {
        if (contains(data) == false) {
            return false;
        }
        delete(root, data);
        return true;
    }

    private Node delete(Node<E> node, E data) {
        int result = data.compareTo(node.getElement());
        if (result < 0) {
            node.setLeft(delete(node.getLeft(), data));
        } else if (result > 0) {
            node.setRight(delete(node.getRight(), data));
        } else {
            if (node.getLeft() == null) {
                Node rightNode = node.getRight();

                node.setElement(null);
                node = null;
                return rightNode;
            } else if (node.getRight() == null) {
                Node leftNode = node.getLeft();

                node.setElement(null);
                node = null;
                return leftNode;
            } else {

                E tmp = rightMin(node.getRight());
                node.setElement(tmp);
                node.setRight(delete(node.getRight(), tmp));
            }
        }
        return node;
    }

    private E rightMin(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return (E) node.getElement();
    }

    //count leaf in tree
    public int getLeafOfTree() {
        return calLeaf(root);
    }

    private int calLeaf(Node<E> node) {
        if (node == null) {
            return 0;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        }

        return calLeaf(node.getLeft()) + calLeaf(node.getRight());
    }

// Breath first traversal
    void breathFirstTraverse() {
        if (root == null) {
            System.out.println("Tree is empty");
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (queue.peek() != null) {
            Node tmp = queue.remove();
            System.out.print(tmp.getElement() + " ");
            if (tmp.getLeft() != null) {
                queue.add(tmp.getLeft());
            }
            if (tmp.getRight() != null) {
                queue.add(tmp.getRight());
            }
        }

    }

    public void rotateR(Node p) {
        root = rotateRight(p);
    }

    protected Node rotateRight(Node p) {
        if (p == null || p.left == null) {
            return p;
        }
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        return q;
    }

    protected void rotateAnyRight(Node p) {
        if (p == null || p.left == null) {
            return;
        }
        Node pr = findParent(p);
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        pr.left = q;
    }

    public void rotateL(Node p) {
        root = rotateLeft(p);
    }

    protected Node rotateLeft(Node p) {
        if (p == null || p.right == null) {
            return p;
        }
        Node q = p.right;
        q.right = q.left;
        q.left = p;
        return q;
    }

    protected void rotateAnyLeft(Node p) {
        if (p == null || p.right == null) {
            return;
        }
        Node pr = findParent(p);
        Node q = p.right;
        p.right = q.left;
        q.left = p;
        pr.right = q;
    }

    protected Node findParent(Node child) {
        Node p = root;
        Queue<Node> q = new LinkedList<>();
        if (p == null) {
            return null;
        }
        q.add(p);
        while (!q.isEmpty()) {
            p = q.remove();
            if (p.left != null) {
                if (p.left == child) {
                    return p;
                }
            }
            if (p.right != null) {
                if (p.right == child) {
                    return p;
                }
            }
            if (p.left != null) {
                q.add(p.left);
            }
            if (p.right != null) {
                q.add(p.right);
            }
        }
        return null;
    }

    public void deleteCOP(Node p) {
        Node pn = findParent(p), n = p;
        n = p;
        if (p != null) {
            if (n.right == null) {
                n = n.left;
            } else if (n.left == null) {
                n = n.right;
            } else {
                Node t = n.left;
                Node pt = n;
                while (t.right != null) {
                    pt = t;
                    t = t.right;
                }
                n.element = t.element;
                if (pt == n) {
                    pt.left = t.left;
                } else {
                    pt.right = t.left;
                }
            }
            if (p == root) {
                root = n;
            } else if (pn.left == p) {
                pn.left = n;
            } else {
                pn.right = n;
            }
        } else {
            System.out.println("Tree is empty");
        }
    }

    // Test the class's methods
    public static void main(String[] args) {
        /**
         * NOTE that these code is just example feel free to modify for testing
         * other methods
         */
        BinarySearchTree<Integer> i_tree = new BinarySearchTree<Integer>();

        /* Let us build the BST as below
                  5
                /   \
              3       9
             /  \    /  \
            2    4  6    10 
           /         \     
          1           7
         */
        i_tree.insert(5);
        i_tree.insert(3);
        i_tree.insert(2);
        i_tree.insert(4);
        i_tree.insert(9);
        i_tree.insert(6);
        i_tree.insert(10);
        i_tree.insert(1);
        i_tree.insert(7);

        // print inorder traversal of the BST
        i_tree.inorder();

        // print preorder traversal of the BST
        i_tree.preorder();

        // print postorder traversal of the BST
        i_tree.postorder();
        // Breath first traverse
        System.out.print("Breath First Traverse:  ");
        i_tree.breathFirstTraverse();
        System.out.println("");
// ham dem so la, ham bfs, 
        System.out.println("Maximum values in BST = " + i_tree.findMax(i_tree.getRoot()));
        System.out.println("Minimum values in BST = " + i_tree.findMin(i_tree.getRoot()));
        System.out.println("Height: " + i_tree.getHeight(i_tree.getRoot()));
        System.out.println("Contain: " + i_tree.contains(9));
        System.out.println("Number of leaf in tree: " + i_tree.getLeafOfTree());
        System.out.println("Result of deleting 9:  " + i_tree.delete(9));
        BinarySearchTree<String> s_tree = new BinarySearchTree<String>();
        /* 
        Let us build the BST as below
                  m
                /   \
              d       r
             /  \    /  \
            c    g  o    t 
           /         \
          b           q
          
         */
        s_tree.insert("m");
        s_tree.insert("d");
        s_tree.insert("c");
        s_tree.insert("b");
        s_tree.insert("g");
        s_tree.insert("r");
        s_tree.insert("o");
        s_tree.insert("t");
        s_tree.insert("q");

        // print inorder traversal of the BST
        s_tree.inorder();

        // print preorder traversal of the BST
        s_tree.preorder();

        // print postorder traversal of the BST
        s_tree.postorder();
        System.out.print("Breath First Traverse:  ");
        s_tree.breathFirstTraverse();
        System.out.println("");
        System.out.println("Maximum values in BST = " + s_tree.findMax(s_tree.getRoot()));
        System.out.println("Minimum values in BST = " + s_tree.findMin(s_tree.getRoot()));
        System.out.println("Height: " + s_tree.getHeight(s_tree.getRoot()));
        System.out.println("Contain: " + s_tree.contains("g"));
        System.out.println("Number of leaf in tree: " + s_tree.getLeafOfTree());
        System.out.println("Result of deleting c:  " + s_tree.delete("c"));
    }
}
