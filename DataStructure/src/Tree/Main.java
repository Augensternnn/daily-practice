package Tree;

import Tree.printer.BinaryTrees;
import file.Files;

public class Main {
    static void test(){
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < 30; i++) {
            bst.add((int)(Math.random()*100));
        }
        //BinaryTrees.println(bst);
        String str = BinaryTrees.printString(bst);
        str += "\n";
        Files.writeToFile("G:\\1.txt",str,true);
    }

    static void test2(){
        Integer data[] = new Integer[] {7, 4, 2, 1, 3, 5, 9, 8, 11, 10, 12};
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.print(bst);
        System.out.println();
//        bst.preorderTraversal();
//        bst.inorderTraversal();
        bst.postorderTraversal();
    }
    public static void main(String[] args) {
        //test();
        test2();
    }
}
