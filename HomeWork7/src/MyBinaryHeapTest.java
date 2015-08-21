
public class MyBinaryHeapTest {

	public static void main(String[] args) {
		MyBinaryHeaps2<Integer> myHeap = new MyBinaryHeaps2<Integer>();

		myHeap.Enqueue(20);
		myHeap.Enqueue(8);
		myHeap.Enqueue(30);
		myHeap.Enqueue(5);
		myHeap.Enqueue(50);
	
		for (Object element : myHeap.getArr()) {
			System.out.println(element);
		}

	
		
	
	}

}
