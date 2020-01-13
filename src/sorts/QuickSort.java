package sorts;

import java.util.ArrayList;

public class QuickSort extends Sorter {

	@Override
	public ArrayList<ArrayList<Integer>> sort(ArrayList<Integer> elements) {
		int size = elements.size();
		steps = new ArrayList<ArrayList<Integer>>(size);
		if(generateSteps)
			steps.add(new ArrayList<Integer>(elements));
		quickSort (elements, 0, size-1);
		return steps;
	}
	
	private void quickSort(ArrayList<Integer> elements, int l, int h) {
		
		if(l < h) {
			int pivot = partition (elements, l, h);
			
			quickSort(elements, l, pivot-1);
			quickSort(elements, pivot+1, h);
		}
	}

	private int partition(ArrayList<Integer> elements, int l, int h) {
		int pivot = elements.get(h);
		
		int i = l -1;
		for (int j = l; j < h; j++) {
			if (elements.get(j) <= pivot) {
				i++;
				swap(elements, i, j);
				if(generateSteps)
					steps.add(new ArrayList<Integer>(elements));
			}
		}
		swap(elements, i+1, h);
		
		if(generateSteps)
			steps.add(new ArrayList<Integer>(elements));
		return i+1;
	}

}
