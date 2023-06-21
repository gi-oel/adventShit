package AdventOfCode2022;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Tag5 {
    public static void main(String[] args) throws IOException {
        // Alles auslesen und in ein array schreiben
        List<String> alleSchritte = Files.readAllLines(Paths.get("AdventOfCode2022Input/craneBoxes.txt"), StandardCharsets.UTF_8);

        // Liste mit den Boxen machen
        // Listen in ein array machen, damit es einfacher ist
        var alleStapel = new List[]{
                List.of("S", "P", "W", "N", "J", "Z"),
                List.of("T", "S", "G"),
                List.of("H", "L", "R", "Q", "V"),
                List.of("D", "T", "S", "V"),
                List.of("J", "M", "B", "D", "T", "Z", "Q"),
                List.of("L", "Z", "C", "D", "J", "T", "W", "M"),
                List.of("J", "T", "G", "W", "M", "P", "L"),
                List.of("H", "Q", "F", "B", "T", "M", "G", "N"),
                List.of("W", "Q", "B", "P", "P", "C", "G", "D", "R")};

        // Alle umdrehen, dass es einfacher ist
        for (var stapel : alleStapel) {
            Collections.reverse(stapel);
        }

        // Durch alle Schritte durchgehen
        for (String schritt : alleSchritte) {
            // Schritt aufteilen um zu verstehen was zu tun ist. 1, 3, 5 wird gebraucht
            var anleitung = schritt.split(" ");


        }
    }
}
