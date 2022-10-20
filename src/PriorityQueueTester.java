
public class PriorityQueueTester {
	public static void main(String[] args)
	{
		HeapPQ<Integer> queue = new HeapPQ<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(4);
		queue.add(8);
		queue.removeMin();
		System.out.println(queue.toString());
		while(!queue.isEmpty())
		{
			System.out.println(queue.removeMin());
			System.out.println(queue.toString());
			
		}
		System.out.println(queue.removeMin());
		System.out.println(queue.toString());
	}
}
