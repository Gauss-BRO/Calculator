import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = reader.readLine().replaceAll(" ", "");
            App app = new App(line);
            app.calculation();
            System.out.println(app.getResult());
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
