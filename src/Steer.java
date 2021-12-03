import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

public class Steer {
    public static void main(String[] args) {
        try {
            BufferedReader r = new BufferedReader(new FileReader(Paths.get("steer.txt").toFile()));
            String command = r.readLine();
            int x = 0;
            int y = 0;
            int aim = 0;
            while (command != null) {
                String[] commands = command.split(" ");
                if (Objects.equals(commands[0], "forward")) {
                    x += Integer.parseInt(commands[1]);
                    if (aim != 0) {
                        y = x * aim;
                    }
                } else if (Objects.equals(commands[0], "up")) {
                    aim -= Integer.parseInt(commands[1]);
                } else if (Objects.equals(commands[0], "down")) {
                    aim += Integer.parseInt(commands[1]);
                }
                command = r.readLine();
            }
            System.out.println("X = " + x);
            System.out.println("Y = " + y);
            long sol = (long) x * y;
            System.out.println("Solution: " + sol);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
