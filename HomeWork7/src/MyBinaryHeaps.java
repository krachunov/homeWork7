import java.util.Collections;
import java.util.Comparator;

public class MyBinaryHeaps<T> {
	private class Node<T extends Comparator<T>> {
		private T value;
		private T parent;
		private T leftChild;
		private T rightChild;

		public Node(T element) {
			setValue(element);
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public T getParent() {
			return parent;
		}

		public void setParent(T parent) {
			this.parent = parent;
		}

		public T getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(T leftChild) {
			this.leftChild = leftChild;
		}

		public T getRightChild() {
			return rightChild;
		}

		public void setRightChild(T rightChild) {
			this.rightChild = rightChild;
		}

	}

	private Node[] arr;
	private final int SIZE = 128;
	private int count = 0;

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

	public boolean add(Comparator element) {
		// TODO - check this
		grow();
		Node newElement = new Node(element);
		int index = getCount();
		getArr()[index] = newElement;
		setCount(getCount() + 1);

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
