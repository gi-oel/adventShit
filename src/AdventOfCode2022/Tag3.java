package AdventOfCode2022;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Tag3 {
    public static void main(String[] args) throws IOException {
        String ganzerInput = Files.readString(Paths.get("AdventOfCode2022Input/rucksack.txt"), StandardCharsets.UTF_8);
        String[] alleRucksaecke = ganzerInput.split("\r\n");
        int punkteTeil1 = 0;
        int punkteTeil2 = 0;

        //Durch alle Rucksäcke gehen und halbieren
        for (String rucksack : alleRucksaecke) {
            String[] teile = {rucksack.substring(0, rucksack.length() / 2), rucksack.substring(rucksack.length() / 2)};

            System.out.println(teile[0] + " : " + teile[1]);
            //Durch 1. Teil gehen und schauen, ob es im 2. existiert
            for (char buchstabe : teile[0].toCharArray()) {
                //Wenn es vorkommt
                if (teile[1].indexOf(buchstabe) >= 0) {
                    punkteTeil1 += charPunkte(buchstabe);
                    System.out.println("Char: " + buchstabe);
                    break;
                }
            }
        }

        //Gruppen bilden
        for (int i = 0; i < alleRucksaecke.length; i += 3) {
            System.out.println(alleRucksaecke[i] + " : " + alleRucksaecke[i + 1] + " : " + alleRucksaecke[i + 2]);
            for (char buchstabe : alleRucksaecke[i].toCharArray()) {
                //Wenn der char in allen vorkommt
                if (alleRucksaecke[i + 1].indexOf(buchstabe) >= 0 && alleRucksaecke[i + 2].indexOf(buchstabe) >= 0) {
                    System.out.println("Char: " + buchstabe);
                    punkteTeil2 += charPunkte(buchstabe);
                    break;
                }
            }
        }

        System.out.println("Alle Punkte Teil 1: " + punkteTeil1);
        System.out.println("Alle punkte Teil 2: " + punkteTeil2);
    }

    public static int charPunkte(char cha) {
        //Schauen, ob es klein oder gross ist
        if (!Character.isUpperCase(cha)) {
            return (int) cha - 96;
        } else {
            return (int) cha - 38;
        }
    }
}
