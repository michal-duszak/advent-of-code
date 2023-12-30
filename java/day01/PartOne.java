import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PartOne {
    public int calculate() {
        File file = new File("aoc1input.txt");
        int sum = 0;
        StringBuilder word = new StringBuilder();

        try (FileInputStream fis = new FileInputStream(file)) {
            int readVal = fis.read();
            while (readVal != -1) {
                word.append((char) readVal);
                if (readVal == 10) {
                    for (int i = 0; i < word.toString().length(); i++) {
                        if (word.charAt(i) >= 48 && word.charAt(i) <= 57) {
                            sum = sum + (word.charAt(i) - '0') * 10;
                            break;
                        }
                    }

                    word.reverse();

                    for (int i = 0; i < word.toString().length(); i++) {
                        if (word.charAt(i) >= 48 && word.charAt(i) <= 57) {
                            sum = sum + (word.charAt(i) - '0');
                            break;
                        }
                    }
                    word.replace(0, word.toString().length(), "");
                }
                readVal = fis.read();
            }
            return sum;
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }

}
