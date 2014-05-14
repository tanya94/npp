import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by HP on 14.05.2014.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter("out1.txt");
        RandomNumbers rndNum = new RandomNumbers(writer);
        rndNum.run();
        writer.close();
    }
}
