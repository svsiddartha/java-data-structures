import org.w3c.dom.Node;

import javax.management.NotificationEmitter;
import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    private class Node{
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    Node root;
    public void add(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node current = queue.remove();

            if(current.left == null){
                current.left = node;
                return;
            } else {
                queue.add(current.left);
            }

            if(current.right == null){
                current.right = node;
                return;
            } else {
                queue.add(current.right);
            }
        }
    }


    public void preOrder(Node root) {
        if(root == null){
            return;
        }
        System.out.print(root.value + " ");

        preOrder(root.left);
        preOrder(root.right);
    }
    public void preOrder(){
        preOrder(root);
    }
    public boolean search(Node node,int val){
        if(node == null){
            return false;
        }
        if(node.value == val){
            return true;
        }
        boolean res1 = search(node.left,val);
        boolean res2 = search(node.right,val);
        return res1 || res2;
    }
    public boolean search(int val){
        return search(root,val);
    }
    public void delete(Node node,int val){
        if(node == null){
            return;
        }
        if(node.left != null && node.left.value == val ){
            if(node.left.left != null){
                node.left = node.left.left;
            } else if(node.left.right != null){
                node.left = node.left.right;
            } else {
                node.left = null;
            }
            return;
        }
        if(node.right != null && node.right.value == val){
            if(node.right.left != null){
                node.right = node.right.left;
            } else if(node.right.right != null){
                node.right = node.right.right;
            } else {
                node.right = null;
            }
            return;
        }
        delete(node.left,val);
        delete(node.right,val);
    }
    public void delete(int val) {
        delete(root,val);
    }



    public void delete1(Node node,int val){
        if(node == null){
            return;
        }
        if(node.left != null && node.left.value == val ){
            if(node.left.left != null && node.left.right != null){
                Node temp = node.left;
                node.left = node.left.right;
                node.left.left = temp.left;
            } else if(node.left.left != null){
                node.left = node.left.left;
            } else if(node.left.right != null){
                node.left = node.left.right;
            } else {
                node.left = null;
            }
            return;
        }
        if(node.right != null && node.right.value == val){
            if(node.right.left != null){
                node.right = node.right.left;
            } else if(node.right.right != null){
                node.right = node.right.right;
            } else {
                node.right = null;
            }
            return;
        }
        delete1(node.left,val);
        delete1(node.right,val);
    }
}


class Main2{
    public static void main(String[] args){
        Tree tree = new Tree();
        tree.add(10);
        tree.add(20);
        tree.add(30);
        tree.add(40);
        tree.add(50);
        tree.preOrder();
        System.out.println();
        System.out.println(tree.search(20));
        tree.delete(40);
        tree.preOrder();
        tree.delete(20);
        System.out.println();
        tree.preOrder();
    }
}