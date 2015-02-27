package core.staticscope;

public class Main1 {

    public static int count = 0;
    
    public Main1() {
        count++;
    }

    public static void main(String[] args) {
        Main1 m = new Main1();
        System.out.println("There are " + Main1.count + " Main1 objects");
        
        Main1 n = new Main1();
        Main1 o = new Main1();
        System.out.println("There are " + Main1.count + " Main1 objects");
    }
}


