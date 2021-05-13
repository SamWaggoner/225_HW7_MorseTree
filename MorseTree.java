
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseTree {
	
	public MorseTree() {
		return;
	}
	
//	public TreeNode<String> MorseTree(String rootStr, String filepath) throws FileNotFoundException {
//		TreeNode<String> root = new TreeNode<String>(rootStr);
//		File text = new File(filepath);
//		Scanner scanner = new Scanner(text);
//		String line = scanner.nextLine();
//		// setting the first level left node to e
//		root.setLeft(new TreeNode<String>(line));
//		line = scanner.nextLine();
//		// setting the first level right node to t
//		root.setRight(new TreeNode<String>(line));
//		
//		// loop that inserts letters that start with dots on the left node,
//		// and letters that start with dash on the right node
//		while(scanner.hasNextLine()){
//	    	line = scanner.nextLine();
//	    	if ("o".equals(line.substring(2,3)))
//	    			root.left.insert(new TreeNode<String>(line));
//	    	if ("-".equals(line.substring(2,3)))
//		    		root.right.insert(new TreeNode<String>(line));
//	        }
//		scanner.close();
//		return root;
//	}
	
	public MorseTree(TreeNode<String> root, String filepath) throws FileNotFoundException {
		File text = new File(filepath);
		Scanner scanner = new Scanner(text);
		
		String line = scanner.nextLine();
		// setting the first level left node to e
		root.setLeft(new TreeNode<String>(line));
		
		line = scanner.nextLine();
		// setting the first level right node to t
		root.setRight(new TreeNode<String>(line));
		
		// loop that inserts letters that start with dots on the left node,
		// and letters that start with dash on the right node
		while(scanner.hasNextLine()){
	    	line = scanner.nextLine();
	    	if ("o".equals(line.substring(2,3))) {
//	    		System.out.println("inserting on the left: " + line);
	    		LeftOrRight(root.left, new TreeNode<String>(line));
	    	}
	    	if ("-".equals(line.substring(2,3))) {
//	    		System.out.println("inserting on the left: " + line);
	    		LeftOrRight(root.right, new TreeNode<String>(line));
	    	}
	    }
		scanner.close();
	}
	
	public void LeftOrRight(TreeNode<String> node, TreeNode<String> nodeInserted) {
		
		int nodeLength = node.element.length();
		int insertLength = nodeInserted.element.length();
//		System.out.println("------------------------");
//		System.out.println("node: " + node.element);
//		System.out.println("nodeLength: " + nodeLength);
//		System.out.println("nodeInserted: " + nodeInserted.element);
//		System.out.println("insertLength: " + insertLength);
		
		if (insertLength == nodeLength) {
			if (nodeInserted.element.charAt(insertLength) == 'o') {
//				System.out.println(nodeInserted.element + "inserted left of " + node.element);
				node.setLeft(nodeInserted);
				return;
			}
			else if (nodeInserted.element.charAt(insertLength) == '-') {
				node.setLeft(nodeInserted);
				return;
			}
		}
		
		if (insertLength > nodeLength) {
//			System.out.println("compared char: " + nodeInserted.element.charAt(nodeLength + 1));
			if (nodeInserted.element.charAt(nodeLength + 1) == 'o') {
//				System.out.println("inserting left, start");
				if (node.left == null) {
//					System.out.println(nodeInserted.element + " inserted right of " + node.element);
					node.setLeft(nodeInserted);
					return;
				}
				else {
					LeftOrRight(node.left, nodeInserted);
					return;
				}
			}
			
			if (nodeInserted.element.charAt(nodeLength + 1) == '-') {
//				System.out.println(" inserting right, start");
				if (node.right == null) {
					node.setRight(nodeInserted);
				}
				else {
				LeftOrRight(node.right, nodeInserted);
				}
			}
		}
	}
	
	public String PreOrderTraversal(TreeNode<String> node) {
		String preOrderString = " ";
		preOrderString = PreOrdah(node);
		preOrderString = preOrderString.substring(2); // gets rid of the root at the beginning
		return preOrderString;
	}
	
	public String PreOrdah(TreeNode<String> node) {
		
		if (node.getLeft() == null && node.getRight() == null)
			return Character.toString(node.element.charAt(0)) + " ";
		
		if (node.getLeft() != null && node.getRight() == null)
			return Character.toString(node.element.charAt(0)) + " " + PreOrdah(node.getLeft());
		
		if (node.getRight() != null && node.getLeft() == null)
			return Character.toString(node.element.charAt(0)) + " " + PreOrdah(node.getRight());
		
		if (node.getRight() != null && node.getLeft() != null)
			return Character.toString(node.element.charAt(0)) + " " + PreOrdah(node.getLeft()) + PreOrdah(node.getRight());
		else
			return "";
	}
	
	public String PostOrderTraversal(TreeNode<String> node) {
		String postOrderString = " ";
		postOrderString = PostOrdah(node);
		postOrderString = postOrderString.substring(0,postOrderString.length() - 2); // gets rid of the root at the end
		return postOrderString;
	}
	
	public String PostOrdah(TreeNode<String> node) {
		
		if (node.getLeft() == null && node.getRight() == null)
			return Character.toString(node.element.charAt(0));
		
		if (node.getLeft() != null && node.getRight() == null)
			return PostOrdah(node.getLeft()) + " " + Character.toString(node.element.charAt(0));
		
		if (node.getRight() != null && node.getLeft() == null)
			return PostOrdah(node.getRight()) + " " + Character.toString(node.element.charAt(0));
		
		if (node.getRight() != null && node.getLeft() != null)
			return PostOrdah(node.getLeft()) + " " + PostOrdah(node.getRight()) + " " + Character.toString(node.element.charAt(0));
		else
			return "";
	}
	
	public void PostOrder(TreeNode<String> root) {
		root.postorderTraversal();
	}
	
	public String ToMorse(String string, TreeNode<String> root) {
//		System.out.println(string);
		int length = string.length();
//		System.out.println("length: " + length);
		String morseString = "|";
		for (int i = 0; i < length; i++) {
 			char currentChar = Character.toLowerCase(string.charAt(i));
//			System.out.println("currentchar: " + currentChar);
			String morseLetter = Search(root, currentChar);
			morseString = morseString + morseLetter;
//			System.out.println("morseLetter = " + morseLetter);
//			System.out.println("morseString = " + morseString);
		}
		return morseString;
	}
	
	public String Search(TreeNode<String> node, char currentChar) {
		if (node.element.charAt(0) == currentChar){
//			System.out.println(node.element.substring(2));
			return node.element.substring(2) + "|";
		}
		else{
			if (node.getLeft() != null && node.getRight() != null){
				return Search(node.getLeft(), currentChar) + Search(node.getRight(), currentChar);
			}
			else if (node.getLeft() == null && node.getRight() != null){
				return Search(node.getRight(), currentChar);
			}
			else if (node.getLeft() != null && node.getRight() == null){
				return Search(node.getLeft(), currentChar);
			}
			else {
				return "";
			}
		}
	}
}
