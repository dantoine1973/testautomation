import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class FileHandlingExercise {
    public static void main(String[] args) {
        String fileName = "example.txt";
                String fileName2 = "example2.txt";
        String content = "Hello!\nThis is a sample file.";
        String line;

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("File created and content written successfully");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null)
            System.out.println(line);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }

    }
}
