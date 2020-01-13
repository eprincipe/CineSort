package sorts;

import java.util.ArrayList;

public class InsertionSort extends Sorter {

	@Override
	public ArrayList<ArrayList<Integer>> sort(ArrayList<Integer> elements) {

		int size = elements.size();
		steps = new ArrayList<ArrayList<Integer>>(size);
		for (int i = 1; i < size; i++) {
			
			int m = elements.get(i);
			int j = i-1;
			
			while (j >= 0 && elements.get(j) > m) {
				elements.set(j + 1, elements.get(j));
				j = j-1;
			}
			elements.set(j+1, m);
			if(generateSteps)
				steps.add(new ArrayList<Integer>(elements));
		}
		return steps;
	}

}
