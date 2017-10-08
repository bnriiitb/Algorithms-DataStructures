package Heaps;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Heaps<T extends Comparable<T>> {
	private ArrayList<T> items;

	public Heaps() {
		items = new ArrayList<T>();
	}

	private void siftUp() {//called when a new item inserted into the heap
		int k = items.size() - 1;
		while (k > 0) {
			int p = (k - 1) / 2;
			T item = items.get(k);
			T parent = items.get(p);
			if (item.compareTo(parent) > 0) {
				// new item is greater than parent then swap parent with new
				// item to make keep the property of max heap
				items.set(k, parent);
				items.set(p, item);
				k = p;
			} else {// new item is at the correct place no need to sift up
				break;
			}
		}
	}

	private void siftDown() {//called when a max element is deleted
		int k = 0;
		int l = 2 * k + 1;
		while (l < items.size()) {
			int max = l, r = l + 1;
			if (r < items.size()) {// right child exists
				// get the max item among left and right children
				if (items.get(r).compareTo(items.get(l)) > 0) {
					max=r;
				}
			}
			if(items.get(max).compareTo(items.get(k))>0){
				T temp = items.get(k);
				items.set(k, items.get(max));
				items.set(max, temp);
				k=max;
				l=2*k+1;
			}else{// no need to sift down as element is at the correct place
				break;
			}
		}
	}

	public void insert(T item) {
		items.add(item);
		siftUp();
	}

	public T delete() {
		if (items.size() == 0) {
			throw new NoSuchElementException("!!!Heap is empty!!!");
		}
		if (items.size() == 1) {
			return items.remove(0);
		}
		T top = items.get(0);
		items.set(0, items.remove(items.size() - 1));
		siftDown();
		return top;
	}

	public int size() {
		return items.size();
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}

	public String toString() {
		return items.toString();
	}
}
