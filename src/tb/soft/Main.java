package tb.soft;
import javax.swing.*;

public class Main{

    public static void main(String[] args) {

        System.out.println("Program pokazuje program rysowania kwadratów oraz kół");
        System.out.println("za pomocą wczytywania k albo o");
        System.out.println("albo");
        System.out.println("Program też od razu działa uciekający przycisk");
        System.out.println("z prawej strony ma bezpieczną strefe");


        runMain();

    }
    public static void runMain() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MyFrame okno = new MyFrame();
            }
        });
    }
}
