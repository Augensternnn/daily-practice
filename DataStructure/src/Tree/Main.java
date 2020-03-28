package Tree;

import Tree.printer.BinaryTrees;
import file.Files;

public class Main {
    static void test(){
        BST1<Integer> bst1 = new BST1<>();
        for (int i = 0; i < 30; i++) {
            bst1.add((int)(Math.random()*100));
        }
        //BinaryTrees.println(bst);
        String str = BinaryTrees.printString(bst1);
        str += "\n";
        Files.writeToFile("G:\\1.txt",str,true);
    }

    static void test2(){
        Integer data[] = new Integer[] {7, 4, 2, 1, 3, 5, 9, 8, 11, 10, 12};
        BST1<Integer> bst1 = new BST1<>();
        for (int i = 0; i < data.length; i++) {
            bst1.add(data[i]);
        }
        BinaryTrees.print(bst1);
        System.out.println();
//        bst.preorderTraversal();
//        bst.inorderTraversal();
//        bst.postorderTraversal();
//        bst1.levelOrderTraversal();
        bst1.levelOrderTraversal(new BST1.Visitor<Integer>() {
            @Override
            public void visit(Integer element) {
                System.out.print("_"+element+"_");
            }
        });

    }
    public static void main(String[] args) {
        //test();
        test2();
    }
}
