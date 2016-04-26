package core.operation;

public class MainInstanceof1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainInstanceof1 main = new MainInstanceof1();
		P p = main.new P();
		C c = main.new C();
		System.out.println(c instanceof P);
		System.out.println(p instanceof C);

	}

class P{}
class C extends P{
	
}



}

