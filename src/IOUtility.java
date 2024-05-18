import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IOUtility {
    public static String FILE_NAME_PUBLIC_KEY = "pk.txt";
    public static String FILE_NAME_PRIVATE_KEY = "sk.txt";
    public static String FILE_NAME_CIPHER_TEXT = "cipher.txt";
    public static String FILE_NAME_PLAIN_TEXT = "text-d.txt";
    public static String FILE_NAME_TEXT = "text.txt";

    public static void writeFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readFile(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}