
public class TreeNode<T> {

	public T element;
	public TreeNode<T> left;
	public TreeNode<T> right;
	
	public TreeNode(T element){
		this.element = element;
		left = null;
		right = null;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}
	
	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
	
	public void inorderTraversal(){			//O(n)
		try{
			this.getLeft().inorderTraversal();
		}
		catch (NullPointerException e){}
		System.out.println(this.toString());
		try{
			this.getRight().inorderTraversal();
		}
		catch (NullPointerException e){
			return;
		}
	}
	
	public void preorderTraversal(){		//O(n)
		System.out.println(this.toString());
		try{
			this.getLeft().preorderTraversal();
		}
		catch (NullPointerException e){}
		try{
			this.getRight().preorderTraversal();
		}
		catch (NullPointerException e){
			return;
		}
	}
	
	public void postorderTraversal(){		//O(n)
		try{
			this.getLeft().postorderTraversal();
		}
		catch (NullPointerException e){}
		try{
			this.getRight().postorderTraversal();
		}
		catch (NullPointerException e){}
		System.out.println(this.toString());
	}
	
	public void insert(TreeNode<T> newNode){	//O(log n)
		if (this.getLeft() == null){
			this.setLeft(newNode);
		}
		else if (this.getRight() == null){
			this.setRight(newNode);
		}
		else{
			this.getLeft().insert(newNode);
		}
	}
	
    //The following two methods are ideal for homework, but you must still call them at the right node
    //this.getLeft().getLeft().getLeft().insertLeft(newNode);
	public void insertLeft(TreeNode<T> newNode){		   //O(1)
		if (this.getLeft() == null){
			this.setLeft(newNode);
		}
		else{
			System.out.println("Tried to overwrite a node on the left");
		}
	}
	
	public void insertRight(TreeNode<T> newNode){		//O(1)
		if (this.getRight() == null){
			this.setRight(newNode);
		}
		else{
			System.out.println("Tried to overwrite a node on the right");
		}
	}
	
//	public void insertBalanced(TreeNode<T> newNode){   //O(n log n)
//		if (this.getLeft() == null && this.getRight() == null){
//			this.setLeft(newNode);
//		}
//		else if (this.getLeft() == null && this.getRight() != null){
//			this.setLeft(newNode);
//		}
//		else if (this.getRight() == null && this.getLeft() != null){
//			this.setRight(newNode);
//		}
//		else{
//			if (this.getLeft().getHeight() > this.getRight().getHeight()){
//				this.getRight().insertBalanced(newNode);
//			}
//			else{
//			this.getLeft().insertBalanced(newNode);
//				}
//		}
//	}
	
	public void insertBalanced(TreeNode<T> newNode){   //O(n log n)
		if (this.getLeft() == null && this.getRight() == null){
			this.setLeft(newNode);
		}
		else if (this.getLeft() == null && this.getRight() != null){
			this.setLeft(newNode);
		}
		else if (this.getRight() == null && this.getLeft() != null){
			this.setRight(newNode);
		}
		else if (this.getLeft().getHeight() > this.getRight().getHeight()) {
				this.getRight().insertBalanced(newNode);
		}
		else{
			this.getLeft().insertBalanced(newNode);
		}
	}
	
	public int getHeight(){		//O(n)
		if ((this.getLeft() == null) && (this.getRight() != null)){
			return this.getRight().getHeight() + 1;
		}
		else if ((this.getRight() == null) && (this.getLeft() != null)){
			return this.getLeft().getHeight() + 1;
		}
		else if ((this.getLeft() == null) && (this.getRight() == null)){
			return 0;
		}
		else{
			return Math.max(this.getLeft().getHeight(), this.getRight().getHeight()) + 1;
		}
	}
	
	public boolean search(T target){      //O(n)
		if (this.element.equals(target)){
			return true;
		}
		else{
			if (this.getLeft() != null && this.getRight() != null){
				return this.getLeft().search(target) || this.getRight().search(target);
			}
			else if (this.getLeft() == null && this.getRight() != null){
				return this.getRight().search(target);
			}
			else if (this.getLeft() != null && this.getRight() == null){
				return this.getLeft().search(target);
			}
			else{
				return false;
			}
		}
	}
	
	public void remove(T target){     //O(n^2)
		if (this.element.equals(target)){
			//Do a removal
		}
		else{
			if (this.getLeft() != null && this.getRight() != null){
				if (this.getLeft().getElement().equals(target)){
					leafPromoteLeft();
				}
				else if (this.getRight().getElement().equals(target)){
					//Do a removal
				}
				else{
					this.getLeft().remove(target);
					this.getRight().remove(target);
				}
			}
			else if (this.getLeft() == null && this.getRight() != null){
				if (this.getRight().getElement().equals(target)){
					//Do a removal
				}
				else{
					this.getRight().remove(target);
				}
			}
			else if (this.getLeft() != null && this.getRight() == null){
				if (this.getLeft().getElement().equals(target)){
					//Do a removal
				}
				else{
					this.getLeft().remove(target);
				}
			}
			else{
				return;
			}
		}
	}
	
	public void leafPromoteLeft(){
		if (this.getLeft().getHeight() == 0){
			this.setLeft(null);
		}
		else{
			if (this.getLeft().getLeft() != null && this.getLeft().getRight() != null){
				if (this.getLeft().getLeft().getHeight() > this.getLeft().getRight().getHeight()){
					this.setLeft(this.getLeft().getLeft());
				}
				else if (this.getLeft().getLeft().getHeight() <= this.getLeft().getRight().getHeight()){
					this.setLeft(this.getLeft().getRight());	
				}
			}
		}
	}

	@Override
	public String toString() {
		return "" + this.element;
	}
}
