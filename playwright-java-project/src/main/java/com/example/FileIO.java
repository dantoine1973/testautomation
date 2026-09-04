package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class FileIO {
    public static void main(String[] args) throws IOException {

        Scanner scanner = null;
        FileWriter writer = null;
        File file = null;

        try  {
            writer = new FileWriter("c:\\temp\\example3.txt");
            writer.write("Hello, World!");

            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

        try {
            file = new File("C:\\temp\\example4.txt");
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}