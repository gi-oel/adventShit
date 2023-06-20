package AdventOfCode2022;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Tag4 {
    public static void main(String[] args) throws IOException {
        // Alles auslesen und in ein array schreiben
        String alleSektionen = Files.readString(Paths.get("AdventOfCode2022Input/sections.txt"), StandardCharsets.UTF_8);
        String[] geteiltePaare = alleSektionen.split("\n");

        // durch alle sektionen durchgehen
        int anzahlUeberschreitungen = 0;
        int anzahlAlleUeberschreitungen = 0;
        for (String paar : geteiltePaare) {
            // Aufteilen in Sektionen
            String[] sektionen = paar.split(",");

            // Aufteilen in einzelne Zahlen
            int[] ersteSektion = Arrays.stream(sektionen[0].split("-")).mapToInt(Integer::parseInt).toArray();
            int[] zweiteSektion = Arrays.stream(sektionen[1].split("-")).mapToInt(Integer::parseInt).toArray();

            // Überprüfen, ob das erste paar das andere direkt überschreitet oder das zweite das erste
            if (ersteSektion[0] >= zweiteSektion[0] && ersteSektion[1] <= zweiteSektion[1] || zweiteSektion[0] >= ersteSektion[0] && zweiteSektion[1] <= ersteSektion[1]) {
                anzahlUeberschreitungen++;
            }

            // Überprüfen, ob sich irgendwas überschreitet
            if (ersteSektion[0] >= zweiteSektion[0] && ersteSektion[0] <= zweiteSektion[1]
                    || ersteSektion[1] >= zweiteSektion[0] && ersteSektion[1] <= zweiteSektion[1]
                    || zweiteSektion[0] >= ersteSektion[0] && zweiteSektion[0] <= ersteSektion[0]
                    || zweiteSektion[1] >= ersteSektion[0] && zweiteSektion[1] <= ersteSektion[1]) {
                anzahlAlleUeberschreitungen++;
            }
        }

        System.out.println("Anzahl Überschreitungen: " + anzahlUeberschreitungen);
        System.out.println("Anzahl Alle Überschreitungen: " + anzahlAlleUeberschreitungen);

    }
}
