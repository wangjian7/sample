package book.impatientjava;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] friends = { "john", "marry" };
		Arrays.swap(friends, 0, 1);
		for (String friend : friends) {
			System.out.println(friend);
		}
	}
}
