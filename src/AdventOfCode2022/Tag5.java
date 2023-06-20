package AdventOfCode2022;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Tag5 {
    public static void main(String[] args) throws IOException {
        // Alles auslesen und in ein array schreiben
        String alles = Files.readString(Paths.get("AdventOfCode2022Input/craneBoxes.txt"), StandardCharsets.UTF_8);

        System.out.println(alles);
    }
}
