import java.util.Collections;
import java.util.Comparator;

public class MyBinaryHeaps<T> {

	private class Node<T> {
		private T value;
		private Node parent;
		private Node leftChild;
		private Node rightChild;

		public Node(T element) {
			setValue(element);
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public Node getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(Node leftChild) {
			this.leftChild = leftChild;
		}

		public Node getRightChild() {
			return rightChild;
		}

		public void setRightChild(Node rightChild) {
			this.rightChild = rightChild;
		}

	}

	private Node[] arr;
	private final int SIZE = 3;
	private int count = 1;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Node[] getArr() {
		return arr;
	}

	public MyBinaryHeaps() {
		arr = new Node[SIZE];
	}

	/**
	 * Resize double
	 */
	public void grow() {
		if (count == getArr().length) {
			Node[] newArr = new Node[arr.length * 2];
			System.arraycopy(arr, 0, newArr, 0, arr.length);
			this.arr = newArr;
		}
	}

	public void relocateNewNode() {
		Node child = getArr()[getCount()];
		Node parent = getArr()[getCount() / 2];
		// while (child.getValue() > parent.getValue()) {
		//
		// }

	}

	public boolean add(T element) {
		grow();
		Node newElement = new Node(element);
		int index = getCount();
		getArr()[index] = newElement;
		if (count / 2 > 0) {
			newElement.setParent(getArr()[getCount() / 2]);
		}
		setCount(getCount() + 1);

		// TODO relocate new node to right position

		return true;
	}

	public boolean remove(T element) {
		// TODO
		return false;
	}

	public T find(T element) {
		// TODO
		return element;

	}

}
