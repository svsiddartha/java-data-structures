import java.awt.event.PaintEvent;
import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Bst tree = new Bst();
        for(int i=0;i<n;i++){
            tree.add(sc.nextInt());
        }
        tree.levelOrder(tree.root);

    }
}
class Bst{
    class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    Node root;
    class Pair{
        Node node;
        int hd;
        Pair(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public Node add(Node root,int val){
        if(root == null){
            return new Node(val);
        }
        if(val < root.val){
            root.left = add(root.left,val);
        } else {
            root.right = add(root.right,val);
        }
        return root;
    }

    public void add(int val){
        root = add(root,val);
    }

    public Node insert(Node root,int val){
        if(root == null){
            return new Node(val);
        }
        if(val < root.val){
            root.left = insert(root.left,val);
        } else {
            root.right = insert(root.right,val);
        }
        return root;
    }

    public int height(){
        int count = TreeHeight(root);
        return count;
    }

    public int TreeHeight(Node root){
        if(root == null){
            return -1;
        }
        int tl = TreeHeight(root.left);
        int tr = TreeHeight(root.right);
        return 1+(int)Math.max(tl,tr);
    }

    public void topView(Node root) {
      if(root == null){
          return;
      }
      Queue<Pair> queue = new LinkedList<>();
      Map<Integer,Integer> map = new TreeMap<>();
      queue.add(new Pair(root,0));
      while (!queue.isEmpty()){
          Pair curr = queue.remove();
          Node node = curr.node;
          int hd = curr.hd;
          if(!map.containsKey(hd)){
              map.put(hd, node.val);
          }
          if(node.left != null){
              queue.add(new Pair(node.left,hd-1));
          }
          if(node.right != null){
              queue.add(new Pair(node.right,hd+1));
          }
      }
      for(int num : map.values()){
          System.out.print(num+" ");
      }
    }
    public void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    void levelOrder(Node root) {

        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node curr = queue.remove();
            System.out.print(curr.val+" ");
            if(curr.left != null){
                queue.add(curr.left);
            }
            if(curr.right != null){
                queue.add(root.right);
            }
        }

    }
    public void postOrder(Node root) {
        if(root == null){
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.val+ " ");
    }
    public void inOrder(Node root) {
        if(root == null){
            return;
        }
        preOrder(root.left);
        System.out.print(root.val+ " ");
        preOrder(root.right);
    }

    public void delete(Node node, int val){
        if(node == null){
            return;
        }
        if(node.left != null && node.left.val == val ){
            if(node.left.left != null){
                node.left = node.left.left;
            } else if(node.left.right != null){
                node.left = node.left.right;
            } else {
                node.left = null;
            }
            return;
        }
        if(node.right != null && node.right.val == val){
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

}
