//
///**
// * create and store the public and private key
// */
//public class Task1 {
//    public static void main(String[] args) {
//        BigIntegerUtility bigUtility = new BigIntegerUtility();
//        IOUtility ioUtility = new IOUtility();
//
//        BigInteger privateKey = bigUtility.generateRandomNumber();
//        BigInteger publicKey = bigUtility.GENERATOR.modPow(privateKey, bigUtility.getN());
//
//        ioUtility.writePrivateKey(privateKey);
//        ioUtility.writePublicKey(publicKey);
//    }
//}

import java.math.BigInteger;

/**
 * create and store the public and private key
 */
public class Task1 {
    public static void main(String[] args) {
        BigIntegerUtility bigUtility = new BigIntegerUtility();
        IOUtility ioUtility = new IOUtility();

        BigInteger privateKey = bigUtility.generateRandomNumber();
        BigInteger publicKey = bigUtility.GENERATOR.modPow(privateKey, bigUtility.getN()); // todo check

        ioUtility.writePrivateKey(privateKey);
        ioUtility.writePublicKey(publicKey);
    }
}
