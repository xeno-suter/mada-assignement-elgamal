import java.math.BigInteger;

// Task 4
public class ElGamalDecryption {
    public static void main(String[] args) {
        String privateKeyString = IOUtility.readFile(IOUtility.FILE_NAME_PRIVATE_KEY);
        BigInteger privateKey = new BigInteger(privateKeyString);

        String cipherText = IOUtility.readFile(IOUtility.FILE_NAME_CIPHER_TEXT);
        StringBuilder plainText = new StringBuilder();

        String[] pairs = cipherText.split(";");
        for (String pair : pairs) {
            if (!pair.isEmpty()) {
                String[] parts = pair.substring(1, pair.length() - 1).split(",");
                BigInteger y1 = new BigInteger(parts[0]);
                BigInteger y2 = new BigInteger(parts[1]);

                BigInteger m = (y2.multiply(y1.modPow(privateKey.negate(), BigIntegerUtility.N))).mod(BigIntegerUtility.N);
                plainText.append((char) m.intValue());
            }
        }

        IOUtility.writeFile(IOUtility.FILE_NAME_PLAIN_TEXT, plainText.toString());
    }
}
