import java.util.ArrayDeque;

public class BinaryTree {
    static class BinaryTreeNode {
        char value;
        BinaryTreeNode left_child;
        BinaryTreeNode right_child;

        //kontruktør
        BinaryTreeNode(char value){
            this.value = value;
            this.left_child = null;
            this.right_child = null;
        }
        //det venstre barnet
        BinaryTreeNode addLeftChild(char value){
            this.left_child = new BinaryTreeNode(value);
            return this.left_child;
        }

        //det høyre barnet
        BinaryTreeNode addRightChild(char value){
            this.right_child = new BinaryTreeNode(value);
            return this.right_child;
        }

        static void printLevelOrder(BinaryTreeNode root){
            ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<BinaryTreeNode>();

            //legg til rot node
            queue.addLast(root);

            while (!queue.isEmpty()){
                //ta ut første i køen
                BinaryTreeNode current = queue.removeFirst();

                //legg til current sine to barn i køen
                if (current.left_child != null) {
                    queue.addLast(current.left_child);
                }
                if (current.right_child != null) {
                    queue.addLast(current.right_child);
                }
                //skriv ut verdier
                System.out.println(current.value + "");
            }
        }
        static void printPreOrder(BinaryTreeNode node){
            if(node == null){
                return;
            }
            System.out.println(node.value);
            printPreOrder(node.left_child);
            printPreOrder(node.right_child);
        }

        public static void main(String[] args) {

            //lager rot-noden (Nivå 0)
            BinaryTreeNode root = new BinaryTreeNode('A');

            //legg inn resterende noder på nivå 1
            BinaryTreeNode b = root.addLeftChild('B');
            BinaryTreeNode c = root.addRightChild('C');

            //legg inn alle noder på nivå 2
            BinaryTreeNode d = b.addLeftChild('D');
            BinaryTreeNode e = b.addRightChild('E');

            BinaryTreeNode f = c.addLeftChild('F');
            BinaryTreeNode g = c.addRightChild('G');

            //Kall funskjonen vår
            printLevelOrder(root);
            printPreOrder(root);
        }
    }
}
