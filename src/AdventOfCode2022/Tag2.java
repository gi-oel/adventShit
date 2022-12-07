package AdventOfCode2022;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Tag2 {
    public static void main(String[] args) throws IOException {
        var punkte = new Object() {
            final int stein = 1;
            final int papier = 2;
            final int schere = 3;
            final int verlieren = 0;
            final int unentschieden = 3;
            final int gewinn = 6;
        };

        var typ = new Object() {
            final String gewinn = "Z";
            final String unentschieden = "Y";
            final String verloren = "X";
        };

        //Datei auslesen
        String ganzerText = Files.readString(Paths.get("AdventOfCode2022Input/rockPaperScissor.txt"), StandardCharsets.UTF_8);
        String[] alleRunden = ganzerText.split("\r\n");

        int punkteInsgesamtTeil1 = 0;
        int punkteInsgesamtTeil2 = 0;
        //Punkte berechnen für Wahl
        for (String runde : alleRunden) {
            String[] zug = runde.split(" ");
            switch (zug[1]) {
                case "X" -> punkteInsgesamtTeil1 += punkte.stein;
                case "Y" -> punkteInsgesamtTeil1 += punkte.papier;
                case "Z" -> punkteInsgesamtTeil1 += punkte.schere;
            }
            if (zug[0].equals("A") && zug[1].equals("X") || zug[0].equals("B") && zug[1].equals("Y") || zug[0].equals("C") && zug[1].equals("Z")) {
                punkteInsgesamtTeil1 += punkte.unentschieden;
            } else if (zug[0].equals("A") && zug[1].equals("Y") || zug[0].equals("B") && zug[1].equals("Z") || zug[0].equals("C") && zug[1].equals("X")) {
                punkteInsgesamtTeil1 += punkte.gewinn;
            }

            //Bemerken, ob gewonnen oder verloren
            if (zug[1].equals(typ.gewinn)) {
                punkteInsgesamtTeil2 += punkte.gewinn;
                switch (zug[0]) {
                    case "A" -> punkteInsgesamtTeil2 += punkte.papier;
                    case "B" -> punkteInsgesamtTeil2 += punkte.schere;
                    case "C" -> punkteInsgesamtTeil2 += punkte.stein;
                }
            } else if (zug[1].equals(typ.unentschieden)) {
                punkteInsgesamtTeil2 += punkte.unentschieden;
                switch (zug[0]) {
                    case "A" -> punkteInsgesamtTeil2 += punkte.stein;
                    case "B" -> punkteInsgesamtTeil2 += punkte.papier;
                    case "C" -> punkteInsgesamtTeil2 += punkte.schere;
                }
            } else if (zug[1].equals(typ.verloren)) {
                punkteInsgesamtTeil2 += punkte.verlieren;
                switch (zug[0]) {
                    case "A" -> punkteInsgesamtTeil2 += punkte.schere;
                    case "B" -> punkteInsgesamtTeil2 += punkte.stein;
                    case "C" -> punkteInsgesamtTeil2 += punkte.papier;
                }
            }

        }
        System.out.println("Punkte insgesamt Teil 1: " + punkteInsgesamtTeil1);
        System.out.println("Punkte insgesamt Teil 2: " + punkteInsgesamtTeil2);
    }
}
