import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MyBinaryHeapTest {

	public static void main(String[] args) {
		MyBinaryHeaps2<Integer> myHeap = new MyBinaryHeaps2<Integer>();

		myHeap.enqueue(20);
		myHeap.enqueue(8);
		myHeap.enqueue(30);
		myHeap.enqueue(5);
		myHeap.enqueue(50);

//		myHeap.print();

		System.out.println(myHeap.dequeue());
		System.out.println(myHeap.dequeue());
		System.out.println(myHeap.dequeue());
		System.out.println(myHeap.dequeue());
		System.out.println(myHeap.dequeue());
		System.out.println(myHeap.dequeue());
	

		PriorityQueue<Integer> a = new PriorityQueue<Integer>();

		a.add(20);
		a.add(8);
		a.add(30);
		a.add(5);
		a.add(50);
		System.out.println("------");
		for (Integer integer : a) {
			System.out.println(integer);
		}


	}
}
