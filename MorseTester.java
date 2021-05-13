import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseTester {

	public static void main(String[] args) throws FileNotFoundException {
		TreeNode<String> root = new TreeNode<String>("_");
		MorseTree morseTree= new MorseTree(root,"C:\\Users\\Sam\\OneDrive\\Desktop\\morsecode.txt");
		
//		System.out.println("left half of the tree");
//		System.out.println(root);
//		System.out.println(root.getLeft());
//		System.out.println(root.getLeft().getLeft());
//		System.out.println(root.getLeft().getRight());
//		System.out.println(root.getLeft().getLeft().getLeft());
//		System.out.println(root.getLeft().getLeft().getRight());
//		System.out.println(root.getLeft().getRight().getLeft());
//		System.out.println(root.getLeft().getRight().getRight());
//		System.out.println(root.getLeft().getLeft().getLeft().getLeft());
//		System.out.println(root.getLeft().getLeft().getLeft().getRight());
//		System.out.println(root.getLeft().getLeft().getRight().getLeft());
//		System.out.println(root.getLeft().getLeft().getRight().getRight());
//		System.out.println(root.getLeft().getRight().getLeft().getLeft());
//		System.out.println(root.getLeft().getRight().getLeft().getRight());
//		System.out.println(root.getLeft().getRight().getRight().getLeft());
//		System.out.println(root.getLeft().getRight().getRight().getRight());
//		
//		
//		System.out.println("right half of the tree");
//		System.out.println(root);
//		System.out.println(root.getRight());
//		System.out.println(root.getRight().getLeft());
//		System.out.println(root.getRight().getRight());
//		System.out.println(root.getRight().getLeft().getLeft());
//		System.out.println(root.getRight().getLeft().getRight());
//		System.out.println(root.getRight().getRight().getLeft());
//		System.out.println(root.getRight().getRight().getRight());
//		System.out.println(root.getRight().getLeft().getLeft().getLeft());
//		System.out.println(root.getRight().getLeft().getLeft().getRight());
//		System.out.println(root.getRight().getLeft().getRight().getLeft());
//		System.out.println(root.getRight().getLeft().getRight().getRight());
//		System.out.println(root.getRight().getRight().getLeft().getLeft());
//		System.out.println(root.getRight().getRight().getLeft().getRight());
//		System.out.println(root.getRight().getRight().getRight().getLeft());
//		System.out.println(root.getRight().getRight().getRight().getRight());

		
//		System.out.println("Preorder Traversal: ");
//		root.preorderTraversal();
//		System.out.println("My Preorder Traversal: ");
		System.out.println(morseTree.PreOrderTraversal(root));
		
//		System.out.println("Postorder Traversal: ");
//		root.postorderTraversal();
//		System.out.println("My Postorder Traversal: ");
		System.out.println(morseTree.PostOrderTraversal(root));
		
//		System.out.println("---- To Morse ----");
		System.out.println(morseTree.ToMorse("the quick fox", root));		
	}
}
