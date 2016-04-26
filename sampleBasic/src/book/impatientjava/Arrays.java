package book.impatientjava;

public class Arrays<B> {
	public static <T> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// Cannot make a static reference to the non-static type B
	// public static B swap1(B[] array, int i, int j) {return null;}

	public B swap1(B[] array, int i, int j) {
		return null;
	}
}
