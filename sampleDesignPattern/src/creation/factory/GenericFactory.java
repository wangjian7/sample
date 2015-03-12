// http://www.captaindebug.com/2011/05/generic-factory-class-sample.html#.VPAVti6UehA
package creation.factory;

public class GenericFactory<T> {

	// T type MUST have a default constructor
	private final Class<T> type;

	public GenericFactory(Class<T> type) {

		this.type = type;
	}

	/**
	 * Use the factory to get the next instance.
	 */
	public T getInstance() {

		try {
			// assume type is a public class
			return type.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Create the factory. Note that V can be T, but to demonstrate that generic
	 * method are not generic classes, I've called it V and not T. In using this
	 * method V becomes T.
	 */
	public static <V> GenericFactory<V> getInstance(Class<V> type) {

		return new GenericFactory<V>(type);
	}

	
}