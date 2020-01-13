package sorts;

import java.util.ArrayList;

public class MergeSort extends Sorter {
	
	/**
	 * Topdown MergeSort implementation
	 * @param ArrayList<Integer> to be sorted
	 * @return Step by step progression for animation
	 */
	@Override
	public ArrayList<ArrayList<Integer>> sort(ArrayList<Integer> elements) {
		int size = elements.size();
		steps = new ArrayList<ArrayList<Integer>>(size);
		if(generateSteps)
			steps.add(new ArrayList<Integer>(elements));
		topDownSplitMerge (elements, 0, size-1);
		return steps;
	}
	
	private void topDownSplitMerge(ArrayList<Integer> elements,
			int begin, int end) {
		
		if (begin < end) {
			int middle = (begin + end) / 2;
			
			topDownSplitMerge(elements, begin, middle);
			topDownSplitMerge(elements, middle+1, end);
			
			topDownMerge(elements, begin, middle, end);
		}
	}

	private void topDownMerge(ArrayList<Integer> elements,
			int begin, int middle, int end) {
		
		int sizeL = middle - begin +1;
		int sizeR = end - middle;
		
		int[] left = new int[sizeL];
		int[] right = new int [sizeR];
				
		for (int i = 0; i < sizeL; i++)
			left[i] = elements.get(begin + i);
		for (int j = 0; j < sizeR; j++)
			right[j] = elements.get(middle + j + 1);
		
		int i = 0, j = 0, k = begin;
		while (i < sizeL && j < sizeR) {
			if (left[i] <= right[j]) {
				elements.set(k, left[i]);
				i++;
			} else {
				elements.set(k, right[j]);
				j++;
			}
			k++;
		}
		while (i < sizeL) {
			elements.set(k, left[i]);
			i++;
			k++;
		}
		while (j < sizeR) {
			elements.set(k, right[j]);
			j++;
			k++;
		}
		
		if(generateSteps)
			steps.add(new ArrayList<Integer>(elements));
	}

}
