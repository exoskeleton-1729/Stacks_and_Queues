import java.util.ArrayList;

public class PriorityQueue implements MyPriorityQueue {
		ArrayList list = new ArrayList();
		public PriorityQueue ()
		{
		}
		
		public void add(Comparable obj)
		{
			int addAt = 0;
			for(int i = 0; i < list.size(); i++) {
				if(obj.compareTo(list.get(i)) >= 0){
					addAt = i+1;
				}
			}
			list.add(addAt, obj);
		}
		
		// Removes and returns the MINIMUM element from the Priority Queue
		public Comparable removeMin()
		{
			Comparable min = (Comparable) list.get(0);
			list.remove(min);
			return min;
		}
		
		// Returns the MINIMUM element from the Priority Queue without removing it
		public Comparable peek()
		{
			return (Comparable) list.get(list.size()-1);
		}
		
		// Returns true if the priority queue is empty
		public boolean isEmpty()
		{
			return(size() == 0);
		}
		
		//Returns the number of elements in the priority queue
		public int size()
		{
			return list.size();
		}

}
