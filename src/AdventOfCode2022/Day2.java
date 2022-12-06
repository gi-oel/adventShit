package AdventOfCode2022;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day2 {
    public static void main(String[] args) throws IOException {
        var punkte = new Object() {
            final int stein = 1;
            final int papier = 2;
            final int schere = 3;
            final int verlieren = 0;
            final int unentschieden = 3;
            final int gewinn = 6;
        };

        //Datei auslesen
        String ganzerText = Files.readString(Paths.get("AdventOfCode2022Input/rockPaperScissor.txt"), StandardCharsets.UTF_8);
        String[] alleRunden = ganzerText.split("\r\n");

        int punkteInsgesamt = 0;
        //Punkte berechnen für Wahl
        for (String runde : alleRunden) {
            String[] zug = runde.split(" ");
            switch (zug[1]) {
                case "X" -> punkteInsgesamt += punkte.stein;
                case "Y" -> punkteInsgesamt += punkte.papier;
                case "Z" -> punkteInsgesamt += punkte.schere;
            }

            if (zug[0].equals("A") && zug[1].equals("X") || zug[0].equals("B") && zug[1].equals("Y") || zug[0].equals("C") && zug[1].equals("Z")) {
                punkteInsgesamt += punkte.unentschieden;
            } else if (zug[0].equals("A") && zug[1].equals("Y") || zug[0].equals("B") && zug[1].equals("Z") || zug[0].equals("C") && zug[1].equals("X")) {
                punkteInsgesamt += punkte.gewinn;
            }
        }

        System.out.println(punkteInsgesamt);
    }
}
