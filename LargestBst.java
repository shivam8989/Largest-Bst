package Binary_Tree;

public class LargestBst {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class Info {
        boolean isBst;
        int size;
        int min;
        int max;

        public Info(boolean isBst,int size,int min,int max){
            this.isBst = isBst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public static int  maxBst = 0;
    public static Info largestBst(Node root){
        if(root==null){
            return new Info(true,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        Info leftinfo = largestBst(root.left);
        Info rightinfo = largestBst(root.right);
        int size = leftinfo.size+ rightinfo.size+1;
        int min = Math.min(root.data,Math.min(leftinfo.min, rightinfo.min));
        int max =Math.max(root.data,Math.max(leftinfo.max, rightinfo.max));

        if(root.data <= leftinfo.max || root.data>= rightinfo.min){
            return  new Info(false,size,min,max);
        }
        if(leftinfo.isBst && rightinfo.isBst){
            maxBst= Math.max(maxBst,size);
            return new Info(true,size,min,max);
        }
         return  new Info(false,size,min,max);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(60);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);
        Info info = largestBst(root);
        System.out.println("largest size of Bst = "+maxBst);
    }
}
