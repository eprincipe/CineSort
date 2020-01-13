package sorts;

import java.util.ArrayList;

public class HeapSort extends Sorter {

	
	@Override
	public ArrayList<ArrayList<Integer>> sort(ArrayList<Integer> elements) {
		
		int size = elements.size();
		steps = new ArrayList<ArrayList<Integer>>(size);
		
		for (int i = size/2 -1; i >= 0; i--)
			heapify (elements, size, i);
		
		for (int i = size-1; i >= 0; i--) {
			swap(elements, 0, i);
			if(generateSteps)
				steps.add(new ArrayList<Integer>(elements));
			heapify (elements, i, 0);
		}
		return steps;
	}

	private void heapify(ArrayList<Integer> elements, int size, int i) {
		
		int max = i;
		int l = 2*i + 1;
		int r = 2*(i + 1);
		
		if (l < size && elements.get(l) > elements.get(max))
			max = l;
		
		if (r < size && elements.get(r) > elements.get(max))
			max = r;
		
		if (max != i) {
			swap(elements, i, max);
			heapify(elements, size, max);
			if(generateSteps)
				steps.add(new ArrayList<Integer>(elements));
		}
	}

}
