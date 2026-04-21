package hust.soict.hedspi.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        try {
            String filename = "test.txt"; // thay bằng file lớn của bạn
            byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

            long startTime = System.currentTimeMillis();
            StringBuilder outputStringBuilder = new StringBuilder();
            for (byte b : inputBytes) {
                // nối chuỗi bằng StringBuilder
                outputStringBuilder.append((char) b);
            }
            String outputString = outputStringBuilder.toString();
            long endTime = System.currentTimeMillis();
            System.out.println("Time with StringBuilder: " + (endTime - startTime) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}