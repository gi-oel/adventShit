import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader r = new BufferedReader(new FileReader(Paths.get("data.txt").toFile()));
            String number = r.readLine();
            List<Integer> nums = new ArrayList<>();
            while (number != null) {
                nums.add(Integer.parseInt(number));
                number = r.readLine();
            }
            r.close();
            int lastNum = 0;
            int count = 0;
            for (int i = 2; i < nums.size(); i++) {
                int n1 = nums.get(i - 2);
                int n2 = nums.get(i - 1);
                int n3 = nums.get(i);
                if (lastNum != 0 && lastNum < n1 + n2 + n3) {
                    count++;
                }
                lastNum = n1 + n2 + n3;
            }

            System.out.println("Higher val: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
