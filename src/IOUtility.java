import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class IOUtility {
    public static String FILE_NAME_PUBLIC_KEY = "pk.txt";
    public static String FILE_NAME_PRIVATE_KEY = "sk.txt";
    public static String FILE_NAME_CIPHER = "cipher.txt";
    public static String FILE_NAME_DECRYPTED_TEXT = "text-d.txt";

    private final Path publicKeyPath = Path.of(FILE_NAME_PUBLIC_KEY);
    private final Path privateKeyPath = Path.of(FILE_NAME_PRIVATE_KEY);
    private final Path chiperPath = Path.of(FILE_NAME_CIPHER);
    private final Path decryptedTextPath = Path.of(FILE_NAME_DECRYPTED_TEXT);

    public void writePrivateKey(BigInteger k) {
        writeKey(k, privateKeyPath);
    }

    public void writePublicKey(BigInteger k) {
        writeKey(k, publicKeyPath);
    }

    public void writeCipherText(String c1, String c2) {
        try {
            Files.writeString(chiperPath, String.format("(%s, %s);", c1, c2), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeDecryptedText(String text) {
        try {
            Files.writeString(decryptedTextPath, text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeKey(BigInteger k, Path path) {
        try {
            Files.writeString(path, k.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BigInteger readPublicKey() {
        return readKey(FILE_NAME_PUBLIC_KEY);
    }

    public BigInteger readPrivateKey() {
        return readKey(FILE_NAME_PRIVATE_KEY);
    }

    private BigInteger readKey(String fileName) {
        var content = readTextFile(fileName);
        return new BigInteger(content);
    }

    public byte[] readTextFile(String fileName) {
        try {
            return Files.readAllBytes(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeOldCipher() {
        try {
            Files.deleteIfExists(chiperPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> readCipherText() {
        try {
            return List.of(Files.readString(chiperPath).split(";"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}