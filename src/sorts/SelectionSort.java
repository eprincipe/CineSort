package sorts;

import java.util.ArrayList;

public class SelectionSort extends Sorter {
	
	public ArrayList<ArrayList<Integer>> sort(ArrayList<Integer> elements) {
		int size = elements.size();
		steps = new ArrayList<ArrayList<Integer>>(size);
		if(generateSteps)
			steps.add(new ArrayList<Integer>(elements));
		
		for (int i = 0; i < size; i++) {
			int min = i;
			
			for (int j = i+1; j < size; j++)
				if (elements.get(j) < elements.get(min))
						min = j;
			
			swap(elements, i, min);
			if(generateSteps)
				steps.add(new ArrayList<Integer>(elements));
		}
		
		return steps;
	}

}
;