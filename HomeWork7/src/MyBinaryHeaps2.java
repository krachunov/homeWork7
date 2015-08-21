import java.util.Collections;
import java.util.Comparator;

public class MyBinaryHeaps2<T extends Comparable<T>> implements Comparator<T> {

	public int compare(T a, T b) {
		return a.compareTo(b);
	}

	private Object[] arr;
	private T element;
	private final int SIZE = 16;
	private int count = 0;

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Object[] getArr() {
		return arr;
	}

	@SuppressWarnings("unchecked")
	public MyBinaryHeaps2() {
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

	private int leftChild(int index) {
		return (index * 2 < getArr().length - 1 ? index * 2 : -1);
	}

	private int rightChild(int index) {
		return ((index * 2 + 1) < getArr().length - 1 ? (index * 2 + 1) : -1);
	}

	private int parentIndex(int index) {
		return (index / 2 > 0 ? index / 2 : index / 2 == 0 ? 0 : -1);
	}

	private int smalestChild(int left, int right) {
		T leftChild = (T) getArr()[left];
		T rightChild = (T) getArr()[right];

		if (left > 0 && right > 0 && leftChild.compareTo(rightChild) > 0) {
			return right;
		} else if (left > 0 && right > 0 && leftChild.compareTo(rightChild) < 0) {
			return left;
		} else if (left > 0 && right < 0) {
			return left;
		} else {
			return right;
		}
	}

	/**
	 * 
	 * @param element1
	 *            - new Element
	 * @param element2
	 *            - parent to new Element
	 */
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
		int parentIndex = parentIndex(currentIndex);
		T child = (T) getArr()[currentIndex];
		T parent = (T) getArr()[parentIndex];
		// TODO
		while (parent.compareTo(child) > 0 && currentIndex > 0) {
			swap(currentIndex, parentIndex);
			currentIndex = parentIndex / 2;
			if (currentIndex < 1) {
				break;
			}
			parentIndex = parentIndex(currentIndex);
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
		if (getCount() >= 2) {
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
		getArr()[1] = newEl;
		getArr()[getCount() - 1] = null;
		setCount(getCount() - 1);

		int currentIndex = 0;
		int leftChild = leftChild(currentIndex);
		int rightChild = rightChild(currentIndex);
		int smallestChild = smalestChild(leftChild, rightChild);

		T parent = (T) getArr()[currentIndex];
		T childToChange = (T) getArr()[smallestChild];

		while (smallestChild > 0 && parent.compareTo(childToChange) > 0) {
			swap(currentIndex, smallestChild);
			currentIndex = smallestChild;
			leftChild = leftChild(currentIndex);
			rightChild = rightChild(currentIndex);
			smallestChild = smalestChild(leftChild, rightChild);
			parent = (T) getArr()[currentIndex];
			childToChange = (T) getArr()[smallestChild];
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
