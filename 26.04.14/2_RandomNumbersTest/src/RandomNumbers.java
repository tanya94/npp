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

    public RandomNumbers(PrintWriter writer){
        this.writer = writer;
    }

    public void run() throws IOException {
        for(int maxValue = 10; maxValue <= 100; maxValue++){ // для каждого k от 10 до 100
            writer.println("#" + maxValue + ":");
            for (int kol = 1000; kol < 10000000; kol*=10) {
                generateRandomNumbers(maxValue, kol);
                double d = dCount(maxValue, kol);
                writer.println(kol + " - " + d);
                result.clear();
            }
            writer.println();
        }
    }

    private void generateRandomNumbers(int maxValue, int kol) {
        for (int i = 1; i<=kol; i++){
            Random rnd = new Random();
            int currentNumber = rnd.nextInt(maxValue)+1;
            result.put(i,currentNumber);
        }
    }

    private double dCount(int maxValue, int kol) {
        int[] amount = new int[maxValue+1];
        for (Map.Entry<Integer,Integer> en: result.entrySet()) {
            amount[en.getValue()]++;
        }
        int max = maxKol(amount);
        int min = minKol(amount);
        return (double)(max-min)/(double)kol;
    }

    private int maxKol(int[] amount) {
        int max = amount[1];
        for (int i = 2; i<amount.length; i++){
            if (amount[i] > max){
                max = amount[i];
            }
        }
        return max;
    }

    private int minKol(int[] amount) {
        int min = amount[1];
        for (int i = 2; i<amount.length; i++){
            if (amount[i] < min){
                min = amount[i];
            }
        }
        return min;
    }
}
