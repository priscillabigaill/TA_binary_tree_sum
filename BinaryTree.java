import java.util.Scanner;

public class BinaryTree {

    // represent a node
    private static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    // root node of the binary tree
    private static Node root;

    // insert a new node into the binary tree
    void insert(int value) {
        root = insertRecursive(root, value);
    }

    //recursively insert a new node into the binary tree
     private Node insertRecursive(Node root, int value) {

         // if root node is null
         // create a new node (containing the value)
         if(root == null){
             root = new Node(value);
             return root;
         }

         // if value os less than root value,
         // insert into the left
         if(value< root.value){
             root.left = insertRecursive(root.left, value);
         } else { // if the value is greater, add to right
             root.right = insertRecursive(root.right, value);
         }
         return root;
    }

    // recursively calculate sum of all nodes
    int sum(Node root) {
        if (root == null) {
            return 0;
        }
        return root.value + sum(root.left) + sum(root.right);
    }

    public static void main(String[] args) {

        // create binary tree object
        BinaryTree tree = new BinaryTree();

        // take input from the user to put into binary tree
        Scanner value = new Scanner(System.in);
        System.out.print("input numbers you want to sum (separated by a coma): ");
        String input = value.nextLine();
        String[] parts = input.split(",");

        for (String c :parts) {
            int num = Integer.parseInt(c.trim());
            tree.insert(num);
        }

        // calculate sum of all nodes and print it (use sum method)
        int sum = tree.sum(root);
        System.out.print("The sum of all the numbers are: " + sum);

        value.close();
    }

}