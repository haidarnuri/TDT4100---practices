package setupcheck;

public class SimpleClass {
    private int myVal;

    public SimpleClass(int myVal) {
        this.myVal = myVal;
    }

    public int getMyVal() {
        return myVal;
    }

    public static void main(String... args) {
        Object o = "**The program runs**"; // Don't write code like this at home
        
        // Check that preview features are enabled
        if (o instanceof String s) {
            System.out.println(s.substring(2, s.length()-2));
        }
    }
}