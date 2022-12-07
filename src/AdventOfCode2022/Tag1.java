package AdventOfCode2022;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Tag1 {
    public static void main(String[] args) {
        try {
            String wholeText = Files.readString(Paths.get("AdventOfCode2022Input/calories.txt"), StandardCharsets.UTF_8);
            // Aufteilen in einzelne Elfen
            List<Integer> elvesFoodArray = new ArrayList<>();

            //Durch Elfen gehen und essen in einzelne arrays aufteilen
            for (String elfFood : wholeText.split("\r\n\r\n")) {
                int addNum = 0;
                for (int num : Arrays.stream(elfFood.split("\r\n"))
                        .map(Integer::parseInt)
                        .toList().toArray(new Integer[0])) {
                    addNum += num;
                }
                elvesFoodArray.add(addNum);
            }
            System.out.println(Collections.max(elvesFoodArray));

            elvesFoodArray.sort(Collections.reverseOrder());
            System.out.println(elvesFoodArray.get(0) + elvesFoodArray.get(1) + elvesFoodArray.get(2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
