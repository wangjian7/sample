package creation.singleton1;

//File Name: SingletonDemo.java
//The ClassicSingleton class maintains a static reference to the lone singleton instance and returns that reference from the static getInstance() method.
//Here ClassicSingleton class employs a technique known as lazy instantiation to create the singleton; as a result, the singleton instance is not created until the getInstance() method is called for the first time. 
//This technique ensures that singleton instances are created only when needed.
public class Demo {
	public static void main(String[] args) {
		Singleton tmp = Singleton.getInstance();
		tmp.setName("tmp");
		Singleton tmp2 = Singleton.getInstance();
		tmp.printName();
		tmp2.printName();

		LazySingleton tmp3 = LazySingleton.getInstance();
		tmp3.setName("tmp3");
		LazySingleton tmp4 = LazySingleton.getInstance();
		tmp3.printName();
		tmp4.printName();

	}
}