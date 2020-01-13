package sorts;

import java.util.ArrayList;

public class BubbleSort extends Sorter {

	@Override
	public ArrayList<ArrayList<Integer>> sort(ArrayList<Integer> elements) {
		
		int size = elements.size();
		steps = new ArrayList<ArrayList<Integer>>(size);

		boolean sorted;
		do {
			sorted = true;
			for (int i =1; i < size; i++)
				if (elements.get(i-1) > elements.get(i)) {
					swap(elements, i-1, i);
					sorted = false;
					if(generateSteps)
						steps.add(new ArrayList<Integer>(elements));
				}
		} while (!sorted);
		
		return steps;
	}

}
