package book.corejava;

public class ClassCast {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassCast cc = new ClassCast();
		A a = cc.new A();
		B b = cc.new B();
		C c = cc.new C();
		
		a=(A)b;
		b=(B)a;
		

	}

	class A {
	}

	class B extends A {
	}

	class C extends A {

	}

}
