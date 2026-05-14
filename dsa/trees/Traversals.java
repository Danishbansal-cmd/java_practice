package trees;

import java.util.*;

class Node {
    Node left;
    Node right;
    int value;

    Node(int val, Node l, Node r){
        this.left = l;
        this.right = r;
        this.value = val;
    }
    Node(int val){
        this.left = null;
        this.right = null;
        this.value = val;
    }
}

public class Traversals {
    public static void main(String[] args) {
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7
        //       /     / \
        //      8     9  10
        //           /
        //          11
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.right.left = new Node(8);

        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        root.right.right.left.left = new Node(11);

        

        // printing the inorder of the tree
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();

        // printing the preorder
        System.out.print("Postorder: ");
        preorder(root);
        System.out.println();

        // printing the postorder
        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();

        // bfs -> breadth first search
        System.out.print("BFS -> breadth first search: ");
        bfs(root);
        System.out.println();

        // bfsLevel -> breadth first search
        System.out.print("BFSLevel -> breadth first search: ");
        bfsLevel(root);
        System.out.println();

        // height of the tree
        System.out.print("Tree Height: " + treeHeight(root));
        System.out.println();
        
        // Diameter of the tree
        // Diameter = length of the longest path between any two nodes in the tree
        // prints the number of edges in the longest path or in the diameter
        System.out.print("Diameter: " + diameter(root, 0)[1]);
        System.out.println();
        
        // top/bottom view of the tree
        System.out.print("Top/Bottom View of the tree: ");
        topViewBottomView(root);
        System.out.println();
        
        // left/right view of the tree
        System.out.print("Left/Right View of the tree: ");
        leftViewRightView(root);
        System.out.println();
        
        // check if the tree is balanced
        System.out.print("Balanced Tree Check (is Tree Balanced): " + (isHeightBalanced(root) != -1));
        System.out.println();
    }

    

    // node, left, right
    static void preorder(Node root){
        if(root != null) System.out.print(root.value + " ");
        if(root.left != null) preorder(root.left);
        if(root.right != null) preorder(root.right);
    }

    // left, node, right
    static void inorder(Node root){
        if(root.left != null) inorder(root.left);
        if(root != null) System.out.print(root.value + " ");
        if(root.right != null) inorder(root.right);
    }

    // left, right, node
    static void postorder(Node root){
        if(root.left != null) postorder(root.left);
        if(root.right != null) postorder(root.right);
        if(root != null) System.out.print(root.value + " ");
    }

    // level order (bfs)
    static void bfs(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr != null) System.out.print(curr.value + " ");
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
        }
    }

    // level order (bfs with levels printing)
    static void bfsLevel(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();

            System.out.println();
            System.out.print("Level-" + level + ": ");
            level++;
            for(int i = 0; i < size; i++){
                Node curr = q.poll();
                if(curr != null) System.out.print(curr.value + " ");
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
    }

    // getting the tree height
    static int treeHeight(Node root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
    }

    // diameter of the tree
    static int[] diameter(Node root, int diamtr){
        if(root == null){
            return new int[]{0, 0};
        }

        int[] left = diameter(root.left, diamtr);
        int[] right = diameter(root.right, diamtr);

        int height = 1 + Math.max(left[0], right[0]);
        int currDiam = (left[0] + right[0]);
        int maxDiam = Math.max(currDiam, Math.max(left[1], right[1]));

        return new int[]{height, maxDiam};
    }

    // prints the top/bottom view of the tree
    static void topViewBottomView(Node root){
        if(root == null) return;

        TreeMap<Integer, Integer> mp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int hd = curr.hd;
            Node node = curr.n;

            // for the topview uncomment this line
            // if(!mp.containsKey(hd)){
            //     mp.put(hd, node.value);
            // }

            // for bottom view uncomment this line
            // always update the value of the horizontal distance in the map
            // this way we will get to store the value of the node that is visible from the bottom
            mp.put(hd, node.value);

            if(node.left != null) q.add(new Pair(node.left, hd-1));
            if(node.right != null) q.add(new Pair(node.right, hd+1));
        }

        for(int val : mp.values()){
            System.out.print(val + " ");
        }
    }

    // prints the left/right view of the tree
    static void leftViewRightView(Node root){
        if(root == null) return;

        TreeMap<Integer, Integer> mp = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int currLevel = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++){
                Node curr = q.poll();

                // for the leftView uncomment these lines
                // if(!mp.containsKey(currLevel)){
                //     mp.put(currLevel, curr.value);
                // }

                // for the rightView uncomment these lines
                mp.put(currLevel, curr.value);

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            
            currLevel += 1;
        }

        for(int val : mp.values()){
            System.out.print(val + " ");
        }
    }

    // checks if the tree is balanced
    // returns 0 -> on null/ balanced
    // return -1 -> if not balanced
    static int isHeightBalanced(Node root){
        if(root == null) return 0;

        int left = isHeightBalanced(root.left);
        if(left == -1) return -1;

        int right = isHeightBalanced(root.right);
        if(right == -1) return -1;

        if(Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }
}

class Pair{
    Node n;
    int hd;

    Pair(Node node, int horizontaDistance){
        this.n = node;
        this.hd = horizontaDistance;
    }
}
