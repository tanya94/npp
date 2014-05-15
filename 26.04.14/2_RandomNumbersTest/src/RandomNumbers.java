import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by tanya94 on 10.05.2014.
 */
public class RandomNumbers {
    PrintWriter writer;
    HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
    int max, min;

    public RandomNumbers(PrintWriter writer) {
        this.writer = writer;
    }

    public void run() throws IOException {
        for (int maxValue = 10; maxValue <= 100; maxValue++) { // для каждого k от 10 до 100
            writer.println("#" + maxValue + ":");
            for (int kol = 1000; kol < 10000000; kol *= 10) {
                generateRandomNumbers(maxValue, kol);
                findMaxAndMin(kol);
                double d = (double) (max - min) / (double) kol;
                writer.println(kol + " - " + d);
                result.clear();
            }
            writer.println();
        }
    }

    private void generateRandomNumbers(int maxValue, int kol) {
        for (int i = 1; i <= kol; i++) {
            Random rnd = new Random();
            int currentNumber = rnd.nextInt(maxValue) + 1;
            int currentCount = 0;
            if (result.containsKey(currentNumber)) {
                currentCount = result.get(currentNumber);
            }
            result.put(currentNumber, currentCount + 1);
        }
    }

    private void findMaxAndMin(int maxKol) {
        max = 0;
        min = maxKol;
        for (Map.Entry<Integer, Integer> en : result.entrySet()) {
            int currentCount = en.getValue();
            if (currentCount > max) {
                max = currentCount;
            }
            if (currentCount < min) {
                min = currentCount;
            }
        }
    }
}