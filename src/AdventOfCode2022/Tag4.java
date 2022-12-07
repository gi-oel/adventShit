package AdventOfCode2022;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Tag4 {
    public static void main(String[] args) throws IOException {
        String alleSektionen = Files.readString(Paths.get("AdventOfCode2022Input/sections.txt"), StandardCharsets.UTF_8);
        String[] geteilteSektionen = alleSektionen.split("[,]|[(\\r\\n)]");
        System.out.println(Arrays.toString(geteilteSektionen));
    }
}
