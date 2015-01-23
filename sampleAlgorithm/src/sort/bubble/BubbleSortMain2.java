/**
 * 
 */
package sort.bubble;

/**
 * @author i069381
 *
 */
public class BubbleSortMain2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numberToSort;
		numberToSort = new int[] { 4, 2, 5, 7, 8, 1, 9, 3, 10, 6 };
		int index = 0;
		int currentNumber;
		boolean flag = false;
		for (int i = 0; i < 10; i++) {
			flag = false;
			currentNumber = numberToSort[i];
			for (int j = i + 1; j < 10; j++) {
				if (currentNumber > numberToSort[j]) {
					currentNumber = numberToSort[j];
					index = j;
					flag = true;
				}
			}
			if (flag) {
				// swift nubmer[i] and nubmer[j]
				numberToSort[index] = numberToSort[i];
				numberToSort[i] = currentNumber;
			}

		}
		for (int i = 0; i < 10; i++) {
			System.out.println(numberToSort[i]);
		}

	}

}
