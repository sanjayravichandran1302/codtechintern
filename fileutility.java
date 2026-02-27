import java.io.*;
import java.util.Scanner;

public class fileutility {

    static String fileName = "sample.txt";

    public static void writeFile(String data) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(data);
            writer.close();
            System.out.println("Data written successfully.\n");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }

    public static void readFile() {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            System.out.println("\nFile Content:");
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public static void modifyFile(String oldWord, String newWord) {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            StringBuilder content = new StringBuilder();

            while (reader.hasNextLine()) {
                content.append(reader.nextLine()).append("\n");
            }
            reader.close();

            String updatedContent = content.toString().replace(oldWord, newWord);

            FileWriter writer = new FileWriter(fileName);
            writer.write(updatedContent);
            writer.close();

            System.out.println("File modified successfully.\n");

        } catch (IOException e) {
            System.out.println("Error modifying file.");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("==== FILE HANDLING UTILITY ====");

        System.out.print("Enter text to write into file: ");
        String text = input.nextLine();
        writeFile(text);

        readFile();

        System.out.print("\nEnter word to replace: ");
        String oldWord = input.nextLine();

        System.out.print("Enter new word: ");
        String newWord = input.nextLine();

        modifyFile(oldWord, newWord);

        readFile();

        input.close();
    }
}