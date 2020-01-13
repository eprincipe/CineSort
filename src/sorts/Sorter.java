package sorts;

import java.util.ArrayList;

public abstract class Sorter {

	protected ArrayList<ArrayList<Integer>> steps;
	protected boolean generateSteps = false;
	/**
	 * Method that sorts the elements in a given integer array.
	 * @param shuffled elements
	 * @return sorted elements
	 */
	abstract public ArrayList<ArrayList<Integer>> sort (ArrayList<Integer> elements);
	
	protected void swap (ArrayList<Integer> elements, int i, int j) {
		int temp = elements.get(j);
		elements.set(j, elements.get(i));
		elements.set(i, temp);
	}
	
	public void generateSteps(boolean generateSteps) {
		this.generateSteps = generateSteps;
	}
}
