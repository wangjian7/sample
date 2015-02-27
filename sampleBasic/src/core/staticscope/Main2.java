package core.staticscope;

public class Main2 {

    public static int count;

    // static constructor, let's set it to 2 just for kicks
    static {
        count = 2;
    }

    public Main2() {
        count++;
    }

    public static void main(String[] args) {
        Main2 m = new Main2();
        System.out.println("There are " + Main2.count + " Main2 objects");

        Main2 n = new Main2();
        Main2 o = new Main2();
        System.out.println("There are " + Main2.count + " Main2 objects");
    }
}


