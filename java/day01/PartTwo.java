import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PartTwo {

    // TODO: just make it work
    public int calculate() {
        File file = new File("aoc1input.txt");
        int sum = 0;
        int counter = 0;
        StringBuilder word = new StringBuilder();

        try (FileInputStream fis = new FileInputStream(file)) {
            int readVal = fis.read();
            while (readVal != -1) {
                word.append((char) readVal);
                if (readVal == 10) {
                    System.out.println(counter++);
                    for (int i = 0; i < word.toString().length(); i++) {

                        if (word.substring(0, i).contains("one")) {
                            word.replace(0, i, word.substring(0, i).replaceAll("one", "1xx"));
                        }

                        if (word.substring(0, i).contains("two")) {
                            word.replace(0, i, word.substring(0, i).replaceAll("two", "2xx"));
                        }

                        if (word.substring(0, i).contains("three")) {
                            word.replace(0, i, word.substring(0, i).replaceAll("three", "3xxxx"));
                        }

                        if (word.substring(0, i).contains("four")) {
                            word.replace(0, i, word.substring(0, i).replaceAll("four", "4xxx"));
                        }

                        if (word.substring(0, i).contains("five")) {
                            word.replace(0, i, word.substring(0, i).replaceAll("five", "5xxx"));
                        }

                        if (word.substring(0, i).contains("six")) {
                            word.replace(0, i, word.substring(0, i).replaceAll("six", "6xx"));
                        }

                        if (word.substring(0, i).contains("seven")) {
                            word.replace(0, i, word.substring(0, i).replaceAll("seven", "7xxxx"));
                        }

                        if (word.substring(0, i).contains("eight")) {
                            word.replace(0, i, word.substring(0, i).replaceAll("eight", "8xxxx"));
                        }

                        if (word.substring(0, i).contains("nine")) {
                            word.replace(0, i, word.substring(0, i).replaceAll("nine", "9xxx"));
                        }

                    }

                    System.out.print(word+ " ");

                    for (int i = 0; i < word.toString().length(); i++) {
                        if (word.charAt(i) >= 48 && word.charAt(i) <= 57) {
                            System.out.print("sum: " + sum + "plus " + (word.charAt(i) - '0') * 10 + " is: ");
                            sum = sum + ((word.charAt(i) - '0') * 10);
                            System.out.print(sum);

                            break;
                        }
                    }

                    word.reverse();

                    for (int i = 0; i < word.toString().length(); i++) {
                        if (word.charAt(i) >= 48 && word.charAt(i) <= 57) {
                            System.out.print("sum: " + sum + "plus " + (word.charAt(i) - '0') + " is: ");
                            sum = sum + (word.charAt(i) - '0');
                            System.out.print(sum);

                            break;
                        }
                    }

                    System.out.println('\n');
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
