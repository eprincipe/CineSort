package sorts;

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort extends Sorter {

	private int base;
	
	public RadixSort() {
		super();
		this.base = 10;
	}
	
	public RadixSort(int base) {
		super();
		this.base = base;
	}
	
	public ArrayList<ArrayList<Integer>> sort(ArrayList<Integer> elements) {
		
		int size = elements.size();
		steps = new ArrayList<ArrayList<Integer>>(size);
		
		//getting the biggest element
		int max = elements.get(0);
		for(int i = 1; i < size; i++)
			if(elements.get(i) > max)
				max = elements.get(i);
		
		//performing a count sort for every digit
		for(int e = 1; max/e > 0; e = e*base)
			countingSort(elements, size, e);
		
		return steps;
	}

	private void countingSort(ArrayList<Integer> elements, int size, int e) {
		
		ArrayList<Integer> temp = new ArrayList<Integer>(elements);
		int count[] = new int[base];
		Arrays.fill(count, 0);
		int i;
		
		for(i =0; i < size; i ++)
			count[(elements.get(i)/e) % base]++;
		
		for(i = 1; i < base; i++)
			count[i] += count[i - 1];
		
		int index;
		for(i = size - 1; i >= 0; i--) {
			index = (temp.get(i)/e) % base;
			elements.set(count[index] - 1, temp.get(i));
			count[index]--;
			if(generateSteps)
				steps.add(new ArrayList<Integer>(elements));
		}
	}
}
