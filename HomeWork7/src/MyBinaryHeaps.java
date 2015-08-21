import java.util.Collections;
import java.util.Comparator;

public class MyBinaryHeaps<T extends Comparable<T>> implements Comparator<T> {

	public int compare(T a, T b) {
		return a.compareTo(b);
	}

	private Object[] arr;
	private final int SIZE = 16;
	private int count = 0;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Object[] getArr() {
		return arr;
	}

	public MyBinaryHeaps() {
		arr = new Object[SIZE];
	}

	/**
	 * Resize double the array
	 */
	private void grow() {
		if (count == getArr().length) {
			Object[] newArr = new Object[arr.length * 2];
			System.arraycopy(arr, 0, newArr, 0, arr.length);
			this.arr = newArr;
		}
	}

	/**
	 * Find left child to the given index
	 * 
	 * @param index
	 *            parent index
	 * @return
	 */
	private int getLeftChildIndex(int index) {
		return ((index * 2) + 1 < getCount() ? (index * 2) + 1 : -1);
	}

	/**
	 * Find right child to the given index
	 * 
	 * @param index
	 *            parent index
	 * @return
	 */
	private int getRightChildIndex(int index) {

		return ((index * 2 + 2) < getCount() ? (index * 2 + 2) : -1);
	}

	/**
	 * Find parent to the given index
	 * 
	 * @param index
	 * @return
	 */
	private int getParentIndex(int index) {
		return ((index - 1) / 2 > 0 ? (index - 1) / 2
				: (((index - 1) / 2 == 0) ? 0 : -1));
	}

	/**
	 * find a small element of two children
	 * 
	 * @param left
	 *            - index to the left child
	 * @param right
	 *            - index to the right child
	 * @return -
	 */
	@SuppressWarnings("unchecked")
	private int smallestChild(int left, int right) {
		T leftChild = null;
		T rightChild = null;
		if (left >= 0 && left < getCount()) {
			leftChild = (T) getArr()[left];
		}
		if (right >= 0 && right < getCount()) {
			rightChild = (T) getArr()[right];
		}

		if (left > 0 && right > 0 && leftChild.compareTo(rightChild) > 0
				&& leftChild != null && rightChild != null) {
			return right;
		} else if (left > 0 && right > 0 && leftChild.compareTo(rightChild) < 0
				&& leftChild != null && rightChild != null) {
			return left;
		} else if (left > 0 && right < 0) {
			return left;
		} else {
			return right;
		}
	}

	/**
	 * swap two elements
	 * 
	 * @param element1
	 *            index of first element
	 * 
	 * @param element2
	 *            index of second element
	 */
	@SuppressWarnings("unchecked")
	private void swap(int element1, int element2) {
		T firstElement = (T) getArr()[element1];
		T secondElement = (T) getArr()[element2];

		getArr()[element1] = secondElement;
		getArr()[element2] = firstElement;
	}

	/**
	 * Relocate two element - children and parent. Swap them
	 */
	@SuppressWarnings("unchecked")
	private void relocateNewNode() {
		// get the last add element
		int currentIndex = getCount();
		int parentIndex = getParentIndex(currentIndex);
		T child = (T) getArr()[currentIndex];
		T parent = (T) getArr()[parentIndex];
		while (parent.compareTo(child) > 0 && currentIndex > 0) {
			swap(currentIndex, parentIndex);
			currentIndex = parentIndex;
			if (currentIndex < 0) {
				break;
			}
			parentIndex = getParentIndex(currentIndex);
			child = (T) getArr()[currentIndex];
			parent = (T) getArr()[parentIndex];
		}
	}

	/**
	 * Add new element
	 * 
	 * @param element
	 *            - new Element
	 * @return - true or false
	 */
	public boolean enqueue(T element) {
		grow();
		int index = getCount();
		getArr()[index] = element;
		if (getCount() > 0) {
			relocateNewNode();
		}
		setCount(getCount() + 1);
		return true;
	}

	@SuppressWarnings("unchecked")
	public T dequeue() {
		if (getCount() == 0) {
			throw new IllegalArgumentException("The queue is empty");
		}
		T element = (T) getArr()[0];
		T newEl = (T) getArr()[getCount() - 1];
		getArr()[0] = newEl;
		getArr()[getCount() - 1] = null;
		setCount(getCount() - 1);

		int currentIndex = 0;
		int leftChildIndex = getLeftChildIndex(currentIndex);
		int rightChildIndex = getRightChildIndex(currentIndex);
		int smallestChildIndex = smallestChild(leftChildIndex, rightChildIndex);

		T parent = (T) getArr()[currentIndex];
		T childToChange = null;
		if (smallestChildIndex >= 0) {
			childToChange = (T) getArr()[smallestChildIndex];
		}

		while (smallestChildIndex > 0 && parent.compareTo(childToChange) > 0) {
			swap(currentIndex, smallestChildIndex);
			currentIndex = smallestChildIndex;
			leftChildIndex = getLeftChildIndex(currentIndex);
			rightChildIndex = getRightChildIndex(currentIndex);
			smallestChildIndex = smallestChild(leftChildIndex, rightChildIndex);
			parent = (T) getArr()[currentIndex];
			if (smallestChildIndex < 0) {
				continue;
			}
			childToChange = (T) getArr()[smallestChildIndex];
		}

		return element;
	}

	@Override
	public boolean equals(Object obj) {
		return (this == obj);
	}

	public void print() {
		for (Object element : this.getArr()) {
			if (element != null) {
				System.out.println(element);
			}
		}
	}
}
