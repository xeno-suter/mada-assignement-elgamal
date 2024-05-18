import java.io.*;
import java.math.BigInteger;

// Task 3
public class ElGamalCipher {
    public static void main(String[] args) {
        BigInteger n = BigIntegerUtility.N;
        String publicKeyString = IOUtility.readFile(IOUtility.FILE_NAME_PUBLIC_KEY);
        BigInteger publicKey = new BigInteger(publicKeyString);

        String text = IOUtility.readFile(IOUtility.FILE_NAME_TEXT);
        StringBuilder cipherText = new StringBuilder();

        for (char character : text.toCharArray()) {
            BigInteger m = BigInteger.valueOf((int) character);
            BigInteger k = new BigInteger(n.bitLength() - 1, BigIntegerUtility.RANDOM);
            BigInteger y1 = BigIntegerUtility.G.modPow(k, n);
            BigInteger y2 = (m.multiply(publicKey.modPow(k, n))).mod(n);

            cipherText.append("(").append(y1).append(",").append(y2).append(");");
        }

        IOUtility.writeFile(IOUtility.FILE_NAME_CIPHER_TEXT, cipherText.toString());
    }
}
