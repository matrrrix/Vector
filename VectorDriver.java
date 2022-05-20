

import java.util.Iterator;

public class VectorDriver {

	public static void main(String[] args) {

		Vector<Integer> v1 = new Vector<>();
		Object[] list;
		
		System.out.println(v1.size());
		System.out.println("Empty? " + v1.isEmpty());
		v1.pushback(10);
		v1.pushback(20);
		v1.pushback(30);
		v1.pushback(40);
		
		list = (Object[]) v1.data();
      print(v1);	
		
		v1.popback();
		print(v1);
		
		System.out.println("Capacity: " + v1.capacity());
		System.out.println("Size: " + v1.size());
		System.out.println("Empty? " + v1.isEmpty());
		System.out.println("At 1: " + v1.at(1));
		v1.shrinkToFit();
		System.out.println(v1.size());
		System.out.println("Shrinked: " + v1.capacity());
		print(v1);

		System.out.println("Front: " + v1.front());
		System.out.println(" Back: " + v1.back());
		v1.erase(0);
		System.out.println("Front: " + v1.front());
		v1.insert(0, 5);
		System.out.println("After insert(0,5): " + v1.size());
		System.out.println("Front: " + v1.front());
		print(v1);
		
		// erase range
		v1.insert(0, 44); // autoboxed
		v1.insert(0, Integer.valueOf(55)); // explictly create object
		v1.insert(0, 66);
		v1.insert(0, 77);
		print(v1);
		v1.erase(2, 4);
		System.out.println("v1 expected 77 66 33 22 11:");
		print(v1);
		System.out.println("Capacity: " + v1.capacity());
		System.out.println("Size: " + v1.size());
//		System.out.print("Iterator in use: ");
// 		for (Integer val : v1)
// 			System.out.print(val + " ");
// 		System.out.println();
	}

	public static void print(Vector<Integer> v1) {
		Iterator<Integer> it = v1.begin();
		while (it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
	}
}
