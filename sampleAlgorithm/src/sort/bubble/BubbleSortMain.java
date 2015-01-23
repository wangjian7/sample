/**
 * 
 */
package sort.bubble;

/**
 * @author i069381
 *
 */
public class BubbleSortMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numberToSort;
		numberToSort = new int[] { 4, 2, 5, 7, 8, 1, 9, 3, 10, 6 };
		int index = 0;
		int currentNumber;
		for (int i = 0; i < 10; i++) {
			currentNumber = numberToSort[i];
			index = i;
			for (int j = i + 1; j < 10; j++) {
				if (currentNumber > numberToSort[j]) {
					currentNumber = numberToSort[j];
					index = j;
				}
			}
			// swift nubmer[i] and nubmer[j]
			numberToSort[index] = numberToSort[i];
			numberToSort[i] = currentNumber;
			// index=i;
			// this is wrong, you have to set i at the beginning

		}
		for (int i = 0; i < 10; i++) {
			System.out.println(numberToSort[i]);
		}

	}

}
