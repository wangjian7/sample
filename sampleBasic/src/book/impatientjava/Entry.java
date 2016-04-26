///6.1 Generic Classes
package book.impatientjava;

public class Entry <K, V> {
	private K key;
	private V value;

	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public String toString() {
		return this.key.toString() + this.value.toString();

	}
}