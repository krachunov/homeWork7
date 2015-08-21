import java.util.Collections;
import java.util.Comparator;

public class MyBinaryHeaps2<T extends Comparable<T>> implements Comparator<T> {

	public int compare(T a, T b) {
		return a.compareTo(b);
	}

	private Object[] arr;
	private T element;
	private final int SIZE = 16;
	private int count = 1;

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
	public void grow() {
		if (count == getArr().length) {
			Object[] newArr = new Object[arr.length * 2];
			System.arraycopy(arr, 0, newArr, 0, arr.length);
			this.arr = newArr;
		}
	}

	/**
	 * 
	 * @param element1
	 *            - new Element
	 * @param element2
	 *            - parent to new Element
	 */
	public void swap(T child, T parent, int indexToStartSwap) {
		int currentIndex = indexToStartSwap;
		int parrentIndex = currentIndex / 2;
		getArr()[parrentIndex] = child;
		getArr()[currentIndex] = parent;
	}

	/**
	 * Relocate two element - children and parent.
	 */
	@SuppressWarnings("unchecked")
	public void relocateNewNode() {
		int currentIdex = getCount();
		int parentIndex = currentIdex / 2;
		T child = (T) getArr()[currentIdex];
		T parent = (T) getArr()[parentIndex];
		// TODO
		while (child.compareTo(parent) > 0 && currentIdex > 1) {
			swap(child, parent, currentIdex);
			currentIdex = getCount() / 2;
			if (currentIdex < 2) {
				break;
			}
			parentIndex = currentIdex / 2;
			child = (T) getArr()[currentIdex];
			parent = (T) getArr()[parentIndex];
		}

	}
/**
 * Add new element
 * @param element - new Element
 * @return - true or false
 */
	public boolean Enqueue(T element) {
		grow();
		int index = getCount();
		getArr()[index] = element;
		if (getCount() > 2) {
			relocateNewNode();
		}
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
