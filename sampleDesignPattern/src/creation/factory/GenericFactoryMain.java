package creation.factory;

public class GenericFactoryMain {
	
	public static void main(String[] args) {

		GenericFactory<String> factory = GenericFactory.getInstance(String.class);

		String sample = factory.getInstance();
		System.out.println("Sample is: " + sample);

		GenericFactory<TestOne> factory2 = GenericFactory.getInstance(TestOne.class);

		TestOne sample2 = factory2.getInstance();
		System.out.println("Sample is: " + sample2);
	}

	public static class TestOne {

		@Override
		public String toString() {

			return "This is TestOne";
		}
	}
}
