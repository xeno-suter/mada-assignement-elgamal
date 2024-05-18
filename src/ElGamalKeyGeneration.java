import java.math.BigInteger;

// Task 2
public class ElGamalKeyGeneration {

    public static void main(String[] args) {
        BigInteger privateKey = BigIntegerUtility.generatePrivateKey();
        BigInteger publicKey = BigIntegerUtility.generatePublicKey(privateKey);

        IOUtility.writeFile(IOUtility.FILE_NAME_PUBLIC_KEY, privateKey.toString());
        IOUtility.writeFile(IOUtility.FILE_NAME_PRIVATE_KEY, publicKey.toString());
    }
}
