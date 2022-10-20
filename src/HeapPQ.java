
public class HeapPQ<E extends Comparable<E>> implements MyPriorityQueue<E> {

	private E[] heap;
	private int objectCount;
	
	public HeapPQ()
    {
        this.heap = (E[])new Comparable[100];
        this.objectCount = 0;
    }

	//Adds obj to the Priority Queue
	public void add(E obj)
	{
		if(heap.length == objectCount)
			increaseCapacity();
		heap[objectCount] = obj;
		bubbleUp(objectCount);
		objectCount++;
	}
	
	//Removes and returns the MINIMUM element from the Priority Queue
	public E removeMin()
	{
		E temp = heap[0];
		bubbleDown(0);
		objectCount--;
		return temp;
	}
	
	//Returns the MINIMUM element from the Priority Queue without removing it
	public E peek()
	{
		return heap[0];
	}
	
	// Returns true if the priority queue is empty
	public boolean isEmpty()
	{
		return (objectCount == 0);
	}
	
	//Returns the number of elements in the priority queue
	public int size()
	{
		return objectCount;
	}
	
	public String toString()
	{
		StringBuffer stringbuf = new StringBuffer("[");
		for (int i = 0; i < objectCount; i++)
		{
			stringbuf.append(heap[i]);
			if (i < objectCount - 1)
				stringbuf.append(", ");
		}
		stringbuf.append("]\nor alternatively,\n");

		for(int rowLength = 1, j = 0; j < objectCount; rowLength *= 2)
		{
			for (int i = 0; i < rowLength && j < objectCount; i++, j++)
			{
				stringbuf.append(heap[j] + " ");
			}
			stringbuf.append("\n");
			if (j < objectCount)
			{
				for (int i = 0; i < Math.min(objectCount - j, rowLength*2); i++)
				{
					if (i%2 == 0)
						stringbuf.append("/");
					else
						stringbuf.append("\\ ");
				}
				stringbuf.append("\n");
			}
		}
		return stringbuf.toString();
	}
	
	//Doubles the size of the heap array
	private void increaseCapacity()
	{
		E[] newArray = (E[]) new Object[heap.length * 2];
		for(int i = 0; i < heap.length; i++)
		{
			newArray[i] = heap[i];
		}
		heap = newArray;
	}

	//Returns the index of the "parent" of index i
	private int parent(int i)
	{
		return (i-1)/2;
	}
	//Returns the index of the *smaller child* of index i
	private int smallerChild(int i)
	{
		if(2*i+1 < objectCount)
			if(2*i+1 == objectCount-1 || heap[2*i+1].compareTo(heap[2*i+2]) < 0)
				return (2*i + 1);
			else
				return (2*i+2);
		else
			return i;
	}
	//Swaps the contents of indices i and j
	private void swap(int i, int j)
	{
		E temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	// Bubbles the element at index i upwards until the heap properties hold again.
	private void bubbleUp(int i)
	{
		int index = i;
		while (heap[index].compareTo(heap[parent(index)]) < 0)
		{
			swap(index, parent(index));
			index = parent(index);
		}
	}
	
	// Bubbles the element at index i downwards until the heap properties hold again.
	private void bubbleDown(int i)
	{
		int index = i;
		while (heap[index].compareTo(heap[smallerChild(index)]) < 0)
		{
			swap(index, smallerChild(index));
			index = smallerChild(index);
		}
	}

}
