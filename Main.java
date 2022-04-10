
public class Main {
    static Window window;
    public static void main(String[] args) {
        window = new Window();
    }

    static void resetting(){
        window.dispose();
        window = new Window();
    }
}
